package abstractFactoryObjets;

public interface FabriqueAbstraiteObjet {

  static FabriqueAbstraiteObjet chooseFactory(String s){
    if(s.equals("Feu")){
      return (new FabriqueConcreteFeu());
    }
    else{
      return (new FabriqueConcreteGlace());
    }
  }

  ArmeAbstraite creerArme() ;

  ArmureAbstraite creerArmure() ;

  PotionAbstraite creerPotion() ;

  ChaussureAbstraite creerChaussure() ;

}
