package inventaire;

import abstractFactoryObjets.ArmureAbstraite;
import factoryPersonnage.Personnage;

class Armure implements Composant{

    private ArmureAbstraite armureAbstraite;
    private String typeArmure;

    public Armure(ArmureAbstraite armureAbstraite, String typeArmure) {
        this.armureAbstraite = armureAbstraite;
        this.typeArmure = typeArmure;
    }

    @Override
    public void afficherInventaire() {
        System.out.print("| Armure de " + typeArmure);
    }

    @Override
    public void UtiliserObjet(Personnage perso) {
        armureAbstraite.equiperArmure(perso);
    }

    public String getTypeArmure() {
        return typeArmure;
    }
}
