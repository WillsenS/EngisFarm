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
#include "Facility.h"
#include "Cell.h"
#include "Renderable.h"
#include "Player.h"

using namespace std;

/*
 * Enum used to switch case the command as cpp does not allow
 * switch case-ing a string.
 */
typedef enum {
    Interact,
    Move,
    Kill,
    Grow,
    Mix,
    Exit
} commands;

/*
 * Print all the commands available in the game.
 */
void printCommandList() {
    cout << endl << "Command List" << endl << endl;
    cout << "0: Interact" << setw(20) << setiosflags(ios::right) << "3: Grow" << endl;
    cout << "1: Move" << setw(23) << setiosflags(ios::right) << "4: Mix" << endl;
    cout << "2: Kill" << setw(24) << setiosflags(ios::right) << "5: Exit" << endl;
}

/*
 * Set all the facilities inside Cells.
 */
void setFacilities(Renderable &_r, Facility &_f) {
    _r.setElement(_f.getWellx(), _f.getWelly(), 'W');
    _r.setElement(_f.getMixerx(), _f.getMixery(), 'M');
    _r.setElement(_f.getTruckx(), _f.getTrucky(), 'T');

}

int main(){

    bool isRunning = true;
    int command;

    Renderable r;
    Facility f;

    setFacilities(r, f);

    // Initialized Player here
    Player p = Player(13, 11,r);
    // r.setElement(p.getPosX(), p.getPosY(), 'P');


    // Initialized Animals here

    while (isRunning) {
        r.render();
        printCommandList();

        cout << endl << "Enter you Command: ";
        cin >> command;

        if (cin.fail()) {
            cout << "Invalid command" << endl;
            cin.clear();
            cin.ignore(10000, '\n');
            continue;
        }

        switch (command) {
            case Interact:
                cout << "Interact" << endl;

                // look for adjacent cells

                // show list of adjacent objects

                // choose which object to interact

                p.interact(f);
                p.print();

                break;

            case Move:
                cout << "Move" << endl;

                p.move(r);
                // show list of available cells to move into

                // choose which direction to move

                break;

            case Kill:
                cout << "Kill" << endl;

                // show list of available objects to kill in adjacent cells.

                // choose which object to kill
                break;

            case Grow:
                cout << "Grow" << endl;
                p.Grow(r);
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
        // run the game tick
    }

    return 0;
}
