#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include <ctime>
#include <cstdlib>
#include <algorithm>

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

vector<FarmAnimal*> animals; /*!< Vector for storing animal objects */
Renderable r; /*!< The board */
Facility f; /*!< The board facility */
bool isRunning; /*!< Whether the game is running or not */
int command; /*!< Command inputted by user */

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
    Talk,
    Exit
} commands;

/*
 * Print all the commands available in the game.
 */
void printCommandList() {
    cout << endl << "Command List" << endl << endl;
    cout << "0: Interact" << setw(20) << setiosflags(ios::right) << "3: Grow" << endl;
    cout << "1: Move" << setw(23) << setiosflags(ios::right) << "4: Mix" << endl;
    cout << "2: Kill" << setw(24) << setiosflags(ios::right) << "5: Talk" << setw(24) << setiosflags(ios::right) << "6: Exit"<< endl;
}

/*
 * Print player status.
 */
void printPlayerStatus(Player p) {
    cout << endl << "Player Status" << endl << endl;
    cout << "Money = " << p.getMoney() << endl;
    cout << "Water = " << p.getWater() << endl;
}

/*
 * Create Animal Object according to cell land type.
 */
void createAnimal(int x, int y) {
    char landType = r.getTypeLand(x, y);
    int prob;
    switch (landType) {
        case '-':
            prob = rand() % 2 + 1;
            if (prob == 1) {
                animals.push_back(new kambing(x, y));
                r.setElement(x, y, 'K');
            } else {
                animals.push_back(new sapi(x, y));
                r.setElement(x, y, 'S');
            }
            break;

        case 'o':
            prob = rand() % 2 + 1;
            if (prob == 1) {
                animals.push_back(new ayam(x, y));
                r.setElement(x, y, 'A');
            } else {
                animals.push_back(new bebek(x, y));
                r.setElement(x, y, 'B');
            }
            break;

        case 'x':
            prob = rand() % 5;
            switch (prob) {
                case 0:
                    animals.push_back(new ayam(x, y));
                    r.setElement(x, y, 'A');
                    break;

                case 1:
                    animals.push_back(new bebek(x, y));
                    r.setElement(x, y, 'B');
                    break;

                case 2:
                    animals.push_back(new babi(x, y));
                    r.setElement(x, y, 'Z');
                    break;

                case 3:
                    animals.push_back(new domba(x, y));
                    r.setElement(x, y, 'D');
                    break;

                case 4:
                    animals.push_back(new kambing(x, y));
                    r.setElement(x, y, 'K');
                    break;

                case 5:
                    animals.push_back(new sapi(x, y));
                    r.setElement(x, y, 'S');
                    break;
            }
            break;
    }
}

/*
 * Initialize all animal in the board
 */
void initializeAnimal() {
    srand(static_cast<int>(time(0)));
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
    r.setElement(_f.getWellX(), _f.getWellY(), 'W');
    r.setElement(_f.getMixerX(), _f.getMixerY(), 'M');
    r.setElement(_f.getTruckX(), _f.getTruckY(), 'T');

}
/*
 * Check animal.
 */
void cekAnimal(){

    //bool cek = true;
    // cout<<animals[0]->getStatus()<<endl;
    // for (auto it = animals.begin();it!=animals.end();it++){
    //         cout<<animals[it]->getStatus()<<endl;
    // } 
    // for (int i =0;i<animals.size();i++){
    //     cout<<animals[i]->getStatus()<<endl;
    // } 

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

    // vector<FarmAnimal*>::iterator it;
    // for (it = animals.begin(); it != animals.end(); ++it)
    //     (*it)->getStatus();

    while (isRunning) {
        r.render();
        printCommandList();
        printPlayerStatus(p);
        p.print();

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

                break;
            case Move:
                cout << "Move" << endl;

                p.move(r);
                // show list of available cells to move into

                // choose which direction to move

                break;
            case Kill:
                cout << "Kill" << endl;

                p.Kill(r, animals);
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
            case Talk:
            {
                cout << "Talk" << endl;
                p.talk();
                vector<FarmAnimal*>::iterator it;
                for(it = animals.begin(); it!=animals.end(); ++it){
                    if((*it)->getPosX() == p.getPosX()-1 && (*it)->getPosY() == p.getPosY()){
                        if((*it)->getStatus()==true){
                            (*it)->talk();
                        }
                    }
                    if((*it)->getPosX() == p.getPosX()+1 && (*it)->getPosY() == p.getPosY()){
                        if((*it)->getStatus()==true){
                            (*it)->talk();
                        }
                    }
                    if((*it)->getPosX() == p.getPosX() && (*it)->getPosY() == p.getPosY()+1){
                        if((*it)->getStatus()==true){
                            (*it)->talk();
                        }
                    }
                    if((*it)->getPosX() == p.getPosX() && (*it)->getPosY() == p.getPosY()-1){
                        if((*it)->getStatus()==true){
                            (*it)->talk();
                        }
                    }
                }
                break;
            }
            case Exit:
                cout << "Exit" << endl;
                isRunning = false;
                break;
            default:
                cout << "Invalid command" << endl;
        }
        // run the game tick
        //bool hidup = isRunning;
        //  isRunning = all_of(animals.begin(),animals.end(),[](bool v ){return !v;});
        //cout<<isRunning<<endl;
    }



    return 0;
}
