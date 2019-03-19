#ifndef RENDERABLE_H
#define RENDERABLE_H

#include <iostream>
using namespace std;

class Renderable {
    /*menampilkan semua yang ada di GUI */
    public:
        virtual void render() = 0; /* pure virtual */
};
#endif