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
        void setSizex(int _x);
        /*Mengubah nilai sizey menjadi _y*/
        void setSizey(int _y);
        /*Mengembalikan sizex map*/
        int getSizex();
        /*Mengembalikan sizex map*/
        int getSizey();
        /*Mengembalikan value dari matriks map*/
        char getElement(int x, int y);
        /*Mengembalikan jenis land sesuai dengan value dari matriks map*/
        //string getProperties(int value);
        /*Mengecek cell terisi atau tidak*/
        bool isEmptyCell(int x, int y);
        /*Menentukan nilai value dari cell pada matriks*/
        void setElement(int x, int y, char e);

    private :
        /*ukuran map dalam x dan y*/
        int sizex; 
        int sizey; 

        /*Matriks Map*/
        char **map;
};
#endif
