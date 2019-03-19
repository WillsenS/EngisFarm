#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>

class Player : public livingThings {
    private:
        int posX;
        int posY;
        int water;
    public:
        /*Constructor */
        Player(int x, int y);

        /*Destructor*/
        ~Player();

        /*Bergerak ke posX, posY*/
          Hanya dapat bergerak 1 petak per pemanggilan (?) ato enggak*/
        void Move (int posX, int posY);

        /*Berbicara kepada hewan,
          Suara dihasilkan bergantung pada hewan*/
        void Talk();

        /*Berinteraksi dengan objek di samping player
          Dapat berupa FarmAnimal atau Facility
          Untuk FarmAnimal, hanya dapat digunakan kepada EggProducingAnimal dan MilkProducingAnimal*/
        void Interact();

        /*Menyembelih hewan
          Hanya dapat digunakan kepada MeatProducingAnimal*/
        void Kill();

        /*Menyiram land
          Menumbuhkan rumput ditempat player berdiri
          Water -1*/
        void Grow();

};
#endif
