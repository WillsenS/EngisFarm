/**
 * FarmProduct class.
 * 
 * @author Ghazwan S. M. <ghazwan.sihamudin@gmail.com>
 * @since 2019.04.14
 */

public class FarmProduct implements Product {

    public FarmProduct(){
    };

    /**
     * Get the product value.
     * @return int product value.
     */
    public int getProductValue() {
        return this.productValue;
    };

    /**
     * Get the expire value of the product.
     * @return int expire value.
     */
    public int getExpireValue() {
        return this.expireValue;
    };

    /**
     * Reduce the expire value of the product by 1.
     */
    public void setExpireValue() {
        this.expireValue--;
    };

    /**
     * Get the product expire condition.
     * @return bool expire condition.
     */
    public bool isExpire() {
        return this.expireValue <= 0 ? true : false;
    };
};
