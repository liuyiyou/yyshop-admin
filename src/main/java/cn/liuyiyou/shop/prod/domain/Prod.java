package cn.liuyiyou.shop.prod.domain;

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
import java.time.Instant;

/**
 * 商品基本信息表
 *
 * @author liuyiyou.cn 2019-09-27
 */
@Data
@Entity
@Table(name = "prod")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Prod extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 产品标识
     */
    @NotNull
    @Column(name = "prod_id", nullable = false)
    private Long prodId;

    /**
     * 产品名称
     */
    @Size(max = 500)
    @Column(name = "prod_name", length = 500)
    private String prodName;

    /**
     * 产品关键字，逗号分隔。
     */
    @Size(max = 500)
    @Column(name = "key_words", length = 500)
    private String keyWords;

    /**
     * 品牌ID，base_brand.brand_id
     */
    @Column(name = "brand_id")
    private Integer brandId;

    /**
     * 品牌名称名字，冗余字段，前端修改了品牌名字后同步修改这里。
     */
    @Size(max = 200)
    @Column(name = "brand_name", length = 200)
    private String brandName;

    /**
     * 原产地 base_country.country_id
     */
    @Size(max = 10)
    @Column(name = "country_id", length = 10)
    private String countryId;

    /**
     * 归属类目 base_catalog.cata_id
     */
    @Column(name = "cata_id")
    private Integer cataId;

    /**
     * 类目描述，JSON格式， {\r\n   11 : 美妆个护 ，\r\n   1101 : 个护 ，\r\n   110101 : 洁面 \r\n}\r\n\r\n目前发现2个用途：\r\n1 在管理后台显示类似 ‘美妆个护>护肤>洁面’；\r\n2 在详情页的面包屑展示。\r\n
     */
    @Size(max = 400)
    @Column(name = "cata_desc", length = 400)
    private String cataDesc;

    /**
     * \r\nSPU属性，只做展现用，可能对统计不好计算。 JSON数组：\r\n\r\n[\r\n  {\r\n     attrid-name : 71-颜色 ，\r\n     valid-name : 11-红色 \r\n  }，\r\n  {\r\n     attrid-name : 72-规格 ，\r\n     valid-name : 4-4G \r\n  }\r\n]\r\n]
     */
    @Size(max = 2048)
    @Column(name = "spu_attr", length = 2048)
    private String spuAttr;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    private Instant createTime;

    /**
     * 产品状态： 1 - 在用，0 - 无用。\r\n\r\n这里的原子商品，无上架下架状态。
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 状态变换日期 (上架日期下架日期)
     */
    @Column(name = "status_time")
    private Instant statusTime;

    /**
     * 产品图片相册（多个用逗号分开），存放在服务器上的相对路径。
     */
    @Size(max = 1024)
    @Column(name = "album", length = 1024)
    private String album;

    /**
     * 产品简述
     */
    @Size(max = 255)
    @Column(name = "brief", length = 255)
    private String brief;

    /**
     * 产品描述(静态化)
     */
    @Column(name = "descp")
    private String descp;

    /**
     * 创建人的ID
     */
    @Column(name = "create_suid")
    private Long createSuid;

    /**
     * 修改记录，JSON格式[{suid，datetime}]
     */
    @NotNull
    @Column(name = "update_logs", nullable = false)
    private String updateLogs;


    /**
     * 推广素材状态：1-启用，2-关闭
     */
    @Column(name = "pop_status")
    private Integer popStatus;

    /**
     * 推广素材图片
     */
    @Size(max = 1024)
    @Column(name = "pop_album", length = 1024)
    private String popAlbum;

    /**
     * 推广描述
     */
    @Size(max = 1024)
    @Column(name = "pop_describe", length = 1024)
    private String popDescribe;


}
