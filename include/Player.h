#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>
#include <string>
#include "LinkedList.h"
#include "LivingThings.h"

class Player : public LivingThings {
    private:
        int posX;
        int posY;
        int water;
        int money;
        LinkedList<string> inventory;
    public:
        //Constructor
        Player(int x, int y);

        //Destructor
        ~Player();

        /*Bergerak ke posX, posY*/
        void move (int posX, int posY);

        /*Berbicara kepada hewan,
          Suara dihasilkan bergantung pada hewan*/
        void talk();

        /*Berinteraksi dengan objek di samping player
          Dapat berupa FarmAnimal atau Facility
          Untuk FarmAnimal, hanya dapat digunakan kepada EggProducingAnimal dan MilkProducingAnimal*/
        //void Interact();

        /*Menyembelih hewan
          Hanya dapat digunakan kepada MeatProducingAnimal*/
        //void Kill();

        /*Menyiram land
          Menumbuhkan rumput ditempat player berdiri
          Water -1*/
        //void Grow();

        // //Menyiram land
        // //Menumbuhkan rumput ditempat player berdiri
        // //Water -1
        // void Grow();
};
#endif
