import fri.shapesge.Manazer;
import java.util.Random;
import javax.swing.JOptionPane;

public class Play {
    private Manazer manazer;
    private Had had;
    private Mapa mapa;
    private Smer aktualnySmer;
    private Jablko jablko;
    private Random r;

    private int skore;
    private int hlavaX;
    private int hlavaY;

    private int jablkoX;
    private int jablkoY;

    private int velkostMapyX;
    private int velkostMapyY;

    private boolean ibaHlava;

    public Play() {
        this.aktualnySmer = Smer.VPRAVO;
        this.mapa = new Mapa(10, 10);
        this.mapa.zobrazMapu();
        this.r = new Random();

        this.had = new Had();
        this.jablko = new Jablko();

        this.skore = 0;
        this.hlavaX = 0;
        this.hlavaY = 0;
        this.jablkoX = 0;
        this.jablkoY = 0;
        this.velkostMapyX = 9;
        this.velkostMapyY = 9;
        this.ibaHlava = true;

        this.spravaJablka();
        this.jablko.zobraz();

        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
    }

    public void main() {
    }

    public void tik() {
        this.hlavaX += this.aktualnySmer.getX();
        this.hlavaY += this.aktualnySmer.getY();

        if (hlavaX > velkostMapyX || hlavaY > velkostMapyY || hlavaX < 0 || hlavaY < 0) {
            this.koniecHry();
        } else {

            if (this.had.jeKolizia(this.hlavaX, this.hlavaY)) {
                JOptionPane.showMessageDialog(null, "GAME OVER! Zjedol si sám seba.");
                this.koniecHry();
            }


            if (this.jablkoX == this.hlavaX && this.jablkoY == this.hlavaY) {
                zjedzJablko();
            }

            this.pohyb();
        }
    }

    private void zjedzJablko() {
        this.skore++;
        this.had.pridajKusok();
        this.spravaJablka();
        this.ibaHlava = false;
    }

    private void spravaJablka() {
        if (this.jablko != null) {
            this.jablko.skry();
        }

        do {
            this.jablkoX = r.nextInt(velkostMapyX + 1);
            this.jablkoY = r.nextInt(velkostMapyY + 1);
        } while (this.jablkoX == this.hlavaX && this.jablkoY == this.hlavaY);

        this.jablko = new Jablko();
        this.jablko.zmenPoziciu(this.jablkoX, this.jablkoY);
        this.jablko.zobraz();
    }

    private void pohyb() {
        this.had.pohniSaX(this.aktualnySmer.getX());
        this.had.pohniSaY(this.aktualnySmer.getY());
    }

    public void posunHore() {

        if(ibaHlava) {

            this.aktualnySmer = Smer.HORE;

        }

        if (this.aktualnySmer != Smer.DOLE && !ibaHlava) {

            this.aktualnySmer = Smer.HORE;

        }

    }


    public void posunDole() {

        if(ibaHlava) {

            this.aktualnySmer = Smer.DOLE;

        }

        if (this.aktualnySmer != Smer.HORE && !ibaHlava ) {

            this.aktualnySmer = Smer.DOLE;

        }

    }

    public void posunVlavo() {

        if(ibaHlava) {

            this.aktualnySmer = Smer.VLAVO;

        }


        if (this.aktualnySmer != Smer.VPRAVO && !ibaHlava ) {

            this.aktualnySmer = Smer.VLAVO;

        }

    }

    public void posunVpravo() {

        if(ibaHlava) {

            this.aktualnySmer = Smer.VPRAVO;

        }

        if (this.aktualnySmer != Smer.VLAVO && !ibaHlava) {

            this.aktualnySmer = Smer.VPRAVO;

        }

    }

    private void koniecHry() {
        this.manazer.prestanSpravovatObjekt(this);
        JOptionPane.showMessageDialog(null, "GAME OVER!\nNarazil si do steny.\nTvoje skóre je: " + skore);
        System.exit(0);
    }
}

// TO DO List

//urgent
//pohybove metode pridať bool ibaHlava ak je iba hlava môže sa hybať do každého smeru
//pridanie tela hada -> hotovo
//upravenie koniec hry a vypis správy;



//pridanie herného modu vyber modu v metode herný mod cez select a nasledne podla toho sa nakonfikenguruje play


//maybable
//pridanie IOmessages na velkosť mapy
//pridanie IO do mapa(x,y)
//pridanie možnosti vacerých jablk
//doladenie hadíka

//pridanie kolizie hada
//pridanie jablka na miesto kde had není


//problemy - bugovanie jablka nedalo sa zjesť - fix - vytvorenie novej inštancie jablka zakaždým
// posun hada - z pixelov na pole
//vykreslovanie mapy problem so zobrazením