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
 * 国家（商品原产地）定义表
 *
 * @author liuyiyou.cn 2019-09-26
 */
@Data
@Entity
@Table(name = "base_country")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseCountry extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 国家标识，取值国家国际简称，如CN-中国
     */
    @NotNull
    @Size(max = 10)
    @Column(name = "country_id", length = 10, nullable = false)
    private String countryId;

    /**
     * 国家名称拼音首字母，大写，如Z-中国
     */
    @Size(max = 1)
    @Column(name = "country_first_char", length = 1)
    private String countryFirstChar;

    /**
     * 国家中文名称
     */
    @Size(max = 100)
    @Column(name = "country_name_cn", length = 100)
    private String countryNameCn;

    /**
     * 国家英文名称
     */
    @Size(max = 100)
    @Column(name = "country_name_en", length = 100)
    private String countryNameEn;

    /**
     * 国家国旗图标url
     */
    @Size(max = 1024)
    @Column(name = "country_icon", length = 1024)
    private String countryIcon;

    /**
     * 国家状态：0-停用，1-启用
     */
    @Column(name = "state")
    private String state;



}
