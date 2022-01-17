package abstractFactoryObjets;


class ArmeGlace implements ArmeAbstraite {

    public ArmeGlace() {}

    @Override
    public int attaquer() {
        System.out.println("Arme de glace attaque !");
        return 40;
    }


}
