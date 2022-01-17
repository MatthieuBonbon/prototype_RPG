package abstractFactoryObjets;

import factoryPersonnage.Personnage;

public interface ChaussureAbstraite {
    void equiperChaussures(Personnage personnage);
    void retirerChaussures(Personnage personnage);
}
