#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>
#include <string>
#include "LinkedList.h"
#include "LivingThings.h"
#include "Facility.h"
#include "Renderable.h"

class Player : public LivingThings {
    private:
        int posX;
        int posY;
        int water;
        int money;
        // LinkedList<string> inventory;
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

        /*
         * Menyembelih hewan
         * Hanya dapat digunakan kepada MeatProducingAnimal
         */
        //void Kill();

        /*
         * Menyiram land
         * Menumbuhkan rumput ditempat player berdiri
         * Water -1
         */
        void Grow(Cell &_c);

        // //Menyiram land
        // //Menumbuhkan rumput ditempat player berdiri
        // //Water -1
        // void grow(Renderable _r);
};
#endif
