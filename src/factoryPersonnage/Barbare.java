package factoryPersonnage;

import main.IHM;

class Barbare extends Personnage {
    public Barbare(String nom, IHM ihm) {
        this(nom, 120, 1.0, 3.0, ihm);
    }

    private Barbare(String nom, int pv, double force, double resistance, IHM ihm) {
        super(nom, pv, force, resistance, ihm);
    }
}
