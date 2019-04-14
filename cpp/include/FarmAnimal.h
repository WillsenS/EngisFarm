#ifndef FARMANIMAL_H
#define FARMANIMAL_H
#define FULLMAX 5
#define dead -5
#define MAX 1

#include <iostream>
#include <string>
#include "LivingThings.h"
#include <stdlib.h>
#include "Cell.h"

using namespace std;
class FarmAnimal : public LivingThings {
    public:
        
        FarmAnimal(int x , int y);//constructor
        ~FarmAnimal();//destructor
        //void move (int posX,int posY);
        //void talk();
        virtual void eat(Cell& _c) = 0;
        virtual string getChar() = 0;
        virtual void getProduct()=0;
        //virtual void setProduct(string produk)=0;
        static int getCountAnimal(); // Menghitung jumlah hewan yang masih hidup
        virtual void Print() = 0;
        virtual void setFull(int Full) = 0;
        virtual void move(Cell& _c) = 0;
        int getPosX();
        int getPosY();
        void setPosX(int x);
        void setPosY(int y);
        bool getStatus();
        void setStatus(bool cek);
        
    private:
        static int countAnimal;
        int posX;
        int posY;
        
       
    protected:
        int Full;
        bool status;
        



};
#endif
