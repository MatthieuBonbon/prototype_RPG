package inventaire;

import abstractFactoryObjets.PotionAbstraite;
import factoryPersonnage.Personnage;

class Potion implements Composant{

    private PotionAbstraite potionAbstraite;
    private String typePotion;

    public Potion(PotionAbstraite potionAbstraite, String typePotion) {
        this.potionAbstraite = potionAbstraite;
        this.typePotion = typePotion;
    }

    @Override
    public void afficherInventaire() {
        System.out.print("| Potion de " + typePotion);
    }

    @Override
    public void UtiliserObjet(Personnage perso) {
        potionAbstraite.utiliserPotion(perso);
    }


    public String getTypePotion() {
        return typePotion;
    }
}
