import fri.shapesge.Stvorec;
import java.util.ArrayList;

public class Had {

    private Stvorec hlava;
    private ArrayList<Stvorec> telo;

    private int hlavaX;
    private int hlavaY;

    private ArrayList<Integer> teloX;
    private ArrayList<Integer> teloY;

    public Had() {

        this.telo = new ArrayList<Stvorec>();
        this.teloX = new ArrayList<Integer>();
        this.teloY = new ArrayList<Integer>();


        this.hlavaX = 0;
        this.hlavaY = 0;

        this.hlava = new Stvorec(0, 0);
        this.zobrazHada();
    }

    public void zobrazHada() {
        this.hlava.zobraz();
        this.hlava.zmenFarbu("green");
    }

    public void pohniSaX(int x) {
        if (x == 0) return;

        int posun = x * 30;

        int stareHlavaX = this.hlavaX;
        int stareHlavaY = this.hlavaY;

        this.hlava.posunVodorovne(posun);
        this.hlavaX += posun;

        this.posunTelo(stareHlavaX, stareHlavaY);
    }

    public void pohniSaY(int y) {
        if (y == 0) return;

        int posun = y * 30;

        int stareHlavaX = this.hlavaX;
        int stareHlavaY = this.hlavaY;

        this.hlava.posunZvisle(posun);
        this.hlavaY += posun;

        this.posunTelo(stareHlavaX, stareHlavaY);
    }

    private void posunTelo(int kamMaIstPrvyX, int kamMaIstPrvyY) {
        if (telo.isEmpty()) return;

        for (int i = telo.size() - 1; i > 0; i--) {
            int cielX = teloX.get(i - 1);
            int cielY = teloY.get(i - 1);
            presunKusok(i, cielX, cielY);
        }

        presunKusok(0, kamMaIstPrvyX, kamMaIstPrvyY);
    }

    private void presunKusok(int index, int cielX, int cielY) {
        Stvorec kusok = telo.get(index);
        int aktualneX = teloX.get(index);
        int aktualneY = teloY.get(index);

        kusok.posunVodorovne(cielX - aktualneX);
        kusok.posunZvisle(cielY - aktualneY);

        teloX.set(index, cielX);
        teloY.set(index, cielY);
    }

    public void pridajKusok() {

        Stvorec kusok = new Stvorec(0, 0);
        kusok.zmenStranu(30);
        kusok.zmenFarbu("blue");


        kusok.posunVodorovne(this.hlavaX);
        kusok.posunZvisle(this.hlavaY);

        kusok.zobraz();


        this.telo.add(kusok);
        this.teloX.add(this.hlavaX);
        this.teloY.add(this.hlavaY);
    }
    public boolean jeKolizia(int x, int y){

        int poziciaX = x*30;
        int poziciaY = y*30;

for(int i = 0 ; i < teloX.size() ; i++){

    if(teloX.get(i)==poziciaX && teloY.get(i)==poziciaY){
        return true;
    }
}
return false;
    }
}