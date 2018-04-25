package cn.e3mall.service.impl;

import cn.e3mall.common.pojo.EasyUIDataResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品管理Service
 *
 * @author Eason
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Resource(name = "tbItemMapper")
    private TbItemMapper itemMapper;

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
}
