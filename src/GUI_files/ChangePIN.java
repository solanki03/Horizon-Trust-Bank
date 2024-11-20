package GUI_files;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import Constants.CommonConstants;

public class ChangePIN extends JFrame implements ActionListener{

    String pinNo;
    JPasswordField newPINTF,rePINTF;
    JButton changeButton, backButton;

    public ChangePIN(String pinNo){

        // set the size of the GUI
        setSize(900, 900);

        // set layout null to place components in the page
        setLayout(null);

        // set GUI in the center of the screen
        setLocationRelativeTo(null);

        // prevent any resize of our GUI
        setResizable(false);

        // configure GUI to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // remove the upper panel from the GUI ---> use Exit button to close the window
        setUndecorated(true);

        this.pinNo = pinNo;
        addComponents();
    }

    private void addComponents() {

        // add atm image to the frame
        ImageIcon atmLogo = new ImageIcon(ClassLoader.getSystemResource("Icons/atm_image.png"));
        Image img = atmLogo.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imgIcon = new ImageIcon(img);
        JLabel imglabel = new JLabel(imgIcon);
        imglabel.setBounds(0, 0, 900, 900);
        add(imglabel);

        // create a label to display msg
        JLabel textLabel = new JLabel("Change Your PIN");
        textLabel.setBounds(290, 200, 300, 30);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        imglabel.add(textLabel);

        // create a label to enter new pin
        JLabel newPINLabel = new JLabel("New PIN: ");
        newPINLabel.setBounds(200, 250, 180, 30);
        newPINLabel.setForeground(Color.WHITE);
        newPINLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        imglabel.add(newPINLabel);

        // create a JTextField to get new pin
        newPINTF = new JPasswordField();
        newPINTF.setBounds(375, 250, 130, 25);
        newPINTF.setFont(new Font("Arial", Font.BOLD, 15));
        imglabel.add(newPINTF);

        // create a label to re-enter new pin
        JLabel rePINLabel = new JLabel("Re-Enter New PIN: ");
        rePINLabel.setBounds(200, 290, 180, 30);
        rePINLabel.setForeground(Color.WHITE);
        rePINLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        imglabel.add(rePINLabel);

        // create a JTextField to re-enter new pin
        rePINTF = new JPasswordField();
        rePINTF.setBounds(375, 290, 130, 25);
        rePINTF.setFont(new Font("Arial", Font.BOLD, 15));
        imglabel.add(rePINTF);

        // create a button to change the existing pin
        changeButton = new JButton("CHANGE");
        changeButton.setBounds(375, 372, 130, 20);
        changeButton.setFont(new Font("Calibri", Font.BOLD, 13));
        changeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(changeButton);
        changeButton.addActionListener(this);

        // create a Back button
        backButton = new JButton("BACK");
        backButton.setBounds(375, 408, 130, 20);
        backButton.setFont(new Font("Calibri", Font.BOLD, 13));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(backButton);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        try {
            
            String Npin = new String(newPINTF.getPassword());
            String Repin = new String(rePINTF.getPassword());

            if(ae.getSource() == changeButton){

                if(Npin.isBlank()){
                    JOptionPane.showMessageDialog(null, "Please Enter the New PIN!");

                } else if(Repin.isBlank()){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter the New PIN!");

                } else {

                    // check whether new pin and re-entered pin are equal or not
                    if(!Npin.equals(Repin)){
                        JOptionPane.showMessageDialog(null, "Entered PIN Mismatched!");
    
                    } else {

                        CommonConstants cc = new CommonConstants();

                        // 3 tables contain pin number data. So, run 3 querries to update all 3 tables information
                        String query1 = "update Bank set PIN = '"+Repin+"' where PIN = '"+pinNo+"' ";
                        String query2 = "update login set PIN_Number = '"+Repin+"' where PIN_Number = '"+pinNo+"' ";
                        String query3 = "update signupThree set PIN_Number = '"+Repin+"' where PIN_Number = '"+pinNo+"' ";

                        cc.s.executeUpdate(query1);
                        cc.s.executeUpdate(query2);
                        cc.s.executeUpdate(query3);

                        JOptionPane.showMessageDialog(null, "PIN Changed Successfully!");

                        // close the current window and open ATM Transaction window
                        setVisible(false);
                        new AtmTransaction(Repin).setVisible(true);

                    }
                }

            } else if(ae.getSource() == backButton){

                // close the current window and open ATM Transaction window
                setVisible(false);
                new AtmTransaction(pinNo).setVisible(true);

            }

        } catch (Exception p) {
            p.printStackTrace();
        }
    }
    
}
