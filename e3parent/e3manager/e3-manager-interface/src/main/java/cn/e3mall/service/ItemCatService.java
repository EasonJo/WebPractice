package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUITreeNote;

import java.util.List;

/**
 * @author Eason
 * @date Create in 16:47 24/04/2018
 */
public interface ItemCatService {
    List<EasyUITreeNote> getItemCatList(long parentId);
}
