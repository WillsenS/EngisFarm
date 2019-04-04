#ifndef CELL_H
#define CELL_H

#include <iostream>
#include <string>
using namespace std;

class Cell {
    public :
        /*Constructor untuk map (cell)*/
        Cell();
        /*Dtor untuk map (cell)*/
        ~Cell();

        /*Mengubah nilai sizex menjadi _x*/
        void setSizeX(int _x);
        /*Mengubah nilai sizey menjadi _y*/
        void setSizeY(int _y);
        /*Mengembalikan sizex map*/
        int getSizeX();
        /*Mengembalikan sizex map*/
        int getSizeY();
        /*Mengembalikan value dari matriks map*/
        char getElement(int x, int y);
        /*Mengembalikan jenis land sesuai dengan value dari matriks map*/
        char getTypeLand(int x, int y);
        /*Mengecek cell terisi atau tidak*/
        bool isEmptyCell(int x, int y);
        /*Menentukan nilai value dari cell pada matriks*/
        void setElement(int x, int y, char e);
        /*Menentukan petak rumput*/
        void setRumput(int x, int y);
        /*Mengembalikan nilai ada rumput atau tidak*/
        char getRumput(int x, int y);

    private :
        /*ukuran map dalam x dan y*/
        int sizex; 
        int sizey; 

        /*Matriks Map*/
        char ***map;
};
#endif
