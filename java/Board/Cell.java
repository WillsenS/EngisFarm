class Cell{
    /*ukuran map dalam x dan y*/
    int sizex; 
    int sizey; 

    /*Matriks Map*/
    char[][][] map;

    /*Constructor untuk map (cell)*/
    public Cell(){
        sizex = 15;
        sizey = 15;
        map = new char[sizex][sizey][3];
        for(int i = 0; i <sizex; i++) {
            for(int j = 0; j < sizey; j++) {
                    map[i][j][0] = '-';
                    map[i][j][1] = '#';
                    map[i][j][2] = ' ';
            }
        }
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                map[i][j][0] = 'o';
                map[i][j][1] = '*';
                map[i][j][2] = ' ';
            }
        }
        for(int i = 6; i < 11; i++) {
            for(int j = 0; j < 7; j++) {
                map[i][j][0] = 'x';
                map[i][j][1] = '@';
                map[i][j][2] = ' ';
            }
        }
    }
    /*Mengubah nilai sizex menjadi _x*/
    public void setSizeX(int _x) {
        sizex = _x;
    }
    /*Mengubah nilai sizey menjadi _y*/
    public void setSizeY(int _y) {
        sizey = _y;
    }
    /*Mengembalikan sizex map*/
    public int getSizeX() {
        return sizex;
    }
    /*Mengembalikan sizex map*/
    public int getSizeY() {
        return sizey;
    }
    /*Mengembalikan value dari matriks map*/
    public char getElement(int x, int y) {
        return map[x][y][2];
    }
    /*Mengembalikan jenis land sesuai dengan value dari matriks map*/
    public char getTypeLand(int x, int y){
        return map[x][y][0];
    }
    /*Mengecek cell terisi atau tidak*/
    public boolean isEmptyCell(int x, int y) {
        if (this.getElement(x, y) == ' ') {
            return true;
        } else if ((this.getElement(x, y) == 'P') ||
            (this.getElement(x, y) == 'M') ||
            (this.getElement(x, y) == 'W') ||
            (this.getElement(x, y) == 'T')){
            return false;
        } else {
            return false;
        }
    }

    /*Menentukan nilai value dari cell pada matriks*/
    public void setElement(int x, int y, char e) {
        map[x][y][2] = e;
    }

    /*
    *Menentukan petak rumput sesuai dengan land
    */
    public void setRumput(int x, int y){
        if(map[x][y][0] == '-'){
            map[x][y][1] = '#';
        }else if(map[x][y][0] == 'o'){
            map[x][y][1] = '*';
        }else{
            map[x][y][1] = '@';
        }
    }

    public void kosongRumput(int x,int y){
        map[x][y][1] = ' ';
    }

    /*Mengembalikan nilai ada rumput atau tidak*/
    public char getRumput(int x, int y){
        return map[x][y][1];
    }

}