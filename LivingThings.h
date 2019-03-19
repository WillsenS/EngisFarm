#ifndef LIVINGTHINGS_H
#define LIVINGTHINGS_H

#include <iostream>
using namespace std;

class LivingThings {
    /*menampilkan semua yang ada di GUI */
    public:
        /*Untuk bergerak */
        virtual void move() = 0; /* pure virtual */
        /*Untuk berbicara */
        virtual void talk() = 0; /* pure virtual */
};
#endif