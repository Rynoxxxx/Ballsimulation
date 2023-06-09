import GLOOP.*;
public class Ballsimulation{
    private GLKamera kamera;
    GLLicht licht;
    GLHimmel himmel;
    GLBoden boden;
    private GLTastatur tastatur;

    private Ball ball;
    private Bounceball bounceball;
    private Randball randball;
    private Hindernis[] hindernis;

    public Ballsimulation(){
        kamera = new GLEntwicklerkamera(1920,1080);
        kamera.setzePosition(0,200,2000);
        licht  = new GLLicht();       
        boden  = new GLBoden("src/Boden.jpg");
        himmel = new GLHimmel("src/Himmel.jpg");
        tastatur = new GLTastatur();

        hindernis = new Hindernis[4];
        hindernis[0] = new Hindernis(1000,200,0, 50,400,1300);
        hindernis[1] = new Hindernis(-1000,200,0, 50,400,1300);
        hindernis[2] = new Hindernis(0,400,0, 2050,50,1300);
        hindernis[3] = new Hindernis(0,0,0, 2050,50,1300);
        ball = new Ball (0,200,0, 20);
        ball.werfen(new GLVektor(1,0,0));

        bounceball = new Bounceball(0,200,50, 20);
        bounceball.werfen(new GLVektor(1,1,0));

        randball = new Randball(0,200,50, 20);
        randball.werfen(new GLVektor(1,-1,0));
        fuehreAus();
    }

    public void fuehreAus(){
        while (!tastatur.esc()){

            ball.bewegeDich();
            bounceball.bewegeDich();
            randball.bewegeDich();
                for (int j=0; j< hindernis.length; j++) {
                ball.bearbeiteHindernis(hindernis[j]);
                bounceball.bearbeiteHindernis(hindernis[j]);
                randball.bearbeiteHindernis(hindernis[j]);
            }
            Sys.warte();
        }
        Sys.beenden();
    }
    
}
