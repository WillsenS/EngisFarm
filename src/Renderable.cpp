#include "../include/Renderable.h"
 
void Renderable::render(){
    for(int i=0; i<Cell::getSizex(); i++){
        cout << "_";
        for(int j=0; j<Cell::getSizey(); j++) {
            cout << "__";
        }
        cout << endl << "|";
        for(int j=0; j<Cell::getSizey(); j++){
            if(Cell::getElement(i,j) != ' '){
                cout << Cell::getElement(i,j) << "|";
            }else if(Cell::getRumput(i,j) != ' '){
                cout << Cell::getRumput(i,j) << "|";
            }else{
                cout << Cell::getTypeLand(i,j) << "|";
            }
        }
        cout << endl;
    }
}