package io.mustang.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.mustang.modules.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author Mustang
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
