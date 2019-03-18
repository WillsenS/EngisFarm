#include <iostream>
#include "LinkedList.cpp"

using namespace std;

int main(){
    LinkedList<int> x;
    x.print();
    if(x.isEmpty()){
        cout << "Kosong" << endl;
    }
    x.add(1);
    cout << x.getSize() << endl;
    x.print();
    x.add(3);
    cout << x.getSize() << endl;
    x.print();
    x.add(7);
    cout << x.getSize() << endl;
    x.print();
    cout << x.find(2) << endl;
    cout << x.find(7) << endl;
    x.print();
    if(x.get(0)==1){
        cout << "get" << endl;
    }
    
    return 0;
}