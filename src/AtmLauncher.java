import javax.swing.SwingUtilities;

import GUI_files.LoginPage;

public class AtmLauncher {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                new LoginPage().setVisible(true);
            }
        });
    }
}
