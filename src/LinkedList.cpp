#include <iostream>
#include "../include/LinkedList.h"

using namespace std;

template<class Type>
LinkedList<Type>::LinkedList(){
        first = NULL; 
        size = 0;
}

// template<class Type>
// LinkedList<Type>::LinkedList(Type element){
//         node<Type>* p;
//         p.add(element);
//         this->first = p->first;
//         size = 1;
//         cout<<"create"<<endl;
// }

// template<class Type>
// Type& LinkedList<Type>::operator=(const Type p){
//     this->first = p->first;
//     return *this;
// }

template<class Type>
int LinkedList<Type>::find(Type element){
    node<Type>* p = this->first;
    int index = 0;

    while(p != NULL){
        if(p->data == element){
            return index;
        }
        p = p->next;
        index++;
    }
    return -1; //element tidak ada di list
}

template<class Type>
bool LinkedList<Type>::isEmpty(){
    return (size == 0);
}

template<class Type>
void LinkedList<Type>::add(Type element){
    node<Type> *p, *q;
    if(this->first == NULL){
        first = new node<Type>;
        first->data = element;
        first->next = NULL;
        size++;
        cout << "size++" << endl;
        return;
    }else{
        p = first;
        while(p->next != NULL){
            p = p->next;
        }
        q = new node<Type>;
        q->data = element;
        q->next = NULL;
        p->next = q; 
    }
    size++;
    cout << "size++" << endl;
}

template<class Type>
void LinkedList<Type>::remove(Type element){
    node<Type> *p, *q;
    if(first == NULL) return;
    p = first;
    q = NULL;
    while(p){
        if(p->data == element){
            if(!q){
                first = p->next; 
                delete p;
                size--;
                return;
            }else{
                q->next = p->next;
                delete p;
                size--;
                return;
            }
            
        }
        q = p;
        p = p->next;
    }
}

//Membuang elemen pertama
void revomeFirst();

template<class Type>
Type LinkedList<Type>::get(int indeks){
    int i = 0;
    node<Type>* p = this->first;
    while(i<indeks && p!=NULL){
        p = p->next;
        i++;
    }
    if(i == indeks){
        return p->data; 
    }
}

template<class Type>
int LinkedList<Type>::getSize(){
    return this->size;
}

template<class Type>
void LinkedList<Type>::print(){
    cout<<"[";
    node<Type>* p = this->first;
    if(p!=NULL){
        while(p->next!=NULL){
        cout<<p->data<<", ";
        p = p->next;
        }
        cout<<p->data;
    }
    cout<<"]"<<endl;
}


