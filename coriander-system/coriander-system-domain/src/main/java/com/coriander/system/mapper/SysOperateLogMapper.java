package com.coriander.system.mapper;

import com.coriander.system.domain.pojo.SysOperateLog;

/**
 * @author : xiangy
 */
public interface SysOperateLogMapper {
    int deleteByPrimaryKey(Long operateId);

    int insert(SysOperateLog record);

    int insertSelective(SysOperateLog record);

    SysOperateLog selectByPrimaryKey(Long operateId);

    int updateByPrimaryKeySelective(SysOperateLog record);

    int updateByPrimaryKey(SysOperateLog record);
}