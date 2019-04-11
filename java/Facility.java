class Facility extends Cell{
    int wellx = 14;
    int welly = 11;
    int MixerX = 14;
    int MixerY = 13;
    int TruckX = 14;
    int TruckY = 14;

    /*Constructor untuk facility*/
    public Facility() {
        super.setElement(getWellX(), getWellY(), 'W');
        super.setElement(getMixerX(), getMixerY(), 'M');
        super.setElement(getTruckX(), getTruckY(), 'T');
    }

    public Facility(Cell c) {
        c.setElement(getWellX(), getWellY(), 'W');
        c.setElement(getMixerX(), getMixerY(), 'M');
        c.setElement(getTruckX(), getTruckY(), 'T');
    }
    /*Mengembalikan letak x dari Well*/
    public int getWellX() {
        return wellx;
    }

    /*Mengembalikan letak y dari Well*/
    public int getWellY() {
        return welly;
    }

    /*Mengembalikan letak x dari Well*/
    public int getMixerX() {
        return MixerX;
    }

    /*Mengembalikan letak y dari Mixer*/
    public int getMixerY() {
        return MixerY;
    }

    /*Mengembalikan letak x dari Mixer*/
    public int getTruckX() {
        return TruckX;
    }

    /*Mengembalikan letak y dari Well*/
    public int getTruckY() {
        return TruckY;
    }

}