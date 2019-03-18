#ifndef LAND_H
#define LAND_H

#include <iostream>
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
    private :
        //ukuran map
        int sizex; 
        int sizey; 
        char *map;
};
#endif