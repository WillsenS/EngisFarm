#ifndef SAPI_H
#define SAPI_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Milkproducing.h"
#include "Meatproducing.h"

using namespace std;
/**
 * sapi class.
 * Class sabi ,turunan meat producing&milk
 * @author 13517090
 * @since 2019.03.17
 */
class sapi : public Meatproducing,public Milkproducing{
    public:
        sapi(int posX ,int posY);
        ~sapi();
        void move ();
        void talk();
        void eat();
        string getProduct();
        //void setProduct(string cowMilk);
        int getcountcowMilk()const;
        int getFull();
        void setFull(int Full);
    private:
        bool hasEat;
        string cowMilk;
        int countcowMilk;
        int posX;
        int posY;
        int Full;
};
#endif
