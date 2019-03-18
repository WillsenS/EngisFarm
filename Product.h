#ifndef PRODUCT_H
#define PRODUCT_H

/**
 * Product class.
 * 
 * @author Ghazwan S. M. <ghazwan.sihamudin@gmail.com>
 * @since 2019.03.17
 */
Class Product {
    public:

        /**
         * Get the product value.
         * @return int product value.
         */
        int getProductValue();

        /**
         * Get the expire value of the product.
         * @return int expire value.
         */
        int getExpireValue();

        /**
         * Get the product expire condition.
         * @return bool expire condition.
         */
        bool isExpire()

    private:

        /**
         * @var int The money value of product.
         */
        int productValue;

        /**
         * @var int The number of ticks available before the product expire.
         */
        int expireValue;
};
#endif
