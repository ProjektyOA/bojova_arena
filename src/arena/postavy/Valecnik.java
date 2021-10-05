/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arena.postavy;

/**
 *
 * @author hodl
 */
public class Valecnik extends Bojovnik{
  private double pravdepodobnostKrit;  //mezi 0 - 1

    public Valecnik(String jmeno, int maxZdravi, int udelovanePoskozeni, double crit) {
        super(jmeno, maxZdravi, udelovanePoskozeni);
        this.pravdepodobnostKrit = crit;
    }
   /**
     * Bojovník se brání proti útočníkovi
     * @param hodnotaUtoku hodnota útoku protivníka 
     * @return informace o provedené obraně 
     */
  @Override
    public String branSe(int hodnotaUtoku)
    {
     this.setAktZdravi(this.getAktZdravi() - hodnotaUtoku);
     return "Válečník "+this.getJmeno() + " obdržel poškození s hodnotou "+ hodnotaUtoku +"\n";
    }   

  /**
     * Zaútočí proti dalšímu bojovníkovi
     * @param protivnik protivník
     * @return Informace o útoku
     */
    public String utoc(Bojovnik protivnik)
    {
     if(Math.random() <= this.pravdepodobnostKrit)
      {//udelím kritik
       protivnik.branSe(this.getUdelovanePoskozeni()*2);
       return "Válečník "+this.getJmeno() + " zasazuje kritický úder s poškozením"+ this.getUdelovanePoskozeni()*2+"\n";
      }  else
         {
          protivnik.branSe(this.getUdelovanePoskozeni());
          return "Válečník "+this.getJmeno() + " uděluje poškození"+ this.getUdelovanePoskozeni()+"\n";
         }

     //protivnik.branSe(this.getUdelovanePoskozeni());   
     //return "Bojovník "+this.getJmeno() + " útočí s hodnotou "+ this.getUdelovanePoskozeni()+"\n";
    }           
  
}
