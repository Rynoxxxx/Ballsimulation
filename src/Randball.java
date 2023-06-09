import GLOOP.*;
public class Randball extends Ball{

    public Randball(double pX, double pY, double pZ, double pRadius){
        super(pX,pY,pZ,pRadius);
        kugel.setzeFarbe(0,0,1);
    }

    @Override
    public void werfen(GLVektor pI) {
        super.werfen(pI);

    }

    @Override
    public void bearbeiteHindernis(Hindernis pH) {

        double dX = Math.abs(kugel.gibX() - pH.gibPosition().x);
        double dY = Math.abs(kugel.gibY() - pH.gibPosition().y);
        double dZ = Math.abs(kugel.gibZ() - pH.gibPosition().z);

        double b = pH.gibBreite();
        double h = pH.gibHoehe();
        double t = pH.gibTiefe();

        if((dX < b/2+radius/2)&&(dY < h/2 +radius/2)&&(dZ < t/2 +radius/2)){
            if (2*dX/b> 2*dY/h && 2*dX/b>2*dZ/t)
                bewegung.x = - bewegung.x;
                bewegung.x= bewegung.x*Math.random()*2+1;

            if (2*dY/h>2*dX/b && 2*dY/h>2*dZ/t)
                bewegung.y = - bewegung.y;
                bewegung.y= bewegung.y*Math.random()*2+1;
            if (2*dZ>2*dX/b && 2*dZ/t>2*dY/h)
                bewegung.z = - bewegung.z;

        }
    }

}


