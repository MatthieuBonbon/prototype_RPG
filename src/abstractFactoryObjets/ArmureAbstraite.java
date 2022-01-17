package abstractFactoryObjets;

import factoryPersonnage.Personnage;

public interface ArmureAbstraite {
    void equiperArmure(Personnage personnage);

    void retirerArmure(Personnage personnage);
}
