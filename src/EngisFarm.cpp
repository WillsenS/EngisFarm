#include <iostream>
#include <iomanip>
#include <string>

#include "ayam.h"
#include "bebek.h"
#include "kambing.h"
#include "babi.h"
#include "domba.h"
#include "sapi.h"
#include "LivingThings.h"
#include "Eggproducing.h"
#include "Milkproducing.h"
#include "Meatproducing.h"
#include "FarmAnimal.h"
#include "Cell.h"
#include "Renderable.h"

using namespace std;

typedef enum {
    Interact,
    Move,
    Kill,
    Grow,
    Mix,
    Exit
} commands;

void printCommandList() {
    cout << endl << "Command List" << endl << endl;
    cout << "0: Interact" << setw(20) << setiosflags(ios::right) << "3: Grow" << endl;
    cout << "1: Move" << setw(23) << setiosflags(ios::right) << "4: Mix" << endl;
    cout << "2: Kill" << setw(24) << setiosflags(ios::right) << "5: Exit" << endl;
}

int main(){

    bool isRunning = true;
    int command;

    Renderable r;

    while (isRunning) {
        r.render();
        printCommandList();
        
        cout << endl << "Enter you Command: ";
        cin >> command;
        
        switch (command) {
            case Interact:
                cout << "Interact" << endl;
                break;

            case Move:
                cout << "Move" << endl;
                break;

            case Kill:
                cout << "Kill" << endl;
                break;

            case Grow:
                cout << "Grow" << endl;
                break;

            case Mix:
                cout << "Mix" << endl;
                break;

            case Exit:
                cout << "Exit" << endl;
                isRunning = false;
                break;

         default:
            cout << "Invalid command" << endl;
       }
    }
    // cout << command << endl;

    return 0;
}
