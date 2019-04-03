#include <iostream>
#include <string>
#include "FarmProduct.h"
using namespace std;

FarmProduct::FarmProduct() {
}

FarmProduct::~FarmProduct() {
}

int FarmProduct::getProductValue() {
    return this->productValue;
}

int FarmProduct::getExpireValue() {
    return this->expireValue;
}

void FarmProduct::setExpireValue() {
    this->expireValue--;
}

bool FarmProduct::isExpire() {
    return this->expireValue <= 0 ? true : false;
}