package cn.e3mall.content.service.impl;

import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.pojo.TbContentExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Eason
 * @date Create in 14:46 26/04/2018
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {

    @Resource(name = "tbContentMapper")
    private TbContentMapper tbContentMapper;

    @Resource(name = "jedisClientPool")
    private JedisClient jedisClient;

//    @Value(value = "${CONTENT_LIST}")
    private String CONTENT_LIST = "CONTENT_LIST";

    @Override
    public E3Result addContent(TbContent content) {
        Date date = new Date();
        content.setCreated(date);
        content.setUpdated(date);

        tbContentMapper.insert(content);

        //缓存同步,删除缓存中对应的数据
        jedisClient.hdel(CONTENT_LIST,content.getCategoryId().toString());

        return E3Result.ok();
    }

    @Override
    public List<TbContent> getContentListByCid(long cid) {
        //查询缓存
        String json = jedisClient.hget(CONTENT_LIST, String.valueOf(cid));
        //有缓存中直接响应结果
        if (org.apache.commons.lang3.StringUtils.isNotBlank(json)) {
            List<TbContent> tbContents = JsonUtils.jsonToList(json, TbContent.class);
            return tbContents;
        }

        //如果没有则查询数据库
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(cid);

        List<TbContent> tbContents = tbContentMapper.selectByExampleWithBLOBs(example);

        jedisClient.hset(CONTENT_LIST, String.valueOf(cid), JsonUtils.objectToJson(tbContents));

        return tbContents;
    }
}
