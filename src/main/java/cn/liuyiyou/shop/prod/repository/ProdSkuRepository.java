package cn.liuyiyou.shop.prod.repository;

import cn.liuyiyou.shop.prod.domain.ProdSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the {@link ProdSku} entity.
 *
 * @author liuyiyou.cn 2019-09-27
 */
@Repository
public interface ProdSkuRepository extends JpaRepository<ProdSku, Long>, JpaSpecificationExecutor<ProdSku> {

}
