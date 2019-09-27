package cn.liuyiyou.shop.prod.dto;

import cn.liuyiyou.shop.prod.domain.Prod;
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
@ApiModel("ProdDTO")
@Data
public class ProdDTO implements Serializable {

    /**
     * 产品标识
     */
    @NotNull
    @ApiModelProperty(value = "产品标识", required = true)
    private Long prodId;

    /**
     * 产品名称
     */
    @Size(max = 500)
    @ApiModelProperty(value = "产品名称")
    private String prodName;

    /**
     * 产品关键字，逗号分隔。
     */
    @Size(max = 500)
    @ApiModelProperty(value = "产品关键字，逗号分隔。")
    private String keyWords;

    /**
     * 品牌ID，base_brand.brand_id
     */
    @ApiModelProperty(value = "品牌ID，base_brand.brand_id")
    private Integer brandId;

    /**
     * 品牌名称名字，冗余字段，前端修改了品牌名字后同步修改这里。
     */
    @Size(max = 200)
    @ApiModelProperty(value = "品牌名称名字，冗余字段，前端修改了品牌名字后同步修改这里。")
    private String brandName;

    /**
     * 原产地 base_country.country_id
     */
    @Size(max = 10)
    @ApiModelProperty(value = "原产地 base_country.country_id")
    private String countryId;

    /**
     * 归属类目 base_catalog.cata_id
     */
    @ApiModelProperty(value = "归属类目 base_catalog.cata_id")
    private Integer cataId;

    /**
     * 类目描述，JSON格式， {\r\n   11 : 美妆个护 ，\r\n   1101 : 个护 ，\r\n   110101 : 洁面 \r\n}\r\n\r\n目前发现2个用途：\r\n1 在管理后台显示类似 ‘美妆个护>护肤>洁面’；\r\n2 在详情页的面包屑展示。\r\n
     */
    @Size(max = 400)
    @ApiModelProperty(value = "类目描述，JSON格式， {\r\n   11 : 美妆个护 ，\r\n   1101 : 个护 ，\r\n   110101 : 洁面 \r\n}\r\n\r\n目前发现2个用途：\r\n1 在管理后台显示类似 ‘美妆个护>护肤>洁面’；\r\n2 在详情页的面包屑展示。\r\n", example = "\r\n   11 : 美妆个护")
    private String cataDesc;

    /**
     * \r\nSPU属性，只做展现用，可能对统计不好计算。 JSON数组：\r\n\r\n[\r\n  {\r\n     attrid-name : 71-颜色 ，\r\n     valid-name : 11-红色 \r\n  }，\r\n  {\r\n     attrid-name : 72-规格 ，\r\n     valid-name : 4-4G \r\n  }\r\n]\r\n]
     */
    @Size(max = 2048)
    @ApiModelProperty(value = "\r\nSPU属性，只做展现用，可能对统计不好计算。 JSON数组：\r\n\r\n[\r\n  {\r\n     attrid-name : 71-颜色 ，\r\n     valid-name : 11-红色 \r\n  }，\r\n  {\r\n     attrid-name : 72-规格 ，\r\n     valid-name : 4-4G \r\n  }\r\n]\r\n]", example = "\r\n     attrid-name : 71-颜色")
    private String spuAttr;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    private Instant createTime;

    /**
     * 产品状态： 1 - 在用，0 - 无用。\r\n\r\n这里的原子商品，无上架下架状态。
     */
    @ApiModelProperty(value = "产品状态： 1 - 在用，0 - 无用。\r\n\r\n这里的原子商品，无上架下架状态。")
    private Integer status;

    /**
     * 状态变换日期 (上架日期下架日期)
     */
    @ApiModelProperty(value = "状态变换日期 (上架日期下架日期)")
    private Instant statusTime;

    /**
     * 产品图片相册（多个用逗号分开），存放在服务器上的相对路径。
     */
    @Size(max = 1024)
    @ApiModelProperty(value = "产品图片相册（多个用逗号分开），存放在服务器上的相对路径。")
    private String album;

    /**
     * 产品简述
     */
    @Size(max = 255)
    @ApiModelProperty(value = "产品简述")
    private String brief;

    /**
     * 产品描述(静态化)
     */
    @ApiModelProperty(value = "产品描述(静态化)")
    private String descp;


    private Instant lastModifiedDate;

    /**
     * 创建人的ID
     */
    @ApiModelProperty(value = "创建人的ID")
    private Long createSuid;

    /**
     * 修改记录，JSON格式[{suid，datetime}]
     */
    @NotNull
    @ApiModelProperty(value = "修改记录，JSON格式[{suid，datetime}]", example = "suid", required = true)
    private String updateLogs;


    /**
     * 推广素材状态：1-启用，2-关闭
     */
    @ApiModelProperty(value = "推广素材状态：1-启用，2-关闭")
    private Integer popStatus;

    /**
     * 推广素材图片
     */
    @Size(max = 1024)
    @ApiModelProperty(value = "推广素材图片")
    private String popAlbum;

    /**
     * 推广描述
     */
    @Size(max = 1024)
    @ApiModelProperty(value = "推广描述")
    private String popDescribe;

    public ProdDTO() {
        // Empty constructor needed for Jackson.
    }

    public ProdDTO(Prod prod) {
        this.prodId = prod.getProdId();
        this.prodName = prod.getProdName();
        this.keyWords = prod.getKeyWords();
        this.brandId = prod.getBrandId();
        this.brandName = prod.getBrandName();
        this.countryId = prod.getCountryId();
        this.cataId = prod.getCataId();
        this.cataDesc = prod.getCataDesc();
        this.spuAttr = prod.getSpuAttr();
        this.createTime = prod.getCreateTime();
        this.status = prod.getStatus();
        this.statusTime = prod.getStatusTime();
        this.album = prod.getAlbum();
        this.brief = prod.getBrief();
        this.descp = prod.getDescp();
        this.createSuid = prod.getCreateSuid();
        this.updateLogs = prod.getUpdateLogs();
        this.popStatus = prod.getPopStatus();
        this.popAlbum = prod.getPopAlbum();
        this.popDescribe = prod.getPopDescribe();
    }

    public Prod toProd() {
        Prod prod = new Prod();
        prod.setProdId(this.getProdId());
        prod.setProdName(this.getProdName());
        prod.setKeyWords(this.getKeyWords());
        prod.setBrandId(this.getBrandId());
        prod.setBrandName(this.getBrandName());
        prod.setCountryId(this.getCountryId());
        prod.setCataId(this.getCataId());
        prod.setCataDesc(this.getCataDesc());
        prod.setSpuAttr(this.getSpuAttr());
        prod.setCreateTime(this.getCreateTime());
        prod.setStatus(this.getStatus());
        prod.setStatusTime(this.getStatusTime());
        prod.setAlbum(this.getAlbum());
        prod.setBrief(this.getBrief());
        prod.setDescp(this.getDescp());
        prod.setCreateSuid(this.getCreateSuid());
        prod.setUpdateLogs(this.getUpdateLogs());
        prod.setLastModifiedDate(this.getLastModifiedDate());
        prod.setPopStatus(this.getPopStatus());
        prod.setPopAlbum(this.getPopAlbum());
        prod.setPopDescribe(this.getPopDescribe());

        return prod;
    }

    public Prod toProd(Prod prod) {
        Optional.ofNullable(prodId).ifPresent(prod::setProdId);
        Optional.ofNullable(prodName).ifPresent(prod::setProdName);
        Optional.ofNullable(keyWords).ifPresent(prod::setKeyWords);
        Optional.ofNullable(brandId).ifPresent(prod::setBrandId);
        Optional.ofNullable(brandName).ifPresent(prod::setBrandName);
        Optional.ofNullable(countryId).ifPresent(prod::setCountryId);
        Optional.ofNullable(cataId).ifPresent(prod::setCataId);
        Optional.ofNullable(cataDesc).ifPresent(prod::setCataDesc);
        Optional.ofNullable(spuAttr).ifPresent(prod::setSpuAttr);
        Optional.ofNullable(createTime).ifPresent(prod::setCreateTime);
        Optional.ofNullable(status).ifPresent(prod::setStatus);
        Optional.ofNullable(statusTime).ifPresent(prod::setStatusTime);
        Optional.ofNullable(album).ifPresent(prod::setAlbum);
        Optional.ofNullable(brief).ifPresent(prod::setBrief);
        Optional.ofNullable(descp).ifPresent(prod::setDescp);
        Optional.ofNullable(createSuid).ifPresent(prod::setCreateSuid);
        Optional.ofNullable(updateLogs).ifPresent(prod::setUpdateLogs);
        Optional.ofNullable(lastModifiedDate).ifPresent(prod::setLastModifiedDate);
        Optional.ofNullable(popStatus).ifPresent(prod::setPopStatus);
        Optional.ofNullable(popAlbum).ifPresent(prod::setPopAlbum);
        Optional.ofNullable(popDescribe).ifPresent(prod::setPopDescribe);

        return prod;
    }


}
