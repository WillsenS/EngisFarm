#include <iostream>
#include <string>
#include "Cell.h"
using namespace std;

/*Constructor untuk map (cell)*/
Cell::Cell(){
    sizex = 15;
    sizey = 15;
    map = new char*[sizex];
    for(int i=0; i<sizex; i++){
        map[i] = new char[sizey];
        for(int j=0; j<sizey; j++){
            map[i][j] = '-';
        }
    }
    for(int i=0; i<5; i++){
        for(int j=0; j<5; j++){
            map[i][j] = 'o';
        }
    }
    for(int i=6; i<11; i++){
        for(int j=0; j<7; j++){
            map[i][j] = 'x';
        }
    }
}
/*Dtor untuk map (cell)*/
Cell::~Cell(){
    for(int i=0; i<sizex; i++){
        delete[] map[i];
    }
    delete[] map;
}

/*Mengubah nilai sizex menjadi _x*/
void Cell::setSizex(int _x){
    sizex = _x;
}
/*Mengubah nilai sizey menjadi _y*/
void Cell::setSizey(int _y){
    sizey = _y;
}
/*Mengembalikan sizex map*/
int Cell::getSizex(){
    return sizex;
}
/*Mengembalikan sizex map*/
int Cell::getSizey(){
    return sizey;
}
/*Mengembalikan value dari matriks map*/
char Cell::getElement(int x, int y){
    return map[x][y];
}
/*Mengembalikan jenis land sesuai dengan value dari matriks map*/
//string Cell::getProperties(int value);
/*Mengecek cell terisi atau tidak*/
bool Cell::isEmptyCell(int x, int y){
    if(map[x][y]=='y'){
        return true;
    }else{
        return false;
    }
}

/*Menentukan nilai value dari cell pada matriks*/
void Cell::setElement(int x, int y, char e){
    map[x][y] = 'e';
}