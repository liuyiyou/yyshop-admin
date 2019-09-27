package cn.liuyiyou.shop.oms.dto;

import cn.liuyiyou.shop.oms.domain.Order;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Optional;


@ApiModel("OrderDTO")
@Data
public class OrderDTO implements Serializable {

    /**
     * 订单ID
     */
    @NotNull
    @ApiModelProperty(value = "订单ID", required = true)
    private Long orderId;

    /**
     * 创建订单的用户ID
     */
    @NotNull
    @ApiModelProperty(value = "创建订单的用户ID", required = true)
    private Integer uid;

    /**
     * 用户生成订单的时间
     */
    @ApiModelProperty(value = "用户生成订单的时间")
    private Instant createTime;

    /**
     * 订单商品总价(元)
     */
    @ApiModelProperty(value = "订单商品总价(元)")
    private Float totalPrice;

    /**
     * 收货人身份证号码
     */
    @Size(max = 20)
    @ApiModelProperty(value = "收货人身份证号码")
    private String consignIdno;

    /**
     * 收货人信息: 默认填入用户的user.uname
     */
    @Size(max = 255)
    @ApiModelProperty(value = "收货人信息: 默认填入用户的user.uname")
    private String consignee;

    /**
     * 收货人电话： 默认填入user 表里面的 account
     */
    @Size(max = 11)
    @ApiModelProperty(value = "收货人电话： 默认填入user 表里面的 account")
    private String consignPhone;

    /**
     * 收货人地址
     */
    @Size(max = 1024)
    @ApiModelProperty(value = "收货人地址")
    private String consignAddr;

    /**
     * 订单状态： 1 待支付 2 已支付待发货 3 已发货 4 交易已完成 5 订单超时关闭
     */
    @ApiModelProperty(value = "订单状态： 1 待支付 2 已支付待发货 3 已发货 4 交易已完成 5 订单超时关闭")
    private Integer status;

    /**
     * 订单的退货退款状态：6-部分退货退款，7-整单退货退款
     */
    @ApiModelProperty(value = "订单的退货退款状态：6-部分退货退款，7-整单退货退款")
    private Integer returnStatus;

    /**
     * 订单退货退款状态变更时间
     */
    @ApiModelProperty(value = "订单退货退款状态变更时间")
    private Instant returnTime;

    /**
     * 该订单发生的退货退款金额
     */
    @ApiModelProperty(value = "该订单发生的退货退款金额")
    private Float returnAmount;

    /**
     * 发货状态：1：部分发货，2：全部发货，和status共同控制
     */
    @ApiModelProperty(value = "发货状态：1：部分发货，2：全部发货，和status共同控制")
    private Integer sendStatus;

    /**
     * 取消订单的原因
     */
    @Size(max = 255)
    @ApiModelProperty(value = "取消订单的原因")
    private String cancelReason;

    /**
     * 收货人所在区（对应ibalife_base.base_county.county_id）
     */
    @ApiModelProperty(value = "收货人所在区（对应ibalife_base.base_county.county_id）")
    private Integer consignCountry;

    /**
     * 收货人所在省（对应ibalife_base.base_province.prov_id）
     */
    @ApiModelProperty(value = "收货人所在省（对应ibalife_base.base_province.prov_id）")
    private Integer consignProvince;

    /**
     * 收货人所在市（对应ibalife_base.base_city.city_id）
     */
    @ApiModelProperty(value = "收货人所在市（对应ibalife_base.base_city.city_id）")
    private Integer consignCity;

    /**
     * 支付方式 1-线下付款，2-支付宝，3-易宝，4-微信，5-银联，6-网付通，7-苹果支付，8-招商银行，9-余额支付，10-余额微信混合支付，11-余额支付宝混合支付，12-余额银联混合支付，13-通联代付，14-小程序支付
     */
    @ApiModelProperty(value = "支付方式 1-线下付款，2-支付宝，3-易宝，4-微信，5-银联，6-网付通，7-苹果支付，8-招商银行，9-余额支付，10-余额微信混合支付，11-余额支付宝混合支付，12-余额银联混合支付，13-通联代付，14-小程序支付")
    private Integer payType;

    /**
     * 订单交易流水号
     */
    @Size(max = 64)
    @ApiModelProperty(value = "订单交易流水号")
    private String tranno;

    /**
     * 创建订单的用户帐号
     */
    @Size(max = 11)
    @ApiModelProperty(value = "创建订单的用户帐号")
    private String uaccount;

    /**
     * 订单来源（1表示网站，2表示微商城）
     */
    @ApiModelProperty(value = "订单来源（1表示网站，2表示微商城）")
    private Integer src;

    /**
     * 订单操作人Id
     */
    @ApiModelProperty(value = "订单操作人Id")
    private Integer opUid;

    /**
     * 订单支付时间
     */
    @ApiModelProperty(value = "订单支付时间")
    private Instant payTime;

    /**
     * 订单发货时间
     */
    @ApiModelProperty(value = "订单发货时间")
    private Instant sendTime;

    /**
     * 订单配送完成时间
     */
    @ApiModelProperty(value = "订单配送完成时间")
    private Instant distributeTime;

    /**
     * 订单完成时间
     */
    @ApiModelProperty(value = "订单完成时间")
    private Instant doneTime;

    /**
     * 最后修改日期
     */
    @ApiModelProperty(value = "最后修改日期")
    private Instant lastUpdateTime;

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

    public OrderDTO() {
        // Empty constructor needed for Jackson.
    }

    public OrderDTO(Order order) {
        this.orderId = order.getOrderId();
        this.uid = order.getUid();
        this.createTime = order.getCreateTime();
        this.totalPrice = order.getTotalPrice();
        this.consignIdno = order.getConsignIdno();
        this.consignee = order.getConsignee();
        this.consignPhone = order.getConsignPhone();
        this.consignAddr = order.getConsignAddr();
        this.status = order.getStatus();
        this.returnStatus = order.getReturnStatus();
        this.returnTime = order.getReturnTime();
        this.returnAmount = order.getReturnAmount();
        this.sendStatus = order.getSendStatus();
        this.cancelReason = order.getCancelReason();
        this.consignCountry = order.getConsignCountry();
        this.consignProvince = order.getConsignProvince();
        this.consignCity = order.getConsignCity();
        this.payType = order.getPayType();
        this.tranno = order.getTranno();
        this.uaccount = order.getUaccount();
        this.src = order.getSrc();
        this.opUid = order.getOpUid();
        this.payTime = order.getPayTime();
        this.sendTime = order.getSendTime();
        this.distributeTime = order.getDistributeTime();
        this.doneTime = order.getDoneTime();
        this.lastUpdateTime = order.getLastUpdateTime();
        this.createdDate = order.getCreatedDate();
        this.lastModifiedDate = order.getLastModifiedDate();
    }

    public Order toOrder() {
        Order order = new Order();
        order.setOrderId(this.getOrderId());
        order.setUid(this.getUid());
        order.setCreateTime(this.getCreateTime());
        order.setTotalPrice(this.getTotalPrice());
        order.setConsignIdno(this.getConsignIdno());
        order.setConsignee(this.getConsignee());
        order.setConsignPhone(this.getConsignPhone());
        order.setConsignAddr(this.getConsignAddr());
        order.setStatus(this.getStatus());
        order.setReturnStatus(this.getReturnStatus());
        order.setReturnTime(this.getReturnTime());
        order.setReturnAmount(this.getReturnAmount());
        order.setSendStatus(this.getSendStatus());
        order.setCancelReason(this.getCancelReason());
        order.setConsignCountry(this.getConsignCountry());
        order.setConsignProvince(this.getConsignProvince());
        order.setConsignCity(this.getConsignCity());
        order.setPayType(this.getPayType());
        order.setTranno(this.getTranno());
        order.setUaccount(this.getUaccount());
        order.setSrc(this.getSrc());
        order.setOpUid(this.getOpUid());
        order.setPayTime(this.getPayTime());
        order.setSendTime(this.getSendTime());
        order.setDistributeTime(this.getDistributeTime());
        order.setDoneTime(this.getDoneTime());
        order.setLastUpdateTime(this.getLastUpdateTime());
        order.setCreatedDate(this.getCreatedDate());
        order.setLastModifiedDate(this.getLastModifiedDate());

        return order;
    }

    public Order toOrder(Order order) {
        Optional.ofNullable(orderId).ifPresent(order::setOrderId);
        Optional.ofNullable(uid).ifPresent(order::setUid);
        Optional.ofNullable(createTime).ifPresent(order::setCreateTime);
        Optional.ofNullable(totalPrice).ifPresent(order::setTotalPrice);
        Optional.ofNullable(consignIdno).ifPresent(order::setConsignIdno);
        Optional.ofNullable(consignee).ifPresent(order::setConsignee);
        Optional.ofNullable(consignPhone).ifPresent(order::setConsignPhone);
        Optional.ofNullable(consignAddr).ifPresent(order::setConsignAddr);
        Optional.ofNullable(status).ifPresent(order::setStatus);
        Optional.ofNullable(returnStatus).ifPresent(order::setReturnStatus);
        Optional.ofNullable(returnTime).ifPresent(order::setReturnTime);
        Optional.ofNullable(returnAmount).ifPresent(order::setReturnAmount);
        Optional.ofNullable(sendStatus).ifPresent(order::setSendStatus);
        Optional.ofNullable(cancelReason).ifPresent(order::setCancelReason);
        Optional.ofNullable(consignCountry).ifPresent(order::setConsignCountry);
        Optional.ofNullable(consignProvince).ifPresent(order::setConsignProvince);
        Optional.ofNullable(consignCity).ifPresent(order::setConsignCity);
        Optional.ofNullable(payType).ifPresent(order::setPayType);
        Optional.ofNullable(tranno).ifPresent(order::setTranno);
        Optional.ofNullable(uaccount).ifPresent(order::setUaccount);
        Optional.ofNullable(src).ifPresent(order::setSrc);
        Optional.ofNullable(opUid).ifPresent(order::setOpUid);
        Optional.ofNullable(payTime).ifPresent(order::setPayTime);
        Optional.ofNullable(sendTime).ifPresent(order::setSendTime);
        Optional.ofNullable(distributeTime).ifPresent(order::setDistributeTime);
        Optional.ofNullable(doneTime).ifPresent(order::setDoneTime);
        Optional.ofNullable(lastUpdateTime).ifPresent(order::setLastUpdateTime);
        Optional.ofNullable(createdDate).ifPresent(order::setCreatedDate);
        Optional.ofNullable(lastModifiedDate).ifPresent(order::setLastModifiedDate);

        return order;
    }


}
