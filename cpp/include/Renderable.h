#ifndef RENDERABLE_H
#define RENDERABLE_H

#include <iostream>
#include "Cell.h"
using namespace std;

class Renderable: public Cell {
    /*menampilkan semua yang ada di GUI */
    public:
        void render();
};
#endif