package cn.e3mall.content.service.impl;

import cn.e3mall.common.pojo.EasyUITreeNote;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCategoryService;
import cn.e3mall.mapper.TbContentCategoryMapper;
import cn.e3mall.pojo.TbContentCategory;
import cn.e3mall.pojo.TbContentCategoryExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Eason
 * @date Create in 17:10 25/04/2018
 */
@Service("contentCategoryService")
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Resource(name = "tbContentCategoryMapper")
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<EasyUITreeNote> getContentCatList(long parentId) {
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample
            (tbContentCategoryExample);

        List<EasyUITreeNote> easyUITreeNotes = new ArrayList<>();

        for (TbContentCategory tbContentCategory : tbContentCategories) {
            EasyUITreeNote easyUITreeNote = new EasyUITreeNote();

            easyUITreeNote.setId(tbContentCategory.getId());
            easyUITreeNote.setText(tbContentCategory.getName());
            easyUITreeNote.setState(tbContentCategory.getIsParent() ? "closed" : "open");
            easyUITreeNotes.add(easyUITreeNote);
        }
        return easyUITreeNotes;
    }

    @Override
    public E3Result addContentCategory(long parentId, String name) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(parentId);
        tbContentCategory.setName(name);
        //1 正常,2 删除
        tbContentCategory.setStatus(1);
        tbContentCategory.setIsParent(false);
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setUpdated(new Date());

        int id = tbContentCategoryMapper.insert(tbContentCategory);

        TbContentCategory parent = tbContentCategoryMapper.selectByPrimaryKey(parentId);

        if (!parent.getIsParent()){
            parent.setIsParent(true);
            tbContentCategoryMapper.updateByPrimaryKey(parent);
        }

        return E3Result.ok(tbContentCategory);
    }
}
