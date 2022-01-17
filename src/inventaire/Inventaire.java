package inventaire;

import abstractFactoryObjets.*;
import factoryPersonnage.Personnage;

import java.util.ArrayList;

public class Inventaire {
    private Composite inventaire;
    private Composite armes;
    private Composite armures;
    private Composite chaussures;
    private Composite potions;

    /**
     * On crée l'arborescence spécifique au pattern composite lors de la construction de l'inventaire
     */
    public Inventaire(){
        inventaire = new Composite("Inventaire");

        armes = new Composite("Armes");
        inventaire.addComposant(armes);

        armures = new Composite("Armures");
        inventaire.addComposant(armures);

        chaussures = new Composite("Chaussures");
        inventaire.addComposant(chaussures);

        potions = new Composite("Potions");
        inventaire.addComposant(potions);
    }



    public void afficherInventaire(Personnage personnage){
        System.out.println("\n********* INFORMATIONS *********");

        System.out.println("Nom : " + personnage.getNom());
        System.out.println("Points de vie : " + personnage.getPv());
        System.out.println("Force : " + personnage.getForce());
        System.out.println("Resistance : " + personnage.getResistance());

        System.out.println("\n********************************\n");


        System.out.println("\n********** EQUIPEMENT **********");

        if(personnage.getArmeEquipee()==null)
            System.out.println("Arme équipée : aucune arme");
        else
            System.out.println("Arme équipée : " + personnage.getTypeArmeEquipee());
        if(personnage.getArmureEquipee()==null)
            System.out.println("Armure équipée : aucune armure");
        else
            System.out.println("Armure équipée : " + personnage.getTypeArmureEquipee());
        if(personnage.getChaussuresEquipees()==null)
            System.out.println("Chaussures équipées : aucunes chaussures");
        else
            System.out.println("Chaussures équipée : " + personnage.getTypeChaussuresEquipees());

        System.out.println("\n********************************\n");


        System.out.println("\n********** INVENTAIRE **********");
        inventaire.afficherInventaire();
        System.out.println("\n********************************\n");
    }





    /**
     *  CONSOMMATION POTION
     */

    public void afficherPotions(){
        System.out.println("\n********** INVENTAIRE **********");
        potions.afficherInventaire();
        System.out.println("\n********************************\n");
    }

    public boolean consommerPotion(String type, Personnage personnage){
        type = type.toUpperCase();
        ArrayList<Composant> child = potions.getEnfants();
        for(int i = 0; i < potions.getEnfantsSize(); i++){
            Potion potion = (Potion) child.get(i);
            if(potion.getTypePotion().toUpperCase().equals(type)){ // Si  une potion de ce type existe
                // Consommer la potion
                potion.UtiliserObjet(personnage);
                return true;
            }
        }

        return false;
    }


    /**
     * JETER OBJET
     */

    public boolean objetExiste(String type, String style){
        ArrayList<Composant> child;
        boolean exist;
        switch (type) {
            case "ARME":
                child = armes.getEnfants();
                exist = armeExiste(child,style);
                break;
            case "ARMURE":
                child = armures.getEnfants();
                exist = armureExiste(child,style);
                break;
            case "CHAUSSURES":
                child = chaussures.getEnfants();
                exist = chaussuresExiste(child,style);
                break;
            default:
                child = potions.getEnfants();
                exist = potionExiste(child,style);
                break;
        }

        return exist;
    }



    private boolean armeExiste(ArrayList<Composant> child, String style){
        for(int i = 0; i < child.size(); i++){
            Arme arme = (Arme) child.get(i);
            if(arme.getTypeArme().toUpperCase().equals(style)){ // Si  une potion de ce type existe
                return true;
            }
        }
        return false;
    }

    private boolean armureExiste(ArrayList<Composant> child, String style){
        for(int i = 0; i < child.size(); i++){
            Armure armure = (Armure) child.get(i);
            if(armure.getTypeArmure().toUpperCase().equals(style)){ // Si  une potion de ce type existe
                return true;
            }
        }
        return false;
    }

    private boolean chaussuresExiste(ArrayList<Composant> child, String style){
        for(int i = 0; i < child.size(); i++){
            Chaussures chaussures1 = (Chaussures) child.get(i);
            if(chaussures1.getTypeChaussures().toUpperCase().equals(style)){ // Si  une potion de ce type existe
                return true;
            }
        }
        return false;
    }

    private boolean potionExiste(ArrayList<Composant> child, String style){
        for(int i = 0; i < child.size(); i++){
            Potion potion = (Potion) child.get(i);
            if(potion.getTypePotion().toUpperCase().equals(style)){ // Si  une potion de ce type existe
                return true;
            }
        }
        return false;
    }




    /**
     * EQUIPER OBJET
     */

    public void equiperArme(String type, Personnage personnage){
        FabriqueAbstraiteObjet fabrique;
        ArmeAbstraite armeAbstraite;
        if(type.equals("FEU")){
            fabrique = FabriqueAbstraiteObjet.chooseFactory("Feu");
            armeAbstraite = fabrique.creerArme();
        }
        else {
            fabrique = FabriqueAbstraiteObjet.chooseFactory("Glace");
            armeAbstraite = fabrique.creerArme();
        }
        personnage.setArmeEquipee(armeAbstraite,type.toLowerCase());

    }


    public void equiperArmure(String type, Personnage personnage){
        FabriqueAbstraiteObjet fabrique;
        ArmureAbstraite armureAbstraite;
        if(type.equals("FEU")){
            fabrique = FabriqueAbstraiteObjet.chooseFactory("Feu");
            armureAbstraite = fabrique.creerArmure();
        }
        else {
            fabrique = FabriqueAbstraiteObjet.chooseFactory("Glace");
            armureAbstraite = fabrique.creerArmure();
        }
        personnage.setArmureEquipee(armureAbstraite,type.toLowerCase());
    }


    public void equiperChaussures(String type, Personnage personnage){
        FabriqueAbstraiteObjet fabrique;
        ChaussureAbstraite chaussureAbstraite;
        if(type.equals("FEU")){
            fabrique = FabriqueAbstraiteObjet.chooseFactory("Feu");
            chaussureAbstraite = fabrique.creerChaussure();
        }
        else {
            fabrique = FabriqueAbstraiteObjet.chooseFactory("Glace");
            chaussureAbstraite = fabrique.creerChaussure();
        }
        personnage.setChaussuresEquipees(chaussureAbstraite,type.toLowerCase());
    }







    // Add equipment in inventory

    public void ajouterArmeDansInventaire(ArmeAbstraite armeAbstraite, String typeArme){
        Arme arme = new Arme(armeAbstraite,typeArme);
        this.armes.addComposant(arme);
    }

    public void ajouterArmureDansInventaire(ArmureAbstraite armureAbstraite, String typeArmure){
        Armure armure = new Armure(armureAbstraite,typeArmure);
        this.armures.addComposant(armure);
    }

    public void ajouterChaussuresDansInventaire(ChaussureAbstraite chaussureAbstraite, String typeChaussures){
        Chaussures chaussures = new Chaussures(chaussureAbstraite, typeChaussures);
        this.chaussures.addComposant(chaussures);
    }

    public void ajouterPotionDansInventaire(PotionAbstraite potionAbstraite, String typePotion){
        Potion potion = new Potion(potionAbstraite, typePotion);
        this.potions.addComposant(potion);
    }






    // Rm equipment in inventory

    public void suppArmeDansInventaire(String type){
        type = type.toUpperCase();
        ArrayList<Composant> child = armes.getEnfants();
        for(int i = 0; i < armes.getEnfantsSize(); i++) {
            Arme arme = (Arme) child.get(i);
            if (arme.getTypeArme().toUpperCase().equals(type)) { // Si  une potion de ce type existe
                // Supprimer l'arme
                armes.rmComposant(armes.getEnfants().get(i));
            }
        }
    }

    public void suppArmureDansInventaire(String type){
        type = type.toUpperCase();
        ArrayList<Composant> child = armures.getEnfants();
        for(int i = 0; i < armures.getEnfantsSize(); i++) {
            Armure armure = (Armure) child.get(i);
            if (armure.getTypeArmure().toUpperCase().equals(type)) { // Si  une potion de ce type existe
                // Supprimer l'armure
                armures.rmComposant(armures.getEnfants().get(i));
            }
        }
    }

    public void suppChaussuresDansInventaire(String type){
        type = type.toUpperCase();
        ArrayList<Composant> child = chaussures.getEnfants();
        for(int i = 0; i < chaussures.getEnfantsSize(); i++) {
            Chaussures chaussures1 = (Chaussures) child.get(i);
            if (chaussures1.getTypeChaussures().toUpperCase().equals(type)) { // Si  une potion de ce type existe
                // Supprimer les chaussures
                chaussures.rmComposant(chaussures.getEnfants().get(i));
            }
        }
    }



    public void suppPotionDansInventaire(String type){
        type = type.toUpperCase();
        ArrayList<Composant> child = potions.getEnfants();
        for(int i = 0; i < potions.getEnfantsSize(); i++) {
            Potion potion = (Potion) child.get(i);
            if (potion.getTypePotion().toUpperCase().equals(type)) { // Si  une potion de ce type existe
                // Supprimer la potion
                potions.rmComposant(potions.getEnfants().get(i));
            }
        }
    }

    public void suppLastElement(){
        if(armes.getEnfantsSize()>0)
            armes.rmComposant(armes.getEnfants().get(armes.getEnfantsSize()-1));
        if(armures.getEnfantsSize()>0)
            armures.rmComposant(armures.getEnfants().get(armures.getEnfantsSize()-1));
        if(chaussures.getEnfantsSize()>0)
            chaussures.rmComposant(chaussures.getEnfants().get(chaussures.getEnfantsSize()-1));
        if(potions.getEnfantsSize()>0)
            potions.rmComposant(potions.getEnfants().get(potions.getEnfantsSize()-1));
    }


    // getters

    public int getNbPotions(){
        return potions.getEnfantsSize();
    }
    public int getNbArmes(){return armes.getEnfantsSize();}
    public int getNbArmures(){return armures.getEnfantsSize();}
    public int getNbChaussures(){return chaussures.getEnfantsSize();}

}
