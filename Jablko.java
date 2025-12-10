import fri.shapesge.Kruh;

public class Jablko {
     private Kruh jablko;
    private Kruh tien;
    
       public Jablko() {
        this.jablko = new Kruh();
        this.tien = new Kruh();

        this.jablko.zmenFarbu("red");
        this.jablko.zmenPolohu(0,0);
    }


    public void zobraz(){
        this.jablko.zobraz();
    }

    public void skry(){

           this.jablko.skry();
    }
   public void zmenPoziciu(int x , int y){
       this.jablko.posunVodorovne(x*30);
      // this.tien.posunVodorovne(x*30);
       
       this.jablko.posunZvisle(y*30); 
       //this.tien.posunZvisle(y*30);
    }
}

