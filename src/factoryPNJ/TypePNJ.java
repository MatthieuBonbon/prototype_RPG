package factoryPNJ;

import main.IHM;

public class TypePNJ implements FabriquePNJ {
    public enum TYPE{LAPIN,ZOMBIE,BOSS} ;

    @Override
    public PNJ CreerPNJ(TYPE type) {
        PNJ p;

        if(type == TYPE.LAPIN){
            p = new Lapin();
        }
        else if(type == TYPE.ZOMBIE){
            p = new Zombie();
        }
        else { // c'est-à-dire si c'est un Boss
            p = new Boss();
        }

        return p;
    }

}
