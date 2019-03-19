#ifndef SIDEPRODUCT_H
#define SIDEPRODUCT_H

#include "Product.h"

/**
 * SideProduct class.
 * 
 * @author Ghazwan S. M. <ghazwan.sihamudin@gmail.com>
 * @since 2019.03.17
 */
Class SideProduct : public Product {
	public:
		SideProduct();
		~SideProduct();

        /**
         * Get product portion.
         * @return int portion.
         */
		int getPortion();
	private:

	    /**
	     * @var int The portion of the side product.
	     */
		int portion;
};
#endif