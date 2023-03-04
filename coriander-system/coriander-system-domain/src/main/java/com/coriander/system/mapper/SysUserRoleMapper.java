package com.coriander.system.mapper;

import com.coriander.system.domain.pojo.SysUserRole;
import org.apache.ibatis.annotations.Param;

/**
 * @author : xiangy
 */
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}