#ifndef FACILITY_H
#define FACILITY_H

#include <iostream>
#include "Cell.h"
using namespace std;

class Facility : public Cell {
    public :
        /*Constructor untuk facility*/
        Facility();

        /*Mengembalikan letak x dari Well*/
        int getWellX();
        /*Mengembalikan letak y dari Well*/
        int getWellY();
        /*Mengembalikan letak x dari Well*/
        int getMixerX();
        /*Mengembalikan letak y dari Mixer*/
        int getMixerY();
        /*Mengembalikan letak x dari Mixer*/
        int getTruckX();
        /*Mengembalikan letak y dari Well*/
        int getTruckY();
    private :
        /*Posisi facility yang ada*/
        static int wellx;
        static int welly;
        static int MixerX;
        static int MixerY;
        static int TruckX;
        static int TruckY;
        
};
#endif
