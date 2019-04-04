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

        /*Berbicara kepada hewan,
          Suara dihasilkan bergantung pada hewan*/
        void talk();

        void print();

        int getPosX();
        int getPosY();

        /*Berinteraksi dengan objek di samping player
          Dapat berupa FarmAnimal atau Facility
          Untuk FarmAnimal, hanya dapat digunakan kepada EggProducingAnimal dan MilkProducingAnimal*/
        void interact(Facility &_f);

        /*Menyembelih hewan
          Hanya dapat digunakan kepada MeatProducingAnimal*/
        //void Kill();

        /*Menyiram land
          Menumbuhkan rumput ditempat player berdiri
          Water -1*/
        void Grow(Cell &_c);

        // //Menyiram land
        // //Menumbuhkan rumput ditempat player berdiri
        // //Water -1
        // void grow(Renderable _r);
};
#endif
