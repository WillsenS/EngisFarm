/**
 * SideProduct class.
 * 
 * @author Ghazwan S. M. <ghazwan.sihamudin@gmail.com>
 * @since 2019.04.14
 */

public class SideProduct implements Product {
    protected int portion;
    /**
     * @var int The money value of product.
     */
    public int productValue;

    /**
     * @var int The number of ticks available before the product expire.
     */
    public int expireValue;

    public SideProduct() {
        this.portion = 0;
        this.productValue = 0;
        this.expireValue = 0;
    }

    /**
     * Get product portion.
     * @return int portion.
     */
    public int getPortion() {
        return this.portion;
    }

    /**
     * Get the product value.
     * @return int product value.
     */
    public int getProductValue() {
        return this.productValue;
    }

    /**
     * Get the expire value of the product.
     * @return int expire value.
     */
    public int getExpireValue() {
        return this.expireValue;
    }

    /**
     * Reduce the expire value of the product by 1.
     */
    public void setExpireValue() {
        if (this.expireValue > 0) {
            this.expireValue--;
        }
    }

    /**
     * Get the product expire condition.
     * @return boolean expire condition.
     */
    public boolean isExpire() {
        return this.expireValue <= 0 ? true : false;
    }
}
