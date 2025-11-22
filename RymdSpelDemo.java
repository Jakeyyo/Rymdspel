
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class RymdSpelDemo extends JFrame {
    private RymdSpel spel = new RymdSpel();
    private MemorySpel memorySpel = new MemorySpel(spel.läsNamn());
    private Hiscores hiscores = new Hiscores();
    private JMenuBar mb = new JMenuBar();
    private JMenu m = new JMenu("Mode");
    private JMenu m2 = new JMenu("Hiscores");
    private JMenuItem item1 = new JMenuItem("Classic Mode");
    private JMenuItem item2 = new JMenuItem("Memory Mode");
    private JMenuItem item3 = new JMenuItem("Hiscores");
    private JMenuItem item4 = new JMenuItem("Uppdatera Hiscores");

    private ActionLyssnare a = new ActionLyssnare();
    

    public RymdSpelDemo () {
        item1.addActionListener(a);
        item2.addActionListener(a);
        item3.addActionListener(a);
        item4.addActionListener(a);
        m.add(item1);
        m.add(item2);
        mb.add(m);
        setJMenuBar(mb);
        m2.add(item3);
        m2.add(item4);
        mb.add(m2);
        spel.setPreferredSize(new Dimension(600, 540));
        memorySpel.setPreferredSize(new Dimension(600, 540));
        hiscores.setPreferredSize(new Dimension(600, 540));
        add(spel, BorderLayout.CENTER);
        memorySpel.pause();
        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        RymdSpelDemo r = new RymdSpelDemo();
    }

    class ActionLyssnare implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            if (e.getSource() == item1) {
                remove(memorySpel);
                remove(hiscores);
                add(spel, BorderLayout.CENTER);
                memorySpel.pause();
                spel.körIgen();
                spel.requestFocus();
            
            }

            if (e.getSource() == item2) {
                remove(spel);
                remove(hiscores);
                spel.pause();
                add(memorySpel, BorderLayout.CENTER);
                memorySpel.körIgen();
                memorySpel.requestFocus();
            }

            if (e.getSource() == item3) {
                remove(spel);
                remove(memorySpel);
                memorySpel.pause();
                spel.pause();
                add(hiscores, BorderLayout.CENTER);
            }

            if (e.getSource() == item4) {
                hiscores.sättScores();
        
            }

            revalidate();
            repaint();
        }
    }
}
