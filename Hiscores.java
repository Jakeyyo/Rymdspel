
import java.awt.BorderLayout;
import java.io.File;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hiscores extends JPanel {

private JLabel l1 = new JLabel();
private String namn = "";
private int poäng;
private StringBuilder sb = new StringBuilder();


public Hiscores () {
    add(l1, BorderLayout.CENTER);

    sb.append("<html>Classic Mode:<br>");

      try {
            Scanner scan = new Scanner(new File("maxPoängRymd.txt"));

            for (int i = 0; i < 5 && scan.hasNext(); i++) {
            sb.append(scan.next() + " " + scan.nextInt() + "<br>");
            scan.nextLine();
            
            }
        }

        catch (Exception e) {}

        sb.append("<br><br>Memory Mode:<br>");

         try {
            Scanner scan = new Scanner(new File("maxPoängMemory.txt"));

            for (int i = 0; i < 5 && scan.hasNext(); i++) {
            sb.append(scan.next() + " " + scan.nextInt() + "<br>");
            scan.nextLine();
            }
        }

        catch (Exception e) {}

        l1.setText(sb.toString());
}

public void sättScores () {
    sb.setLength(0);
    sb.append("<html>Classic Mode:<br>");

      try {
            Scanner scan = new Scanner(new File("maxPoängRymd.txt"));

            for (int i = 0; i < 5 && scan.hasNext(); i++) {
            sb.append(scan.next() + " " + scan.nextInt() + "<br>");
            scan.nextLine();
            
            }
        }

        catch (Exception e) {}

        sb.append("<br><br>Memory Mode:<br>");

         try {
            Scanner scan = new Scanner(new File("maxPoängMemory.txt"));

            for (int i = 0; i < 5 && scan.hasNext(); i++) {
            sb.append(scan.next() + " " + scan.nextInt() + "<br>");
            scan.nextLine();
            }
        }

        catch (Exception e) {}

        l1.setText(sb.toString());
}
    
}
