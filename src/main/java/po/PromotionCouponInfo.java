package po;

import java.math.BigDecimal;

/**
 * @author c_fu
 * @date 2018/3/23
 */
public class PromotionCouponInfo {
    /**
     *  券码
     */
    private String couponCode ;
    /**
     *  策略ID
     */
    private int promotionID ;
    /**
     *  金额
     */
    private BigDecimal amount;

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public int getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(int promotionID) {
        this.promotionID = promotionID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
