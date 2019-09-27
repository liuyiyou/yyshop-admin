package cn.liuyiyou.shop.base.controller;

import cn.liuyiyou.shop.base.dto.BaseBrandDTO;
import cn.liuyiyou.shop.base.service.BaseBrandService;
import cn.liuyiyou.shop.support.http.ResultEntity;
import cn.liuyiyou.shop.support.http.rest.errors.BadRequestAlertException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * Controller to BaseBrand.
 *
 * @author liuyiyou 2019-09-26
 */
@Api(value = "BaseBrandController", tags = "品牌管理")
@RestController
@RequestMapping("/api")
public class BaseBrandController {
    private final Logger log = LoggerFactory.getLogger(BaseBrandController.class);
    @Autowired
    private BaseBrandService baseBrandService;


    @ApiOperation(value = "根据ID获取#BaseBrand#", notes = "根据ID获取#BaseBrand#")
    @GetMapping("/brand/{id:.+}")
    public ResultEntity<BaseBrandDTO> find(@PathVariable Long id) {
        return ResultEntity.wrapOrNotFound(baseBrandService.find(id).map(BaseBrandDTO::new));

    }


    @PostMapping("/brand")
    @ApiOperation(value = "新建#BaseBrand#", notes = "新建#BaseBrand#")
    public ResultEntity<BaseBrandDTO> create(@Valid @RequestBody BaseBrandDTO baseBrandDTO) {
        if (baseBrandDTO.getBrandId() != null) {
            throw new BadRequestAlertException("A new BaseBrand cannot already have an ID", "BaseBrand", "idexists");
        } else {
            BaseBrandDTO newBaseBrand = new BaseBrandDTO(baseBrandService.create(baseBrandDTO));
            return ResultEntity.ok(newBaseBrand);

        }
    }


    @PutMapping("/brand")
    @ApiOperation(value = "更新#BaseBrand#", notes = "更新#BaseBrand#")
    public ResultEntity<BaseBrandDTO> update(@Valid @RequestBody BaseBrandDTO baseBrandDTO) {
        BaseBrandDTO newBaseBrand = new BaseBrandDTO(baseBrandService.update(baseBrandDTO));
        return ResultEntity.ok(newBaseBrand);
    }


    @PutMapping("/brand/modify")
    @ApiOperation(value = "更新#BaseBrand#部分字段，只更新对应DTO里的not null字段", notes = "更新#BaseBrand#部分字段,只更新对应DTO里的not null字段")
    public ResultEntity<BaseBrandDTO> modify(@Valid @RequestBody BaseBrandDTO baseBrandDTO) {
        BaseBrandDTO newBaseBrand = new BaseBrandDTO(baseBrandService.modify(baseBrandDTO));
        return ResultEntity.ok(newBaseBrand);
    }


    @ApiOperation(value = "刪除#BaseBrand#", notes = "刪除#BaseBrand#")
    @DeleteMapping("/brand/{id}")
    public ResultEntity<String> delete(@PathVariable Long id) {
        if (log.isDebugEnabled()) {
            log.debug("REST request to delete BaseBrand: {}", id);
        }
        baseBrandService.delete(id);
        return ResultEntity.success();
    }


    @ApiOperation(value = "获取#BaseBrand#列表", notes = "获取#BaseBrand#列表")
    @GetMapping("/baseBrand/list")
    public ResultEntity<Page<BaseBrandDTO>> list(Pageable pageable) {
        return ResultEntity.ok(baseBrandService.list(pageable));

    }

    @ApiOperation(value = "获取#BaseBrand#列表", notes = "获取#BaseBrand#列表")
    @PostMapping("/baseBrand/list")
    public ResultEntity<Page<BaseBrandDTO>> list(@RequestBody BaseBrandDTO baseBrandDTO, Pageable pageable) {
        return ResultEntity.ok(baseBrandService.list(pageable));

    }

    @ApiOperation(value = "高级搜索", notes = "whereClause example: (id=1 or lastModifiedDate > 20190926) and createdBy=admin \n 前端需要调用encodeURIComponent(whereClause)进行编码")
    @GetMapping(value = "/baseBrand/adv/{whereClause}")
    public ResultEntity<Page<BaseBrandDTO>> advancedSearch(@PathVariable String whereClause, Pageable pageable) throws JSQLParserException {
        return ResultEntity.ok(baseBrandService.advancedSearch(whereClause, pageable));
    }


}
