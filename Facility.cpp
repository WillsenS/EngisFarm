#include <iostream>
#include "Facility.h"
using namespace std;


int Facility::wellx = 14;
int Facility::welly = 11;
int Facility::Mixerx = 14;
int Facility::Mixery = 13;
int Facility::Truckx = 14;
int Facility::Trucky = 14;

/*Constructor untuk facility*/
Facility::Facility() : Cell(){
    Cell::setElement(getWellx(), getWelly(), 'W');
    Cell::setElement(getMixerx(), getMixery(), 'M');
    Cell::setElement(getTruckx(), getTrucky(), 'T');
}

/*Mengembalikan letak x dari Well*/
int Facility::getWellx(){
    return wellx;
}
/*Mengembalikan letak y dari Well*/
int Facility::getWelly(){
    return welly;
}
/*Mengembalikan letak x dari Well*/
int Facility::getMixerx(){
    return Mixerx; 
}
/*Mengembalikan letak y dari Mixer*/
int Facility::getMixery(){
    return Mixery;
}
/*Mengembalikan letak x dari Mixer*/
int Facility::getTruckx(){
    return Truckx;
}
/*Mengembalikan letak y dari Well*/
int Facility::getTrucky(){
    return Trucky;
}

