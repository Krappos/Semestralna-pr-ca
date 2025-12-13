import fri.shapesge.BlokTextu;
import fri.shapesge.StylFontu;


public class VypisSkore {

    private BlokTextu cisloSkore;
    private int AktualneSKore;

    public VypisSkore() {
        this.cisloSkore = new BlokTextu("0",150-17,40);

        this.cisloSkore.zmenFarbu("white");
        this.cisloSkore.zmenFont("Arial",StylFontu.BOLD,35);

        this.zobrazVypis();
    }

    public void zobrazVypis(){
        this.cisloSkore.zobraz();
    }

    public void pridajSkore(){
        this.AktualneSKore++;

        this.cisloSkore.zmenText(Integer.toString(this.AktualneSKore));
        this.cisloSkore.skry();
        this.cisloSkore.zobraz();
    }

    public int getSkore(){
return this.AktualneSKore;

    }


}
