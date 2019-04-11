class Land extends Cell{
    /* Constructor untuk map (land) */
    public Land() {
        super();
        System.out.println("Land Dibuat");
    }

    /*Mengembalikan jenis land sesuai dengan value dari matriks map*/
    public String getProperties(char value) {
        if (value=='-') {
            return "Grassland";
        } else if (value == 'x') {
            return "Barn";
        } else if (value == 'o') {
            return "Coop";
        } else if (value == 'W') {
            return "Well";
        } else if (value == 'M') {
            return "Mixer";
        } else if (value == 'T') {
            return "Truck";
        }else{
            return "value salah";
        }
    }

}