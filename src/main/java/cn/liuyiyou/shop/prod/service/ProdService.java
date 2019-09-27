package cn.liuyiyou.shop.prod.service;

import cn.liuyiyou.shop.prod.domain.Prod;
import cn.liuyiyou.shop.prod.dto.ProdDTO;
import cn.liuyiyou.shop.prod.repository.ProdRepository;
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
 * Service class for managing Prod.
 *
 * @author liuyiyou.cn 2019-09-27
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class ProdService {
    @Autowired
    private ProdRepository prodRepository;

    @Transactional(readOnly = true)
    public Optional<Prod> find(Long id) {
        return prodRepository.findById(id);
    }

    public Prod create(ProdDTO dto) {
        Prod prod = dto.toProd();
        prod.setProdId(null);
        return prodRepository.save(prod);
    }

    public Prod update(ProdDTO dto) {
        if (dto.getProdId() == null) {
            throw new BadRequestAlertException("A  Prod cannot be updated without an ID", "Prod", "idBlank");
        }
        if (this.find(dto.getProdId()).isPresent()) {
            Prod prod = dto.toProd();
            return prodRepository.save(prod);
        } else {
            throw new BadRequestAlertException("Prod does not exist !", "Prod", "notExists");
        }

    }

    public Prod modify(ProdDTO dto) {
        if (dto.getProdId() == null) {
            throw new BadRequestAlertException("A  Prod cannot be modified without an ID", "Prod", "idBlank");
        }

        return prodRepository.findById(dto.getProdId()).map(prod -> {
            dto.toProd(prod);
            return prodRepository.save(prod);
        }).orElseGet(() -> {
            throw new BadRequestAlertException("Prod does not exist !", "Prod", "notExists");
        });
    }

    public void delete(Long id) {
        prodRepository.findById(id).map(prod -> {
            prodRepository.delete(prod);
            return id;
        }).orElseGet(() -> {
            throw new BadRequestAlertException("Prod does not exist !", "Prod", "notExists");
        });

    }


    @Transactional(readOnly = true)
    public Page<ProdDTO> list(Pageable pageable) {
        return prodRepository.findAll(pageable).map(ProdDTO::new);
    }


    @Transactional(readOnly = true)
    public Page<ProdDTO> advancedSearch(String whereClause, Pageable pageable) throws JSQLParserException {
        if (StringUtils.isBlank(whereClause)) {
            return prodRepository.findAll(pageable).map(ProdDTO::new);
        }
        GenericSpecification<Prod> specification = GenericSpecification.of(whereClause);
        return prodRepository.findAll(specification, pageable).map(ProdDTO::new);

    }

}
