package cn.liuyiyou.shop.base.repository;

import cn.liuyiyou.shop.base.domain.BaseCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the {@link BaseCountry} entity.
 *
 * @author liuyiyou.cn 2019-09-26
 */
@Repository
public interface BaseCountryRepository extends JpaRepository<BaseCountry, String>,JpaSpecificationExecutor<BaseCountry> {

}
