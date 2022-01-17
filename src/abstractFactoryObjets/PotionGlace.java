package abstractFactoryObjets;

import factoryPersonnage.Personnage;

class PotionGlace implements PotionAbstraite {
    @Override
    public void utiliserPotion(Personnage personnage) {
        personnage.setPv(personnage.getPv()+30);
        System.out.println("Potion de glace utilisée !");

    }
}
