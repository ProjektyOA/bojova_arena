/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arena.postavy;

import arena.vybaveni.Brneni;

/**
 *
 * @author jarda
 */
public class Sermir extends Valecnik {

    private Brneni mojeBrneni;

    /**
     * Vytvoří Šermíře s přednastaveným brněním
     *
     * @param jmeno jméno šermíře
     * @param maxZdravi max zdraví šermíře
     * @param udelovanePoskozeni útok šermíře
     * @param crit prabděpodobnost kritického zásahu
     */
    public Sermir(String jmeno, int maxZdravi, int udelovanePoskozeni, double crit) {
        super(jmeno, maxZdravi, udelovanePoskozeni, crit);
        this.mojeBrneni = new Brneni("Kožená vesta", 0.1, 0.2, 5);
    }

    /**
     * Vytvoří Šermíře
     *
     * @param mojeBrneni brnění, které bude mít na sobě
     * @param jmeno jméno šermíře
     * @param maxZdravi max zdraví šermíře
     * @param udelovanePoskozeni útok šermíře
     * @param crit prabděpodobnost kritického zásahu
     */
    public Sermir(Brneni mojeBrneni, String jmeno, int maxZdravi, int udelovanePoskozeni, double crit) {
        super(jmeno, maxZdravi, udelovanePoskozeni, crit);
        this.mojeBrneni = mojeBrneni;
    }

    /**
     * Obrana šermíře
     *
     * @param hodnotaUtoku přicházející útok od protivníka
     * @return řetezec akce
     */
    @Override
    public String branSe(int hodnotaUtoku) {
        //nechám své brnění absorpovat část útoku   
        int skutecnePoskozeni = this.mojeBrneni.vratModifUtok(hodnotaUtoku);
        this.setAktZdravi(this.getAktZdravi() - skutecnePoskozeni);
        return "Šermíř " + this.getJmeno() + " obdržel poškození s hodnotou " + skutecnePoskozeni + ", protože jeho brnění " + mojeBrneni.getNazev() + " absorpovalo část poškození\n";
    }

    /**
     * Zaútočí proti dalšímu bojovníkovi
     *
     * @param protivnik protivník
     * @return Informace o útoku
     */
    public String utoc(Bojovnik protivnik) {
        if (Math.random() <= this.getPravdepodobnostKrit()) {//udelím kritik

            return "Šermíř " + this.getJmeno() + " zasazuje kritický úder s poškozením" + this.getUdelovanePoskozeni() * 2 + "\n" + protivnik.branSe(this.getUdelovanePoskozeni() * 2) + "\n";
        } else {

            return "Šermíř " + this.getJmeno() + " uděluje poškození" + this.getUdelovanePoskozeni() + "\n" + protivnik.branSe(this.getUdelovanePoskozeni()) + "\n";
        }

    }

    @Override
    public String toString() {
        return super.toString() +mojeBrneni.toString();
    }
    
    

}
