
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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class MemorySpel extends JPanel {
    private int poäng = 0;
    private JLabel poängSkylt = new JLabel(String.valueOf(poäng));
    

    private String namn;
    private Map<String, Integer> poänglista = new TreeMap<>();

    private int skeppX;
    private int skeppY;

    private int skeppB = 20;
    private int skeppH = 40;

    private Color[] färger = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.RED, Color.YELLOW, Color.GRAY, Color.PINK, Color.ORANGE};

    private int kubSida = 20;
    private int litenKubSida = 10;

    private Color randomFärgFörsta = färger[(int) (Math.random() * färger.length)];
    private int slumpXFörsta;
    private int förstaY = -20;
    private int förstaDelay = 50;

    private int slumpXAndra1 = 20;
    private int slumpXAndra2 = 100;
    private int slumpXAndra3 = 180;
    private int slumpXAndra4 = 260;
    private int slumpXAndra5 = 340;
    private int slumpXAndra6 = 400;
    private int slumpXAndra7 = 450;
    private int slumpXAndra8 = 510;
    private int slumpXAndra9 = 570;

    private int andraY1 = -20;
    private int andraY2 = -20;
    private int andraY3 = -20;
    private int andraY4 = -20;
    private int andraY5 = -20;
    private int andraY6 = -20;
    private int andraY7 = -20;
    private int andraY8 = -20;
    private int andraY9 = -20;

    private Color andraKubFärg1;
    private Color andraKubFärg2;
    private Color andraKubFärg3;
    private Color andraKubFärg4;
    private Color andraKubFärg5;
    private Color andraKubFärg6;
    private Color andraKubFärg7;
    private Color andraKubFärg8;
    private Color andraKubFärg9;

    private Color litenKubFärg1;
    private Color litenKubFärg2;
    private Color litenKubFärg3;
    private Color litenKubFärg4;
    private Color litenKubFärg5; 
    private Color litenKubFärg6;
    private Color litenKubFärg7;
    private Color litenKubFärg8;
    private Color litenKubFärg9;

    private boolean andraKubFärgSatt1 = false;
    private boolean andraKubFärgSatt2 = false;
    private boolean andraKubFärgSatt3 = false;
    private boolean andraKubFärgSatt4 = false;
    private boolean andraKubFärgSatt5 = false;
    private boolean andraKubFärgSatt6 = false;
    private boolean andraKubFärgSatt7 = false;
    private boolean andraKubFärgSatt8 = false;
    private boolean andraKubFärgSatt9 = false;

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

    private int litenKubX4;
    private int litenKubY4;
    private int litenKub2X4;
    private int litenKub2Y4;
    private int litenKub3X4;
    private int litenKub3Y4;
    private int litenKub4X4;
    private int litenKub4Y4;

    private int litenKubX5;
    private int litenKubY5;
    private int litenKub2X5;
    private int litenKub2Y5;
    private int litenKub3X5;
    private int litenKub3Y5;
    private int litenKub4X5;
    private int litenKub4Y5;

    private int litenKubX6;
    private int litenKubY6;
    private int litenKub2X6;
    private int litenKub2Y6;
    private int litenKub3X6;
    private int litenKub3Y6;
    private int litenKub4X6;
    private int litenKub4Y6;

    private int litenKubX7;
    private int litenKubY7;
    private int litenKub2X7;
    private int litenKub2Y7;
    private int litenKub3X7;
    private int litenKub3Y7;
    private int litenKub4X7;
    private int litenKub4Y7;

    private int litenKubX8;
    private int litenKubY8;
    private int litenKub2X8;
    private int litenKub2Y8;
    private int litenKub3X8;
    private int litenKub3Y8;
    private int litenKub4X8;
    private int litenKub4Y8;

    private int litenKubX9;
    private int litenKubY9;
    private int litenKub2X9;
    private int litenKub2Y9;
    private int litenKub3X9;
    private int litenKub3Y9;
    private int litenKub4X9;
    private int litenKub4Y9;

    private int litenKub1N = 0;
    private int litenKub2N = 0;
    private int litenKub3N = 0;
    private int litenKub4N = 0;
    private int litenKub5N = 0;
    private int litenKub6N = 0;
    private int litenKub7N = 0;
    private int litenKub8N = 0;
    private int litenKub9N = 0;

    private int andraDelay = 100;

    private TangentLyssnare tl = new TangentLyssnare();

    private ActionLyssnare1 a1 = new ActionLyssnare1();
    private ActionLyssnare2 a2 = new ActionLyssnare2();

    private startaAndraKub1 kub1 = new startaAndraKub1();
    private startaAndraKub2 kub2 = new startaAndraKub2();
    private startaAndraKub3 kub3 = new startaAndraKub3();
    private startaAndraKub4 kub4 = new startaAndraKub4();
    private startaAndraKub5 kub5 = new startaAndraKub5();
    private startaAndraKub6 kub6 = new startaAndraKub6();
    private startaAndraKub7 kub7 = new startaAndraKub7();
    private startaAndraKub8 kub8 = new startaAndraKub8();
    private startaAndraKub9 kub9 = new startaAndraKub9();

    private LitenKub1Explodera explodera1 = new LitenKub1Explodera();
    private LitenKub2Explodera explodera2 = new LitenKub2Explodera();
    private LitenKub3Explodera explodera3 = new LitenKub3Explodera();
    private LitenKub4Explodera explodera4 = new LitenKub4Explodera();
    private LitenKub5Explodera explodera5 = new LitenKub5Explodera();
    private LitenKub6Explodera explodera6 = new LitenKub6Explodera();
    private LitenKub7Explodera explodera7 = new LitenKub7Explodera();
    private LitenKub8Explodera explodera8 = new LitenKub8Explodera();
    private LitenKub9Explodera explodera9 = new LitenKub9Explodera();


    private Timer förstaFallTimer = new Timer(förstaDelay, a1);
    private Timer startaAndraKuberna = new Timer(0, a2);

    private Timer kub1Start = new Timer(andraDelay, kub1);
    private Timer kub2Start = new Timer(andraDelay, kub2);
    private Timer kub3Start = new Timer(andraDelay, kub3);
    private Timer kub4Start = new Timer(andraDelay, kub4);
    private Timer kub5Start = new Timer(andraDelay, kub5);
    private Timer kub6Start = new Timer(andraDelay, kub6);
    private Timer kub7Start = new Timer(andraDelay, kub7);
    private Timer kub8Start = new Timer(andraDelay, kub8);
    private Timer kub9Start = new Timer(andraDelay, kub9);

    private Timer litenKub1Timer = new Timer(250, explodera1);
    private Timer litenKub2Timer = new Timer(250, explodera2);
    private Timer litenKub3Timer = new Timer(250, explodera3);
    private Timer litenKub4Timer = new Timer(250, explodera4);
    private Timer litenKub5Timer = new Timer(250, explodera5);
    private Timer litenKub6Timer = new Timer(250, explodera6);
    private Timer litenKub7Timer = new Timer(250, explodera7);
    private Timer litenKub8Timer = new Timer(250, explodera8);
    private Timer litenKub9Timer = new Timer(250, explodera9);


    private int slumpAndraDelay = (int) (Math.random() * 5000);
    
    private boolean nerTryckt = false;

    private List<Color> memoryLista = new LinkedList<>();
    private int memoryListaRäknare = 0;
    private int rundor = 0;
    private int rundorRäknare = 1;

    
    public MemorySpel (String namn) {
        this.namn = namn;
        setSize(600, 580);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(tl);
        setLayout(new BorderLayout());
        poängSkylt.setHorizontalAlignment(SwingConstants.RIGHT);
        poängSkylt.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(poängSkylt, BorderLayout.NORTH);
       

        try {
        Scanner scan = new Scanner(new File("maxPoängMemory.txt"));
        
        while (scan.hasNext()) {
            poänglista.put(scan.next(), scan.nextInt());
            scan.nextLine();
        }
        } 
        
        catch (Exception e) {}
        
        resetSlumpXFörsta();
        
    

        skeppX = getWidth() / 2;
        skeppY = getHeight() - skeppH;

        förstaFallTimer.start();
        startaAndraKuberna.setRepeats(false);
        startaAndraKuberna.setInitialDelay(2000);

        memoryLista.add(randomFärgFörsta);

        kub1Start.setInitialDelay(slumpAndraDelay);
        slumpAndraDelay = (int) (Math.random() * 5000);
        kub2Start.setInitialDelay(slumpAndraDelay);
        slumpAndraDelay = (int) (Math.random() * 5000);
        kub3Start.setInitialDelay(slumpAndraDelay);
        slumpAndraDelay = (int) (Math.random() * 5000);
        kub4Start.setInitialDelay(slumpAndraDelay);
        slumpAndraDelay = (int) (Math.random() * 5000);
        kub5Start.setInitialDelay(slumpAndraDelay);
        slumpAndraDelay = (int) (Math.random() * 5000);
        kub6Start.setInitialDelay(slumpAndraDelay);
        slumpAndraDelay = (int) (Math.random() * 5000);
        kub7Start.setInitialDelay(slumpAndraDelay);
        slumpAndraDelay = (int) (Math.random() * 5000);
        kub8Start.setInitialDelay(slumpAndraDelay);
        slumpAndraDelay = (int) (Math.random() * 5000);
        kub9Start.setInitialDelay(slumpAndraDelay);
        slumpAndraDelay = (int) (Math.random() * 5000);
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.fillRect(skeppX, skeppY - skeppH, skeppB, skeppH);

        g.setColor(randomFärgFörsta);
        g.fillRect(slumpXFörsta, förstaY, kubSida, kubSida);

        if (nerTryckt) {
            g.setColor(Color.BLACK);
            g.drawLine(skeppX + 10, getHeight(), skeppX + 10, 0);
        }

        if (kub1Start.isRunning()) {
            if (!andraKubFärgSatt1) {
            andraKubFärg1 = färger[(int) (Math.random() * färger.length)];
            andraKubFärgSatt1 = true;
            }
            g.setColor(andraKubFärg1);
            g.fillRect(slumpXAndra1, andraY1, kubSida, kubSida);
        }

        if (kub2Start.isRunning()) {
            if (!andraKubFärgSatt2) {
            andraKubFärg2 = färger[(int) (Math.random() * färger.length)];
            andraKubFärgSatt2 = true;
            }
            g.setColor(andraKubFärg2);
            g.fillRect(slumpXAndra2, andraY2, kubSida, kubSida);
        }

           if (kub3Start.isRunning()) {
            if (!andraKubFärgSatt3) {
            andraKubFärg3 = färger[(int) (Math.random() * färger.length)];
            andraKubFärgSatt3 = true;
            }
            g.setColor(andraKubFärg3);
            g.fillRect(slumpXAndra3, andraY3, kubSida, kubSida);
        }

           if (kub4Start.isRunning()) {
            if (!andraKubFärgSatt4) {
            andraKubFärg4 = färger[(int) (Math.random() * färger.length)];
            andraKubFärgSatt4 = true;
            }
            g.setColor(andraKubFärg4);
            g.fillRect(slumpXAndra4, andraY4, kubSida, kubSida);
        }

           if (kub5Start.isRunning()) {
            if (!andraKubFärgSatt5) {
            andraKubFärg5 = färger[(int) (Math.random() * färger.length)];
            andraKubFärgSatt5 = true;
            }
            g.setColor(andraKubFärg5);
            g.fillRect(slumpXAndra5, andraY5, kubSida, kubSida);
        }

           if (kub6Start.isRunning()) {
            if (!andraKubFärgSatt6) {
            andraKubFärg6 = färger[(int) (Math.random() * färger.length)];
            andraKubFärgSatt6 = true;
            }
            g.setColor(andraKubFärg6);
            g.fillRect(slumpXAndra6, andraY6, kubSida, kubSida);
        }

           if (kub7Start.isRunning()) {
            if (!andraKubFärgSatt7) {
            andraKubFärg7 = färger[(int) (Math.random() * färger.length)];
            andraKubFärgSatt7 = true;
            }
            g.setColor(andraKubFärg7);
            g.fillRect(slumpXAndra7, andraY7, kubSida, kubSida);
        }

           if (kub8Start.isRunning()) {
            if (!andraKubFärgSatt8) {
            andraKubFärg8 = färger[(int) (Math.random() * färger.length)];
            andraKubFärgSatt8 = true;
            }
            g.setColor(andraKubFärg8);
            g.fillRect(slumpXAndra8, andraY8, kubSida, kubSida);
        }

           if (kub9Start.isRunning()) {
            if (!andraKubFärgSatt9) {
            andraKubFärg9 = färger[(int) (Math.random() * färger.length)];
            andraKubFärgSatt9 = true;
            }
            g.setColor(andraKubFärg9);
            g.fillRect(slumpXAndra9, andraY9, kubSida, kubSida);
        }
        
            if (litenKub1Timer.isRunning()) {
            g.setColor(litenKubFärg1);
            g.fillRect(litenKubX, litenKubY, litenKubSida, litenKubSida);
            g.fillRect(litenKub2X, litenKub2Y, litenKubSida, litenKubSida);
            g.fillRect(litenKub3X, litenKub3Y, litenKubSida, litenKubSida);
            g.fillRect(litenKub4X, litenKub4Y, litenKubSida, litenKubSida);
        }

            if (litenKub2Timer.isRunning()) {
             g.setColor(litenKubFärg2);
            g.fillRect(litenKubX2, litenKubY2, litenKubSida, litenKubSida);
            g.fillRect(litenKub2X2, litenKub2Y2, litenKubSida, litenKubSida);
            g.fillRect(litenKub3X2, litenKub3Y2, litenKubSida, litenKubSida);
            g.fillRect(litenKub4X2, litenKub4Y2, litenKubSida, litenKubSida);
        }

    if (litenKub3Timer.isRunning()) {
    g.setColor(litenKubFärg3);
    g.fillRect(litenKubX3, litenKubY3, litenKubSida, litenKubSida);
    g.fillRect(litenKub2X3, litenKub2Y3, litenKubSida, litenKubSida);
    g.fillRect(litenKub3X3, litenKub3Y3, litenKubSida, litenKubSida);
    g.fillRect(litenKub4X3, litenKub4Y3, litenKubSida, litenKubSida);
}

if (litenKub4Timer.isRunning()) {
     g.setColor(litenKubFärg4);
    g.fillRect(litenKubX4, litenKubY4, litenKubSida, litenKubSida);
    g.fillRect(litenKub2X4, litenKub2Y4, litenKubSida, litenKubSida);
    g.fillRect(litenKub3X4, litenKub3Y4, litenKubSida, litenKubSida);
    g.fillRect(litenKub4X4, litenKub4Y4, litenKubSida, litenKubSida);
}

if (litenKub5Timer.isRunning()) {
     g.setColor(litenKubFärg5);
    g.fillRect(litenKubX5, litenKubY5, litenKubSida, litenKubSida);
    g.fillRect(litenKub2X5, litenKub2Y5, litenKubSida, litenKubSida);
    g.fillRect(litenKub3X5, litenKub3Y5, litenKubSida, litenKubSida);
    g.fillRect(litenKub4X5, litenKub4Y5, litenKubSida, litenKubSida);
}

if (litenKub6Timer.isRunning()) {
     g.setColor(litenKubFärg6);
    g.fillRect(litenKubX6, litenKubY6, litenKubSida, litenKubSida);
    g.fillRect(litenKub2X6, litenKub2Y6, litenKubSida, litenKubSida);
    g.fillRect(litenKub3X6, litenKub3Y6, litenKubSida, litenKubSida);
    g.fillRect(litenKub4X6, litenKub4Y6, litenKubSida, litenKubSida);
}

if (litenKub7Timer.isRunning()) {
     g.setColor(litenKubFärg7);
    g.fillRect(litenKubX7, litenKubY7, litenKubSida, litenKubSida);
    g.fillRect(litenKub2X7, litenKub2Y7, litenKubSida, litenKubSida);
    g.fillRect(litenKub3X7, litenKub3Y7, litenKubSida, litenKubSida);
    g.fillRect(litenKub4X7, litenKub4Y7, litenKubSida, litenKubSida);
}

if (litenKub8Timer.isRunning()) {
     g.setColor(litenKubFärg8);
    g.fillRect(litenKubX8, litenKubY8, litenKubSida, litenKubSida);
    g.fillRect(litenKub2X8, litenKub2Y8, litenKubSida, litenKubSida);
    g.fillRect(litenKub3X8, litenKub3Y8, litenKubSida, litenKubSida);
    g.fillRect(litenKub4X8, litenKub4Y8, litenKubSida, litenKubSida);
}

if (litenKub9Timer.isRunning()) {
     g.setColor(litenKubFärg9);
    g.fillRect(litenKubX9, litenKubY9, litenKubSida, litenKubSida);
    g.fillRect(litenKub2X9, litenKub2Y9, litenKubSida, litenKubSida);
    g.fillRect(litenKub3X9, litenKub3Y9, litenKubSida, litenKubSida);
    g.fillRect(litenKub4X9, litenKub4Y9, litenKubSida, litenKubSida);
}
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
                nerTryckt = true;

    

                if (skeppX + 10 >= slumpXAndra1 && skeppX + 10 <= slumpXAndra1 + 20) {
                    

                    if (!andraKubFärg1.equals(memoryLista.get(memoryListaRäknare)) && andraY1 > 40) {
                       omstart();
                    }

                    else if (andraKubFärg1.equals(memoryLista.get(memoryListaRäknare)) && andraY1 > 40) {

                    sättLitenKubX();
                    litenKub1Timer.start();
                    litenKubFärg1 = andraKubFärg1;
                    andraKubFärg1 = färger[(int) (Math.random() * färger.length)];
                    andraY1 = -20;
                    poäng++;
                    poängSkylt.setText(String.valueOf(poäng));
                    memoryListaRäknare++;

                    if (memoryListaRäknare >= memoryLista.size()) {
                        allaLitenKubExplodera();
                        Color nyFärg = färger[(int) (Math.random() * färger.length)];
                        memoryLista.add(nyFärg);
                        förstaFallTimer.start();
                        memoryListaRäknare = 0;
                        resetSlumpXFörsta();
                    }

                    }
                }

                    if (skeppX + 10 >= slumpXAndra2 && skeppX + 10 <= slumpXAndra2 + 20) {
                 

                    if (!andraKubFärg2.equals(memoryLista.get(memoryListaRäknare)) && andraY2 > 40) {
                        omstart();
                    }

                      else if (andraKubFärg2.equals(memoryLista.get(memoryListaRäknare)) && andraY2 > 40) {
                        sättLitenKubX2();
                        litenKub2Timer.start();
                        litenKubFärg2 = andraKubFärg2;
                        andraKubFärg2 = färger[(int) (Math.random() * färger.length)];
                        andraY2 = -20;
                        poäng++;
                        poängSkylt.setText(String.valueOf(poäng));

                          memoryListaRäknare++;

                    if (memoryListaRäknare >= memoryLista.size()) {
                        allaLitenKubExplodera();
                        Color nyFärg = färger[(int) (Math.random() * färger.length)];
                        memoryLista.add(nyFärg);
                        förstaFallTimer.start();
                        memoryListaRäknare = 0;
                        resetSlumpXFörsta();
                    }
                        
                    }
                }

                    if (skeppX + 10 >= slumpXAndra3 && skeppX + 10 <= slumpXAndra3 + 20) {

                    if (!andraKubFärg3.equals(memoryLista.get(memoryListaRäknare)) && andraY3 > 40) {
                        omstart();
                    }

                      else if (andraKubFärg3.equals(memoryLista.get(memoryListaRäknare)) && andraY3 > 40) {
                        sättLitenKubX3();
                        litenKub3Timer.start();
                        litenKubFärg3 = andraKubFärg3;
                        andraKubFärg3 = färger[(int) (Math.random() * färger.length)];
    
                        andraY3 = -20;
                        poäng++;
                        poängSkylt.setText(String.valueOf(poäng));

                          memoryListaRäknare++;

                    if (memoryListaRäknare >= memoryLista.size()) {
                        allaLitenKubExplodera();
                        Color nyFärg = färger[(int) (Math.random() * färger.length)];
                        memoryLista.add(nyFärg);
                        förstaFallTimer.start();
                        memoryListaRäknare = 0;
                        resetSlumpXFörsta();
                    }
                    }
                }

                    if (skeppX + 10 >= slumpXAndra4 && skeppX +10 <= slumpXAndra4 + 20) {
                 
                    if (!andraKubFärg4.equals(memoryLista.get(memoryListaRäknare)) && andraY4 > 40) {
                        omstart();
                    }

                      else if (andraKubFärg4.equals(memoryLista.get(memoryListaRäknare)) && andraY4 > 40) {
                        sättLitenKubX4();
                        litenKub4Timer.start();
                        litenKubFärg4 = andraKubFärg4;
                        andraKubFärg4 = färger[(int) (Math.random() * färger.length)];
                        andraY4 = -20;
                        poäng++;
                        poängSkylt.setText(String.valueOf(poäng));

                          memoryListaRäknare++;

                    if (memoryListaRäknare >= memoryLista.size()) {
                        allaLitenKubExplodera();
                        Color nyFärg = färger[(int) (Math.random() * färger.length)];
                        memoryLista.add(nyFärg);
                        förstaFallTimer.start();
                        memoryListaRäknare = 0;
                        resetSlumpXFörsta();
                    }
                    }
                }

                if (skeppX + 10 >= slumpXAndra5 && skeppX + 10 <= slumpXAndra5 + 20) {
                    
                    if (!andraKubFärg5.equals(memoryLista.get(memoryListaRäknare)) && andraY5 > 40) {
                        omstart();
                    }

                      else if (andraKubFärg5.equals(memoryLista.get(memoryListaRäknare)) && andraY5 > 40) {
                        
                        sättLitenKubX5();
                        litenKub5Timer.start();
                        litenKubFärg5 = andraKubFärg5;
                        andraKubFärg5 = färger[(int) (Math.random() * färger.length)];
                        andraY5 = -20;
                        poäng++;
                        poängSkylt.setText(String.valueOf(poäng));

                          memoryListaRäknare++;

                    if (memoryListaRäknare >= memoryLista.size()) {
                        allaLitenKubExplodera();
                        Color nyFärg = färger[(int) (Math.random() * färger.length)];
                        memoryLista.add(nyFärg);
                        förstaFallTimer.start();
                        memoryListaRäknare = 0;
                        resetSlumpXFörsta();
                    }
                    }
                }

            if (skeppX + 10 >= slumpXAndra6 && skeppX + 10 <= slumpXAndra6 + 20) {
                
                if (!andraKubFärg6.equals(memoryLista.get(memoryListaRäknare)) && andraY6 > 40) {
                    omstart();
                    }

                      else if (andraKubFärg6.equals(memoryLista.get(memoryListaRäknare)) && andraY6 > 40) {
                        sättLitenKubX6();
                        litenKub6Timer.start();
                        litenKubFärg6 = andraKubFärg6;
                        andraKubFärg6 = färger[(int) (Math.random() * färger.length)];
                        andraY6 = -20;
                        poäng++;
                        poängSkylt.setText(String.valueOf(poäng));

                          memoryListaRäknare++;

                    if (memoryListaRäknare >= memoryLista.size()) {
                        allaLitenKubExplodera();
                        Color nyFärg = färger[(int) (Math.random() * färger.length)];
                        memoryLista.add(nyFärg);
                        förstaFallTimer.start();
                        memoryListaRäknare = 0;
                        resetSlumpXFörsta();
                    }
                    }
            }

        
            if (skeppX + 10 >= slumpXAndra7 && skeppX + 10 <= slumpXAndra7 + 20) {
               
                if (!andraKubFärg7.equals(memoryLista.get(memoryListaRäknare)) && andraY7 > 40) {
                    omstart();
                    }

                      else if (andraKubFärg7.equals(memoryLista.get(memoryListaRäknare)) && andraY7 > 40) {
                        sättLitenKubX7();
                        litenKub7Timer.start();
                        litenKubFärg7 = andraKubFärg7;
                        andraKubFärg7 = färger[(int) (Math.random() * färger.length)];
                        andraY7 = -20;
                        poäng++;
                        poängSkylt.setText(String.valueOf(poäng));

                          memoryListaRäknare++;

                    if (memoryListaRäknare >= memoryLista.size()) {
                        allaLitenKubExplodera();
                        Color nyFärg = färger[(int) (Math.random() * färger.length)];
                        memoryLista.add(nyFärg);
                        förstaFallTimer.start();
                        memoryListaRäknare = 0;
                        resetSlumpXFörsta();
                    }
                    }
            }

         
            if (skeppX + 10 >= slumpXAndra8 && skeppX + 10 <= slumpXAndra8 + 20) {
    
                if (!andraKubFärg8.equals(memoryLista.get(memoryListaRäknare)) && andraY8 > 40) {
                    omstart();
                    }

                      else if (andraKubFärg8.equals(memoryLista.get(memoryListaRäknare)) && andraY8 > 40) {
        
                        sättLitenKubX8();
                        litenKub8Timer.start();
                        litenKubFärg8 = andraKubFärg8;
                        andraKubFärg8 = färger[(int) (Math.random() * färger.length)];
                        andraY8 = -20;
                        poäng++;
                        poängSkylt.setText(String.valueOf(poäng));

                          memoryListaRäknare++;

                    if (memoryListaRäknare >= memoryLista.size()) {
                        allaLitenKubExplodera();
                        Color nyFärg = färger[(int) (Math.random() * färger.length)];
                        memoryLista.add(nyFärg);
                        förstaFallTimer.start();
                        memoryListaRäknare = 0;
                        resetSlumpXFörsta();
                    }
                    }
            }

            if (skeppX + 10 >= slumpXAndra9 && skeppX + 10 <= slumpXAndra9 + 20) {
               

                if (!andraKubFärg9.equals(memoryLista.get(memoryListaRäknare)) && andraY9 > 40) {
                    omstart();
                    }

                      else if (andraKubFärg9.equals(memoryLista.get(memoryListaRäknare)) && andraY9 > 40) {
                        sättLitenKubX9();
                        litenKub9Timer.start();
                        litenKubFärg9 = andraKubFärg9;
                        andraKubFärg9 = färger[(int) (Math.random() * färger.length)];
                        andraY9 = -20;
                        poäng++;
                        poängSkylt.setText(String.valueOf(poäng));

                          memoryListaRäknare++;

                    if (memoryListaRäknare >= memoryLista.size()) {
                        allaLitenKubExplodera();
                        Color nyFärg = färger[(int) (Math.random() * färger.length)];
                        memoryLista.add(nyFärg);
                        förstaFallTimer.start();
                        memoryListaRäknare = 0;
                        resetSlumpXFörsta();
                    }
                    }
            }

            }

            revalidate();
            repaint();
        }

         @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                nerTryckt = false;
            repaint();
            revalidate();
        }
        }
    }
                

    class ActionLyssnare1 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            förstaY += 20;
            revalidate();
            repaint();
            
            if (förstaY >= getHeight() && rundorRäknare < memoryLista.size()) {
                förstaY = -20;
                rundorRäknare++;
                randomFärgFörsta = memoryLista.get(rundorRäknare - 1);
            }

            else if (förstaY >= getHeight()) {  
                förstaFallTimer.stop();
                startaAndraKuberna.start();
                rundorRäknare = 0;
            }
        } 
    }

    class ActionLyssnare2 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            kub1Start.start();
            kub2Start.start();
            kub3Start.start();
            kub4Start.start();
            kub5Start.start();
            kub6Start.start();
            kub7Start.start();
            kub8Start.start();
            kub9Start.start();
        }
    }

    class startaAndraKub1 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            andraY1 += 20;

            if (andraY1 > getHeight()) {
                andraY1 = -20;
                andraKubFärg1 = färger[(int) (Math.random() * färger.length)];
            }

            revalidate();
            repaint();
        }
    }

     class startaAndraKub2 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            andraY2 += 20;

             if (andraY2 > getHeight()) {
                andraY2 = -20;
                andraKubFärg2 = färger[(int) (Math.random() * färger.length)];
            }

            revalidate();
            repaint();
        }
    }

     class startaAndraKub3 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            andraY3 += 20;

             if (andraY3 > getHeight()) {
                andraY3 = -20;
                andraKubFärg3 = färger[(int) (Math.random() * färger.length)];
            }

            revalidate();
            repaint();
        }
    }

     class startaAndraKub4 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            andraY4 += 20;

             if (andraY4 > getHeight()) {
                andraY4 = -20;
                andraKubFärg4 = färger[(int) (Math.random() * färger.length)];
            }

            revalidate();
            repaint();
        }
    }

     class startaAndraKub5 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            andraY5 += 20;

             if (andraY5 > getHeight()) {
                andraY5 = -20;
                andraKubFärg5 = färger[(int) (Math.random() * färger.length)];
            }

            revalidate();
            repaint();
        }
    }

     class startaAndraKub6 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            andraY6 += 20;

             if (andraY6 > getHeight()) {
                andraY6 = -20;
                andraKubFärg6 = färger[(int) (Math.random() * färger.length)];
            }

            revalidate();
            repaint();
        }
    }

     class startaAndraKub7 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            andraY7 += 20;

             if (andraY7 > getHeight()) {
                andraY7 = -20;
                andraKubFärg7 = färger[(int) (Math.random() * färger.length)];
            }

            revalidate();
            repaint(); 
        }
    }

     class startaAndraKub8 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            andraY8 += 20;

             if (andraY8 > getHeight()) {
                andraY8 = -20;
                andraKubFärg8 = färger[(int) (Math.random() * färger.length)];
            }

            revalidate();
            repaint();
        }
    }

     class startaAndraKub9 implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            andraY9 += 20;

             if (andraY9 > getHeight()) {
                andraY9 = -20;
                andraKubFärg9 = färger[(int) (Math.random() * färger.length)];
            }

            revalidate();
            repaint();
        }
    }

    class LitenKub1Explodera implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kub1Explosion();
            
        }
    }

        class LitenKub2Explodera implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kub2Explosion();
        }
    }

    class LitenKub3Explodera implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kub3Explosion();
        }
    }

    class LitenKub4Explodera implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kub4Explosion();
        }
    }

    class LitenKub5Explodera implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kub5Explosion();
        }
    }

    class LitenKub6Explodera implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kub6Explosion();
        }
    }

    class LitenKub7Explodera implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kub7Explosion();
        }
    }

    class LitenKub8Explodera implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kub8Explosion();
        }
    }

    class LitenKub9Explodera implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kub9Explosion();
        }
    }

    
      public void resetSlumpXFörsta () {
        slumpXFörsta = (int) (Math.random() * getWidth());
        if (slumpXFörsta + 20 > getWidth()) {
            slumpXFörsta -= 20;
        }
    }


    public void sättLitenKubX () {
                    litenKubX = slumpXAndra1 - 10;
                    litenKubY = andraY1 - 10;
                    litenKub2X = slumpXAndra1 + 20;
                    litenKub2Y = andraY1 - 10;
                    litenKub3X = slumpXAndra1 - 10;
                    litenKub3Y = andraY1 + 20;
                    litenKub4X = slumpXAndra1 + 20;
                    litenKub4Y = andraY1 + 20;
    }

    public void sättLitenKubX2() {
        litenKubX2 = slumpXAndra2 - 10;
        litenKubY2 = andraY2 - 10;
        litenKub2X2 = slumpXAndra2 + 20;
        litenKub2Y2 = andraY2 - 10;
        litenKub3X2 = slumpXAndra2 - 10;
        litenKub3Y2 = andraY2 + 20;
        litenKub4X2 = slumpXAndra2 + 20;
        litenKub4Y2 = andraY2 + 20;
    }

    public void sättLitenKubX3() {
        litenKubX3 = slumpXAndra3 - 10;
        litenKubY3 = andraY3 - 10;
        litenKub2X3 = slumpXAndra3 + 20;
        litenKub2Y3 = andraY3 - 10;
        litenKub3X3 = slumpXAndra3 - 10;
        litenKub3Y3 = andraY3 + 20;
        litenKub4X3 = slumpXAndra3 + 20;
        litenKub4Y3 = andraY3 + 20;
    }

    public void sättLitenKubX4() {
        litenKubX4 = slumpXAndra4 - 10;
        litenKubY4 = andraY4 - 10;
        litenKub2X4 = slumpXAndra4 + 20;
        litenKub2Y4 = andraY4 - 10;
        litenKub3X4 = slumpXAndra4 - 10;
        litenKub3Y4 = andraY4 + 20;
        litenKub4X4 = slumpXAndra4 + 20;
        litenKub4Y4 = andraY4 + 20;
    }

    public void sättLitenKubX5() {
        litenKubX5 = slumpXAndra5 - 10;
        litenKubY5 = andraY5 - 10;
        litenKub2X5 = slumpXAndra5 + 20;
        litenKub2Y5 = andraY5 - 10;
        litenKub3X5 = slumpXAndra5 - 10;
        litenKub3Y5 = andraY5 + 20;
        litenKub4X5 = slumpXAndra5 + 20;
        litenKub4Y5 = andraY5 + 20;
    }

    public void sättLitenKubX6() {
        litenKubX6 = slumpXAndra6 - 10;
        litenKubY6 = andraY6 - 10;
        litenKub2X6 = slumpXAndra6 + 20;
        litenKub2Y6 = andraY6 - 10;
        litenKub3X6 = slumpXAndra6 - 10;
        litenKub3Y6 = andraY6 + 20;
        litenKub4X6 = slumpXAndra6 + 20;
        litenKub4Y6 = andraY6 + 20;
    }

    public void sättLitenKubX7() {
        litenKubX7 = slumpXAndra7 - 10;
        litenKubY7 = andraY7 - 10;
        litenKub2X7 = slumpXAndra7 + 20;
        litenKub2Y7 = andraY7 - 10;
        litenKub3X7 = slumpXAndra7 - 10;
        litenKub3Y7 = andraY7 + 20;
        litenKub4X7 = slumpXAndra7 + 20;
        litenKub4Y7 = andraY7 + 20;
    }

    public void sättLitenKubX8() {
        litenKubX8 = slumpXAndra8 - 10;
        litenKubY8 = andraY8 - 10;
        litenKub2X8 = slumpXAndra8 + 20;
        litenKub2Y8 = andraY8 - 10;
        litenKub3X8 = slumpXAndra8 - 10;
        litenKub3Y8 = andraY8 + 20;
        litenKub4X8 = slumpXAndra8 + 20;
        litenKub4Y8 = andraY8 + 20;
    }

    public void sättLitenKubX9() {
        litenKubX9 = slumpXAndra9 - 10;
        litenKubY9 = andraY9 - 10;
        litenKub2X9 = slumpXAndra9 + 20;
        litenKub2Y9 = andraY9 - 10;
        litenKub3X9 = slumpXAndra9 - 10;
        litenKub3Y9 = andraY9 + 20;
        litenKub4X9 = slumpXAndra9 + 20;
        litenKub4Y9 = andraY9 + 20;
    }

    public void kub1Explosion () {
        litenKub1N++;

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

            if (litenKub1N == 3) {
                litenKub1Timer.stop();
                litenKub1N = 0;
            }
    }

    public void kub2Explosion() {
    litenKub2N++;

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

    if (litenKub2N == 3) {
        litenKub2Timer.stop();
        litenKub2N = 0;
    }
}

    public void kub3Explosion() {
        litenKub3N++;

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

        if (litenKub3N == 3) {
            litenKub3Timer.stop();
            litenKub3N = 0;
        }
    }

    public void kub4Explosion() {
        litenKub4N++;

        revalidate();
        repaint();

        litenKubX4 -= 10;
        litenKubY4 -= 10;
        litenKub2X4 += 10;
        litenKub2Y4 -= 10;
        litenKub3X4 -= 10;
        litenKub3Y4 += 10;
        litenKub4X4 += 10;
        litenKub4Y4 += 10;

        if (litenKub4N == 3) {
            litenKub4Timer.stop();
            litenKub4N = 0;
        }
    }

    public void kub5Explosion() {
        litenKub5N++;

        revalidate();
        repaint();

        litenKubX5 -= 10;
        litenKubY5 -= 10;
        litenKub2X5 += 10;
        litenKub2Y5 -= 10;
        litenKub3X5 -= 10;
        litenKub3Y5 += 10;
        litenKub4X5 += 10;
        litenKub4Y5 += 10;

        if (litenKub5N == 3) {
            litenKub5Timer.stop();
            litenKub5N = 0;
        }
    }

    public void kub6Explosion() {
        litenKub6N++;

        revalidate();
        repaint();

        litenKubX6 -= 10;
        litenKubY6 -= 10;
        litenKub2X6 += 10;
        litenKub2Y6 -= 10;
        litenKub3X6 -= 10;
        litenKub3Y6 += 10;
        litenKub4X6 += 10;
        litenKub4Y6 += 10;

        if (litenKub6N == 3) {
            litenKub6Timer.stop();
            litenKub6N = 0;
        }
    }

    public void kub7Explosion() {
        litenKub7N++;

        revalidate();
        repaint();

        litenKubX7 -= 10;
        litenKubY7 -= 10;
        litenKub2X7 += 10;
        litenKub2Y7 -= 10;
        litenKub3X7 -= 10;
        litenKub3Y7 += 10;
        litenKub4X7 += 10;
        litenKub4Y7 += 10;

        if (litenKub7N == 3) {
            litenKub7Timer.stop();
            litenKub7N = 0;
        }
    }

    public void kub8Explosion() {
        litenKub8N++;

        revalidate();
        repaint();

        litenKubX8 -= 10;
        litenKubY8 -= 10;
        litenKub2X8 += 10;
        litenKub2Y8 -= 10;
        litenKub3X8 -= 10;
        litenKub3Y8 += 10;
        litenKub4X8 += 10;
        litenKub4Y8 += 10;

        if (litenKub8N == 3) {
            litenKub8Timer.stop();
            litenKub8N = 0;
        }
    }

    public void kub9Explosion() {
        litenKub9N++;

        revalidate();
        repaint();

        litenKubX9 -= 10;
        litenKubY9 -= 10;
        litenKub2X9 += 10;
        litenKub2Y9 -= 10;
        litenKub3X9 -= 10;
        litenKub3Y9 += 10;
        litenKub4X9 += 10;
        litenKub4Y9 += 10;

        if (litenKub9N == 3) {
            litenKub9Timer.stop();
            litenKub9N = 0;
        }
    }


    public void allaLitenKubExplodera () {
        sättLitenKubX();
        sättLitenKubX2();
        sättLitenKubX3();
        sättLitenKubX4();
        sättLitenKubX5();
        sättLitenKubX6();
        sättLitenKubX7();
        sättLitenKubX8();
        sättLitenKubX9();


        litenKub1Timer.start();
        litenKub2Timer.start();
        litenKub3Timer.start();
        litenKub4Timer.start();
        litenKub5Timer.start();
        litenKub6Timer.start();
        litenKub7Timer.start();
        litenKub8Timer.start();
        litenKub9Timer.start();

        andraY1 = -20;
        andraY2 = -20;
        andraY3 = -20;
        andraY4 = -20;
        andraY5 = -20;
        andraY6 = -20;
        andraY7 = -20;
        andraY8 = -20;
        andraY9 = -20;

        kub1Start.stop();
        kub2Start.stop();
        kub3Start.stop();
        kub4Start.stop();
        kub5Start.stop();
        kub6Start.stop();
        kub7Start.stop();
        kub8Start.stop();
        kub9Start.stop();
    }

    public void omstart () {
         allaLitenKubExplodera();
        JOptionPane.showMessageDialog(null, "Aj, aj, aj!");
        memoryListaRäknare = 0;
        memoryLista.clear();
        resetSlumpXFörsta();
        memoryLista.add(randomFärgFörsta);
        förstaFallTimer.start();
        nerTryckt = false;

        try {
                        poänglista.put(namn, poäng);
                        BufferedWriter writer = new BufferedWriter(new FileWriter("maxPoängMemory.txt"));

                        List<String> keys = new ArrayList<>(poänglista.keySet());

                        List<Map.Entry<String, Integer>> lista = new ArrayList<>(poänglista.entrySet());

                        Collections.sort(lista, (a, b) -> b.getValue() - a.getValue());

                        for (int i = 0; i < 5 && i < lista.size(); i++) {
                        writer.write(lista.get(i).getKey() + " " + lista.get(i).getValue());
                        writer.newLine();  
                        }
                        writer.close();  
                    }

                        catch (Exception ie) {}

                        poäng = 0;
        poängSkylt.setText(String.valueOf(poäng));


    }

    private boolean förstaFallTimerKördes = false;
    private boolean startaAndraKubernaKördes = false;

    private boolean kub1StartKördes = false;
    private boolean kub2StartKördes = false;
    private boolean kub3StartKördes = false;
    private boolean kub4StartKördes = false;
    private boolean kub5StartKördes = false;
    private boolean kub6StartKördes = false;
    private boolean kub7StartKördes = false;
    private boolean kub8StartKördes = false;
    private boolean kub9StartKördes = false;

    public void pause () {
        if (förstaFallTimer.isRunning()) {
            förstaFallTimerKördes = true;
            förstaFallTimer.stop();
        }

        if (startaAndraKuberna.isRunning()) {
            startaAndraKubernaKördes = true;
            startaAndraKuberna.stop();
        }

        if (kub1Start.isRunning()) {
            kub1StartKördes = true;
            kub1Start.stop();
        }

          if (kub2Start.isRunning()) {
            kub2StartKördes = true;
            kub2Start.stop();
        }

          if (kub3Start.isRunning()) {
            kub3StartKördes = true;
            kub3Start.stop();
        }

          if (kub4Start.isRunning()) {
            kub4StartKördes = true;
            kub4Start.stop();
        }

          if (kub5Start.isRunning()) {
            kub5StartKördes = true;
            kub5Start.stop();
        }

           if (kub6Start.isRunning()) {
            kub6StartKördes = true;
            kub6Start.stop();
        }

           if (kub7Start.isRunning()) {
            kub7StartKördes = true;
            kub7Start.stop();
        }

           if (kub8Start.isRunning()) {
            kub8StartKördes = true;
            kub8Start.stop();
        }

           if (kub9Start.isRunning()) {
            kub9StartKördes = true;
            kub9Start.stop();
        }
    }

    public void körIgen() {
        if (förstaFallTimerKördes) {
            förstaFallTimer.start();
        }

        if (startaAndraKubernaKördes) {
            startaAndraKuberna.start();
        }

        if (kub1StartKördes) {
            kub1Start.start();
        }

         if (kub2StartKördes) {
            kub2Start.start();
        }

         if (kub3StartKördes) {
            kub3Start.start();
        }

         if (kub4StartKördes) {
            kub4Start.start();
        }

         if (kub5StartKördes) {
            kub5Start.start();
        }

         if (kub6StartKördes) {
            kub6Start.start();
        }

         if (kub7StartKördes) {
            kub7Start.start();
        }

         if (kub8StartKördes) {
            kub8Start.start();
        }

         if (kub9StartKördes) {
            kub9Start.start();
        }
    }
}



