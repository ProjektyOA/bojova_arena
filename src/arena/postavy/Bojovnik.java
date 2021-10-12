package arena.postavy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Třída Bojovník představuje základní bojovou jednotku ve hře
 * @author jarda
 */
public class Bojovnik {
   private String jmeno;
   private int aktZdravi;
   private int maxZdravi;
   private int udelovanePoskozeni;

   /**
    * Konstruktor
    * @param jmeno jméno
    * @param maxZdravi max zdraví
    * @param udelovanePoskozeni udělované poškození
    */
    public Bojovnik(String jmeno, int maxZdravi, int udelovanePoskozeni) {
        this.jmeno = jmeno;
        this.aktZdravi = maxZdravi;
        this.maxZdravi = maxZdravi;
        this.udelovanePoskozeni = udelovanePoskozeni;
    }

    /**
     * Vrátí jméno bojovníka
     * @return jmeno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Nastaví jméno
     * @param jmeno jméno bojovníka
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * Vrátí aktuální zdraví
     * @return aktZdravi zdraví bojovníka
     */
    public int getAktZdravi() {
        return aktZdravi;
    }

    /**
     * Nastaví zdraví bojovníka
     * @param aktZdravi zdravi bojovnika
     */
    public void setAktZdravi(int aktZdravi) {
        this.aktZdravi = aktZdravi;
    }

    /**
     * Vrátí maximální zdraví bojovníka
     * @return maxZdravi
     */
    public int getMaxZdravi() {
        return maxZdravi;
    }

    /**
     * Nastaví maximální zdraví
     * @param maxZdravi maximální zdraví bojovníka
     */
    public void setMaxZdravi(int maxZdravi) {
        this.maxZdravi = maxZdravi;
    }

    /**
     * Vrací udělované poškození bojovníkem
     * @return udelovanePoskozeni
     */
    public int getUdelovanePoskozeni() {
        return udelovanePoskozeni;
    }

    /**
     * Bojovník se brání proti útočníkovi
     * @param hodnotaUtoku hodnota útoku protivníka 
     * @return informace o provedené obraně 
     */
    public String branSe(int hodnotaUtoku)
    {
     this.aktZdravi = this.aktZdravi - hodnotaUtoku;
     return "Bojovník "+this.getJmeno() + " obdržel poškození s hodnotou "+ hodnotaUtoku +"\n";
    }       
    
    @Override
    /**
     * Vrátí informaci o bojovníkovi
     */
    public String toString() {
        return jmeno + " " + aktZdravi + " / " + maxZdravi +"\n";
    }
   
    /**
     * Zaútočí proti dalšímu bojovníkovi
     * @param protivnik protivník
     * @return Informace o útoku
     */
    public String utoc(Bojovnik protivnik)
    {
     protivnik.branSe(this.getUdelovanePoskozeni());   
     return "Bojovník "+this.getJmeno() + " útočí s hodnotou "+ this.getUdelovanePoskozeni()+"\n";
    }       
   
}
