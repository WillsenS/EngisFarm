#ifndef LAND_H
#define LAND_H

#include <iostream>
#include <string>
#include "Cell.h"
using namespace std;

class Land : public Cell {
    public :
        /* Constructor untuk map (land) */
        Land();

        /*Mengembalikan value dari matriks map */
        // char getElement(int x, int y);
        /*Mengembalikan jenis land sesuai dengan value dari matriks map*/
        string getProperties(char value);
        /*Menentukan nilai value dari cell pada matriks*/
        void setElement(int x, int y, char e);

};
#endif
