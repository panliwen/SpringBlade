/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.modules.lemenpan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springblade.common.tool.BaseCommonValue;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.lemenpan.entity.PersonlInfo;
import org.springblade.modules.lemenpan.service.IPersonlInfoService;
import org.springblade.modules.lemenpan.vo.PersonlInfoVO;
import org.springblade.modules.lemenpan.wrapper.PersonlInfoWrapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 个人信息表 存储个人的身份信息! 控制器
 *
 * @author LeMenPan
 * @since 2019-11-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("blade-desk/personlinfo")
@Api(value = "个人信息表 存储个人的身份信息!", tags = "个人信息表 存储个人的身份信息!接口")
public class PersonlInfoController extends BladeController {

	private IPersonlInfoService personlInfoService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入personlInfo")
	public R<PersonlInfoVO> detail(PersonlInfo personlInfo) {
		PersonlInfo detail = personlInfoService.getOne(Condition.getQueryWrapper(personlInfo));
		return R.data(PersonlInfoWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 个人信息表 存储个人的身份信息!
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入personlInfo")
	@Cacheable(value = BaseCommonValue.INFO_CACHEBLE_KEY)
	public R<IPage<PersonlInfoVO>> list(PersonlInfo personlInfo, Query query) {
		IPage<PersonlInfo> pages = personlInfoService.page(Condition.getPage(query), Condition.getQueryWrapper(personlInfo));
		return R.data(PersonlInfoWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 个人信息表 存储个人的身份信息!
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入personlInfo")
	@Cacheable(value = BaseCommonValue.INFO_CACHEBLE_KEY)
	public R<IPage<PersonlInfoVO>> page(PersonlInfoVO personlInfo, Query query) {
		IPage<PersonlInfoVO> pages = personlInfoService.selectPersonlInfoPage(Condition.getPage(query), personlInfo);
		return R.data(pages);
	}

	/**
	 * 新增 个人信息表 存储个人的身份信息!
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入personlInfo")
	public R save(@Valid @RequestBody PersonlInfo personlInfo) {
		return R.status(personlInfoService.save(personlInfo));
	}

	/**
	 * 修改 个人信息表 存储个人的身份信息!
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入personlInfo")
	public R update(@Valid @RequestBody PersonlInfo personlInfo) {
		return R.status(personlInfoService.updateById(personlInfo));
	}

	/**
	 * 新增或修改 个人信息表 存储个人的身份信息!
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入personlInfo")
	public R submit(@Valid @RequestBody PersonlInfo personlInfo) {
		return R.status(personlInfoService.saveOrUpdate(personlInfo));
	}

	
	/**
	 * 删除 个人信息表 存储个人的身份信息!
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(personlInfoService.removeById(Func.toInt(ids)));
	}

	
}
