package cn.liuyiyou.shop.prod.service;

import cn.liuyiyou.shop.prod.domain.ProdSku;
import cn.liuyiyou.shop.prod.dto.ProdSkuDTO;
import cn.liuyiyou.shop.prod.repository.ProdSkuRepository;
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
 * Service class for managing ProdSku.
 *
 * @author liuyiyou.cn 2019-09-27
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class ProdSkuService {
    @Autowired
    private ProdSkuRepository prodSkuRepository;

    @Transactional(readOnly = true)
    public Optional<ProdSku> find(Long id) {
        return prodSkuRepository.findById(id);
    }

    public ProdSku create(ProdSkuDTO dto) {
        ProdSku prodSku = dto.toProdSku();
        prodSku.setSkuId(null);
        return prodSkuRepository.save(prodSku);
    }

    public ProdSku update(ProdSkuDTO dto) {
        if (dto.getSkuId() == null) {
            throw new BadRequestAlertException("A  ProdSku cannot be updated without an ID", "ProdSku", "idBlank");
        }
        if (this.find(dto.getSkuId()).isPresent()) {
            ProdSku prodSku = dto.toProdSku();
            return prodSkuRepository.save(prodSku);
        } else {
            throw new BadRequestAlertException("ProdSku does not exist !", "ProdSku", "notExists");
        }

    }

    public ProdSku modify(ProdSkuDTO dto) {
        if (dto.getSkuId() == null) {
            throw new BadRequestAlertException("A  ProdSku cannot be modified without an ID", "ProdSku", "idBlank");
        }

        return prodSkuRepository.findById(dto.getSkuId()).map(prodSku -> {
            dto.toProdSku(prodSku);
            return prodSkuRepository.save(prodSku);
        }).orElseGet(() -> {
            throw new BadRequestAlertException("ProdSku does not exist !", "ProdSku", "notExists");
        });
    }

    public void delete(Long id) {
        prodSkuRepository.findById(id).map(prodSku -> {
            prodSkuRepository.delete(prodSku);
            return id;
        }).orElseGet(() -> {
            throw new BadRequestAlertException("ProdSku does not exist !", "ProdSku", "notExists");
        });

    }


    @Transactional(readOnly = true)
    public Page<ProdSkuDTO> list(Pageable pageable) {
        return prodSkuRepository.findAll(pageable).map(ProdSkuDTO::new);
    }


    @Transactional(readOnly = true)
    public Page<ProdSkuDTO> advancedSearch(String whereClause, Pageable pageable) throws JSQLParserException {
        if (StringUtils.isBlank(whereClause)) {
            return prodSkuRepository.findAll(pageable).map(ProdSkuDTO::new);
        }
        GenericSpecification<ProdSku> specification = GenericSpecification.of(whereClause);
        return prodSkuRepository.findAll(specification, pageable).map(ProdSkuDTO::new);

    }

}
