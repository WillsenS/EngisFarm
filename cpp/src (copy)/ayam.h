#ifndef AYAM_H
#define AYAM_H

#include <iostream>
#include <string>
//#include "FarmAnimal.h"
#include "Eggproducing.h"
#include "Meatproducing.h"
#include "Cell.h"

using namespace std;
class ayam : public Eggproducing,public Meatproducing{
    public:
        ayam(int posX ,int posY);
        ~ayam();
        void move (Cell& _c);
        void talk();
        void eat(Cell&_c);
        string getChar();
        void getProduct();
        //void setProduct(string telur);
        int getCountTelur() const ;
        int getFull();
        void setFull(int Full);
        /*int getPosX();
        int getPosY();
        void setPosX(int x);
        void setPosY(int y);*/
        void Print();

    private:
        bool hasEat;
        string telur;
        int posX;
        int posY;
        int countTelurA;
        int Full;
};
#endif
