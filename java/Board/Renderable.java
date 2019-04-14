class Renderable extends Cell{
    public void render(){
        for(int i=0; i<super.getSizeX(); i++){
            System.out.print("_");
            for(int j=0; j<super.getSizeY(); j++) {
                System.out.print("__");
            }
            System.out.println(); 
            System.out.print("|");
            for(int j=0; j<super.getSizeY(); j++){
                if (super.getElement(i,j) != ' '){
                    System.out.print(super.getElement(i,j) + "|");
                } else if (super.getRumput(i,j) != ' '){
                    System.out.print(super.getRumput(i,j) + "|");
                } else {
                    System.out.print(super.getTypeLand(i,j) + "|");
                }
            }
            System.out.println();
        }
    }
}