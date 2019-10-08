package cn.liuyiyou.shop.base.dto;

import cn.liuyiyou.shop.base.domain.BaseCountry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Optional;
import lombok.Data;
/**
 * 国家（商品原产地）定义表
 *
 * @author liuyiyou.cn 2019-09-26
 */
@ApiModel("BaseCountryDTO")
@Data
public class BaseCountryDTO implements Serializable{

    /**
     * 国家标识，取值国家国际简称，如CN-中国
     */
    @NotNull
    @Size(max = 10)
    @ApiModelProperty(value = "国家标识，取值国家国际简称，如CN-中国" , required = true)
    private String countryId;

    /**
     * 国家名称拼音首字母，大写，如Z-中国
     */
    @Size(max = 1)
    @ApiModelProperty(value = "国家名称拼音首字母，大写，如Z-中国" )
    private String countryFirstChar;

    /**
     * 国家中文名称
     */
    @Size(max = 100)
    @ApiModelProperty(value = "国家中文名称" )
    private String countryNameCn;

    /**
     * 国家英文名称
     */
    @Size(max = 100)
    @ApiModelProperty(value = "国家英文名称" )
    private String countryNameEn;

    /**
     * 国家国旗图标url
     */
    @Size(max = 1024)
    @ApiModelProperty(value = "国家国旗图标url" )
    private String countryIcon;

    /**
     * 国家状态：0-停用，1-启用
     */
    @ApiModelProperty(value = "国家状态：0-停用，1-启用" )
    private String state;

    /**
     * 国家信息创建时间
     */
    @ApiModelProperty(value = "国家信息创建时间" )
    private Instant createdDate;

    /**
     * 国家信息最后修改时间
     */
    @ApiModelProperty(value = "国家信息最后修改时间" )
    private Instant lastModifiedDate;

    public BaseCountryDTO() {
        // Empty constructor needed for Jackson.
    }
    public BaseCountryDTO(BaseCountry baseCountry) {
        this.countryId = baseCountry.getCountryId();
        this.countryFirstChar = baseCountry.getCountryFirstChar();
        this.countryNameCn = baseCountry.getCountryNameCn();
        this.countryNameEn = baseCountry.getCountryNameEn();
        this.countryIcon = baseCountry.getCountryIcon();
        this.state = baseCountry.getState();
        this.createdDate = baseCountry.getCreatedDate();
        this.lastModifiedDate = baseCountry.getLastModifiedDate();
    }

    public BaseCountry toBaseCountry() {
        BaseCountry baseCountry = new BaseCountry();
        baseCountry.setCountryId(this.getCountryId());
        baseCountry.setCountryFirstChar(this.getCountryFirstChar());
        baseCountry.setCountryNameCn(this.getCountryNameCn());
        baseCountry.setCountryNameEn(this.getCountryNameEn());
        baseCountry.setCountryIcon(this.getCountryIcon());
        baseCountry.setState(this.getState());
        baseCountry.setCreatedDate(this.getCreatedDate());
        baseCountry.setLastModifiedDate(this.getLastModifiedDate());

        return baseCountry;
    }
    public BaseCountry toBaseCountry(BaseCountry baseCountry) {
        Optional.ofNullable(countryId).ifPresent(baseCountry::setCountryId);
        Optional.ofNullable(countryFirstChar).ifPresent(baseCountry::setCountryFirstChar);
        Optional.ofNullable(countryNameCn).ifPresent(baseCountry::setCountryNameCn);
        Optional.ofNullable(countryNameEn).ifPresent(baseCountry::setCountryNameEn);
        Optional.ofNullable(countryIcon).ifPresent(baseCountry::setCountryIcon);
        Optional.ofNullable(state).ifPresent(baseCountry::setState);
        Optional.ofNullable(createdDate).ifPresent(baseCountry::setCreatedDate);
        Optional.ofNullable(lastModifiedDate).ifPresent(baseCountry::setLastModifiedDate);

        return baseCountry;
    }



}
