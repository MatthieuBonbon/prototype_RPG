package abstractFactoryObjets;

import factoryPersonnage.Personnage;

class ArmureFeu implements ArmureAbstraite {
    @Override
    public void equiperArmure(Personnage personnage) {
        personnage.setForce(personnage.getForce()*1.5);
        System.out.println("Armure de feu équipée !");
    }

    @Override
    public void retirerArmure(Personnage personnage) {
        personnage.setForce(personnage.getForce()/1.5);
        System.out.println("Armure de feu retirée !");
    }
}
