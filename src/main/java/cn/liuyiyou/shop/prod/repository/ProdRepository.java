package cn.liuyiyou.shop.prod.repository;

import cn.liuyiyou.shop.prod.domain.Prod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the {@link Prod} entity.
 *
 * @author liuyiyou.cn 2019-09-27
 */
@Repository
public interface ProdRepository extends JpaRepository<Prod, Long>, JpaSpecificationExecutor<Prod> {

}
