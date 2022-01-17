package factoryPNJ;

import main.IHM;

class Boss extends PNJ {
    public Boss() {
        this(150, 15, 1.5);
    }

    private Boss(int pv, int degats, double resistance) {
        super(pv, degats, resistance);
    }

    @Override
    public String toString() {
        return "Boss";
    }
}