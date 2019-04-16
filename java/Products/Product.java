/**
 * Product interace class.
 * 
 * @author Ghazwan S. M. <ghazwan.sihamudin@gmail.com>
 * @since 2019.03.17
 */
interface Product {

    /**
     * Get the value of the product.
     * @return int expire value.
     */
    public int getProductValue();

    /**
     * Get the expire value of the product.
     * @return int expire value.
     */
    public int getExpireValue();

    /**
     * Reduce the expire value of the product by 1.
     */
    public void setExpireValue();

    /**
     * Get the product expire condition.
     * @return boolean expire condition.
     */
    public boolean isExpire();
}
