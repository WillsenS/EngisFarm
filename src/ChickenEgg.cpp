#include "ChickenEgg.h"

ChickenEgg::ChickenEgg() {
    this->productValue = 3;
    this->expireValue = 10;
}

ChickenEgg::~ChickenEgg() {
    this->productValue = 0;
    this->expireValue = 0;
}
