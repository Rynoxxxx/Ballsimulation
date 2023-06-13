import GLOOP.*;
public class Gravball extends Ball {
    public Gravball(double pX, double pY, double pZ, double pRadius){
        super(pX,pY,pZ,pRadius);
        kugel.setzeFarbe(0,1,0);
    }
public void Farbe(){
        kugel.setzeFarbe(Math.random(),Math.random(),Math.random());
}


}
