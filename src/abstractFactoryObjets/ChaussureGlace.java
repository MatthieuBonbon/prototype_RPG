package abstractFactoryObjets;

import factoryPersonnage.Personnage;

class ChaussureGlace implements ChaussureAbstraite {
    @Override
    public void equiperChaussures(Personnage personnage) {
        personnage.setResistance(personnage.getResistance()*1.2);
        System.out.println("Chaussures de glace équipées !");
    }

    @Override
    public void retirerChaussures(Personnage personnage) {
        personnage.setResistance(personnage.getResistance()/1.2);
        System.out.println("Chaussures de glace retirées !");
    }
}
