package cn.liuyiyou.shop.oms.controller;

import cn.liuyiyou.shop.oms.dto.OrderDTO;
import cn.liuyiyou.shop.oms.service.OrderService;
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


@Slf4j
@Api(value = "OrderController", tags = "订单管理")
@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "根据ID获取#Order#", notes = "根据ID获取#Order#")
    @GetMapping("/order/{id}")
    public ResultEntity<OrderDTO> find(@PathVariable Long id) {
        return ResultEntity.wrapOrNotFound(orderService.find(id).map(OrderDTO::new));

    }


    @PostMapping("/order")
    @ApiOperation(value = "新建#Order#", notes = "新建#Order#")
    public ResultEntity<OrderDTO> create(@Valid @RequestBody OrderDTO orderDTO) {
        if (orderDTO.getOrderId() != null) {
            throw new BadRequestAlertException("A new Order cannot already have an ID", "Order", "idexists");

        } else {
            OrderDTO newOrder = new OrderDTO(orderService.create(orderDTO));
            return ResultEntity.ok(newOrder);

        }
    }


    @PutMapping("/order")
    @ApiOperation(value = "更新#Order#", notes = "更新#Order#")
    public ResultEntity<OrderDTO> update(@Valid @RequestBody OrderDTO orderDTO) {
        if (log.isDebugEnabled()) {
            log.debug("REST request to update OrderDTO : {}", orderDTO);
        }

        OrderDTO newOrder = new OrderDTO(orderService.update(orderDTO));
        return ResultEntity.ok(newOrder);
    }


    @PutMapping("/order/modify")
    @ApiOperation(value = "更新#Order#部分字段，只更新对应DTO里的not null字段", notes = "更新#Order#部分字段,只更新对应DTO里的not null字段")
    public ResultEntity<OrderDTO> modify(@Valid @RequestBody OrderDTO orderDTO) {
        OrderDTO newOrder = new OrderDTO(orderService.modify(orderDTO));
        return ResultEntity.ok(newOrder);
    }


    @ApiOperation(value = "刪除#Order#", notes = "刪除#Order#")
    @DeleteMapping("/order/{id}")
    public ResultEntity<String> delete(@PathVariable Long id) {
        if (log.isDebugEnabled()) {
            log.debug("REST request to delete Order: {}", id);
        }
        orderService.delete(id);
        return ResultEntity.success();
    }

    @ApiOperation(value = "获取#Order#列表", notes = "获取#Order#列表")
    @GetMapping("/order/list")
    public ResultEntity<Page<OrderDTO>> list(Pageable pageable) {
        return ResultEntity.ok(orderService.list(pageable));

    }

    @ApiOperation(value = "获取#Order#列表", notes = "获取#Order#列表")
    @PostMapping("/order/list")
    public ResultEntity<Page<OrderDTO>> list(@RequestBody OrderDTO orderDTO, Pageable pageable) {
        return ResultEntity.ok(orderService.list(pageable));

    }


    @ApiOperation(value = "高级搜索", notes = "whereClause example: (id=1 or lastModifiedDate > 'yyyy-MM-dd HH:mm') and createdBy=admin \n 前端需要调用encodeURIComponent(whereClause)进行编码")
    @GetMapping(value = "/order/adv/{whereClause}")
    public ResultEntity<Page<OrderDTO>> advancedSearch(@PathVariable String whereClause, Pageable pageable) throws JSQLParserException {
        return ResultEntity.ok(orderService.advancedSearch(whereClause, pageable));
    }


}
