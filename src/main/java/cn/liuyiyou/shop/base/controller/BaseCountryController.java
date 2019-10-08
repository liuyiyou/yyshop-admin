package cn.liuyiyou.shop.base.controller;

import cn.liuyiyou.shop.base.dto.BaseCountryDTO;
import cn.liuyiyou.shop.base.service.BaseCountryService;
import cn.liuyiyou.shop.support.http.ResultEntity;
import cn.liuyiyou.shop.support.http.rest.errors.BadRequestAlertException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller to BaseCountry.
 *
 * @author liuyiyou.cn 2019-09-26
 */
@Api(value = "BaseCountryController", tags = "国家管理")
@RestController
@RequestMapping("/api")
@Slf4j
public class BaseCountryController {
    @Autowired
    private BaseCountryService baseCountryService;


    @ApiOperation(value = "根据ID获取#BaseCountry#", notes = "根据ID获取#BaseCountry#")
    @GetMapping("/baseCountry/{id:.+}")
    public ResultEntity<BaseCountryDTO> find(@PathVariable String id) {
        return ResultEntity.wrapOrNotFound(baseCountryService.find(id).map(BaseCountryDTO::new));

    }


    @PostMapping("/baseCountry")
    @ApiOperation(value = "新建#BaseCountry#", notes = "新建#BaseCountry#")
    public ResultEntity<BaseCountryDTO> create(@Valid @RequestBody BaseCountryDTO baseCountryDTO) {
        if (baseCountryDTO.getCountryId() != null) {
            throw new BadRequestAlertException("A new BaseCountry cannot already have an ID", "BaseCountry", "idexists");

        } else {
            BaseCountryDTO newBaseCountry = new BaseCountryDTO(baseCountryService.create(baseCountryDTO));
            return ResultEntity.ok(newBaseCountry);

        }
    }


    @PutMapping("/baseCountry")
    @ApiOperation(value = "更新#BaseCountry#", notes = "更新#BaseCountry#")
    public ResultEntity<BaseCountryDTO> update(@Valid @RequestBody BaseCountryDTO baseCountryDTO) {
        BaseCountryDTO newBaseCountry = new BaseCountryDTO(baseCountryService.update(baseCountryDTO));
        return ResultEntity.ok(newBaseCountry);
    }


    @PutMapping("/baseCountry/modify")
    @ApiOperation(value = "更新#BaseCountry#部分字段，只更新对应DTO里的not null字段", notes = "更新#BaseCountry#部分字段,只更新对应DTO里的not null字段")
    public ResultEntity<BaseCountryDTO> modify(@Valid @RequestBody BaseCountryDTO baseCountryDTO) {
        BaseCountryDTO newBaseCountry = new BaseCountryDTO(baseCountryService.modify(baseCountryDTO));
        return ResultEntity.ok(newBaseCountry);
    }


    @ApiOperation(value = "刪除#BaseCountry#", notes = "刪除#BaseCountry#")
    @DeleteMapping("/baseCountry/{id:.+}")
    public ResultEntity<String> delete(@PathVariable String id) {
        baseCountryService.delete(id);
        return ResultEntity.success();
    }


    @ApiOperation(value = "获取#BaseCountry#列表", notes = "获取#BaseCountry#列表")
    @GetMapping("/baseCountry/list")
    public ResultEntity<Page<BaseCountryDTO>> list(Pageable pageable) {
        return ResultEntity.ok(baseCountryService.list(pageable));

    }

    @ApiOperation(value = "获取#BaseCountry#列表", notes = "获取#BaseCountry#列表")
    @PostMapping("/baseCountry/list")
    public ResultEntity<Page<BaseCountryDTO>> list(@RequestBody BaseCountryDTO baseCountryDTO, Pageable pageable) {
        return ResultEntity.ok(baseCountryService.list(pageable));

    }


    @ApiOperation(value = "高级搜索", notes = "whereClause example: (id=1 or lastModifiedDate > 'yyyy-MM-dd HH:mm') and createdBy=admin \n 前端需要调用encodeURIComponent(whereClause)进行编码")
    @GetMapping(value = "/baseCountry/adv/{whereClause}")
    public ResultEntity<Page<BaseCountryDTO>> advancedSearch(@PathVariable String whereClause, Pageable pageable) throws JSQLParserException {
        return ResultEntity.ok(baseCountryService.advancedSearch(whereClause, pageable));
    }


}
