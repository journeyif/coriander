package com.coriander.system.domain.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author : xiangy
 */

/**
 * 操作日志记录
 */
@ApiModel(value = "操作日志记录")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysOperateLog implements Serializable {
    /**
     * 日志主键
     */
    @ApiModelProperty(value = "日志主键")
    private Long operateId;

    /**
     * 模块标题
     */
    @ApiModelProperty(value = "模块标题")
    private String title;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @ApiModelProperty(value = "业务类型（0其它 1新增 2修改 3删除）")
    private Integer businessType;

    /**
     * 方法名称
     */
    @ApiModelProperty(value = "方法名称")
    private String method;

    /**
     * 请求方式
     */
    @ApiModelProperty(value = "请求方式")
    private String requestMethod;

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    @ApiModelProperty(value = "操作类别（0其它 1后台用户 2手机端用户）")
    private Integer operateType;

    /**
     * 操作人员
     */
    @ApiModelProperty(value = "操作人员")
    private String operateName;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    /**
     * 请求URL
     */
    @ApiModelProperty(value = "请求URL")
    private String operateUrl;

    /**
     * 主机地址
     */
    @ApiModelProperty(value = "主机地址")
    private String operateIp;

    /**
     * 操作地点
     */
    @ApiModelProperty(value = "操作地点")
    private String operateLocation;

    /**
     * 请求参数
     */
    @ApiModelProperty(value = "请求参数")
    private String operateParam;

    /**
     * 返回参数
     */
    @ApiModelProperty(value = "返回参数")
    private String jsonResult;

    /**
     * 操作状态（0正常 1异常）
     */
    @ApiModelProperty(value = "操作状态（0正常 1异常）")
    private Integer status;

    /**
     * 错误消息
     */
    @ApiModelProperty(value = "错误消息")
    private String errorMsg;

    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private LocalDateTime operateTime;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}