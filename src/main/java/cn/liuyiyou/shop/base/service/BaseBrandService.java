package cn.liuyiyou.shop.base.service;

import cn.liuyiyou.shop.base.domain.BaseBrand;
import cn.liuyiyou.shop.base.dto.BaseBrandDTO;
import cn.liuyiyou.shop.base.repository.BaseBrandRepository;
import cn.liuyiyou.shop.support.http.rest.errors.BadRequestAlertException;
import cn.liuyiyou.shop.support.jpa.criteria.GenericSpecification;
import net.sf.jsqlparser.JSQLParserException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service class for managing BaseBrand.
 *
 * @author liuyiyou 2019-09-26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BaseBrandService {
    private final Logger log = LoggerFactory.getLogger(BaseBrandService.class);
    @Autowired
    private BaseBrandRepository baseBrandRepository;

    @Transactional(readOnly = true)
    public Optional<BaseBrand> find(Long id) {
        return baseBrandRepository.findById(id);
    }

    public BaseBrand create(BaseBrandDTO dto) {
        BaseBrand baseBrand = dto.toBaseBrand();
        baseBrand.setBrandId(null);

        return baseBrandRepository.save(baseBrand);
    }

    public BaseBrand update(BaseBrandDTO dto) {
        if (dto.getBrandId() == null) {
            throw new BadRequestAlertException("A  BaseBrand cannot be updated without an ID", "BaseBrand", "idBlank");
        }
        if (this.find(dto.getBrandId()).isPresent()) {
            if (log.isDebugEnabled()) {
                log.debug("Update  BaseBrandDTO: {}", dto);
            }
            BaseBrand baseBrand = dto.toBaseBrand();
            return baseBrandRepository.save(baseBrand);
        } else {
            throw new BadRequestAlertException("BaseBrand does not exist !", "BaseBrand", "notExists");
        }

    }

    public BaseBrand modify(BaseBrandDTO dto) {
        if (dto.getBrandId() == null) {
            throw new BadRequestAlertException("A  BaseBrand cannot be modified without an ID", "BaseBrand", "idBlank");
        }
        return baseBrandRepository.findById(dto.getBrandId()).map(baseBrand -> {
            dto.toBaseBrand(baseBrand);
            return baseBrandRepository.save(baseBrand);
        }).orElseGet(() -> {
            throw new BadRequestAlertException("BaseBrand does not exist !", "BaseBrand", "notExists");
        });
    }

    public void delete(Long id) {
        baseBrandRepository.findById(id).map(baseBrand -> {
            baseBrandRepository.delete(baseBrand);
            return id;
        }).orElseGet(() -> {
            throw new BadRequestAlertException("BaseBrand does not exist !", "BaseBrand", "notExists");
        });

    }


    @Transactional(readOnly = true)
    public Page<BaseBrandDTO> list(Pageable pageable) {
        return baseBrandRepository.findAll(pageable).map(BaseBrandDTO::new);
    }


    /**
     * @param whereClause (id=1 or lastModifiedDate > 20190926) and createdBy=admin
     * @param pageable
     * @return
     * @throws JSQLParserException
     */
    @Transactional(readOnly = true)
    public Page<BaseBrandDTO> advancedSearch(String whereClause, Pageable pageable) throws JSQLParserException {
        if (StringUtils.isBlank(whereClause)) {
            return baseBrandRepository.findAll(pageable).map(BaseBrandDTO::new);
        }
        GenericSpecification<BaseBrand> specification = GenericSpecification.of(whereClause);
        return baseBrandRepository.findAll(specification, pageable).map(BaseBrandDTO::new);

    }

}
