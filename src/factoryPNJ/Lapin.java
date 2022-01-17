package factoryPNJ;

import main.IHM;

class Lapin extends PNJ {
    public Lapin() { this(30, 5, 1.0); }

    private Lapin(int pv, int degats, double resistance) {
        super(pv, degats, resistance);
    }

    @Override
    public String toString() {
        return "Lapin";
    }
}