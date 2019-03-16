#ifndef FARMANIMAL_H
#define FARMANIMAL_H

#include <iostream>
#include <string>

class FarmAnimal {//: public livingThings {
    public:
        FarmAnimal(int x , int y);//constructor
        ~FarmAnimal();//destructor
        void Move (int posX,int posY);
        void Talk();
        virtual void eat();
        virtual string getProduct()=0;
        virtual void setProduct(string produk)=0;
        static int getcountAnimal; // Menghitung jumlah hewan yang masih hidup
        
    private:
        static int countAnimal;
        int posX;
        int posY;



};
#endif
