package factoryPNJ;

import main.IHM;

class Zombie extends PNJ {
    public Zombie() { this(60, 10, 1.0); }

    private Zombie(int pv, int degats, double resistance) {
        super(pv, degats, resistance);
    }

    @Override
    public String toString() {
        return "Zombie";
    }
}
