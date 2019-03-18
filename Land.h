#ifndef LAND_H
#define LAND_H

#include <iostream>
#include <string>
using namespace std;

class Land {
    public :
        //Constructor untuk map (land)
        Land();
        //Dtor untuk map (land)
        ~Land();

        //Mengembalikan sizex map
        int getSizex();
        //Mengembalikan sizex map
        int getSizey();
        //Mengembalikan value dari matriks map
        int getElement(int x, int y);
        //Mengembalikan jenis land sesuai dengan value dari matriks map
        string getProperties(int value);

    private :
        //ukuran map dalam x dan y
        int sizex; 
        int sizey; 

        //Matriks Map
        char *map;
};
#endif
