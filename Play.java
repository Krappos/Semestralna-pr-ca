import fri.shapesge.Manazer;
import java.util.Random;
import javax.swing.JOptionPane;

public class Play {
    private Manazer manazer;
    private Had had;
    private Mapa mapa;
    private Jablko jablko;
    private Random r;

    //Enumeracia
    private Smer aktualnySmer;
    private ZaverecneSpravy finalnaSprava;

    private int skore;
    private int hlavaX;
    private int hlavaY;

    private int jablkoX;
    private int jablkoY;

    private int velkostMapyX;
    private int velkostMapyY;

    private boolean ibaHlava;
    private boolean jeZakliknute;

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

        this.jeZakliknute = false;

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

        this.jeZakliknute = false;

        if (hlavaX > velkostMapyX || hlavaY > velkostMapyY || hlavaX < 0 || hlavaY < 0) {
            this.finalnaSprava=ZaverecneSpravy.NarazenieDoSteny;
            this.koniecHry();
        } else {

            if (this.had.jeKolizia(this.hlavaX, this.hlavaY)) {
                this.finalnaSprava=ZaverecneSpravy.NarazenieDoHada;
                this.koniecHry();
            }
            if(this.skore == 100){
                this.finalnaSprava=ZaverecneSpravy.ZjedolSiVsetko;
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
        if(!this.jeZakliknute) {
            if(this.ibaHlava) {
                this.aktualnySmer = Smer.HORE;
            }

            if (this.aktualnySmer != Smer.DOLE && !ibaHlava) {
                this.aktualnySmer = Smer.HORE;
            }
        }

        this.jeZakliknute = true;

    }

    public void posunDole() {
        if(!this.jeZakliknute) {
            if(this.ibaHlava) {
                this.aktualnySmer = Smer.DOLE;
            }

            if (this.aktualnySmer != Smer.HORE && !ibaHlava ) {
                this.aktualnySmer = Smer.DOLE;
            }

        }
        this.jeZakliknute = true;


    }

    public void posunVlavo() {
        if(!this.jeZakliknute) {
            if(this.ibaHlava) {
                this.aktualnySmer = Smer.VLAVO;
            }


            if (this.aktualnySmer != Smer.VPRAVO && !ibaHlava ) {
                this.aktualnySmer = Smer.VLAVO;
            }
        }
        this.jeZakliknute = true;

    }

    public void posunVpravo() {
        if(!this.jeZakliknute) {
            if(this.ibaHlava) {
                this.aktualnySmer = Smer.VPRAVO;
            }

            if (this.aktualnySmer != Smer.VLAVO && !ibaHlava) {
                this.aktualnySmer = Smer.VPRAVO;
            }
        }
        this.jeZakliknute = true;



    }

    private void koniecHry() {
        this.manazer.prestanSpravovatObjekt(this);
        JOptionPane.showMessageDialog(null,  finalnaSprava.getFinalnaSprava() + " " + skore);
        System.exit(0);
    }
}



// --------------------------//

// TO DO List
//upravenie hlavy jablka

//optimalizacia klikania ak je stlačenie kym neprejde tick nespustí sa žiaden pohyb
//až po tyku kvôli optimalizácií a nerozbitiu funkcií

//pridanie herného modu vyber modu v metode herný mod cez select a nasledne podla toho sa nakonfikenguruje play

//fixnutie pozície jablka aby sa nespavnovalo pod hadom

//prianie optimalizácie pre hadíka

// --------------------------//
//hotove
//pridanie kolizie hada
//pridanie tela hada -> hotovo
//upravenie koniec hry a vypis správy; -> hotovo
//pohybove metode pridať bool ibaHlava ak je iba hlava môže sa hybať do každého smeru


// --------------------------//

//maybable
//pridanie IOmessages na velkosť mapy
//pridanie IO do mapa(x,y)
//pridanie možnosti vacerých jablk
//doladenie hadíka


// --------------------------//

//problemy
// bugovanie jablka nedalo sa zjesť - fix - vytvorenie novej inštancie jablka zakaždým
// posun hada - z pixelov na pole
//vykreslovanie mapy problem so zobrazením

