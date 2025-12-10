import fri.shapesge.Stvorec;
import java.util.ArrayList;

public class Mapa {

    private int dlzkaX;
    private int dlzkaY;
    private int poziciaX;
    private int poziciaY;
    private ArrayList<Stvorec> blok;

    //main velkost 10x10
    public Mapa(int dlzkaX , int dlzkaY) {
        this.dlzkaX=dlzkaX;
        this.dlzkaY= dlzkaY;
        this.poziciaX=0;
        this.poziciaY=0;
        this.blok=new ArrayList<Stvorec>();
        //predotvorenie platna kvôli bufferu 
        //ak to tu nebude a priamo vytvorí mapu hra padne
        Stvorec s= new Stvorec(0,0);
        s.zobraz();
        s.skry();
    }

    private void vytvorMapu() {
        for (int i = 0; i < this.dlzkaY; i++) {
            this.poziciaX = 0;

            for (int z = 0; z < this.dlzkaX; z++) {

                Stvorec s = new Stvorec(poziciaX, poziciaY); 
                if ((i + z) % 2 == 0) {
                    s.zmenFarbu("#aad751"); 
                } else {
                    s.zmenFarbu("#a2d149"); 
                }
                this.blok.add(s);

                this.poziciaX += 30;
            }

            this.poziciaY += 30;
        } 
    }

    public void zobrazMapu() {
        this.vytvorMapu();
        for(Stvorec s:blok){
            s.zobraz(); 
        }

    }

    public void skryMapu() {
        for(Stvorec s:blok){
            s.skry(); 
        }
    }

    public int getVelkostMapyXBlok() {
        return dlzkaX;
    }

    public int getVelkostMapyYBlok() {
        return dlzkaY;
    }

    public int getVelkostMapyXPx() {

        return dlzkaX*30;   
    }

    public int getVelkostMapyYPx() {

        return dlzkaY*30;   
    }

}
