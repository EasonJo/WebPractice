package cn.e3mall.sso.service;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbUser;

/**
 * @author Eason
 * @date Create in 18:38 02/05/2018
 */
public interface RegisterService {
    /**
     * 校验数据
     *
     * @param param
     * @param type
     * @return
     */
    E3Result checkData(String param, int type);

    E3Result register(TbUser user);
}
