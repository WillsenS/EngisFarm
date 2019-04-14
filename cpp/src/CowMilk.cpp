#include "CowMilk.h"

CowMilk::CowMilk() {
    this->productValue = 4;
    this->expireValue = 5;
}

CowMilk::~CowMilk() {
    this->productValue = 0;
    this->expireValue = 0;
}
