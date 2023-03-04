package com.coriander.system.mapper;

import com.coriander.system.domain.pojo.SysRoleMenu;
import org.apache.ibatis.annotations.Param;

/**
 * @author : xiangy
 */
public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);
}