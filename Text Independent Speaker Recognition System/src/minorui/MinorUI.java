/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minorui;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Dell
 */
public class MinorUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (UnsupportedLookAndFeelException e) {
    // handle exception
} catch (ClassNotFoundException e) {
    // handle exception
} catch (InstantiationException e) {
    // handle exception
} catch (IllegalAccessException e) {
    // handle exception
}
        NewJFrame uiframe = new NewJFrame();
        uiframe.setVisible(true);
        // TODO code application logic here
    }
}
