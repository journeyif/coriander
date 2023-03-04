package com.coriander.system.mapper;

import com.coriander.system.domain.pojo.SysRoleDept;
import org.apache.ibatis.annotations.Param;

/**
 * @author : xiangy
 */
public interface SysRoleDeptMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("deptId") Long deptId);

    int insert(SysRoleDept record);

    int insertSelective(SysRoleDept record);
}