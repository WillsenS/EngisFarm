#ifndef SIDEPRODUCT_H
#define SIDEPRODUCT_H

#include "Product.h"

/**
 * SideProduct class.
 * 
 * @author Ghazwan S. M. <ghazwan.sihamudin@gmail.com>
 * @since 2019.03.17
 */
class SideProduct : public Product {
	public:
		SideProduct();
		~SideProduct();

        /**
         * Get product portion.
         * @return int portion.
         */
		int getPortion();

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


	
    protected:
	    /**
	     * @var int The portion of the side product.
	     */
		int portion;
};
#endif
