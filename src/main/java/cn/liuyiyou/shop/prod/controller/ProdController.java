package cn.liuyiyou.shop.prod.controller;

import cn.liuyiyou.shop.prod.dto.ProdDTO;
import cn.liuyiyou.shop.prod.service.ProdService;
import cn.liuyiyou.shop.support.http.ResultEntity;
import cn.liuyiyou.shop.support.http.rest.errors.BadRequestAlertException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
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


@Api(value = "ProdController", tags = "商品管理")
@RestController
@RequestMapping("/api")
@Slf4j
public class ProdController {

    @Autowired
    private ProdService prodService;


    @ApiOperation(value = "根据ID获取#Prod#", notes = "根据ID获取#Prod#")
    @GetMapping("/prod/{id}")
    public ResultEntity<ProdDTO> find(@PathVariable Long id) {
        return ResultEntity.wrapOrNotFound(prodService.find(id).map(ProdDTO::new));

    }


    @PostMapping("/prod")
    @ApiOperation(value = "新建#Prod#", notes = "新建#Prod#")
    public ResultEntity<ProdDTO> create(@Valid @RequestBody ProdDTO prodDTO) {
        if (prodDTO.getProdId() != null) {
            throw new BadRequestAlertException("A new Prod cannot already have an ID", "Prod", "idexists");

        } else {
            ProdDTO newProd = new ProdDTO(prodService.create(prodDTO));
            return ResultEntity.ok(newProd);

        }
    }

    @PutMapping("/prod")
    @ApiOperation(value = "更新#Prod#", notes = "更新#Prod#")
    public ResultEntity<ProdDTO> update(@Valid @RequestBody ProdDTO prodDTO) {
        ProdDTO newProd = new ProdDTO(prodService.update(prodDTO));
        return ResultEntity.ok(newProd);
    }

    @PutMapping("/prod/modify")
    @ApiOperation(value = "更新#Prod#部分字段，只更新对应DTO里的not null字段", notes = "更新#Prod#部分字段,只更新对应DTO里的not null字段")
    public ResultEntity<ProdDTO> modify(@Valid @RequestBody ProdDTO prodDTO) {
        ProdDTO newProd = new ProdDTO(prodService.modify(prodDTO));
        return ResultEntity.ok(newProd);
    }


    @ApiOperation(value = "刪除#Prod#", notes = "刪除#Prod#")
    @DeleteMapping("/prod/{id:.+}")
    public ResultEntity<String> delete(@PathVariable Long id) {
        if (log.isDebugEnabled()) {
            log.debug("REST request to delete Prod: {}", id);
        }
        prodService.delete(id);
        return ResultEntity.success();
    }


    @ApiOperation(value = "获取#Prod#列表", notes = "获取#Prod#列表")
    @GetMapping("/prod/list")
    public ResultEntity<Page<ProdDTO>> list(Pageable pageable) {
        return ResultEntity.ok(prodService.list(pageable));

    }

    @ApiOperation(value = "获取#Prod#列表", notes = "获取#Prod#列表")
    @PostMapping("/prod/list")
    public ResultEntity<Page<ProdDTO>> list(@RequestBody ProdDTO prodDTO, Pageable pageable) {
        return ResultEntity.ok(prodService.list(pageable));

    }


    @ApiOperation(value = "高级搜索", notes = "whereClause example: (id=1 or lastModifiedDate > 'yyyy-MM-dd HH:mm') and createdBy=admin \n 前端需要调用encodeURIComponent(whereClause)进行编码")
    @GetMapping(value = "/prod/adv/{whereClause}")
    public ResultEntity<Page<ProdDTO>> advancedSearch(@PathVariable String whereClause, Pageable pageable) throws JSQLParserException {
        return ResultEntity.ok(prodService.advancedSearch(whereClause, pageable));
    }


}
