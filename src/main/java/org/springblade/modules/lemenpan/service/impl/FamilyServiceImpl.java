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
package org.springblade.modules.lemenpan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.modules.lemenpan.entity.Family;
import org.springblade.modules.lemenpan.mapper.FamilyMapper;
import org.springblade.modules.lemenpan.service.IFamilyService;
import org.springblade.modules.lemenpan.vo.FamilyVO;
import org.springframework.stereotype.Service;

/**
 * 家庭成员 家庭的成员信息 服务实现类
 *
 * @author LeMenPan
 * @since 2019-11-10
 */
@Service
public class FamilyServiceImpl extends ServiceImpl<FamilyMapper, Family> implements IFamilyService {

	@Override
	public IPage<FamilyVO> selectFamilyPage(IPage<FamilyVO> page, FamilyVO family) {
		return page.setRecords(baseMapper.selectFamilyPage(page, family));
	}

}
