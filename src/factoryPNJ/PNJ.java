package factoryPNJ;


public class PNJ {
  private int pv;

  private int degats;

  private double resistance;

  protected PNJ(int pv, int degats, double resistance){
    this.pv = pv;
    this.degats = degats;
    this.resistance = resistance;
  }

  public int Attaquer() {
    return this.degats;
  }

  public void subirDegats(int degatsBruts){
    double resist = 1.0/resistance;
    double degats = ((double) degatsBruts) * resist;

    this.pv=this.pv-(int)degats;
  }

  public int getPv() {
    return pv;
  }
}
