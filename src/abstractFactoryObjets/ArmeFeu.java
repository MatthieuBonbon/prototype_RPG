package abstractFactoryObjets;


class ArmeFeu implements ArmeAbstraite {

    public ArmeFeu() {}

    @Override
    public int attaquer() {
        System.out.println("Arme de feu attaque !");
        return 50;
    }


}
