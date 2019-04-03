#include <iostream>
#include "LinkedList.cpp"

using namespace std;

int main(){
    LinkedList<char> x;
    x.print();

    cout << x.getSize() << endl;
    
    cout << x.get(3) << endl;

    if(x.get(3)==0){
        cout << "A" << endl;
    }
    
    return 0;
}