package abstractFactoryObjets;

class FabriqueConcreteGlace implements FabriqueAbstraiteObjet {
  public ArmeAbstraite creerArme() {
    return (new ArmeGlace());
  }

  public ArmureAbstraite creerArmure() {
    return (new ArmureGlace());
  }

  public PotionAbstraite creerPotion() {
    return (new PotionGlace());
  }

  public ChaussureAbstraite creerChaussure() {
    return (new ChaussureGlace());
  }

}
