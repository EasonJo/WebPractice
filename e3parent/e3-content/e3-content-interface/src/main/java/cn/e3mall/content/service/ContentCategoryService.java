package cn.e3mall.content.service;

import cn.e3mall.common.pojo.EasyUITreeNote;
import cn.e3mall.common.utils.E3Result;

import java.util.List;

/**
 * 分类操作 Service
 *
 * @author Eason
 * @date Create in 17:07 25/04/2018
 */
public interface ContentCategoryService {
    /**
     * 获取分类列表
     *
     * @param parentId ID
     * @return {@link EasyUITreeNote}
     */
    List<EasyUITreeNote> getContentCatList(long parentId);

    /**
     * 添加内容分类
     *
     * @param parentId 父节点 ID
     * @param name     类别名称
     * @return {@link E3Result}
     */
    E3Result addContentCategory(long parentId, String name);
}
