package cn.e3mall.content.service;

import cn.e3mall.common.pojo.EasyUITreeNote;

import java.util.List;

/**
 * @author Eason
 * @date Create in 17:07 25/04/2018
 */
public interface ContentCategoryService {
    List<EasyUITreeNote> getContentCatList(long parentId);
}
