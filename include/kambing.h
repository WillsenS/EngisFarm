#ifndef KAMBING_H
#define KAMBING_H

#include <iostream>
#include <string>
//#include "FarmAnimal.h"
#include "Milkproducing.h"
#include "Meatproducing.h"
#include "Cell.h"
using namespace std;

class kambing : public Meatproducing,public Milkproducing{
    public:
        kambing(int posX ,int posY);
        ~kambing();
        void move (Cell& _c);
        void talk();
        void eat(Cell&_c);
        string getChar();
        string getProduct();
        //void setProduct(string goatMilk);
        int getcountgoatMilk() const;
        int getFull();
        void setFull(int Full);
        /*int getPosX();
        int getPosY();
        void setPosX(int x);
        void setPosY(int y);*/
        void Print();
    private:
        bool hasEat;
        string goatMilk;
        int countgoatMilk;
        int posX;
        int posY;
        int Full;
};
#endif
