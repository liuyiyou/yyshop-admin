package cn.liuyiyou.shop.base.service;

import cn.liuyiyou.shop.base.domain.BaseCountry;
import cn.liuyiyou.shop.base.dto.BaseCountryDTO;
import cn.liuyiyou.shop.base.repository.BaseCountryRepository;
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
 * Service class for managing BaseCountry.
 *
 * @author liuyiyou.cn 2019-09-26
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class BaseCountryService {
    @Autowired
    private BaseCountryRepository baseCountryRepository;

    @Transactional(readOnly = true)
    public Optional<BaseCountry> find(String id) {
        return baseCountryRepository.findById(id);
    }

    public BaseCountry create(BaseCountryDTO dto) {
        BaseCountry baseCountry = dto.toBaseCountry();
        baseCountry.setCountryId(null);

        return baseCountryRepository.save(baseCountry);
    }

    public BaseCountry update(BaseCountryDTO dto) {
        if (dto.getCountryId() == null) {
            throw new BadRequestAlertException("A  BaseCountry cannot be updated without an ID", "BaseCountry", "idBlank");
        }
        if (this.find(dto.getCountryId()).isPresent()) {
            BaseCountry baseCountry = dto.toBaseCountry();
            return baseCountryRepository.save(baseCountry);
        } else {
            throw new BadRequestAlertException("BaseCountry does not exist !", "BaseCountry", "notExists");
        }

    }

    public BaseCountry modify(BaseCountryDTO dto) {
        if (dto.getCountryId() == null) {
            throw new BadRequestAlertException("A  BaseCountry cannot be modified without an ID", "BaseCountry", "idBlank");
        }
        return baseCountryRepository.findById(dto.getCountryId()).map(baseCountry -> {
            dto.toBaseCountry(baseCountry);
            return baseCountryRepository.save(baseCountry);
        }).orElseGet(() -> {
            throw new BadRequestAlertException("BaseCountry does not exist !", "BaseCountry", "notExists");
        });
    }

    public void delete(String id) {
        baseCountryRepository.findById(id).map(baseCountry -> {
            baseCountryRepository.delete(baseCountry);

            return id;
        }).orElseGet(() -> {
            throw new BadRequestAlertException("BaseCountry does not exist !", "BaseCountry", "notExists");
        });

    }


    @Transactional(readOnly = true)
    public Page<BaseCountryDTO> list(Pageable pageable) {
        return baseCountryRepository.findAll(pageable).map(BaseCountryDTO::new);
    }


    @Transactional(readOnly = true)
    public Page<BaseCountryDTO> advancedSearch(String whereClause, Pageable pageable) throws JSQLParserException {
        if (StringUtils.isBlank(whereClause)) {
            return baseCountryRepository.findAll(pageable).map(BaseCountryDTO::new);
        }
        GenericSpecification<BaseCountry> specification = GenericSpecification.of(whereClause);
        return baseCountryRepository.findAll(specification, pageable).map(BaseCountryDTO::new);

    }

}
