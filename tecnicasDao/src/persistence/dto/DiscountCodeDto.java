package persistence.dto;

import java.math.BigDecimal;

/**
 * Created by ljunior on 4/14/16.
 */
public class DiscountCodeDto {
    private String discountCode;
    private BigDecimal rate;

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
