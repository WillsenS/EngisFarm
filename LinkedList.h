#ifndef LinkedList_H
#define LinkedList_H

#include <iostream>
using namespace std;

template<class Type>
struct node {
	node<Type>* next;
	Type data;
};

template<class Type>
class LinkedList{
    private:
        node<Type>* first;
        int size;

    public:
        //ctor
        LinkedList();
        // LinkedList(Type element);
        
        // Type& operator=(const Type p);
        //Mengembalikan indeks dimana elemen ditemukan, -1 jika tidak ada
        int find(Type element);
        //Mengembalikan True jika linked list kosong
        bool isEmpty();
        //Menambahkan elemen sebagai elemen paling akhir
        void add(Type element);
        //Membuang elemen dari linked list
        void remove(Type element);
        //Mengembalikan elemen pada indeks
        Type get(int indeks);
        //mengembalikan ukuran dari linkedlist
        int getSize();
        //mencetak isi linkedlist
        void print();
};

#endif
