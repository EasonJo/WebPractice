package cn.e3mall.service.impl;

import cn.e3mall.common.pojo.EasyUIDataResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.common.utils.IDUtils;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public TbItem getItemById(long itemId) {
        //根据主键查询
        //TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
        TbItemExample example = new TbItemExample();
        Criteria criteria = example.createCriteria();
        //设置查询条件
        criteria.andIdEqualTo(itemId);
        //执行查询
        List<TbItem> list = itemMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
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
        item.setId(IDUtils.genItemId());
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
        return E3Result.ok();
    }
}
