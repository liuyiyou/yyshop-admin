package cn.liuyiyou.shop.prod.domain;

import cn.liuyiyou.shop.support.AbstractAuditingEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.math.BigDecimal;
import lombok.Data;
/**
 * 商品基本信息表
 *
 * @author liuyiyou.cn 2019-09-27
 */
@Data
@Entity
@Table(name = "prod_sku")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProdSku extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 产品标识
     */
    @NotNull
    @Column(name = "sku_id", nullable = false)
    private Long skuId;

    /**
     * sku产品名称（该字段冗余，暂不对外显示），值为spu名称+规格型号
     */
    @Size(max = 1,024)
    @Column(name = "sku_name", length = 1,024)
    private String skuName;

    /**
     * 所属的product; 外键product.prod_id
     */
    @NotNull
    @Column(name = "prod_id", nullable = false)
    private Long prodId;

    /**
     * 销售价
     */
    @Column(name = "price")
    private Integer price;

    /**
     * 参考价
     */
    @Column(name = "refer_price")
    private Integer referPrice;

    /**
     * 销量
     */
    @Column(name = "saled")
    private Integer saled;

    /**
     * 冻结库存
     */
    @Column(name = "freez")
    private Integer freez;

    /**
     * 已售库存
     */
    @Column(name = "store")
    private Integer store;

    /**
     * 是否是虚拟的SKU: 0-否，1-是\r\n\r\n这个字段其实没啥用。一个产品写一条SKU就成。
     */
    @Column(name = "is_virtual")
    private Integer isVirtual;

    /**
     * SKU属性，JSON数组：\r\n\r\n[\r\n  {\r\n     attrid-name : 71-颜色 ，\r\n     valid-name : 11-红色 \r\n  }，\r\n  {\r\n     attrid-name : 72-规格 ，\r\n     valid-name : 4-4G \r\n  }\r\n]
     */
    @Size(max = 500)
    @Column(name = "sku_attr", length = 500)
    private String skuAttr;

    /**
     * sku编码
     */
    @Size(max = 100)
    @Column(name = "sku_code", length = 100)
    private String skuCode;

    /**
     * 商品条形码
     */
    @Size(max = 50)
    @Column(name = "barcode", length = 50)
    private String barcode;

    /**
     * 商品毛重
     */
    @Column(name = "gross_weight")
    private Float grossWeight;

    /**
     * 供货价格
     */
    @Column(name = "supp_price")
    private Float suppPrice;

    /**
     * sku主图，存放在服务器上的相对路径
     */
    @Size(max = 200)
    @Column(name = "sku_pic", length = 200)
    private String skuPic;

    /**
     * 产品状态： 0 - 无用 ， 1 - 在用， 2 - 不启用。
     */
    @Column(name = "status")
    private Integer status;


}
