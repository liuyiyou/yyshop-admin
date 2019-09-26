package cn.liuyiyou.shop.base.domain;

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
 * 品牌定义表,这里会定义所有可供选择的品牌。\r\n该表会与类目表中的叶子类目关联,以缩小在商品上传时品牌的选择范围（选定商品的所属类目后,只能看到该类目关联的品牌）。\r\n该表还会与商品表关联,以标识商品的品牌。
 *
 * @author liuyiyou 2019-09-26
 */
@Data
@Entity
@Table(name = "base_brand")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseBrand extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 品牌标识
     */
    @NotNull
    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    /**
     * 品牌名首字母，大写
     */
    @Size(max = 1)
    @Column(name = "brand_first_char", length = 1)
    private String brandFirstChar;

    /**
     * 品牌中文名
     */
    @Size(max = 100)
    @Column(name = "brand_name_cn", length = 100)
    private String brandNameCn;

    /**
     * 品牌英文名
     */
    @Size(max = 100)
    @Column(name = "brand_name_en", length = 100)
    private String brandNameEn;

    /**
     * 品牌描述
     */
    @Size(max = 300)
    @Column(name = "brand_descp", length = 300)
    private String brandDescp;

    /**
     * 品牌关键字，以逗号分隔
     */
    @Size(max = 1024)
    @Column(name = "brand_keywords", length = 1024)
    private String brandKeywords;

    /**
     * 品牌图标url
     */
    @Size(max = 1024)
    @Column(name = "brand_icon", length = 1024)
    private String brandIcon;

    /**
     * 品牌所属国家ID
     */
    @Size(max = 10)
    @Column(name = "country_id", length = 10)
    private String countryId;

    /**
     * 商品图片url
     */
    @Size(max = 1024)
    @Column(name = "prod_img", length = 1024)
    private String prodImg;

    /**
     * banner图片url
     */
    @Size(max = 1024)
    @Column(name = "banner_img", length = 1024)
    private String bannerImg;


}
