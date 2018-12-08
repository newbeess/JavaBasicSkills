package po;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author c_fu
 * @date 2018/3/23
 */
public class ReceivedCouponItem {

    protected String couponCode;
    protected int promotionID;


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
}
