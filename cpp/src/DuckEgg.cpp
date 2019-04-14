#include "DuckEgg.h"

DuckEgg::DuckEgg() {
    this->productValue = 4;
    this->expireValue = 10;
}

DuckEgg::~DuckEgg() {
    this->productValue = 0;
    this->expireValue = 0;
}
