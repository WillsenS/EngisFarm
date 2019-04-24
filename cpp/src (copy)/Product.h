#ifndef PRODUCT_H
#define PRODUCT_H

/**
 * Product class.
 * 
 * @author Ghazwan S. M. <ghazwan.sihamudin@gmail.com>
 * @since 2019.03.17
 */
class Product {
    public:
        /**
         * Get the product value.
         * @return int product value.
         */
        virtual int getProductValue() = 0;

        /**
         * Get the expire value of the product.
         * @return int expire value.
         */
        virtual int getExpireValue() = 0;

        /**
         * Reduce the expire value of the product by 1.
         */
        virtual void setExpireValue() = 0;

        /**
         * Get the product expire condition.
         * @return bool expire condition.
         */
        virtual bool isExpire() = 0;

    protected:

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
