/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.modules.lemenpan.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 个人信息表 存储个人的身份信息!实体类
 *
 * @author LeMenPan
 * @since 2019-11-10
 */
@Data
@TableName("personl_info")
//@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "PersonlInfo对象", description = "个人信息表 存储个人的身份信息!")
public class PersonlInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 编号 主键ID
	 */
	@ApiModelProperty(value = "编号 主键ID")
	private Double id;
	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	@TableField("User_Id")
	private Double userId;
	/**
	 * 名称
	 */
	@ApiModelProperty(value = "名称")
	private String name;
	/**
	 * 性别 性别：1 男  2 女  默认1
	 */
	@ApiModelProperty(value = "性别 性别：1 男  2 女  默认1")
	private Integer sex;
	/**
	 * 身高
	 */
	@ApiModelProperty(value = "身高")
	private String heigth;
	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码")
	private String hpone;
	/**
	 * 电子邮箱
	 */
	@ApiModelProperty(value = "电子邮箱")
	private String email;
	/**
	 * 出生年月
	 */
	@ApiModelProperty(value = "出生年月")
	private LocalDateTime birthday;
	/**
	 * 民族
	 */
	@ApiModelProperty(value = "民族")
	private String nation;
	/**
	 * 籍贯
	 */
	@ApiModelProperty(value = "籍贯")
	@TableField("Native_Place")
	private String nativePlace;
	/**
	 * 出生地
	 */
	@ApiModelProperty(value = "出生地")
	@TableField("Birthday_Address")
	private String birthdayAddress;
	/**
	 * 创建人编号
	 */
	@ApiModelProperty(value = "创建人编号")
	@TableField("Create_User")
	private Integer createUser;
	/**
	 * 创建日期
	 */
	@ApiModelProperty(value = "创建日期")
	@TableField("Create_Date")
	private LocalDateTime createDate;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;
	/**
	 * 是否删除 是否删除 ， 0 否 ， 1 是  默认为0
	 */
	@ApiModelProperty(value = "是否删除 是否删除 ， 0 否 ， 1 是  默认为0")
	@TableField("Is_Deleted")
	private Integer isDeleted;
	/**
	 * 租户ID
	 */
	@ApiModelProperty(value = "租户ID")
	@TableField("Tenant_Id")
	private Integer tenantId;


}
