package cn.eason.springboot.dao;

import cn.eason.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Eason
 * @date Create in 14:59 15/05/2018
 */
@Mapper
public interface UserMapper {
    List<User> findAll();
}
