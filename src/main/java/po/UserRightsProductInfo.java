package po;

/**
 * @author c_fu
 * @date 2018/3/23
 */
public class UserRightsProductInfo {

    private long userProductId;
    private String result;
    private Integer promotionCode;

    public long getUserProductId() {
        return userProductId;
    }

    public void setUserProductId(long userProductId) {
        this.userProductId = userProductId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(Integer promotionCode) {
        this.promotionCode = promotionCode;
    }
}
