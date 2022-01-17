package inventaire;

import abstractFactoryObjets.ArmeAbstraite;
import factoryPersonnage.Personnage;

class Arme implements Composant{

    private ArmeAbstraite armeAbstraite;
    private String typeArme;

    public Arme(ArmeAbstraite armeAbstraite, String typeArme) {
        this.armeAbstraite = armeAbstraite;
        this.typeArme = typeArme;
    }

    @Override
    public void afficherInventaire() {
        System.out.print("| Arme de " + typeArme);
    }

    @Override
    public void UtiliserObjet(Personnage perso) {
    }

    public String getTypeArme() {
        return typeArme;
    }

}
