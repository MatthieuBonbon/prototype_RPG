package abstractFactoryObjets;

class FabriqueConcreteFeu implements FabriqueAbstraiteObjet {
  public ArmeAbstraite creerArme() {
    return (new ArmeFeu());
  }

  public ArmureAbstraite creerArmure() {
    return (new ArmureFeu());
  }

  public PotionAbstraite creerPotion() {
    return (new PotionFeu());
  }

  public ChaussureAbstraite creerChaussure() {
    return (new ChaussureFeu());
  }

}
