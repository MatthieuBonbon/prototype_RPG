package main;


import java.util.Scanner;


public class IHM {
    private final Scanner scanner = new Scanner(System.in);

    public String[] choisirPersonnage(){
        String[] data = new String[2];

        System.out.println("Veuillez choisir un nom pour votre héros.");
        String name = scanner.nextLine();
        System.out.println("Le nom choisi est : " + name);

        data[0] = name;

        String type = choisirTypePersonnage();
        if(type.equals("1")) {
            data[1] = "Assassin";
            System.out.println("Vous avez choisi de jouer un assassin.");
        }
        else if (type.equals("2")) {
            data[1] = "Barbare";
            System.out.println("Vous avez choisi de jouer un barbare.");
        }
        else {
            data[1] = "Sorcier";
            System.out.println("Vous avez choisi de jouer un sorcier.");
        }

       // System.out.println("Vous avez reçu votre équipement de départ lié à votre type de personnage.");

        return data;
    }

    private String choisirTypePersonnage(){
        System.out.println("Veuillez choisir un type de personnage");
        System.out.println("1 : Assassin");
        System.out.println("2 : Barbare");
        System.out.println("3 : Sorcier");

        String type = scanner.nextLine();

        if(type.equals("1") || type.equals("2") || type.equals("3")){
            return type;
        }
        else{
            System.out.println("Le type de personnage choisi est invalide. Veuillez recommencer.");
            return choisirTypePersonnage();
        }
    }

    public String choixInterfaceJeu(){
        System.out.println("Veuillez choisir une action :");
        System.out.println("I : Ouvrir l'inventaire.");
        System.out.println("D : Se rendre dans un donjon.");

        String choix = scanner.nextLine();
        choix = choix.toUpperCase();

        if(choix.equals("I") || choix.equals("D")){
            return choix;
        }
        else {
            System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
            return choixInterfaceJeu();
        }
    }

    public String choixActionInventaire(){
        System.out.println("Bienvenue dans le système de gestion de l'inventaire.\n" +
                "Votre inventaire est affiché ci-dessus." +
                "\nVeuillez choisir une action :" +
                "\n1 : Consommer une potion." +
                "\n2 : Jeter un objet." +
                "\n3 : S'équiper avec un objet." +
                "\n" +
                "\nQ : Quitter inventaire");

        String choix = scanner.nextLine();
        choix = choix.toUpperCase();
        if(choix.equals("1") || choix.equals("2") || choix.equals("3") || choix.equals("Q")){
            return choix;
        }
        else {
            System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
            return choixActionInventaire();
        }
    }



    public String choixPotionConsommer(){
        String choixPotion;

        System.out.println("Veuillez choisir une potion à consommer.");

        choixPotion = scanner.nextLine();

        if(choixPotion.length()>=11){
            String potion = choixPotion.substring(0,6).toUpperCase();
            if(potion.equals("POTION")){
                String type = choixPotion.substring(10);
                if (type.toUpperCase().equals("FEU") || type.toUpperCase().equals("GLACE")){
                    return type.toUpperCase();
                }
                else {
                    System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
                    return choixPotionConsommer();
                }
            }
            else{
                System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
                return choixPotionConsommer();
            }
        }
        else{
            System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
            return choixPotionConsommer();
        }
    }

    public void objetInexistant(){
        System.out.println("Il n'y a pas d'objets de ce type dans l'inventaire.");
    }

    public void objetDejaEquipe(){
        System.out.println("Vous êtes déjà équipé par cet objet.");
    }

    public String choixTypeObjetJeter() {
        System.out.println("Bienvenue dans le système de suppression de l'inventaire.\n" +
                "Votre inventaire est affiché ci-dessus." +
                "\nVeuillez choisir une action :" +
                "\n1 : Jeter une arme." +
                "\n2 : Jeter une armure." +
                "\n3 : Jeter des chaussures." +
                "\n4 : Jeter une potion." +
                "\n" +
                "\nQ : Revenir au menu principal de l'inventaire.");

        String choix = scanner.nextLine();
        choix = choix.toUpperCase();
        if (choix.equals("1") || choix.equals("2") || choix.equals("3") || choix.equals("4") || choix.equals("Q")) {
            return choix;
        }
        else {
            System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
            return choixTypeObjetJeter();
        }
    }

    public String choixObjetSupprimer(String typeObjet){
        String choixObjetSuppr;

        if(typeObjet.equals("CHAUSSURES"))
            System.out.println("Veuillez choisir des chaussures à jeter.");
        else
            System.out.println("Veuillez choisir une " + typeObjet.toLowerCase() + " à jeter.");

        choixObjetSuppr = scanner.nextLine();

        int nb = 0;
        for(int i = 0; i< choixObjetSuppr.length(); i++){
            if(choixObjetSuppr.charAt(i) == ' '){
                nb++;
            }
        }

        if(choixObjetSuppr.length()>=9 && nb==2){
            String type = choixObjetSuppr.substring(0,choixObjetSuppr.indexOf(" ")).toUpperCase();
            if(type.equals(typeObjet)){
                String style = choixObjetSuppr.substring(choixObjetSuppr.indexOf(" ")+1).toUpperCase();
                style = style.substring(style.indexOf(" ")+1);
                if (style.toUpperCase().equals("FEU") || style.toUpperCase().equals("GLACE")){
                    return style.toUpperCase();
                }
                else {
                    System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
                    return choixObjetSupprimer(typeObjet);
                }
            }
            else{
                System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
                return choixObjetSupprimer(typeObjet);
            }
        }
        else{
            System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
            return choixObjetSupprimer(typeObjet);
        }
    }



    public String choixTypeObjetEquiper(){
        System.out.println("Bienvenue dans le système d'équipement de l'inventaire.\n" +
                "Votre inventaire est affiché ci-dessus." +
                "\nVeuillez choisir une action :" +
                "\n1 : Equiper une arme." +
                "\n2 : Equiper une armure." +
                "\n3 : Equiper des chaussures." +
                "\n" +
                "\nQ : Revenir au menu principal de l'inventaire.");

        String choix = scanner.nextLine();
        choix = choix.toUpperCase();
        if (choix.equals("1") || choix.equals("2") || choix.equals("3") || choix.equals("Q")) {
            return choix;
        }
        else {
            System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
            return choixTypeObjetEquiper();
        }
    }



    public String choixObjetEquiper(String typeObjet){
        String choixObjetEquiper;

        if(typeObjet.equals("CHAUSSURES"))
            System.out.println("Veuillez choisir des chaussures à équiper.");
        else
            System.out.println("Veuillez choisir une " + typeObjet.toLowerCase() + " à équiper.");

        choixObjetEquiper = scanner.nextLine();

        int nb = 0;
        for(int i = 0; i< choixObjetEquiper.length(); i++){
            if(choixObjetEquiper.charAt(i) == ' '){
                nb++;
            }
        }

        if(choixObjetEquiper.length()>=9 && nb==2){
            String type = choixObjetEquiper.substring(0,choixObjetEquiper.indexOf(" ")).toUpperCase();
            if(type.equals(typeObjet)){
                String style = choixObjetEquiper.substring(choixObjetEquiper.indexOf(" ")+1).toUpperCase();
                style = style.substring(style.indexOf(" ")+1);
                if (style.toUpperCase().equals("FEU") || style.toUpperCase().equals("GLACE")){
                    return style.toUpperCase();
                }
                else {
                    System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
                    return choixObjetEquiper(typeObjet);
                }
            }
            else{
                System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
                return choixObjetEquiper(typeObjet);
            }
        }
        else{
            System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
            return choixObjetEquiper(typeObjet);
        }
    }



    public String choixFinDeSalle(){
        System.out.println("Veuillez choisir une action :");
        System.out.println("I : Ouvrir l'inventaire.");
        System.out.println("C : Continuer dans la salle suivante.");
        System.out.println("Q : Quitter le donjon et revenir au menu");

        String choix = scanner.nextLine();
        choix = choix.toUpperCase();

        if(choix.equals("I") || choix.equals("C") || choix.equals("Q")){
            return choix;
        }
        else {
            System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
            return choixFinDeSalle();
        }
    }

    public String choixFinDeJeu(){
        System.out.println("Voulez vous continuer ou arrêter de jouer ?");
        System.out.println("C : Continuer le jeu.");
        System.out.println("Q : Quitter le jeu");

        String choix = scanner.nextLine();
        choix = choix.toUpperCase();

        if(choix.equals("C") || choix.equals("Q")){
            return choix;
        }
        else {
            System.out.println("L'action choisie est incorrecte. Veuillez recommencer.");
            return choixFinDeJeu();
        }
    }
}
