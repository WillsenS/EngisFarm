#include <iostream>
#include <string>
#include "SideProduct.h"
using namespace std;

SideProduct::SideProduct() {
}

SideProduct::~SideProduct() {
}

int SideProduct::getProductValue() {
    return this->isExpire() ? 0 : this->productValue;
}

int SideProduct::getExpireValue() {
    return this->expireValue * this->portion;
}

void SideProduct::setExpireValue() {
    this->expireValue--;
}

bool SideProduct::isExpire() {
    return this->expireValue <= 0 ? true : false;
}

int SideProduct::getPortion() {
    return this->portion;
}