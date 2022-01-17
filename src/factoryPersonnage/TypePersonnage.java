package factoryPersonnage;

import main.IHM;

public class TypePersonnage implements FabriquePersonnage {
    public enum TYPE{BARBARE,SORCIER,ASSASSIN} ;

    @Override
    public Personnage CreerPersonnage(String nom, TYPE type, IHM ihm) {
        Personnage p;

        if(type == TYPE.ASSASSIN){
            p = new Assassin(nom, ihm);
        }
        else if(type == TYPE.BARBARE){
            p = new Barbare(nom, ihm);
        }
        else { // c'est-à-dire si c'est un Sorcier
            p = new Sorcier(nom, ihm);
        }

        return p;
    }



}
