#ifndef FARMANIMAL_H
#define FARMANIMAL_H
#define FULLMAX 5
#define MAX 1

#include <iostream>
#include <string>
#include "LivingThings.h"
#include <stdlib.h>

using namespace std;
class FarmAnimal : public LivingThings {
    public:
        
        FarmAnimal(int x , int y);//constructor
        ~FarmAnimal();//destructor
        //void move (int posX,int posY);
        //void talk();
        virtual void eat()=0;
        //virtual string getProduct()=0;
        //virtual void setProduct(string produk)=0;
        static int getcountAnimal(); // Menghitung jumlah hewan yang masih hidup
        virtual void Print()=0;
        virtual void setFull(int Full)=0;
         int getPosX();
         int getPosY();
          void setPosX(int x);
         void setPosY(int y);
        
    private:
        static int countAnimal;
        int posX;
        int posY;
       
    protected:
        int Full;
        



};
#endif
