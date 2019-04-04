#include <iostream>
#include "../include/Facility.h"
using namespace std;


int Facility::wellx = 14;
int Facility::welly = 11;
int Facility::MixerX = 14;
int Facility::MixerY = 13;
int Facility::TruckX = 14;
int Facility::TruckY = 14;

/*Constructor untuk facility*/
Facility::Facility() : Cell() {
    Cell::setElement(getWellX(), getWellY(), 'W');
    Cell::setElement(getMixerX(), getMixerY(), 'M');
    Cell::setElement(getTruckX(), getTruckY(), 'T');
}

/*Mengembalikan letak x dari Well*/
int Facility::getWellX() {
    return wellx;
}

/*Mengembalikan letak y dari Well*/
int Facility::getWellY() {
    return welly;
}

/*Mengembalikan letak x dari Well*/
int Facility::getMixerX() {
    return MixerX;
}

/*Mengembalikan letak y dari Mixer*/
int Facility::getMixerY() {
    return MixerY;
}

/*Mengembalikan letak x dari Mixer*/
int Facility::getTruckX() {
    return TruckX;
}

/*Mengembalikan letak y dari Well*/
int Facility::getTruckY() {
    return TruckY;
}


