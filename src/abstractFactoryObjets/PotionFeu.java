package abstractFactoryObjets;

import factoryPersonnage.Personnage;

class PotionFeu implements PotionAbstraite {
    @Override
    public void utiliserPotion(Personnage personnage) {
        personnage.setPv(personnage.getPv()+15);
        System.out.println("Potion de feu utilisée !");

    }
}
