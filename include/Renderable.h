#ifndef RENDERABLE_H
#define RENDERABLE_H

#include <iostream>
#include "Cell.h"
using namespace std;

class Renderable:Cell {
    /*menampilkan semua yang ada di GUI */
    public:
        void render(); /* pure virtual */
};
#endif