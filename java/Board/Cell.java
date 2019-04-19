/**
 * Cell Class.
 */
class Cell {
    /** The X size of Board */
    int sizex; 
    /** The Y size of Board */
    int sizey; 

    /** Map Matrix */
    char[][][] map;

    /**
     * Ctor
     */
    public Cell() {
        sizex = 15;
        sizey = 15;
        map = new char[sizex][sizey][3];
        for (int i = 0; i <sizex; i++) {
            for (int j = 0; j < sizey; j++) {
                    map[i][j][0] = '-';
                    map[i][j][1] = '#';
                    map[i][j][2] = ' ';
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j][0] = 'o';
                map[i][j][1] = '*';
                map[i][j][2] = ' ';
            }
        }
        for (int i = 6; i < 11; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j][0] = 'x';
                map[i][j][1] = '@';
                map[i][j][2] = ' ';
            }
        }
    }

    /**
     * Change the value of X size.
     *
     * @param _x The new X size.
     */
    public void setSizeX(int _x) {
        sizex = _x;
    }

    /**
     * Change the value of Y size.
     *
     * @param _y The new Y size.
     */
    public void setSizeY(int _y) {
        sizey = _y;
    }

    /**
     * X size getter.
     *
     * @return int The X size.
     */
    public int getSizeX() {
        return sizex;
    }

    /**
     * Y size getter.
     *
     * @return int The Y size.
     */
    public int getSizeY() {
        return sizey;
    }

    /**
     * Map matrix value getter.
     *
     * @param x The x position.
     * @param y The y position.
     * @return int The map matrix value.
     */
    public char getElement(int x, int y) {
        return map[x][y][2];
    }

    /**
     * Map matrix land type getter.
     *
     * @param x The x position.
     * @param y The y position.
     * @return int The map matrix land type.
     */
    public char getTypeLand(int x, int y) {
        return map[x][y][0];
    }

    /**
     * Check whether the cell is empty or not.
     *
     * @param x The x position.
     * @param y The y position.
     * @return bool True if filled, otherwise False.
     */
    public boolean isEmptyCell(int x, int y) {
        if (this.getElement(x, y) == ' ') {
            return true;
        } else if ((this.getElement(x, y) == 'P') ||
            (this.getElement(x, y) == 'M') ||
            (this.getElement(x, y) == 'W') ||
            (this.getElement(x, y) == 'T')) {
            return false;
        } else {
            return false;
        }
    }

    /**
     * Map matrix value setter.
     *
     * @param x The x position.
     * @param y The y position.
     * @param e The value to be inserted.
     */
    public void setElement(int x, int y, char e) {
        map[x][y][2] = e;
    }

    /**
     * Map matrix grass setter according to land type.
     *
     * @param x The x position.
     * @param y The y position.
     */
    public void setRumput(int x, int y) {
        if(map[x][y][0] == '-') {
            map[x][y][1] = '#';
        } else if(map[x][y][0] == 'o') {
            map[x][y][1] = '*';
        } else{
            map[x][y][1] = '@';
        }
    }

    /**
     * Map matrix empty grass setter.
     *
     * @param x The x position.
     * @param y The y position.
     */
    public void kosongRumput(int x,int y) {
        map[x][y][1] = ' ';
    }

    /**
     * Check whether there is grass.
     *
     * @param x The x position.
     * @param y The y position.
     * @return bool True if exist grass on position, otherwise False..
     */
    public char getRumput(int x, int y) {
        return map[x][y][1];
    }
}