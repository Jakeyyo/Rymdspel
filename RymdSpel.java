
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class RymdSpel extends JPanel {

    private int skeppX;
    private int skeppY;

    private int skeppB = 20;
    private int skeppH = 40;

    private int skepp2X;
    private int skepp2Y;

    private int planB;
    private int planH;

    private int kubsida = 20;
    private int kubY = -20;
    private int kub2Y = -20;
    private int kub3Y = -20;
    private int kubRödY = -20;
    private int kubBlåY = -20;

    private int slumpNr;
    private int slumpNr2;
    private int slumpNr3;
    private int slumpNr4;

    private int boostN = 0;
    private int boost2N = 0;
    private int slumpNr5 = 1 + (int) (Math.random() * 31);

    private int slumpNr6;
    private boolean boostPå = false;

    private int skyddN = 0;
    private int skydd2N = 0;
    private int slumpNr7 = 1 + (int) (Math.random() * 31);

    private int slumpNr8;
    private boolean skyddPå = false;

    private int poäng = 0;
    private JLabel poängSkylt = new JLabel(String.valueOf(poäng));
    private String namn;

    private boolean nerTryckt = false;

    private TangentLyssnare tl = new TangentLyssnare();
    private ActionLyssnare al = new ActionLyssnare();
    private ActionLyssnare2 a2 = new ActionLyssnare2();
    private ActionLyssnare3 a3 = new ActionLyssnare3();
    private ActionLyssnare4 a4 = new ActionLyssnare4();
    private ActionLyssnare5 a5 = new ActionLyssnare5();
    private ActionLyssnare6 a6 = new ActionLyssnare6();
    private ActionLyssnare7 a7 = new ActionLyssnare7();
    private ActionLyssnare8 a8 = new ActionLyssnare8();
    private ActionLyssnare9 a9 = new ActionLyssnare9();
    private ActionLyssnare10 a10 = new ActionLyssnare10();
    private ActionLyssnare11 a11 = new ActionLyssnare11();
    private ActionLyssnare12 a12 = new ActionLyssnare12();
    private ActionLyssnare13 a13 = new ActionLyssnare13();

    private int delay = 1000;
    private int delay2 = 1000;
    private int delay3 = 1000;

    private Timer t = new Timer(delay, al);
    private Timer t2 = new Timer(250, a2);
    private Timer t3 = new Timer(delay2, a3);
    private Timer t4 = new Timer(delay3, a4);
    private Timer t5 = new Timer(1000, a5);

    private Timer t6 = new Timer(1000, a6);
    private Timer t7 = new Timer(500, a7);
    private Timer t8 = new Timer(1000, a8);

    private Timer t9 = new Timer(250, a9);
    private Timer t10 = new Timer(250, a10);

    private Timer t11 = new Timer(1000, a11);
    private Timer t12 = new Timer(500, a12);
    private Timer t13 = new Timer(1000, a13);

    private int litenKubSida = 10;

    private int litenKubX;
    private int litenKubY;
    private int litenKub2X;
    private int litenKub2Y;
    private int litenKub3X;
    private int litenKub3Y;
    private int litenKub4X;
    private int litenKub4Y;

    private int litenKubX2;
    private int litenKubY2;
    private int litenKub2X2;
    private int litenKub2Y2;
    private int litenKub3X2;
    private int litenKub3Y2;
    private int litenKub4X2;
    private int litenKub4Y2;

    private int litenKubX3;
    private int litenKubY3;
    private int litenKub2X3;
    private int litenKub2Y3;
    private int litenKub3X3;
    private int litenKub3Y3;
    private int litenKub4X3;
    private int litenKub4Y3;

    private int n = 0;
    private int n2 = 0;
    private int n3 = 0;

    private int skepp2N = 0;
    private int skepp2Max = 1000;
    private int skepp2Steg;

    private boolean skepp2IPosition = false;
    private boolean skepp2IPosition2 = false;

    private boolean laserPå = false;

    private int antalExplosion = 3;

    private boolean dogAvLaser = false;

    private Map<String, Integer> poänglista = new TreeMap<>();

    public RymdSpel() {
        namn = JOptionPane.showInputDialog("Skriv in ditt namn");

        try {
        Scanner scan = new Scanner(new File("maxPoängRymd.txt"));
        
        while (scan.hasNext()) {
            poänglista.put(scan.next(), scan.nextInt());
            scan.nextLine();
        }
        } 
        
        catch (Exception e) {}
        


        setLayout(new BorderLayout());
        poängSkylt.setHorizontalAlignment(SwingConstants.RIGHT);
        poängSkylt.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(poängSkylt, BorderLayout.NORTH);
        setSize(600, 580);
        addKeyListener(tl);
        setFocusable(true);
        requestFocusInWindow();
        t.start();
        t6.start();
        t11.start();

        skeppX = getWidth() / 2;
        skeppY = getHeight() - skeppH;

        skepp2X = getWidth() /2;
        skepp2Y = -40;

        planB = getWidth();
        planH = getHeight();

        resetSlumpNr();
        resetSlumpnr2();
        resetSlumpNr3();
        resetSlumpNr4();
        resetSlumpNr6();
        resetSlumpNr8();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(skeppX, skeppY - skeppH, skeppB, skeppH);
        g.fillRect(skepp2X, skepp2Y, skeppB, skeppH);

        if (boostPå && nerTryckt) {
            if (kubY >= 20) {
                g.drawLine(skeppX + 10, getHeight() - skeppH, slumpNr, kubY);
            }

            if (kub2Y >= 20) {
                g.drawLine(skeppX + 10, getHeight() - skeppH, slumpNr2, kub2Y);
            }

             if (kub3Y >= 20) {
                g.drawLine(skeppX + 10, getHeight() - skeppH, slumpNr3, kub3Y);
            }
        }
        
        else if (nerTryckt) {
            g.drawLine(skeppX + 10, getHeight(), skeppX + 10, 0);
        }

        g.fillRect(slumpNr, kubY, kubsida, kubsida);
        g.fillRect(slumpNr2, kub2Y, kubsida, kubsida);
        g.fillRect(slumpNr3, kub3Y, kubsida, kubsida);
    
        g.setColor(Color.RED);
        g.fillRect(slumpNr6, kubRödY, kubsida, kubsida);

        if (boostPå) {
            g.fillRect(skeppX + 5, skeppY - skeppH, 10, 15);
        }
        g.setColor(Color.BLACK);

        g.setColor(Color.BLUE);
        g.fillRect(slumpNr8, kubBlåY, kubsida, kubsida);
        g.setColor(Color.BLACK);
        
        if (t2.isRunning()) {
            g.fillRect(litenKubX, litenKubY, litenKubSida, litenKubSida);
            g.fillRect(litenKub2X, litenKub2Y, litenKubSida, litenKubSida);
            g.fillRect(litenKub3X, litenKub3Y, litenKubSida, litenKubSida);
            g.fillRect(litenKub4X, litenKub4Y, litenKubSida, litenKubSida);
        }

        if (t9.isRunning()) {
            g.fillRect(litenKubX2, litenKubY2, litenKubSida, litenKubSida);
            g.fillRect(litenKub2X2, litenKub2Y2, litenKubSida, litenKubSida);
            g.fillRect(litenKub3X2, litenKub3Y2, litenKubSida, litenKubSida);
            g.fillRect(litenKub4X2, litenKub4Y2, litenKubSida, litenKubSida);
        }

         if (t10.isRunning()) {
            g.fillRect(litenKubX3, litenKubY3, litenKubSida, litenKubSida);
            g.fillRect(litenKub2X3, litenKub2Y3, litenKubSida, litenKubSida);
            g.fillRect(litenKub3X3, litenKub3Y3, litenKubSida, litenKubSida);
            g.fillRect(litenKub4X3, litenKub4Y3, litenKubSida, litenKubSida);
        }

          if (t13.isRunning()) {
            g.setColor(Color.BLUE);
            g.drawLine(0, getHeight() - 80, getWidth(), getHeight() - 80);
            g.setColor(Color.BLACK);
        }

        if ((skepp2IPosition2 && laserPå) || dogAvLaser) {
            g.drawLine(skepp2X + 10, getHeight(), skepp2X + 10, 20);
        }

    }

    public String läsNamn () {
        return namn;
    }

    class TangentLyssnare extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                skeppX += 20;
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                skeppX -= 20;
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                revalidate();
                repaint();

                nerTryckt = true;

                revalidate();
                repaint();

                if (poäng >= 5) {
                    t3.start();
                }

                if (poäng >= 15) {
                    t4.start();
                }

                if (poäng >= 20) {
                    t5.start();
                }

                if (((skeppX + 10 >= slumpNr && skeppX <= slumpNr + 20) && kubY >= 0) || (boostPå && t.isRunning() && kubY >= 20)) {
                    sättLitenKubX();
                    t2.start();

                    if (delay <= 150) {
                        delay -= 5;
                    }

                    if (delay <= 250) {
                        delay -= 10;
                    }

                    else {
                    delay -= 30;
                    }
                    t.setDelay(delay);
                    kubY = -20;
                    
                    resetSlumpNr();
                    poäng++;
                    poängSkylt.setText(String.valueOf(poäng));
                }

                    if (((skeppX + 10 >= slumpNr2 && skeppX <= slumpNr2 + 20) && kub2Y >= 0) || (boostPå && t3.isRunning() && kub2Y >= 20)) {
                    sättLitenKubX2();
                    t9.start();
                     
                    resetSlumpnr2();


                    kub2Y = -20;

                     if (delay2 <= 150) {
                        delay2 -= 5;
                    }
                    
                    if (delay2 <= 250) {
                        delay2 -= 10;
                    }

                    else {
                    delay2 -= 30;
                    }
                    t3.setDelay(delay2);
                    poäng++;
                    poängSkylt.setText(String.valueOf(poäng));
                }

                if (((skeppX + 10 >= slumpNr3 && skeppX <= slumpNr3 + 20) && kub3Y >= 0) || (boostPå && t4.isRunning() && kub3Y >= 20)) {
                    sättLitenKubX3();
                    t10.start();
                    
                    resetSlumpNr3();

                    kub3Y = -20;

                     if (delay3 <= 150) {
                        delay3 -= 5;
                    }
                    
                    if (delay3 <= 250) {
                        delay3 -= 10;
                    }

                    else {
                    delay3 -= 30;
                    }

                    t4.setDelay(delay3);
                    poäng++;
                    poängSkylt.setText(String.valueOf(poäng));
                }

            }

            revalidate();
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (!boostPå) {

                nerTryckt = false;
            }

            repaint();
            revalidate();
        }
        }
    }

    class ActionLyssnare implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kubY += 20;

            revalidate();
            repaint();

            if (kubY + 20 >= getHeight() || kub2Y + 20 >= getHeight() || kub3Y  + 20 >= getHeight()) {
                omstart();
            }

            if (kubY + 20 >= getHeight() - 80 && t13.isRunning()) {
                  sättLitenKubX();
                t2.start();
                      kubY = -20;
            }
        }
    }

    class ActionLyssnare2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kub1Explosion();
        }
    }

    class ActionLyssnare3 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            kub2Y += 20;

            revalidate();
            repaint();

            if (kub2Y + 20 >= getHeight() || kubY  + 20 >= getHeight() || kub3Y  + 20 >= getHeight()) {
             omstart();
            }

            if (kub2Y + 20 >= getHeight() - 80 && t13.isRunning()) {
                sättLitenKubX2();
                t9.start();
                kub2Y = -20;
            }

        }
    }

       class ActionLyssnare4 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            kub3Y += 20;

            revalidate();
            repaint();

            if (kubY + 20 >= getHeight() || kubY  + 20 >= getHeight() || kub3Y  + 20 >= getHeight()) {
             omstart();
            }

            
            if (kub3Y + 20 >= getHeight() - 80 && t13.isRunning()) {
                 sättLitenKubX3();
                t10.start();
                      kub3Y = -20;
            }
        }
    }

    class ActionLyssnare5 implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            if (laserPå) {
                laserPå = false;
                skepp2IPosition2 = false;

                slumpNr4 = (int) (Math.random() * planB) * 20;
                if (slumpNr4 + 20 > getWidth()) {
                slumpNr4 -= 20;
                skepp2Steg = (slumpNr4 - skepp2N) / 20;
        }

            }

            if (skepp2N < 3) {
                skepp2Y += 20;
                skepp2N++;
                skepp2Steg = (slumpNr4 - skepp2N) / 20;
            }


            if (skepp2N >= 3 && skepp2N <= skepp2Steg && skepp2IPosition) {
                if (skepp2X < skepp2Steg) {
                    skepp2X += 20;

                    if (skepp2X >= skepp2Steg - 20) {
                        skepp2IPosition2 = true;

                        laserPå = !laserPå;
                    }
                }

                if (skepp2X > skepp2Steg ) {
                    skepp2X -= 20;  
                    
                    if (skepp2X <= skepp2Steg) {
                        skepp2IPosition2 = true;

                        laserPå = !laserPå;
                    }
                }

    
             }

            if (skepp2N == 3) {
                skepp2IPosition = true;
            }

            revalidate();
            repaint();

             if (skepp2IPosition2 && skepp2X + 10 >= skeppX && skepp2X <= skeppX + 10) {
                dogAvLaser = true;
                omstart();
                revalidate();
                repaint();
            }

        }
    }

    class ActionLyssnare6 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            boostN++;
            if (boostN == slumpNr5) {
                t6.stop();
                t7.start();
                boostN = 0;
                slumpNr5 = 1 + (int) (Math.random() * 3);
            }
        }
    }

    class ActionLyssnare7 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            kubRödY += 20;

            revalidate();
            repaint();

            if ((kubRödY >= getHeight() - skeppH - 20) && ((slumpNr6 + 20 <= skeppX + 20 && slumpNr6 + 20 >= skeppX) || slumpNr6 <= skeppX + 20 && slumpNr6 >= skeppX)) {
                boostPå = true;
                nerTryckt = true;
                kubRödY = -20;

                resetSlumpNr6();
                t7.stop();
                t8.start();
            }

            else if (kubRödY > getHeight()) {
            kubRödY = -20;

            resetSlumpNr6();
            t7.stop();
            t6.start();
        }

        }
    }

    class ActionLyssnare8 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            boost2N++;

            if (boost2N == 10) {
                t8.stop();
                t6.start();
                boost2N = 0;
                boostPå = false;
                nerTryckt = false;
                revalidate();
                repaint();
            }
        }
    }

    class ActionLyssnare9 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kub2Explosion();
            
        }
    }

     class ActionLyssnare10 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kub3Explosion();
            
        }
    }

    class ActionLyssnare11 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            skyddN++;
            if (skyddN == slumpNr7) {
                t11.stop();
                t12.start();
                skyddN = 0;
                slumpNr7 = 1 + (int) (Math.random() * 31);
            }
        }
    }

    class ActionLyssnare12 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            kubBlåY += 20;

            revalidate();
            repaint();

            if ((kubBlåY >= getHeight() - skeppH - 20) && ((slumpNr8 + 20 <= skeppX + 20 && slumpNr8 + 20 >= skeppX) || slumpNr8 <= skeppX + 20 && slumpNr8 >= skeppX)) {
                skyddPå = true;
                kubBlåY = -20;

                resetSlumpNr8();
                t12.stop();
                t13.start();
            }

            else if (kubBlåY > getHeight()) {
            kubBlåY = -20;

            resetSlumpNr8();
            t12.stop();
            t11.start();
        }
        }
    }

       class ActionLyssnare13 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            skydd2N++;

            if (skydd2N == 10) {
                t13.stop();
                t11.start();
                skydd2N = 0;
                skyddPå = false;
                revalidate();
                repaint();
            }
        }
    }
        

    public void omstart () {
           t3.stop();
                t.stop();
                t4.stop();
                t5.stop();
                t6.stop();
                t7.stop();
                t8.stop();
                t11.stop();
                t12.stop();
                t13.stop();

                JOptionPane.showMessageDialog(null, "Aj aj aj!");

                try {
    poänglista.put(namn, poäng);

    BufferedWriter writer = new BufferedWriter(
        new FileWriter("maxPoängRymd.txt")
    );

    List<Map.Entry<String, Integer>> lista = new ArrayList<>(poänglista.entrySet());
    lista.sort((a, b) -> b.getValue() - a.getValue());

    for (Map.Entry<String,Integer> entry : lista) {
        writer.write(entry.getKey() + " " + entry.getValue());
        writer.newLine();
    }

    writer.close();
} catch (Exception ie) {}
                kub3Y = -20;
                kub2Y = -20;
                kubY = -20;
                kubRödY = -20;
                kubBlåY = -20;
    
                resetSlumpNr();
                resetSlumpnr2();
                resetSlumpNr3();
                resetSlumpNr4();
                resetSlumpNr6();
                resetSlumpNr8();

                delay3 = 1000;
                delay2 = 1000;
                delay = 1000;
                poäng = 0;
                poängSkylt.setText(String.valueOf(poäng));
                t4.setDelay(delay3);
                t3.setDelay(delay2);
                t.setDelay(delay);
                t.start();
                t6.start();
                t11.start();
                
                skepp2N = 0;
                skepp2X = getWidth() /2;
                skepp2Y = -40;
                skepp2IPosition = false;
                skepp2IPosition2 = false;
                dogAvLaser = false;

                revalidate();
                repaint();
    }

    public void kub1Explosion () {
            n++;

            revalidate();
            repaint();

            litenKubX -= 10;
            litenKubY -= 10;
            litenKub2X += 10;
            litenKub2Y -= 10;
            litenKub3X -= 10;
            litenKub3Y += 10;
            litenKub4X += 10;
            litenKub4Y += 10;

            if (n == antalExplosion) {
                t2.stop();
                n = 0;
            }
    }

    public void kub2Explosion () {
        n2++;

            revalidate();
            repaint();

            litenKubX2 -= 10;
            litenKubY2 -= 10;
            litenKub2X2 += 10;
            litenKub2Y2 -= 10;
            litenKub3X2 -= 10;
            litenKub3Y2 += 10;
            litenKub4X2 += 10;
            litenKub4Y2 += 10;

            if (n2 == antalExplosion) {
                t9.stop();
                n2 = 0;
            }
    }

    public void kub3Explosion () {
        n3++;

            revalidate();
            repaint();

            litenKubX3 -= 10;
            litenKubY3 -= 10;
            litenKub2X3 += 10;
            litenKub2Y3 -= 10;
            litenKub3X3 -= 10;
            litenKub3Y3 += 10;
            litenKub4X3 += 10;
            litenKub4Y3 += 10;

            if (n3 == antalExplosion) {
                t10.stop();
                n3 = 0;
            }
    }
   
    public void resetSlumpNr () {
        slumpNr = (int) (Math.random() * planB);
        if (slumpNr + 20 > getWidth()) {
            slumpNr -= 20;
        }
    }
    
    public void resetSlumpnr2 () {
          slumpNr2 = (int) (Math.random() * planB);
        if (slumpNr2 + 20 > getWidth()) {
            slumpNr2 -= 20;
        }
    }

    public void resetSlumpNr3 () {
        slumpNr3 = (int) (Math.random() * planB);
                if (slumpNr3 + 20 > getWidth()) {
                    slumpNr3 -= 20;
                }
    }

    public void resetSlumpNr4 () {
          slumpNr4 = (int) (Math.random() * planB);
                if (slumpNr4 + 20 > getWidth()) {
                    slumpNr4 -= 20;
                }
    }

    public void resetSlumpNr6 () {
        slumpNr6 = (int) (Math.random() * planB);
                if (slumpNr6 + 20 > getWidth()) {
                slumpNr6 -= 20;
                }
    }

    public void resetSlumpNr8 () {
        slumpNr8 = (int) (Math.random() * planB);
                if (slumpNr8 + 20 > getWidth()) {
                slumpNr8 -= 20;
                }
    }

    public void sättLitenKubX () {
                    litenKubX = slumpNr - 10;
                    litenKubY = kubY - 10;
                    litenKub2X = slumpNr + 20;
                    litenKub2Y = kubY - 10;
                    litenKub3X = slumpNr - 10;
                    litenKub3Y = kubY + 20;
                    litenKub4X = slumpNr + 20;
                    litenKub4Y = kubY + 20;
    }

    public void sättLitenKubX2 () {
                    litenKubX2 = slumpNr2 - 10;
                    litenKubY2 = kub2Y - 10;
                    litenKub2X2 = slumpNr2 + 20;
                    litenKub2Y2 = kub2Y - 10;
                    litenKub3X2 = slumpNr2 - 10;
                    litenKub3Y2 = kub2Y + 20;
                    litenKub4X2 = slumpNr2 + 20;
                    litenKub4Y2 = kub2Y + 20;
    }

    public void sättLitenKubX3 () {
                    litenKubX3 = slumpNr3 - 10;
                    litenKubY3 = kub3Y - 10;
                    litenKub2X3 = slumpNr3 + 20;
                    litenKub2Y3 = kub3Y - 10;
                    litenKub3X3 = slumpNr3 - 10;
                    litenKub3Y3 = kub3Y + 20;
                    litenKub4X3 = slumpNr3 + 20;
                    litenKub4Y3 = kub3Y + 20;
    }

    private boolean t1kördes = false;
    private boolean t2kördes = false;
    private boolean t3kördes = false;
    private boolean t4kördes = false;
    private boolean t5kördes = false;
    private boolean t6kördes = false;
    private boolean t7kördes = false;
    private boolean t8kördes = false;
    private boolean t9kördes = false;
    private boolean t10kördes = false;
    private boolean t11kördes = false;
    private boolean t12kördes = false;
    private boolean t13kördes = false;
    

    public void pause () {
        if (t.isRunning()) {
            t1kördes = true;
            t.stop();
        }

        if (t3.isRunning()) {
            t3kördes = true;
            t3.stop();
        }

        if (t4.isRunning()) {
            t4kördes = true;
            t4.stop();
        }

        if (t5.isRunning()) {
            t5kördes = true;
            t5.stop();
        }

        if (t6.isRunning()) {
            t6kördes = true;
            t6.stop();
        }

        if (t7.isRunning()) {
            t7kördes = true;
            t7.stop();
        }

        if (t8.isRunning()) {
            t8kördes = true;
            t8.stop();
        }

        if (t9.isRunning()) {
            t9kördes = true;
            t9.stop();
        }

        if (t9.isRunning()) {
            t9kördes = true;
            t9.stop();
        }

        if (t10.isRunning()) {
            t10kördes = true;
            t10.stop();
        }

        if (t11.isRunning()) {
            t11kördes = true;
            t11.stop();
        }

        if (t12.isRunning()) {
            t12kördes = true;
            t12.stop();
        }

        if (t13.isRunning()) {
            t13kördes = true;
            t13.stop();
        }
    }

    public void körIgen () {
        if (t1kördes) {
            t.start();
        }

        if (t2kördes) {
            t2.start();
        }

        if (t3kördes) {
            t3.start();
        }

        if (t4kördes) {
            t4.start();
        }

        if (t5kördes) {
            t5.start();
        }

        if (t6kördes) {
            t6.start();
        }

        if (t7kördes) {
            t7.start();
        }

        if (t8kördes) {
            t8.start();
        }

        if (t9kördes) {
            t9.start();
        }

        if (t10kördes) {
            t10.start();
        }

        if (t11kördes) {
            t11.start();
        }

        if (t12kördes) {
            t12.start();
        }

        if (t13kördes) {
            t13.start();
        }

    t1kördes = false;
    t2kördes = false;
    t3kördes = false;
    t4kördes = false;
    t5kördes = false;
    t6kördes = false;
    t7kördes = false;
    t8kördes = false;
    t9kördes = false;
    t10kördes = false;
    t11kördes = false;
    t12kördes = false;
    t13kördes = false;

    }

    
     
} 
