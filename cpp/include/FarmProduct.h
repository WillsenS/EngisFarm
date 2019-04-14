#ifndef FARMPRODUCT_H
#define FARMPRODUCT_H

#include "Product.h"

/**
 * FarmProduct class.
 * 
 * @author Ghazwan S. M. <ghazwan.sihamudin@gmail.com>
 * @since 2019.03.17
 */
class FarmProduct : public Product {
    public:
        FarmProduct();
        ~FarmProduct();
        
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
         * Reduce the expire value of the product by 1.
         */
        void setExpireValue();

        /**
         * Get the product expire condition.
         * @return bool expire condition.
         */
        bool isExpire();



    private:

};
#endif
