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
import org.springblade.core.tool.utils.CollectionUtil;
import org.springblade.modules.lemenpan.entity.PersonlInfo;
import org.springblade.modules.lemenpan.mapper.PersonlInfoMapper;
import org.springblade.modules.lemenpan.service.IPersonlInfoService;
import org.springblade.modules.lemenpan.vo.PersonlInfoVO;
import org.springblade.modules.lemenpan.wrapper.PersonlInfoWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 个人信息表 存储个人的身份信息! 服务实现类
 *
 * @author LeMenPan
 * @since 2019-11-10
 */
@Service
public class PersonlInfoServiceImpl extends ServiceImpl<PersonlInfoMapper, PersonlInfo> implements IPersonlInfoService {

	@Override
	public IPage<PersonlInfoVO> selectPersonlInfoPage(IPage<PersonlInfoVO> page, PersonlInfoVO entity) {
		List<PersonlInfo> list = baseMapper.selectPersonlInfoPage(page, entity);
		List<PersonlInfoVO> returnList = new ArrayList<>();
		if (CollectionUtil.isNotEmpty(list)) {
			for (PersonlInfo personlInfo : list) {
				personlInfo = new PersonlInfoWrapper().entityVO(personlInfo);
				returnList.add((PersonlInfoVO) personlInfo);
			}
		}
		return page.setRecords(returnList);
	}

}
