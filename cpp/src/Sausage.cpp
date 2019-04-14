#include "Sausage.h"

Sausage::Sausage(int portion) {
    this->portion = portion;
    this->productValue = 5;
    this->expireValue = 5;
}

Sausage::~Sausage() {
    this->portion = 0;
    this->productValue = 0;
    this->expireValue = 0;
}
