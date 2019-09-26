package cn.liuyiyou.shop.base.dto;

import cn.liuyiyou.shop.base.domain.BaseBrand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Optional;

/**
 * 品牌定义表,这里会定义所有可供选择的品牌。\r\n该表会与类目表中的叶子类目关联,以缩小在商品上传时品牌的选择范围（选定商品的所属类目后,只能看到该类目关联的品牌）。\r\n该表还会与商品表关联,以标识商品的品牌。
 *
 * @author liuyiyou 2019-09-26
 */
@ApiModel("BaseBrandDTO")
@Data
public class BaseBrandDTO implements Serializable {

    /**
     * 品牌标识
     */
    @NotNull
    @ApiModelProperty(value = "品牌标识", required = true)
    private Long brandId;

    /**
     * 品牌名首字母，大写
     */
    @Size(max = 1)
    @ApiModelProperty(value = "品牌名首字母，大写")
    private String brandFirstChar;

    /**
     * 品牌中文名
     */
    @Size(max = 100)
    @ApiModelProperty(value = "品牌中文名")
    private String brandNameCn;

    /**
     * 品牌英文名
     */
    @Size(max = 100)
    @ApiModelProperty(value = "品牌英文名")
    private String brandNameEn;

    /**
     * 品牌描述
     */
    @Size(max = 300)
    @ApiModelProperty(value = "品牌描述")
    private String brandDescp;

    /**
     * 品牌关键字，以逗号分隔
     */
    @Size(max = 1024)
    @ApiModelProperty(value = "品牌关键字，以逗号分隔")
    private String brandKeywords;

    /**
     * 品牌图标url
     */
    @Size(max = 1024)
    @ApiModelProperty(value = "品牌图标url")
    private String brandIcon;

    /**
     * 品牌所属国家ID
     */
    @Size(max = 10)
    @ApiModelProperty(value = "品牌所属国家ID")
    private String countryId;

    /**
     * 商品图片url
     */
    @Size(max = 1024)
    @ApiModelProperty(value = "商品图片url")
    private String prodImg;

    /**
     * banner图片url
     */
    @Size(max = 1024)
    @ApiModelProperty(value = "banner图片url")
    private String bannerImg;

    private Instant createdDate = Instant.now();

    private Instant lastModifiedDate = Instant.now();


    public BaseBrandDTO(BaseBrand baseBrand) {
        this.brandId = baseBrand.getBrandId();
        this.brandFirstChar = baseBrand.getBrandFirstChar();
        this.brandNameCn = baseBrand.getBrandNameCn();
        this.brandNameEn = baseBrand.getBrandNameEn();
        this.brandDescp = baseBrand.getBrandDescp();
        this.brandKeywords = baseBrand.getBrandKeywords();
        this.brandIcon = baseBrand.getBrandIcon();
        this.countryId = baseBrand.getCountryId();
        this.prodImg = baseBrand.getProdImg();
        this.bannerImg = baseBrand.getBannerImg();
    }

    public BaseBrand toBaseBrand() {
        BaseBrand baseBrand = new BaseBrand();
        baseBrand.setBrandId(this.getBrandId());
        baseBrand.setBrandFirstChar(this.getBrandFirstChar());
        baseBrand.setBrandNameCn(this.getBrandNameCn());
        baseBrand.setBrandNameEn(this.getBrandNameEn());
        baseBrand.setBrandDescp(this.getBrandDescp());
        baseBrand.setBrandKeywords(this.getBrandKeywords());
        baseBrand.setBrandIcon(this.getBrandIcon());
        baseBrand.setCountryId(this.getCountryId());
        baseBrand.setProdImg(this.getProdImg());
        baseBrand.setBannerImg(this.getBannerImg());

        return baseBrand;
    }

    public BaseBrand toBaseBrand(BaseBrand baseBrand) {
        Optional.ofNullable(brandId).ifPresent(baseBrand::setBrandId);
        Optional.ofNullable(brandFirstChar).ifPresent(baseBrand::setBrandFirstChar);
        Optional.ofNullable(brandNameCn).ifPresent(baseBrand::setBrandNameCn);
        Optional.ofNullable(brandNameEn).ifPresent(baseBrand::setBrandNameEn);
        Optional.ofNullable(brandDescp).ifPresent(baseBrand::setBrandDescp);
        Optional.ofNullable(brandKeywords).ifPresent(baseBrand::setBrandKeywords);
        Optional.ofNullable(brandIcon).ifPresent(baseBrand::setBrandIcon);
        Optional.ofNullable(createdDate).ifPresent(baseBrand::setCreatedDate);
        Optional.ofNullable(lastModifiedDate).ifPresent(baseBrand::setLastModifiedDate);
        Optional.ofNullable(countryId).ifPresent(baseBrand::setCountryId);
        Optional.ofNullable(prodImg).ifPresent(baseBrand::setProdImg);
        Optional.ofNullable(bannerImg).ifPresent(baseBrand::setBannerImg);

        return baseBrand;
    }


}
