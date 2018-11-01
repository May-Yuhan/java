import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class Savings_Calculator extends Applet {

    DecimalFormat afrondrobot;
    double grondtal, macht, inzet, jaar, rente;
    String uitkomst;
    TextField inzet_tekstvak, rente_tekstvak, jaar_tekstvak;
    Button button;



    public void init(){

        uitkomst = "";

        // INZET TEKSTVAK
        inzet_tekstvak = new TextField(20);
        add (inzet_tekstvak);


        // RENTE TEKSTVAK
        rente_tekstvak = new TextField(20);
        add (rente_tekstvak);


        // JAAR TEKSTVAK
        jaar_tekstvak = new TextField(20);
        add (jaar_tekstvak);


        // BUTTON
        button = new Button("CALCULATE");
        add (button);


        // BUTTON LISTENER
        Button_Listener button_listener = new Button_Listener();
        button.addActionListener(button_listener);
        inzet_tekstvak.addActionListener(button_listener);
        rente_tekstvak.addActionListener(button_listener);
        jaar_tekstvak.addActionListener(button_listener);

    }

    public void paint (Graphics g){

        inzet_tekstvak.setLocation(20,20);
        rente_tekstvak.setLocation(20,60);
        jaar_tekstvak.setLocation(20,100);
        button.setLocation(20,140);

        g.drawString("€ " + uitkomst,20,180);

        repaint();
    }


    // TEXTFIELD LISTENER 1
    public class TextFieldListener_1 implements ActionListener{

        public void actionPerformed(ActionEvent e){

        }

    }

    // TEXTFIELD LISTENER 2
    public class TextFieldListener_2 implements ActionListener{

        public void actionPerformed(ActionEvent e){

        }

    }

    // TEXTFIELD LISTENER 3
    public class TextFieldListener_3 implements ActionListener{

        public void actionPerformed(ActionEvent e){

        }

    }

    // BUTTON LISTENER
    public class Button_Listener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            // INITIAL AMOUNT:
            inzet = Double.parseDouble(inzet_tekstvak.getText());

            // ANNUAL INTEREST RATE (APR):
            rente = Double.parseDouble(rente_tekstvak.getText());
            rente /= 100;

            // CALCULATED FOR:
            jaar = Double.parseDouble(jaar_tekstvak.getText());

            // FORMULA (COMPOUND A.K.A RENT CALCULATOR)
            grondtal = (1 + rente / 12);
            jaar *= 12;
            macht = Math.pow(grondtal, jaar);
            inzet *= macht;

            // ROUNDED TO TWO DECIMALS
            afrondrobot = new DecimalFormat(",###.##");
            uitkomst = afrondrobot.format(inzet);

        }

    }

}


