package abstractFactoryObjets;

import factoryPersonnage.Personnage;

class ArmureGlace implements ArmureAbstraite {
    @Override
    public void equiperArmure(Personnage personnage) {
        personnage.setResistance(personnage.getResistance()*1.5);
        System.out.println("Armure de glace équipée !");
    }

    @Override
    public void retirerArmure(Personnage personnage) {
        personnage.setResistance(personnage.getResistance()/1.5);
        System.out.println("Armure de glace retirée !");
    }
}
