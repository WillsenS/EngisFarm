#ifndef FARMANIMAL_H
#define FARMANIMAL_H

#include <iostream>
#include <string>
#include "livingThings.h"

using namespace std;
class FarmAnimal : public LivingThings {
    public:
        FarmAnimal(int x , int y);//constructor
        ~FarmAnimal();//destructor
        //void move (int posX,int posY);
        //void talk();
        virtual void eat()=0;
        virtual string getProduct()=0;
        virtual void setProduct(string produk)=0;
        static int getcountAnimal(); // Menghitung jumlah hewan yang masih hidup
        
    private:
        static int countAnimal;
        int posX;
        int posY;



};
#endif
