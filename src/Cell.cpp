#include <iostream>
#include <string>
#include "../include/Cell.h"
using namespace std;

/*Constructor untuk map (cell)*/
Cell::Cell() {
    sizex = 15;
    sizey = 15;
    map = new char**[sizex];
    for(int i = 0; i <sizex; i++) {
        map[i] = new char*[sizey];
        for(int j = 0; j < sizey; j++) {
            map[i][j] = new char[3];
                map[i][j][0] = '-';
                map[i][j][1] = ' ';
                map[i][j][2] = ' ';
        }
    }
    for(int i = 0; i < 5; i++) {
        for(int j = 0; j < 5; j++) {
            map[i][j][0] = 'o';
            map[i][j][1] = '*';
            map[i][j][2] = ' ';
        }
    }
    for(int i = 6; i < 11; i++) {
        for(int j = 0; j < 7; j++) {
            map[i][j][0] = 'x';
            map[i][j][1] = '@';
            map[i][j][2] = ' ';
        }
    }
}
/*Dtor untuk map (cell)*/
Cell::~Cell() {
    for(int i = 0; i < sizex; i++) {
        for(int j = 0; j < sizey; j++) {
            delete[] map[i][j];
        }
        delete[] map[i];
    }
    delete[] map;
}

/*Mengubah nilai sizex menjadi _x*/
void Cell::setSizex(int _x) {
    sizex = _x;
}
/*Mengubah nilai sizey menjadi _y*/
void Cell::setSizey(int _y) {
    sizey = _y;
}
/*Mengembalikan sizex map*/
int Cell::getSizex() {
    return sizex;
}
/*Mengembalikan sizex map*/
int Cell::getSizey() {
    return sizey;
}
/*Mengembalikan value dari matriks map*/
char Cell::getElement(int x, int y) {
    return map[x][y][2];
}
/*Mengembalikan jenis land sesuai dengan value dari matriks map*/
char Cell::getTypeLand(int x, int y){
    return map[x][y][0];
}
/*Mengecek cell terisi atau tidak*/
bool Cell::isEmptyCell(int x, int y) {
    if(map[x][y][2] != ' ') {
        return true;
    }else {
        return false;
    }
}

/*Menentukan nilai value dari cell pada matriks*/
void Cell::setElement(int x, int y, char e) {
    map[x][y][2] = e;
}

/*
*Menentukan petak rumput sesuai dengan land
*/
void Cell::setRumput(int x, int y){
    if(map[x][y][0] == '-'){
        map[x][y][1] = '#';
    }else if(map[x][y][0] == 'o'){
        map[x][y][1] = '*';
    }else{
        map[x][y][1] = '@';
    }
}

/*Mengembalikan nilai ada rumput atau tidak*/
char Cell::getRumput(int x, int y){
    return map[x][y][1];
}
