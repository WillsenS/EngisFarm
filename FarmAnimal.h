#ifndef FARMANIMAL_H
#define FARMANIMAL_H
#define FULLMAX 5

#include <iostream>
#include <string>
#include "LivingThings.h"

/**
 * FarmAnimal class 
 * Class hewan yang ad di engi's farm,turunan dari living things
 * @author 13517090
 * @since 2019.03.17
 */
using namespace std;

class FarmAnimal : public LivingThings {
    public:
        FarmAnimal(int x , int y);/*constructor*/
        ~FarmAnimal();/*destructor*/
        //void move (int posX,int posY);
        //void talk();
        virtual void eat()=0; /*pure virtual*/
        //virtual string getProduct()=0;
        //virtual void setProduct(string produk)=0;
        static int getcountAnimal(); /* Menghitung jumlah hewan yang terbentuk*/
        virtual void Print()=0;/*pure virtual*/
        virtual void setFull(int Full)=0;/*pure virtual*/
        
    private:
        static int countAnimal;
        int posX;
        int posY;
        
    protected:
        int Full;



};
#endif
