package cn.liuyiyou.shop.prod.dto;

import cn.liuyiyou.shop.prod.domain.ProdSku;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Optional;

/**
 * 商品基本信息表
 *
 * @author liuyiyou.cn 2019-09-27
 */
@ApiModel("ProdSkuDTO")
@Data
public class ProdSkuDTO implements Serializable {

    /**
     * 产品标识
     */
    @NotNull
    @ApiModelProperty(value = "产品标识", required = true)
    private Long skuId;

    /**
     * sku产品名称（该字段冗余，暂不对外显示），值为spu名称+规格型号
     */
    @Size(max = 1024)
    @ApiModelProperty(value = "sku产品名称（该字段冗余，暂不对外显示），值为spu名称+规格型号")
    private String skuName;

    /**
     * 所属的product; 外键product.prod_id
     */
    @NotNull
    @ApiModelProperty(value = "所属的product; 外键product.prod_id", required = true)
    private Long prodId;

    /**
     * 销售价
     */
    @ApiModelProperty(value = "销售价")
    private Integer price;

    /**
     * 参考价
     */
    @ApiModelProperty(value = "参考价")
    private Integer referPrice;

    /**
     * 销量
     */
    @ApiModelProperty(value = "销量")
    private Integer saled;

    /**
     * 冻结库存
     */
    @ApiModelProperty(value = "冻结库存")
    private Integer freez;

    /**
     * 已售库存
     */
    @ApiModelProperty(value = "已售库存")
    private Integer store;

    /**
     * 是否是虚拟的SKU: 0-否，1-是\r\n\r\n这个字段其实没啥用。一个产品写一条SKU就成。
     */
    @ApiModelProperty(value = "是否是虚拟的SKU: 0-否，1-是\r\n\r\n这个字段其实没啥用。一个产品写一条SKU就成。")
    private Integer isVirtual;

    /**
     * SKU属性，JSON数组：\r\n\r\n[\r\n  {\r\n     attrid-name : 71-颜色 ，\r\n     valid-name : 11-红色 \r\n  }，\r\n  {\r\n     attrid-name : 72-规格 ，\r\n     valid-name : 4-4G \r\n  }\r\n]
     */
    @Size(max = 500)
    @ApiModelProperty(value = "SKU属性，JSON数组：\r\n\r\n[\r\n  {\r\n     attrid-name : 71-颜色 ，\r\n     valid-name : 11-红色 \r\n  }，\r\n  {\r\n     attrid-name : 72-规格 ，\r\n     valid-name : 4-4G \r\n  }\r\n]", example = "\r\n     attrid-name : 71-颜色")
    private String skuAttr;

    /**
     * sku编码
     */
    @Size(max = 100)
    @ApiModelProperty(value = "sku编码")
    private String skuCode;

    /**
     * 商品条形码
     */
    @Size(max = 50)
    @ApiModelProperty(value = "商品条形码")
    private String barcode;

    /**
     * 商品毛重
     */
    @ApiModelProperty(value = "商品毛重")
    private Float grossWeight;

    /**
     * 供货价格
     */
    @ApiModelProperty(value = "供货价格")
    private Float suppPrice;

    /**
     * sku主图，存放在服务器上的相对路径
     */
    @Size(max = 200)
    @ApiModelProperty(value = "sku主图，存放在服务器上的相对路径")
    private String skuPic;

    /**
     * 产品状态： 0 - 无用 ， 1 - 在用， 2 - 不启用。
     */
    @ApiModelProperty(value = "产品状态： 0 - 无用 ， 1 - 在用， 2 - 不启用。")
    private Integer status;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    private Instant createdDate;

    /**
     * 状态变换日期 (上架日期下架日期)
     */
    @ApiModelProperty(value = "状态变换日期 (上架日期下架日期)")
    private Instant lastModifiedDate;

    public ProdSkuDTO() {
        // Empty constructor needed for Jackson.
    }

    public ProdSkuDTO(ProdSku prodSku) {
        this.skuId = prodSku.getSkuId();
        this.skuName = prodSku.getSkuName();
        this.prodId = prodSku.getProdId();
        this.price = prodSku.getPrice();
        this.referPrice = prodSku.getReferPrice();
        this.saled = prodSku.getSaled();
        this.freez = prodSku.getFreez();
        this.store = prodSku.getStore();
        this.isVirtual = prodSku.getIsVirtual();
        this.skuAttr = prodSku.getSkuAttr();
        this.skuCode = prodSku.getSkuCode();
        this.barcode = prodSku.getBarcode();
        this.grossWeight = prodSku.getGrossWeight();
        this.suppPrice = prodSku.getSuppPrice();
        this.skuPic = prodSku.getSkuPic();
        this.status = prodSku.getStatus();
        this.createdDate = prodSku.getCreatedDate();
        this.lastModifiedDate = prodSku.getLastModifiedDate();
    }

    public ProdSku toProdSku() {
        ProdSku prodSku = new ProdSku();
        prodSku.setSkuId(this.getSkuId());
        prodSku.setSkuName(this.getSkuName());
        prodSku.setProdId(this.getProdId());
        prodSku.setPrice(this.getPrice());
        prodSku.setReferPrice(this.getReferPrice());
        prodSku.setSaled(this.getSaled());
        prodSku.setFreez(this.getFreez());
        prodSku.setStore(this.getStore());
        prodSku.setIsVirtual(this.getIsVirtual());
        prodSku.setSkuAttr(this.getSkuAttr());
        prodSku.setSkuCode(this.getSkuCode());
        prodSku.setBarcode(this.getBarcode());
        prodSku.setGrossWeight(this.getGrossWeight());
        prodSku.setSuppPrice(this.getSuppPrice());
        prodSku.setSkuPic(this.getSkuPic());
        prodSku.setStatus(this.getStatus());
        prodSku.setCreatedDate(this.getCreatedDate());
        prodSku.setLastModifiedDate(this.getLastModifiedDate());

        return prodSku;
    }

    public ProdSku toProdSku(ProdSku prodSku) {
        Optional.ofNullable(skuId).ifPresent(prodSku::setSkuId);
        Optional.ofNullable(skuName).ifPresent(prodSku::setSkuName);
        Optional.ofNullable(prodId).ifPresent(prodSku::setProdId);
        Optional.ofNullable(price).ifPresent(prodSku::setPrice);
        Optional.ofNullable(referPrice).ifPresent(prodSku::setReferPrice);
        Optional.ofNullable(saled).ifPresent(prodSku::setSaled);
        Optional.ofNullable(freez).ifPresent(prodSku::setFreez);
        Optional.ofNullable(store).ifPresent(prodSku::setStore);
        Optional.ofNullable(isVirtual).ifPresent(prodSku::setIsVirtual);
        Optional.ofNullable(skuAttr).ifPresent(prodSku::setSkuAttr);
        Optional.ofNullable(skuCode).ifPresent(prodSku::setSkuCode);
        Optional.ofNullable(barcode).ifPresent(prodSku::setBarcode);
        Optional.ofNullable(grossWeight).ifPresent(prodSku::setGrossWeight);
        Optional.ofNullable(suppPrice).ifPresent(prodSku::setSuppPrice);
        Optional.ofNullable(skuPic).ifPresent(prodSku::setSkuPic);
        Optional.ofNullable(status).ifPresent(prodSku::setStatus);
        Optional.ofNullable(createdDate).ifPresent(prodSku::setCreatedDate);
        Optional.ofNullable(lastModifiedDate).ifPresent(prodSku::setLastModifiedDate);

        return prodSku;
    }


}
