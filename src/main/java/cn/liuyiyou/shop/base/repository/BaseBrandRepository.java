package cn.liuyiyou.shop.base.repository;

import cn.liuyiyou.shop.base.domain.BaseBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the {@link BaseBrand} entity.
 *
 * @author liuyiyou 2019-09-26
 */
@Repository
public interface BaseBrandRepository extends JpaRepository<BaseBrand, Long>, JpaSpecificationExecutor<BaseBrand> {

}
