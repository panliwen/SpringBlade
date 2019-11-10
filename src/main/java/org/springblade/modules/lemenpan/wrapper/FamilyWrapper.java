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

import org.springblade.core.mp.support.BaseEntityWrapper;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.lemenpan.entity.Family;
import org.springblade.modules.lemenpan.vo.FamilyVO;

/**
 * 家庭成员 家庭的成员信息包装类,返回视图层所需的字段
 *
 * @author LeMenPan
 * @since 2019-11-10
 */
public class FamilyWrapper extends BaseEntityWrapper<Family, FamilyVO>  {

    public static FamilyWrapper build() {
        return new FamilyWrapper();
    }

	@Override
	public FamilyVO entityVO(Family family) {
		FamilyVO familyVO = BeanUtil.copy(family, FamilyVO.class);
		if (Func.isNotEmpty(familyVO.getSex()))familyVO.setSexName(familyVO.getSex() ==1 ? "男":"女");
		return familyVO;
	}

}
