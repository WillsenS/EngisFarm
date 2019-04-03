#include "../include/Renderable.h"
 
void Renderable::render(){
    for(int i=0; i<Cell::getSizex(); i++){
        for(int j=0l; j<Cell::getSizey(); j++){
            if(Cell::getElement(i,j) != ' '){
                cout << Cell::getElement(i,j);
            }else if(Cell::getRumput(i,j) != ' '){
                cout << Cell::getRumput(i,j);
            }else{
                cout << Cell::getTypeLand(i,j);
            }
        }
        cout << endl;
    }
}