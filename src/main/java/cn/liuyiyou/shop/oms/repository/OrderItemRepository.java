package cn.liuyiyou.shop.oms.repository;

import cn.liuyiyou.shop.oms.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the {@link OrderItem} entity.
 *
 * @author liuyiyou.cn 2019-09-27
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>, JpaSpecificationExecutor<OrderItem> {

}
