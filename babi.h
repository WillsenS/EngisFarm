#ifndef BABI_H
#define BABI_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Meatproducing.h"

using namespace std;
/**
 * babi class.
 * Class babi ,turunan meat producing
 * @author 13517090
 * @since 2019.03.17
 */
class babi : public Meatproducing{
    public:
        babi(int posX ,int posY);
        ~babi();
        void move ();
        void talk();
        void eat();
        string getProduct();
        //void setProduct(string pork);
        int getcountPork() const;
        int getFull();
        void setFull(int Full);
    private:
        bool hasEat;
        string pork;
        int countPork;
        int posX;
        int posY;
        int Full;
};
#endif
