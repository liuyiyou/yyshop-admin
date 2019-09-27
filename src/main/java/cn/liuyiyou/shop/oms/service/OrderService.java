package cn.liuyiyou.shop.oms.service;

import cn.liuyiyou.shop.oms.domain.Order;
import cn.liuyiyou.shop.oms.dto.OrderDTO;
import cn.liuyiyou.shop.oms.repository.OrderRepository;
import cn.liuyiyou.shop.support.http.rest.errors.BadRequestAlertException;
import cn.liuyiyou.shop.support.jpa.criteria.GenericSpecification;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public Optional<Order> find(Long id) {
        return orderRepository.findById(id);
    }

    public Order create(OrderDTO dto) {
        Order order = dto.toOrder();
        order.setOrderId(null);
        return orderRepository.save(order);
    }

    public Order update(OrderDTO dto) {
        if (dto.getOrderId() == null) {
            throw new BadRequestAlertException("A  Order cannot be updated without an ID", "Order", "idBlank");
        }
        if (this.find(dto.getOrderId()).isPresent()) {
            Order order = dto.toOrder();
            return orderRepository.save(order);
        } else {
            throw new BadRequestAlertException("Order does not exist !", "Order", "notExists");
        }

    }

    public Order modify(OrderDTO dto) {
        if (dto.getOrderId() == null) {
            throw new BadRequestAlertException("A  Order cannot be modified without an ID", "Order", "idBlank");
        }
        return orderRepository.findById(dto.getOrderId()).map(order -> {

            dto.toOrder(order);
            return orderRepository.save(order);
        }).orElseGet(() -> {
            throw new BadRequestAlertException("Order does not exist !", "Order", "notExists");
        });
    }

    public void delete(Long id) {
        orderRepository.findById(id).map(order -> {
            orderRepository.delete(order);
            return id;
        }).orElseGet(() -> {
            throw new BadRequestAlertException("Order does not exist !", "Order", "notExists");
        });

    }


    @Transactional(readOnly = true)
    public Page<OrderDTO> list(Pageable pageable) {
        return orderRepository.findAll(pageable).map(OrderDTO::new);
    }


    @Transactional(readOnly = true)
    public Page<OrderDTO> advancedSearch(String whereClause, Pageable pageable) throws JSQLParserException {
        if (StringUtils.isBlank(whereClause)) {
            return orderRepository.findAll(pageable).map(OrderDTO::new);
        }
        GenericSpecification<Order> specification = GenericSpecification.of(whereClause);
        return orderRepository.findAll(specification, pageable).map(OrderDTO::new);

    }

}
