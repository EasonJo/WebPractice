package cn.e3mall.service.impl;

import cn.e3mall.common.pojo.EasyUITreeNote;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.service.ItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eason
 * @date Create in 16:48 24/04/2018
 */
@Service("itemCatService")
public class ItemCatServiceImpl implements ItemCatService {

    @Resource(name = "tbItemCatMapper")
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EasyUITreeNote> getItemCatList(long parentId) {
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(tbItemCatExample);
        List<EasyUITreeNote> easyUITreeNotes = new ArrayList<>();

        for (TbItemCat tbItemCat : tbItemCats) {
            EasyUITreeNote note = new EasyUITreeNote();
            note.setId(tbItemCat.getId());
            note.setText(tbItemCat.getName());
            note.setState(tbItemCat.getIsParent() ? "closed" : "open");
            easyUITreeNotes.add(note);
        }
        return easyUITreeNotes;
    }
}
