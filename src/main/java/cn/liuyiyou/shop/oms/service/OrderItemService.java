package cn.liuyiyou.shop.oms.service;

import cn.liuyiyou.shop.oms.domain.OrderItem;
import cn.liuyiyou.shop.oms.dto.OrderItemDTO;
import cn.liuyiyou.shop.oms.repository.OrderItemRepository;
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

/**
 * Service class for managing OrderItem.
 *
 * @author liuyiyou.cn 2019-09-27
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public Optional<OrderItem> find(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem create(OrderItemDTO dto) {
        OrderItem orderItem = dto.toOrderItem();
        return orderItemRepository.save(orderItem);
    }

    public OrderItem update(OrderItemDTO dto) {
        if (dto.getOrderId() == null) {
            throw new BadRequestAlertException("A  OrderItem cannot be updated without an ID", "OrderItem", "idBlank");
        }
        if (this.find(dto.getOrderId()).isPresent()) {
            OrderItem orderItem = dto.toOrderItem();
            return orderItemRepository.save(orderItem);
        } else {
            throw new BadRequestAlertException("OrderItem does not exist !", "OrderItem", "notExists");
        }

    }

    public OrderItem modify(OrderItemDTO dto) {
        if (dto.getOrderId() == null) {
            throw new BadRequestAlertException("A  OrderItem cannot be modified without an ID", "OrderItem", "idBlank");
        }

        return orderItemRepository.findById(dto.getOrderId()).map(orderItem -> {
            dto.toOrderItem(orderItem);
            return orderItemRepository.save(orderItem);
        }).orElseGet(() -> {
            throw new BadRequestAlertException("OrderItem does not exist !", "OrderItem", "notExists");
        });
    }

    public void delete(Long id) {
        orderItemRepository.findById(id).map(orderItem -> {
            orderItemRepository.delete(orderItem);
            return id;
        }).orElseGet(() -> {
            throw new BadRequestAlertException("OrderItem does not exist !", "OrderItem", "notExists");
        });

    }


    @Transactional(readOnly = true)
    public Page<OrderItemDTO> list(Pageable pageable) {
        return orderItemRepository.findAll(pageable).map(OrderItemDTO::new);
    }


    @Transactional(readOnly = true)
    public Page<OrderItemDTO> advancedSearch(String whereClause, Pageable pageable) throws JSQLParserException {
        if (StringUtils.isBlank(whereClause)) {
            return orderItemRepository.findAll(pageable).map(OrderItemDTO::new);
        }
        GenericSpecification<OrderItem> specification = GenericSpecification.of(whereClause);
        return orderItemRepository.findAll(specification, pageable).map(OrderItemDTO::new);

    }

}
