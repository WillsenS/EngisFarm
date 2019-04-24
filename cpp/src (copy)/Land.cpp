#include <iostream>
#include <string>
#include "Land.h"
using namespace std;

/* Constructor untuk map (land) */
Land::Land():Cell() {
    cout<<"Land Dibuat"<<endl;
}

/*Mengembalikan value dari matriks map */
// char Land::getElement(int x, int y){
//     return Cell::map[x][y];
// }

/*Mengembalikan jenis land sesuai dengan value dari matriks map*/
string Land::getProperties(char value) {
    if (value=='-') {
        return "Grassland";
    } else if (value == 'x') {
        return "Barn";
    } else if (value == 'o') {
        return "Coop";
    } else if (value == 'W') {
        return "Well";
    } else if (value == 'M') {
        return "Mixer";
    } else if (value == 'T') {
        return "Truck";
    }else{
        return "value salah";
    }
}
