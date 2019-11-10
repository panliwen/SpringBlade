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
package org.springblade.modules.lemenpan.wrapper;

import lombok.AllArgsConstructor;
import org.springblade.core.mp.support.BaseEntityWrapper;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.lemenpan.entity.PersonlInfo;
import org.springblade.modules.lemenpan.vo.PersonlInfoVO;
import org.springframework.stereotype.Component;

/**
 * 个人信息表 存储个人的身份信息!包装类,返回视图层所需的字段
 *
 * @author LeMenPan
 * @since 2019-11-10
 */
@AllArgsConstructor
@Component
public class PersonlInfoWrapper extends BaseEntityWrapper<PersonlInfo, PersonlInfoVO>  {

    public static PersonlInfoWrapper build() {
        return new PersonlInfoWrapper();
    }

	@Override
	public PersonlInfoVO entityVO(PersonlInfo personlInfo) {
		PersonlInfoVO personlInfoVO = BeanUtil.copy(personlInfo, PersonlInfoVO.class);
		if (Func.isNotEmpty(personlInfoVO.getSex()))personlInfoVO.setSexName(personlInfoVO.getSex() ==1 ? "男":"女");
		return personlInfoVO;
	}

}
