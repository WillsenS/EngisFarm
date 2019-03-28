#ifndef RENDERABLE_H
#define RENDERABLE_H

#include <iostream>
#include "Cell.h"
using namespace std;

class Renderable:Cell {
    /*menampilkan semua yang ada di GUI */
    public:
        virtual void render() = 0; /* pure virtual */
};
#endif