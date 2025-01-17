package cemaforo;

import javax.swing.*;
import java.awt.*;

public class Semaforo extends JPanel implements Runnable {

    public static final Color ROJO = Color.red;
    public static final Color AMARILLO = Color.yellow;
    public static final Color VERDE = Color.green;


    public int luz = 1;

    private Luz luz1 = new Luz(null);
    private Luz luz2 = new Luz(null);
    private Luz luz3 = new Luz(null);


    public void setColorLuz1(Color cor) {
        this.luz1.setCor(cor);
    }
    public void setColorLuz2(Color cor) {
        this.luz2.setCor(cor);
    }
    public void setColorLuz3(Color cor) {
        this.luz3.setCor(cor);
    }


    public Semaforo(int inicial){
        this.luz = inicial;
        add(luz1);
        add(luz2);
        add(luz3);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0,0,30,80);
    }

    public Dimension getPreferredSize() {
        return new Dimension(30,80);
    }

    public void mudaCor(){

        switch (luz){
            case 1 :
                luz1.setCor(null);
                luz2.setCor(null);
                luz3.setCor(VERDE);
                this.luz = 2;
                break;
            case 2 :
                luz1.setCor(null);
                luz2.setCor(AMARILLO);
                luz3.setCor(null);
                this.luz = 3;
                break;
            case 3 :
            default:
                luz1.setCor(ROJO);
                luz2.setCor(null);
                luz3.setCor(null);
                this.luz = 1;
                break;
        }
    }

    public void run() {
        while(true){
            this.mudaCor();
            try {
                switch (luz){
                    case 1 :
                        Thread.sleep(6000);
                        break;
                    case 2 :
                        Thread.sleep(9000);
                        break;
                    case 3 :
                        Thread.sleep(3000);
                        break;


                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
