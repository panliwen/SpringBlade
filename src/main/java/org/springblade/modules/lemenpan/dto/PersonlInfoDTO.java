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
package org.springblade.modules.lemenpan.dto;

import org.springblade.modules.lemenpan.entity.PersonlInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 个人信息表 存储个人的身份信息!数据传输对象实体类
 *
 * @author LeMenPan
 * @since 2019-11-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PersonlInfoDTO extends PersonlInfo {
	private static final long serialVersionUID = 1L;

}