package factoryPersonnage;

import main.IHM;

public interface FabriquePersonnage {
 Personnage CreerPersonnage(String nom, TypePersonnage.TYPE type, IHM ihm) ;

}
