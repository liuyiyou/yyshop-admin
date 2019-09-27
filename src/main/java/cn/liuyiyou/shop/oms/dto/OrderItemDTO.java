package cn.liuyiyou.shop.oms.dto;

import cn.liuyiyou.shop.oms.domain.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Optional;

/**
 * C端订单产品表
 *
 * @author liuyiyou.cn 2019-09-27
 */
@ApiModel("OrderItemDTO")
@Data
public class OrderItemDTO implements Serializable {

    /**
     * 子采购单ID
     */
    @NotNull
    @ApiModelProperty(value = "子采购单ID", required = true)
    private Long orderId;

    /**
     * 产品ID
     */
    @NotNull
    @ApiModelProperty(value = "产品ID", required = true)
    private Long prodId;

    /**
     * 商品编码，来源于prod_attr.prod_code
     */
    @NotNull
    @ApiModelProperty(value = "商品编码，来源于prod_attr.prod_code", required = true)
    private Long skuId;

    /**
     * 用户ID
     */
    @NotNull
    @ApiModelProperty(value = "用户ID", required = true)
    private Integer uid;

    /**
     * 产品名称
     */
    @Size(max = 200)
    @ApiModelProperty(value = "产品名称")
    private String prodName;

    /**
     * 产品属性，JSON格式，冗余信息，展示用。
     */
    @Size(max = 1024)
    @ApiModelProperty(value = "产品属性，JSON格式，冗余信息，展示用。")
    private String prodAttr;

    /**
     * 产品单价
     */
    @ApiModelProperty(value = "产品单价")
    private Float unitPrice;

    /**
     * 产品数量
     */
    @ApiModelProperty(value = "产品数量")
    private Integer prodNum;

    /**
     * 产品总价
     */
    @ApiModelProperty(value = "产品总价")
    private Float totalPrice;

    /**
     * 产品对应国家馆（ibalife_prod.product.origin）
     */
    @Size(max = 10)
    @ApiModelProperty(value = "产品对应国家馆（ibalife_prod.product.origin）")
    private String countyId;

    /**
     * 商品条形码
     */
    @Size(max = 50)
    @ApiModelProperty(value = "商品条形码")
    private String barcode;

    /**
     * 商品图片
     */
    @Size(max = 512)
    @ApiModelProperty(value = "商品图片")
    private String album;

    /**
     * 参加优惠或扣减后真实价格
     */
    @ApiModelProperty(value = "参加优惠或扣减后真实价格")
    private Float realPrice;

    /**
     * 商品退货退款状态
     */
    @ApiModelProperty(value = "商品退货退款状态")
    private Integer refundStatus;

    /**
     * _status tinyint(4)
     */
    @ApiModelProperty(value = "_status tinyint(4)")
    private Integer commentStatus;

    /**
     * createdDate
     */
    @ApiModelProperty(value = "createdDate")
    private Instant createdDate;

    /**
     * lastModifiedDate
     */
    @ApiModelProperty(value = "lastModifiedDate")
    private Instant lastModifiedDate;

    public OrderItemDTO() {
        // Empty constructor needed for Jackson.
    }

    public OrderItemDTO(OrderItem orderItem) {
        this.orderId = orderItem.getOrderId();
        this.prodId = orderItem.getProdId();
        this.skuId = orderItem.getSkuId();
        this.uid = orderItem.getUid();
        this.prodName = orderItem.getProdName();
        this.prodAttr = orderItem.getProdAttr();
        this.unitPrice = orderItem.getUnitPrice();
        this.prodNum = orderItem.getProdNum();
        this.totalPrice = orderItem.getTotalPrice();
        this.countyId = orderItem.getCountyId();
        this.barcode = orderItem.getBarcode();
        this.album = orderItem.getAlbum();
        this.realPrice = orderItem.getRealPrice();
        this.refundStatus = orderItem.getRefundStatus();
        this.commentStatus = orderItem.getCommentStatus();
        this.createdDate = orderItem.getCreatedDate();
        this.lastModifiedDate = orderItem.getLastModifiedDate();
    }

    public OrderItem toOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(this.getOrderId());
        orderItem.setProdId(this.getProdId());
        orderItem.setSkuId(this.getSkuId());
        orderItem.setUid(this.getUid());
        orderItem.setProdName(this.getProdName());
        orderItem.setProdAttr(this.getProdAttr());
        orderItem.setUnitPrice(this.getUnitPrice());
        orderItem.setProdNum(this.getProdNum());
        orderItem.setTotalPrice(this.getTotalPrice());
        orderItem.setCountyId(this.getCountyId());
        orderItem.setBarcode(this.getBarcode());
        orderItem.setAlbum(this.getAlbum());
        orderItem.setRealPrice(this.getRealPrice());
        orderItem.setRefundStatus(this.getRefundStatus());
        orderItem.setCommentStatus(this.getCommentStatus());
        orderItem.setCreatedDate(this.getCreatedDate());
        orderItem.setLastModifiedDate(this.getLastModifiedDate());

        return orderItem;
    }

    public OrderItem toOrderItem(OrderItem orderItem) {
        Optional.ofNullable(orderId).ifPresent(orderItem::setOrderId);
        Optional.ofNullable(prodId).ifPresent(orderItem::setProdId);
        Optional.ofNullable(skuId).ifPresent(orderItem::setSkuId);
        Optional.ofNullable(uid).ifPresent(orderItem::setUid);
        Optional.ofNullable(prodName).ifPresent(orderItem::setProdName);
        Optional.ofNullable(prodAttr).ifPresent(orderItem::setProdAttr);
        Optional.ofNullable(unitPrice).ifPresent(orderItem::setUnitPrice);
        Optional.ofNullable(prodNum).ifPresent(orderItem::setProdNum);
        Optional.ofNullable(totalPrice).ifPresent(orderItem::setTotalPrice);
        Optional.ofNullable(countyId).ifPresent(orderItem::setCountyId);
        Optional.ofNullable(barcode).ifPresent(orderItem::setBarcode);
        Optional.ofNullable(album).ifPresent(orderItem::setAlbum);
        Optional.ofNullable(realPrice).ifPresent(orderItem::setRealPrice);
        Optional.ofNullable(refundStatus).ifPresent(orderItem::setRefundStatus);
        Optional.ofNullable(commentStatus).ifPresent(orderItem::setCommentStatus);
        Optional.ofNullable(createdDate).ifPresent(orderItem::setCreatedDate);
        Optional.ofNullable(lastModifiedDate).ifPresent(orderItem::setLastModifiedDate);

        return orderItem;
    }


}
