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
import java.time.Instant;

/**
 * C端用户产品订单表。
 *
 * @author liuyiyou 2019-09-27
 */
@Data
@Entity
@Table(name = "order")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Order extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 订单ID
     */
    @NotNull
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    /**
     * 创建订单的用户ID
     */
    @NotNull
    @Column(name = "uid", nullable = false)
    private Integer uid;

    /**
     * 用户生成订单的时间
     */
    @Column(name = "create_time")
    private Instant createTime;

    /**
     * 订单商品总价(元)
     */
    @Column(name = "total_price")
    private Float totalPrice;

    /**
     * 收货人身份证号码
     */
    @Size(max = 20)
    @Column(name = "consign_idno", length = 20)
    private String consignIdno;

    /**
     * 收货人信息: 默认填入用户的user.uname
     */
    @Size(max = 255)
    @Column(name = "consignee", length = 255)
    private String consignee;

    /**
     * 收货人电话： 默认填入user 表里面的 account
     */
    @Size(max = 11)
    @Column(name = "consign_phone", length = 11)
    private String consignPhone;

    /**
     * 收货人地址
     */
    @Size(max = 1024)
    @Column(name = "consign_addr", length = 1024)
    private String consignAddr;

    /**
     * 订单状态： 1 待支付 2 已支付待发货 3 已发货 4 交易已完成 5 订单超时关闭
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 订单的退货退款状态：6-部分退货退款，7-整单退货退款
     */
    @Column(name = "return_status")
    private Integer returnStatus;

    /**
     * 订单退货退款状态变更时间
     */
    @Column(name = "return_time")
    private Instant returnTime;

    /**
     * 该订单发生的退货退款金额
     */
    @Column(name = "return_amount")
    private Float returnAmount;

    /**
     * 发货状态：1：部分发货，2：全部发货，和status共同控制
     */
    @Column(name = "send_status")
    private Integer sendStatus;

    /**
     * 取消订单的原因
     */
    @Size(max = 255)
    @Column(name = "cancel_reason", length = 255)
    private String cancelReason;

    /**
     * 收货人所在区（对应ibalife_base.base_county.county_id）
     */
    @Column(name = "consign_country")
    private Integer consignCountry;

    /**
     * 收货人所在省（对应ibalife_base.base_province.prov_id）
     */
    @Column(name = "consign_province")
    private Integer consignProvince;

    /**
     * 收货人所在市（对应ibalife_base.base_city.city_id）
     */
    @Column(name = "consign_city")
    private Integer consignCity;

    /**
     * 支付方式 1-线下付款，2-支付宝，3-易宝，4-微信，5-银联，6-网付通，7-苹果支付，8-招商银行，9-余额支付，10-余额微信混合支付，11-余额支付宝混合支付，12-余额银联混合支付，13-通联代付，14-小程序支付
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 订单交易流水号
     */
    @Size(max = 64)
    @Column(name = "tranno", length = 64)
    private String tranno;

    /**
     * 创建订单的用户帐号
     */
    @Size(max = 11)
    @Column(name = "uaccount", length = 11)
    private String uaccount;

    /**
     * 订单来源（1表示网站，2表示微商城）
     */
    @Column(name = "src")
    private Integer src;

    /**
     * 订单操作人Id
     */
    @Column(name = "op_uid")
    private Integer opUid;

    /**
     * 订单支付时间
     */
    @Column(name = "pay_time")
    private Instant payTime;

    /**
     * 订单发货时间
     */
    @Column(name = "send_time")
    private Instant sendTime;

    /**
     * 订单配送完成时间
     */
    @Column(name = "distribute_time")
    private Instant distributeTime;

    /**
     * 订单完成时间
     */
    @Column(name = "done_time")
    private Instant doneTime;

    /**
     * 最后修改日期
     */
    @Column(name = "last_update_time")
    private Instant lastUpdateTime;


}
