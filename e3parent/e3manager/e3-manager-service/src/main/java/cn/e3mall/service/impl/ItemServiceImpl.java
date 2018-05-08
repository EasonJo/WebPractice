package cn.e3mall.service.impl;

import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.common.pojo.EasyUIDataResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.common.utils.IDUtils;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import java.util.Date;
import java.util.List;

/**
 * 商品管理Service
 *
 * @author Eason
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Resource(name = "tbItemMapper")
    private TbItemMapper itemMapper;

    @Resource(name = "tbItemDescMapper")
    private TbItemDescMapper itemDescMapper;

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource(name = "topicDestination")
    private Topic topic;

    @Resource(name = "jedisClientPool")
    private JedisClient jedisClient;

    @Value("${REDIS_ITEM_PRE}")
    private String REDIS_ITEM_PRE;
    @Value("${ITEM_CACHE_EXPIRE}")
    private int ITEM_CACHE_EXPIRE;

    @Override
    public TbItem getItemById(long itemId) {
        try {
            //cache
            String json = jedisClient.get(REDIS_ITEM_PRE + itemId + ":BASE");
            if (StringUtils.isNotBlank(json)) {
                TbItem tbItem = JsonUtils.jsonToPojo(json, TbItem.class);
                return tbItem;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //db
        //根据主键查询
        //TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
        TbItemExample example = new TbItemExample();
        Criteria criteria = example.createCriteria();
        //设置查询条件
        criteria.andIdEqualTo(itemId);
        //执行查询
        List<TbItem> list = itemMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            try {
                //save to cache
                jedisClient.set(REDIS_ITEM_PRE + itemId + ":BASE", JsonUtils.objectToJson(list.get(0)));
                jedisClient.expire(REDIS_ITEM_PRE + itemId + ":BASE", ITEM_CACHE_EXPIRE);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return list.get(0);
        }
        return null;
    }

    @Override
    public EasyUIDataResult<TbItem> getItemList(int page, int size) {

        TbItemExample example = new TbItemExample();

        PageHelper.startPage(page, size);
        List<TbItem> items = itemMapper.selectByExample(example);
        PageInfo<TbItem> tbItemPageInfo = new PageInfo<>(items);

        EasyUIDataResult<TbItem> tbItemEasyUIDataResult = new EasyUIDataResult<>();
        tbItemEasyUIDataResult.setTotal(tbItemPageInfo.getTotal());
        tbItemEasyUIDataResult.setRows(tbItemPageInfo.getList());

        return tbItemEasyUIDataResult;
    }

    @Override
    public E3Result addItem(TbItem item, String desc) {
        final long itemId = IDUtils.genItemId();

        item.setId(itemId);
        //1 正常,2 下架,3 删除
        item.setStatus((byte) 1);
        Date date = new Date();

        item.setCreated(date);
        item.setUpdated(date);

        itemMapper.insert(item);

        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(item.getId());
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);

        itemDescMapper.insert(tbItemDesc);

        //这里需要考虑事务的问题.那边可能接收到消息之后,但是事务还未提交
        jmsTemplate.send(topic, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(String.valueOf(itemId));
                return textMessage;
            }
        });
        return E3Result.ok();
    }

    @Override
    public TbItemDesc getItemDescById(long itemId) {
        //查询缓存
        try {
            String json = jedisClient.get(REDIS_ITEM_PRE + ":" + itemId + ":DESC");
            if (StringUtils.isNotBlank(json)) {
                return JsonUtils.jsonToPojo(json, TbItemDesc.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        TbItemDesc tbItemDesc = itemDescMapper.selectByPrimaryKey(itemId);
        //把结果添加到缓存
        try {
            jedisClient.set(REDIS_ITEM_PRE + ":" + itemId + ":DESC", JsonUtils.objectToJson(tbItemDesc));
            //设置过期时间
            jedisClient.expire(REDIS_ITEM_PRE + ":" + itemId + ":DESC", ITEM_CACHE_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbItemDesc;
    }
}
