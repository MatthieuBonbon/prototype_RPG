package inventaire;

import abstractFactoryObjets.ChaussureAbstraite;
import factoryPersonnage.Personnage;

class Chaussures implements Composant{

    private ChaussureAbstraite chaussureAbstraite;
    private String typeChaussures;

    public Chaussures(ChaussureAbstraite chaussureAbstraite, String typeChaussures) {
        this.chaussureAbstraite = chaussureAbstraite;
        this.typeChaussures = typeChaussures;
    }

    @Override
    public void afficherInventaire() {
        System.out.print("| Chaussures de " + typeChaussures);
    }

    @Override
    public void UtiliserObjet(Personnage perso) {
        chaussureAbstraite.equiperChaussures(perso);
    }

    public String getTypeChaussures() {
        return typeChaussures;
    }
}
