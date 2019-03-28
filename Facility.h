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
        int getWellx();
        /*Mengembalikan letak y dari Well*/
        int getWelly();
        /*Mengembalikan letak x dari Well*/
        int getMixerx();
        /*Mengembalikan letak y dari Mixer*/
        int getMixery();
        /*Mengembalikan letak x dari Mixer*/
        int getTruckx();
        /*Mengembalikan letak y dari Well*/
        int getTrucky();
    private :
        /*Posisi facility yang ada*/
        static int wellx; 
        static int welly;
        static int Mixerx; 
        static int Mixery;
        static int Truckx; 
        static int Trucky;
        
};
#endif
