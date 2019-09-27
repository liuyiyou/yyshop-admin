package cn.liuyiyou.shop.oms.domain;

import cn.liuyiyou.shop.support.AbstractAuditingEntity;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * C端订单产品表
 *
 * @author liuyiyou.cn 2019-09-27
 */
@Data
@Entity
@Table(name = "order_item")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class OrderItem extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 子采购单ID
     */
    @NotNull
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    /**
     * 产品ID
     */
    @NotNull
    @Column(name = "prod_id", nullable = false)
    private Long prodId;

    /**
     * 商品编码，来源于prod_attr.prod_code
     */
    @NotNull
    @Column(name = "sku_id", nullable = false)
    private Long skuId;

    /**
     * 用户ID
     */
    @NotNull
    @Column(name = "uid", nullable = false)
    private Integer uid;

    /**
     * 产品名称
     */
    @Size(max = 200)
    @Column(name = "prod_name", length = 200)
    private String prodName;

    /**
     * 产品属性，JSON格式，冗余信息，展示用。
     */
    @Size(max = 1024)
    @Column(name = "prod_attr", length = 1024)
    private String prodAttr;

    /**
     * 产品单价
     */
    @Column(name = "unit_price")
    private Float unitPrice;

    /**
     * 产品数量
     */
    @Column(name = "prod_num")
    private Integer prodNum;

    /**
     * 产品总价
     */
    @Column(name = "total_price")
    private Float totalPrice;

    /**
     * 产品对应国家馆（ibalife_prod.product.origin）
     */
    @Size(max = 10)
    @Column(name = "county_id", length = 10)
    private String countyId;

    /**
     * 商品条形码
     */
    @Size(max = 50)
    @Column(name = "barcode", length = 50)
    private String barcode;

    /**
     * 商品图片
     */
    @Size(max = 512)
    @Column(name = "album", length = 512)
    private String album;

    /**
     * 参加优惠或扣减后真实价格
     */
    @Column(name = "real_price")
    private Float realPrice;

    /**
     * 商品退货退款状态
     */
    @Column(name = "refund_status")
    private Integer refundStatus;

    /**
     * _status tinyint(4)
     */
    @Column(name = "comment_status")
    private Integer commentStatus;


}
