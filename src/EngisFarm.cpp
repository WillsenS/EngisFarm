#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include <ctime>
#include <cstdlib>

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

vector<FarmAnimal*> animals;
Renderable r;
Facility f;
bool isRunning;
int command;

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

void createAnimal(int x, int y) {
    char landType = r.getTypeLand(x, y);
    int prob;
    switch (landType) {
        case '-':
            // cout << "Grass" << endl;
            prob = rand() % 1;
            if (prob) {
                animals.push_back(new kambing(x, y));
                r.setElement(x, y, 'K');
            } else {
                animals.push_back(new sapi(x, y));
                r.setElement(x, y, 'S');
            }
            break;

        case 'o':
            // cout << "Coop" << endl;
            prob = rand() % 1;
            if (prob) {
                animals.push_back(new ayam(x, y));
                r.setElement(x, y, 'A');
            } else {
                animals.push_back(new bebek(x, y));
                r.setElement(x, y, 'B');
            }
            break;

        case 'x':
            // cout << "Barn" << endl;
            prob = rand() % 5;
            switch (prob) {
                case 0:
                    animals.push_back(new ayam(x, y));
                    break;

                case 1:
                    animals.push_back(new bebek(x, y));
                    break;

                case 2:
                    animals.push_back(new babi(x, y));
                    break;

                case 3:
                    animals.push_back(new domba(x, y));
                    break;

                case 4:
                    animals.push_back(new kambing(x, y));
                    break;

                case 5:
                    animals.push_back(new sapi(x, y));
                    break;
            }
            break;
    }
}

void initializeAnimal() {
    srand(time(NULL));
    for (int i = 0; i < r.getSizeX(); i++) {
        for (int j = 0; j < r.getSizeY(); j++) {
            int prob = rand() % 10 + 1;
            if (prob > 9 && r.isEmptyCell(i, j)) {
                createAnimal(i , j);
            }
        }
    }
}

void tick() {
}

/*
 * Set all the facilities inside Cells.
 */
void setFacilities(Facility &_f) {
    r.setElement(_f.getWellx(), _f.getWelly(), 'W');
    r.setElement(_f.getMixerx(), _f.getMixery(), 'M');
    r.setElement(_f.getTruckx(), _f.getTrucky(), 'T');

}

int main(){

    isRunning = true;
    
    setFacilities(f);

    // Initialized Player here
    Player p = Player(13, 11, r);
    // r.setElement(p.getPosX(), p.getPosY(), 'P');

    // Initialized Animals here
    initializeAnimal();
    cout << "Size : " << animals.size() << endl; 

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
