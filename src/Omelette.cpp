#include "Omelette.h"

Omelette::Omelette(int portion) {
    this->portion = portion;
    this->productValue = 3;
    this->expireValue = 5;
}

Omelette::~Omelette() {
    this->portion = 0;
    this->productValue = 0;
    this->expireValue = 0;
}
