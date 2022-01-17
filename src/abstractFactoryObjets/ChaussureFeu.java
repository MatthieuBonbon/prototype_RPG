package abstractFactoryObjets;

import factoryPersonnage.Personnage;

class ChaussureFeu implements ChaussureAbstraite {
    @Override
    public void equiperChaussures(Personnage personnage) {
        personnage.setForce(personnage.getForce()*1.2);
        System.out.println("Chaussures de feu équipées !");
    }

    @Override
    public void retirerChaussures(Personnage personnage) {
        personnage.setForce(personnage.getForce()/1.2);
        System.out.println("Chaussures de feu rétirées !");
    }
}
