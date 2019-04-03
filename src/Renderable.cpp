#include "Renderable.h"
 
void Renderable::render(){
    for(int i=0; i<Cell::getSizex(); i++){
        for(int j=0l; j<Cell::getSizey(); j++){
            cout << Cell::getElement(i,j);
        }
        cout << endl;
    }
}