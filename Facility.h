#ifndef FACILITY_H
#define FACILITY_H

#include <iostream>
#include "Land.h"
using namespace std;

class Facility : public Land {
    public :
        //Constructor untuk facility
        Facility();

        //Mengembalikan letak x dari Well
        getWellx();
        //Mengembalikan letak y dari Well
        getWelly();
        //Mengembalikan letak x dari Well
        getMixerx();
        //Mengembalikan letak y dari Mixer
        getMixery();
        //Mengembalikan letak x dari Mixer
        getTruckx();
        //Mengembalikan letak y dari Well
        getTrucky();
    private :
        //Posisi facility yang ada
        int wellx; 
        int welly;
        int Mixerx; 
        int Mixery;
        int Truckx; 
        int Trucky;
        
};
#endif