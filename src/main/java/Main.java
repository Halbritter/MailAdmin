import de.albritter.gui.WindowMain;
import de.albritter.utils.EventHandler;

import javax.swing.JOptionPane;

/**
 * Created by hhalbritter on 07.06.2016.
 */
public class Main {
    public static void main(String[] argv) {
        WindowMain w = new WindowMain();
        w.setVisible(true);
        w.setSize(600, 400);
        EventHandler.radioAdd();
        System.out.println(JOptionPane.showConfirmDialog(w, "Are you shure to delete id "));
        //l.setSize(300, 200);
        // l.setVisible(true);
        // f.setVisible(true);

    }
}
