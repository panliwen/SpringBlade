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
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.lemenpan.entity.Family;
import org.springblade.modules.lemenpan.service.IFamilyService;
import org.springblade.modules.lemenpan.vo.FamilyVO;
import org.springblade.modules.lemenpan.wrapper.FamilyWrapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 家庭成员 家庭的成员信息 控制器
 *
 * @author LeMenPan
 * @since 2019-11-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("blade-desk/family")
@Api(value = "家庭成员 家庭的成员信息", tags = "家庭成员 家庭的成员信息接口")
public class FamilyController extends BladeController {

	private IFamilyService familyService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入family")
	public R<FamilyVO> detail(Family family) {
		Family detail = familyService.getOne(Condition.getQueryWrapper(family));
		return R.data(FamilyWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 家庭成员 家庭的成员信息
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入family")
	public R<IPage<FamilyVO>> list(Family family, Query query) {
		IPage<Family> pages = familyService.page(Condition.getPage(query), Condition.getQueryWrapper(family));
		return R.data(FamilyWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 家庭成员 家庭的成员信息
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入family")
	@Cacheable()
	public R<IPage<FamilyVO>> page(FamilyVO family, Query query) {
		IPage<FamilyVO> pages = familyService.selectFamilyPage(Condition.getPage(query), family);
		return R.data(pages);
	}

	/**
	 * 新增 家庭成员 家庭的成员信息
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入family")
	public R save(@Valid @RequestBody Family family) {
		return R.status(familyService.save(family));
	}

	/**
	 * 修改 家庭成员 家庭的成员信息
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入family")
	public R update(@Valid @RequestBody Family family) {
		return R.status(familyService.updateById(family));
	}

	/**
	 * 新增或修改 家庭成员 家庭的成员信息
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入family")
	public R submit(@Valid @RequestBody Family family) {
		return R.status(familyService.saveOrUpdate(family));
	}

	
	/**
	 * 删除 家庭成员 家庭的成员信息
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(familyService.removeById(Func.toInt(ids)));
	}

	
}
