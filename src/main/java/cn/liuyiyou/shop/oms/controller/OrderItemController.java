package cn.liuyiyou.shop.oms.controller;

import cn.liuyiyou.shop.oms.dto.OrderItemDTO;
import cn.liuyiyou.shop.oms.service.OrderItemService;
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

/**
 * Controller to OrderItem.
 *
 * @author liuyiyou.cn 2019-09-27
 */
@Api(value = "OrderItemController", tags = "订单明细管理")
@RestController
@RequestMapping("/api")
@Slf4j
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;


    @ApiOperation(value = "根据ID获取#OrderItem#", notes = "根据ID获取#OrderItem#")
    @GetMapping("/orderItem/{id:.+}")
    public ResultEntity<OrderItemDTO> find(@PathVariable Long id) {
        return ResultEntity.wrapOrNotFound(orderItemService.find(id).map(OrderItemDTO::new));

    }


    @PostMapping("/orderItem")
    @ApiOperation(value = "新建#OrderItem#", notes = "新建#OrderItem#")
    public ResultEntity<OrderItemDTO> create(@Valid @RequestBody OrderItemDTO orderItemDTO) {
        if (orderItemDTO.getOrderId() != null) {
            throw new BadRequestAlertException("A new OrderItem cannot already have an ID", "OrderItem", "idexists");
        } else {
            OrderItemDTO newOrderItem = new OrderItemDTO(orderItemService.create(orderItemDTO));
            return ResultEntity.ok(newOrderItem);

        }
    }


    @PutMapping("/orderItem")
    @ApiOperation(value = "更新#OrderItem#", notes = "更新#OrderItem#")
    public ResultEntity<OrderItemDTO> update(@Valid @RequestBody OrderItemDTO orderItemDTO) {
        OrderItemDTO newOrderItem = new OrderItemDTO(orderItemService.update(orderItemDTO));
        return ResultEntity.ok(newOrderItem);
    }

    @PutMapping("/orderItem/modify")
    @ApiOperation(value = "更新#OrderItem#部分字段，只更新对应DTO里的not null字段", notes = "更新#OrderItem#部分字段,只更新对应DTO里的not null字段")
    public ResultEntity<OrderItemDTO> modify(@Valid @RequestBody OrderItemDTO orderItemDTO) {
        OrderItemDTO newOrderItem = new OrderItemDTO(orderItemService.modify(orderItemDTO));
        return ResultEntity.ok(newOrderItem);
    }


    @ApiOperation(value = "刪除#OrderItem#", notes = "刪除#OrderItem#")
    @DeleteMapping("/orderItem/{id:.+}")
    public ResultEntity<String> delete(@PathVariable Long id) {
        orderItemService.delete(id);
        return ResultEntity.success();
    }


    @ApiOperation(value = "获取#OrderItem#列表", notes = "获取#OrderItem#列表")
    @GetMapping("/orderItem/list")
    public ResultEntity<Page<OrderItemDTO>> list(Pageable pageable) {
        return ResultEntity.ok(orderItemService.list(pageable));

    }

    @ApiOperation(value = "获取#OrderItem#列表", notes = "获取#OrderItem#列表")
    @PostMapping("/orderItem/list")
    public ResultEntity<Page<OrderItemDTO>> list(@RequestBody OrderItemDTO orderItemDTO, Pageable pageable) {
        return ResultEntity.ok(orderItemService.list(pageable));

    }


    @ApiOperation(value = "高级搜索", notes = "whereClause example: (id=1 or lastModifiedDate > 'yyyy-MM-dd HH:mm') and createdBy=admin \n 前端需要调用encodeURIComponent(whereClause)进行编码")
    @GetMapping(value = "/orderItem/adv/{whereClause}")
    public ResultEntity<Page<OrderItemDTO>> advancedSearch(@PathVariable String whereClause, Pageable pageable) throws JSQLParserException {
        return ResultEntity.ok(orderItemService.advancedSearch(whereClause, pageable));
    }


}
