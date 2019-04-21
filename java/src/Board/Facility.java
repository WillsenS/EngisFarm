/**
 * Facility Class.
 */
class Facility extends Cell {
    /** Well X position */
    int wellx = 14;
    /** Well Y position */
    int welly = 11;
    /** Mixer X position */
    int MixerX = 14;
    /** Mixer Y position */
    int MixerY = 13;
    /** Truck X position */
    int TruckX = 14;
    /** Truck Y position */
    int TruckY = 14;

    /**
     * Ctor.
     */
    public Facility() {
        super.setElement(getWellX(), getWellY(), 'W');
        super.setElement(getMixerX(), getMixerY(), 'M');
        super.setElement(getTruckX(), getTruckY(), 'T');
    }

    /**
     * Ctor with param.
     *
     * @param c The Cell the Facility refer to.
     */
    public Facility(Cell c) {
        c.setElement(getWellX(), getWellY(), 'W');
        c.setElement(getMixerX(), getMixerY(), 'M');
        c.setElement(getTruckX(), getTruckY(), 'T');
    }

    /**
     * Return the X position of the Well.
     *
     * @return int Well X position
     */
    public int getWellX() {
        return wellx;
    }

    /**
     * Return the Y position of the Well.
     *
     * @return int Well Y position
     */
    public int getWellY() {
        return welly;
    }

    /**
     * Return the X position of the Mixer.
     *
     * @return int Mixer X position
     */
    public int getMixerX() {
        return MixerX;
    }

    /**
     * Return the Y position of the Mixer.
     *
     * @return int Mixer Y position
     */
    public int getMixerY() {
        return MixerY;
    }

    /**
     * Return the X position of the Truck.
     *
     * @return int Truck X position
     */
    public int getTruckX() {
        return TruckX;
    }

    /**
     * Return the Y position of the Truck.
     *
     * @return int Truck Y position
     */
    public int getTruckY() {
        return TruckY;
    }
}