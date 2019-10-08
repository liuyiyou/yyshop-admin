package cn.liuyiyou.shop.prod.controller;

import cn.liuyiyou.shop.prod.dto.ProdSkuDTO;
import cn.liuyiyou.shop.prod.service.ProdSkuService;
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


@Api(value = "ProdSkuController", tags = "SKU管理")
@RestController
@Slf4j
@RequestMapping("/api")
public class ProdSkuController {
    @Autowired
    private ProdSkuService prodSkuService;


    @ApiOperation(value = "根据ID获取#ProdSku#", notes = "根据ID获取#ProdSku#")
    @GetMapping("/prodSku/{id}")
    public ResultEntity<ProdSkuDTO> find(@PathVariable Long id) {
        return ResultEntity.wrapOrNotFound(prodSkuService.find(id).map(ProdSkuDTO::new));

    }


    @PostMapping("/prodSku")
    @ApiOperation(value = "新建#ProdSku#", notes = "新建#ProdSku#")
    public ResultEntity<ProdSkuDTO> create(@Valid @RequestBody ProdSkuDTO prodSkuDTO) {
        if (prodSkuDTO.getSkuId() != null) {
            throw new BadRequestAlertException("A new ProdSku cannot already have an ID", "ProdSku", "idexists");

        } else {
            ProdSkuDTO newProdSku = new ProdSkuDTO(prodSkuService.create(prodSkuDTO));
            return ResultEntity.ok(newProdSku);

        }
    }

    @PutMapping("/prodSku")
    @ApiOperation(value = "更新#ProdSku#", notes = "更新#ProdSku#")
    public ResultEntity<ProdSkuDTO> update(@Valid @RequestBody ProdSkuDTO prodSkuDTO) {
        ProdSkuDTO newProdSku = new ProdSkuDTO(prodSkuService.update(prodSkuDTO));
        return ResultEntity.ok(newProdSku);
    }


    @PutMapping("/prodSku/modify")
    @ApiOperation(value = "更新#ProdSku#部分字段，只更新对应DTO里的not null字段")
    public ResultEntity<ProdSkuDTO> modify(@Valid @RequestBody ProdSkuDTO prodSkuDTO) {
        ProdSkuDTO newProdSku = new ProdSkuDTO(prodSkuService.modify(prodSkuDTO));
        return ResultEntity.ok(newProdSku);
    }


    @ApiOperation(value = "刪除#ProdSku#", notes = "刪除#ProdSku#")
    @DeleteMapping("/prodSku/{id}")
    public ResultEntity<String> delete(@PathVariable Long id) {
        prodSkuService.delete(id);
        return ResultEntity.success();
    }


    @ApiOperation(value = "获取#ProdSku#列表", notes = "获取#ProdSku#列表", response = ProdSkuDTO.class)
    @GetMapping("/prodSku/list")
    public ResultEntity<Page<ProdSkuDTO>> list(Pageable pageable) {
        return ResultEntity.ok(prodSkuService.list(pageable));

    }

    @ApiOperation(value = "获取#ProdSku#列表", notes = "获取#ProdSku#列表", response = ProdSkuDTO.class)
    @PostMapping("/prodSku/list")
    public ResultEntity<Page<ProdSkuDTO>> list(@RequestBody ProdSkuDTO prodSkuDTO, Pageable pageable) {
        return ResultEntity.ok(prodSkuService.list(pageable));

    }


    @ApiOperation(value = "高级搜索", notes = "whereClause example: (id=1 or lastModifiedDate > 'yyyy-MM-dd HH:mm') and createdBy=admin \n 前端需要调用encodeURIComponent(whereClause)进行编码", response = ProdSkuDTO.class)
    @GetMapping(value = "/prodSku/adv/{whereClause}")
    public ResultEntity<Page<ProdSkuDTO>> advancedSearch(@PathVariable String whereClause, Pageable pageable) throws JSQLParserException {
        return ResultEntity.ok(prodSkuService.advancedSearch(whereClause, pageable));
    }


}
