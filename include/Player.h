#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>
#include <string>
#include <vector>
#include "LinkedList.h"
#include "LivingThings.h"
#include "Facility.h"
#include "Renderable.h"
#include "GoatMeat.h"
#include "GoatMilk.h"
#include "ChickenEgg.h"
#include "ChickenMeat.h"
#include "CowMeat.h"
#include "CowMilk.h"
#include "DuckEgg.h"
#include "DuckMeat.h"
#include "Pork.h"
#include "Omelette.h"
#include "Sausage.h"
#include "FarmAnimal.h"

class Player : public LivingThings {
    private:
        int posX;
        int posY;
        int water;
        int money;
        LinkedList<string> inventory;
    public:
        //Constructor
        Player(int x, int y, Cell& _c);

        //Destructor
        ~Player();

        /*Bergerak ke posX, posY*/
        void move (Cell& _c);

        /*
         * Berbicara kepada hewan,
         * Suara dihasilkan bergantung pada hewan
         */
        void talk();

        void print();

        int getPosX();
        int getPosY();
        int getMoney();
        int getWater();

        /*
         * Berinteraksi dengan objek di samping player
         * Dapat berupa FarmAnimal atau Facility
         * Untuk FarmAnimal, hanya dapat digunakan kepada EggProducingAnimal dan MilkProducingAnimal
         */
        void interact(Facility &_f);

        /*
         * Berinteraksi dengan facility.
         */
        void interactFacility(Facility &_f);

        /*
         * Mengembalikan jenis interaksi yang akan dilakukan oleh User.
         * @return int Tupe interaksi; 0 untuk Facilitty, 1 untuk Animal.
         */
        int getInteractType(Facility &_f);

        bool isAdjacent(int x, int y);

        /*Menyembelih hewan
          Hanya dapat digunakan kepada MeatProducingAnimal*/
        void Kill(Cell &_c, vector<FarmAnimal*>& animals);

        /*
         * Menyiram land
         * Menumbuhkan rumput ditempat player berdiri
         * Water -1
         */
        void Grow(Cell &_c);


        void cekhewan(int x, int y, Cell &_c);
        // //Menyiram land
        // //Menumbuhkan rumput ditempat player berdiri
        // //Water -1
        // void grow(Renderable _r);
};
#endif
