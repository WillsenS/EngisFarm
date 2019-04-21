import java.util.*;
/**
 * Player Class
 */
class Player implements LivingThings {
    /** Player X position. */
    int posX;
    /** Player Y position. */
    int posY;
    /** How much water the player carry. */
    int water;
    /** How much money the player own. */
    int money;
    /** Player inventory. */
    Vector<String> inventory;

    /**
     * Player ctor
     *
     * @param x THe initial x position of Player.
     * @param y The initial y position of player.
     * @param c The cell the player refer to.
     */
    public Player(int x, int y, Cell c) {
        posX = x;
        posY = y;
        water = 0;
        money = 0;
        c.setElement(posX, posY, 'P');
        inventory = new Vector<String>();
    }

    /**
     * Talk to Player.
     */
    public void talk() {
        System.out.println("Player : Halo");
        System.out.println("Player now in " + posX + ", " + posY);
    }

    /**
     * print all Player info.
     */
    public void print() {
        System.out.println("Player Info");
        System.out.println("Position : " + posX + ", " + posY);
        System.out.println("Water : " + water);
        System.out.println("Money : " + money);
        System.out.print("Inventory : ");
        // print isi inventory
        System.out.println(inventory);
    }

    /**
     * X position getter.
     *
     * @return int The X position of Player.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Y position getter.
     *
     * @return int The Y position of Player.
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Money getter.
     *
     * @return int The Player's money.
     */
    public int getMoney() {
        return money;
    }
    
    /**
     * Water getter.
     *
     * @return int The Player's water.
     */
    public int getWater() {
        return water;
    }

    /**
     * Move the player.
     *
     * @param _c The cell the player refer to.
     */
    public void move(Cell _c) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Select Move : ");
        char cc = sc.next().charAt(0); 
        switch (cc) {
            case 'w' :  
                if(posX-1>=0 && posX-1<15 && posY>=0 && posY<15) {
                    if(_c.getElement(posX-1, posY)==' ') {
                        _c.setElement(posX, posY, ' ');
                        posX-=1;
                        _c.setElement(posX, posY, 'P');
                    } else{
                        System.out.println("Ada Sesuatu");
                    }
                }
                break;
            case 'a' :
                if(posX>=0 && posX<15 && posY-1>=0 && posY-1<15) { 
                    if(_c.getElement(posX, posY-1)==' ') { 
                        _c.setElement(posX, posY, ' ');
                        posY-=1;
                        _c.setElement(posX, posY, 'P');
                    } else{
                        System.out.println("Ada Sesuatu");
                    }
                }
                break;
            case 's' :  
                if(posX+1>=0 && posX+1<15 && posY>=0 && posY<15) {
                    if(_c.getElement(posX+1, posY)==' ') {
                        _c.setElement(posX, posY, ' ');
                        posX+=1;
                        _c.setElement(posX, posY, 'P');
                    } else{
                        System.out.println("Ada Sesuatu");
                    }
                }
                break;
            case 'd' :  
                if(posX>=0 && posX<15 && posY+1>=0 && posY+1<15) {
                    if(_c.getElement(posX, posY+1)==' ') {
                        _c.setElement(posX, posY, ' ');
                        posY+=1;
                        _c.setElement(posX, posY, 'P');
                    } else{
                        System.out.println("Ada Sesuatu");
                    }
                }
                break;
            default:
            System.out.println("Invalid command");
        }
    }

    /**
     * Get interaction type done by player.
     *
     * @param _f Facility in board.
     * @param side The side which player interact with.
     * @return Interaction Type, 1 for animal interaction
     *                           0 for facility interaction
     */
    public int getInteractType(Facility _f, int side) {
        if (isAdjacent(_f.getWellX(), _f.getWellY(), side) ||
            isAdjacent(_f.getMixerX(), _f.getMixerY(), side) ||
            isAdjacent(_f.getTruckX(), _f.getTruckY(), side)) {
            return 0;
        }
        return 1;
    }

    /**
     * Check whether a side player choosen is adjacent to something.
     *
     * @param x X position of the object.
     * @param y Y position of the object.
     * @param side The side which player choose.
     * @return True if object is on the side the player choose,
     *         False otherwise
     */
    public boolean isAdjacent(int x, int y, int side) {
        boolean retval = false;
        switch (side) {
            case 1: {
                retval = ((posX - 1) == x && posY == y);    
                break;
            }
    
            case 2: {
                retval = ((posX + 1) == x && posY == y);
                break;
            }
    
            case 3: {
                retval = ((posY - 1) == y && posX == x);
                break;
            }
    
            case 4: {
                retval = ((posY + 1) == y && posX == x);
                break;
            }
        }
        return retval;
    }

    /**
     * Player interaction with an object.
     *
     * @param _f Facility on Board.
     * @param _c The cell thhe Player refer to.
     * @param animals List of animals on Board.
     */
    public void interact(Facility _f, Cell _c, Vector<FarmAnimal> animals) {
        System.out.println("Select Side to Interact");
        System.out.println("1. Atas    2. Bawah");
        System.out.println("3. Kiri    4. Kanan");
        Scanner sc = new Scanner(System.in);
        System.out.print("Select Move : ");
        int cc = sc.nextInt(); 
    
        int interactType = this.getInteractType(_f, cc);
        if (interactType == 0) {
            this.interactFacility(_f, cc);
        } else {
            this.interactAnimal(_c, cc, animals);
        }
    }

    /**
     * Interact with animal.
     *
     * @param _c The cell the Player refer to.
     * @param side The side Player interact with.
     * @param animals List of animals on Board.
     */
    public void interactAnimal(Cell _c, int side, Vector<FarmAnimal> animals) {
         switch (side) {
            case 1: {
                cekAnimal(_c, posX - 1, posY, animals);
                break;
            }
    
            case 2: {
                cekAnimal(_c, posX + 1, posY, animals);
                break;
            }
    
            case 3: {
                cekAnimal(_c, posX, posY - 1, animals);
                break;
            }
    
            case 4: {
                cekAnimal(_c, posX, posY + 1, animals);
                break;
            }
        }
    }

    /**
     * Check animal the player interact with. If there is an animal,
     * the Player get the animal product. Otherwise, the player got nothing.
     *
     * @param _c The cell the Player refer to.
     * @param x The X position of the cell Player interact with.
     * @param y The Y position of the cell Player interact with.
     * @param animals The list of animals on Board.
     */
    public void cekAnimal(Cell _c, int x, int y, Vector<FarmAnimal> animals) {
        if(_c.getElement(x,y) == 'A') {
            for(int i=0; i<animals.size(); i++) {
                if(animals.get(i).getPosX() == x && animals.get(i).getPosY() == y && animals.get(i).getCountProduct()>0) {
                    System.out.println("ayam " + animals.get(i).getCountProduct());
                    animals.get(i).getProduct();
                    inventory.add("ChickenEgg");
                }
            }
         }
         // bebek(B)
         else if(_c.getElement(x,y) == 'B') {
            for(int i=0; i<animals.size(); i++) {
                if(animals.get(i).getPosX() == x && animals.get(i).getPosY() == y && animals.get(i).getCountProduct()>0) {
                    System.out.println("bebek " + animals.get(i).getCountProduct());
                    animals.get(i).getProduct();
                    inventory.add("DuckEgg");
                }
            }
         } 
         // kambing(G)
         else if(_c.getElement(x,y) == 'D') {
            for(int i=0; i<animals.size(); i++) {
                if(animals.get(i).getPosX() == x && animals.get(i).getPosY() == y && animals.get(i).getCountProduct()>0) {
                    animals.get(i).getProduct();
                    inventory.add("GoatMilk");
                }
            }
         }
         // Sapi(C)
         else if(_c.getElement(x,y) == 'S') {
            for(int i=0; i<animals.size(); i++) {
                if(animals.get(i).getPosX() == x && animals.get(i).getPosY() == y && animals.get(i).getCountProduct()>0) {
                    animals.get(i).getProduct();
                    inventory.add("CowMilk");
                }
            }
         } else{
            System.out.println("Kosong");
         }   
    }

    /**
     * Inceract with facility.
     *
     * @param _f The Facility on Board.
     * @param side The side the player interact with.
     */
    public void interactFacility(Facility _f, int side) {
        if (isAdjacent(_f.getWellX(), _f.getWellY(), side)) {
            water = 10;
        } else if (isAdjacent(_f.getMixerX(), _f.getMixerY(), side)) {
            System.out.print("Bahan yang ingin dibuat : ");
            Scanner sc = new Scanner(System. in);
            String Bahan = sc. nextLine();
            if (Bahan.equals("Omelette")) {
                int Bahan1 = inventory.indexOf("ChickenEgg");
                if (Bahan1 == -1) {
                    System.out.println("Gaada ChickenEgg");
                }
                else {
                    int Bahan2 = inventory.indexOf("DuckEgg");
                    if (Bahan2 == -1) {
                        System.out.println("Gaada DuckEgg");
                    }
                    else {
                        Omelette a = new Omelette(1);
                        inventory.add("Omelette");
                        inventory.remove("ChickenEgg");
                        inventory.remove("DuckEgg");
                    }
                }
            }
            else if (Bahan.equals("Barbeque")) {
                int Bahan1 = inventory.indexOf("Pork");
                if (Bahan1 == -1) {
                    System.out.println("Gaada Pork");
                }
                else {
                    int Bahan2 = inventory.indexOf("LambMeat");
                    if (Bahan2 == -1) {
                        System.out.println("Gaada LambMeat");
                    }
                    else {
                        Barbeque a = new Barbeque(1);
                        inventory.add("Barbeque");
                        inventory.remove("Pork");
                        inventory.remove("LambMeat");
                    }
                }
            }
            else if (Bahan.equals("Sausage")) {
                int Bahan1 = inventory.indexOf("CowMeat");
                if (Bahan1 == -1) {
                    System.out.println("Gaada CowMeat");
                }
                else {
                    int Bahan2 = inventory.indexOf("GoatMeat");
                    if (Bahan2 == -1) {
                        System.out.println("Gaada GoatMeat");
                    }
                    else {
                        Sausage a = new Sausage(1);
                        inventory.add("Sausage");
                        inventory.remove("CowMeat");
                        inventory.remove("GoatMeat");
                    }
                }
            }
            else {
                System.out.println("Gaada SideProduct yang itu");
            }
        } else if (isAdjacent(_f.getTruckX(), _f.getTruckY(), side)) {
            if(inventory.isEmpty()) {
                System.out.println("Inventory Kosong");
            } else{
                String isi;
                while(!inventory.isEmpty()) {
                    isi = inventory.get(0);
                    inventory.remove(isi);
                    if ( isi.toString().equals("ChickenMeat")) {
                        money += 4;
                    } else if(isi.toString().equals("ChickenEgg")) {
                        money += 3;
                    } else if(isi.toString().equals("DuckMeat")) {
                        money += 5;
                    } else if(isi.toString().equals("DuckEgg")) {
                        money += 4;
                    } else if(isi.toString().equals("CowMeat")) {
                        money += 6;
                    } else if(isi.toString().equals("CowMilk")) {
                        money += 4;
                    } else if(isi.toString().equals("GoatMeat")) {
                        money += 5;
                    } else if(isi.toString().equals("GoatMilk")) {
                        money += 3;
                    } else if(isi.toString().equals("LambMeat")) {
                        money += 5;
                    } else if(isi.toString().equals("Omelette")) {
                        money += 3;
                    } else if(isi.toString().equals("Pork")) {
                        money += 5;
                    } else if(isi.toString().equals("Sausage")) {
                        money += 5;
                    } else if(isi.toString().equals("Barbeque")) {
                        money += 5;
                    }
                }
                System.out.println("Truck Succes");
            }
        }
    }

    /**
     * Kill animal.
     *
     * @param _c The Cell the Player refer to.
     * @param animals The list of animals on Board.
     */
    public void Kill(Cell _c, Vector<FarmAnimal> animals) {
            System.out.println("Select Side to Kill");
            System.out.println("1. Atas    2. Bawah");
            System.out.println("3. Kiri    4. Kanan");
            Scanner sc = new Scanner(System.in);
            int cc = sc.nextInt(); 
           switch(cc) {
               case 1 :
               {
                   cekHewan(posX-1, posY, _c);
    
                   for(int i=0; i<animals.size(); i++) {
                       if(animals.get(i).getPosX() == this.posX-1 && animals.get(i).getPosY() == this.posY) {
                           animals.get(i).setStatus(false);
                       }
                   }
                   break;
               }
               case 2 :
               {
                   cekHewan(posX+1, posY, _c);
    
                   for(int i=0; i<animals.size(); i++) {
                       if(animals.get(i).getPosX() == this.posX+1 && animals.get(i).getPosY() == this.posY) {
                           animals.get(i).setStatus(false);
                       }
                   }
                   break;
               }
               case 3 :
               {   
                   cekHewan(posX, posY-1, _c);
    
                   for(int i=0; i<animals.size(); i++) {
                       if(animals.get(i).getPosX() == this.posX-1 && animals.get(i).getPosY() == this.posY-1) {
                           animals.get(i).setStatus(false);
                       }
                   }
                   break;
               }
               case 4 :
               {
                   cekHewan(posX, posY+1, _c);
    
                   for(int i=0; i<animals.size(); i++) {
                       if(animals.get(i).getPosX() == this.posX && animals.get(i).getPosY() == this.posY+1) {
                           animals.get(i).setStatus(false);
                       }
                   }
                   break;
               }
               default :{
                System.out.println("Command Salah");
               }   
           }
            
       }

       /**
        * Check animal the player want to kill. If there is an animal,
        * the Player get the animal product. Otherwise, the player got nothing.
        *
        * @param x The X position of the cell Player interact with.
        * @param y The Y position of the cell Player interact with.
        * @param _c The cell the Player refer to.
        */
       public void cekHewan(int x, int y, Cell _c) {
           // ayam(A)
            if(_c.getElement(x,y) == 'A') {
                ChickenMeat a = new ChickenMeat();
                inventory.add("ChickenMeat");
                _c.setElement(x, y, ' ');
            }
            // bebek(B)
            else if(_c.getElement(x,y) == 'B') {
                DuckMeat b = new DuckMeat();
                inventory.add("DuckMeat");
                _c.setElement(x, y, ' ');
            } 
            // babi(b)
            else if(_c.getElement(x,y) == 'Z') {
                Pork c = new Pork();
                inventory.add("Pork");
                _c.setElement(x, y, ' ');
            } 
            // domba(D)
            else if(_c.getElement(x,y) == 'K') {
                LambMeat d = new LambMeat();
                inventory.add("LambMeat");
                _c.setElement(x, y, ' ');
            }
            // kambing(G)
            else if(_c.getElement(x,y) == 'D') {
                GoatMeat e = new GoatMeat();
                inventory.add("GoatMeat");
                _c.setElement(x, y, ' ');
            }
            // Sapi(C)
            else if(_c.getElement(x,y) == 'S') {
                CowMeat f = new CowMeat();
                inventory.add("CowMeat");
                _c.setElement(x, y, ' ');
            } else{
                System.out.println("Kosong");
            }   
            this.print();
       }

       /**
        * Grow grass on current position.
        *
        * @param _c The Cell the Player refer to.
        */
       public void grow(Cell _c) {
           if (water > 0) {
               // Mengisi petak cell dengan notasi rumput
               if(_c.getRumput(posX, posY) == ' ') {
                   _c.setRumput(posX, posY);
                   water-=1;
               }
               else {
                   // udah ada rumput, jadi do nothing/pesen error
                   System.out.println("Can't grow anymore!"); 
               }
           }
           else {
               // gaada air, sana pergi ke well
               System.out.println("insufficient water!");
           }
           this.print();
       }

}