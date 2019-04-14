#include "BBQ.h"

BBQ::BBQ(int portion) {
    this->portion = portion;
    this->productValue = 5;
    this->expireValue = 5;
}

BBQ::~BBQ() {
    this->portion = 0;
    this->productValue = 0;
    this->expireValue = 0;
}
