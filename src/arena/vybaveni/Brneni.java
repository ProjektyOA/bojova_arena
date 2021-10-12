/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arena.vybaveni;

/**
 *
 * @author jarda
 */
public class Brneni {

    private String nazev;
    private double minP;
    private double maxP;
    private int zivotnost;

    public Brneni(String nazev, double minP, double maxP, int zivotnost) {
        this.nazev = nazev;
        this.minP = minP;
        this.maxP = maxP;
        this.zivotnost = zivotnost;
    }

    public String getNazev() {
        return nazev;
    }

    
    /**
     * Absorpuje část útoku
     *
     * @param skutUtok útok od protivníka
     * @return neabsorpovaný útok
     */
    public int vratModifUtok(int skutUtok) {
        if (this.zivotnost != 0) {
            this.zivotnost--;
            double nahC = minP + Math.random() * (maxP - minP);  //generuje náh číslo v <minP; maxP)
            int absorpce = (int) (skutUtok * nahC);
            return skutUtok - absorpce;
        } else {
            return skutUtok;
        }
    }

    @Override
    public String toString() {
        return "Brneni: "+nazev;
    }

    
           
}
