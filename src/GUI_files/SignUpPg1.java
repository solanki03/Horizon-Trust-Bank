package GUI_files;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import Constants.CommonConstants;

public class SignUpPg1 extends JFrame implements ActionListener {

    int randomNum;
    JTextField userNameTextField, fNameTextField, dobTextField, emailTextField, cityTextField, pincodeTextField,
            stateTextField;
    JTextArea addressTextArea;
    JButton nextButton, backButton;
    JDateChooser dateSelect;
    JRadioButton male, female, transgender, married, unmarried, others;

    public SignUpPg1() {
        // set the tite of the game
        super("Application Form");

        // set the size of the GUI
        setSize(850, 800);

        // set layout null to place components in the page
        setLayout(null);

        // set GUI in the center of the screen
        setLocationRelativeTo(null);

        // prevent any resize of our GUI
        setResizable(false);

        // configure GUI to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // create the background color of GUI
        getContentPane().setBackground(CommonConstants.REG_COLOR);

        addComponents();
    }

    private void addComponents() {

        // generate a random form number
        randomNum = 1 + (int) (Math.random() * ((9999 - 1) + 1));

        // create a application form label
        JLabel formNo = new JLabel("APPLICATION FORM NO. " + randomNum);
        formNo.setBounds(170, 20, 540, 40);
        formNo.setForeground(CommonConstants.TEXT_COLOR);
        formNo.setFont(new Font("Tahoma", Font.BOLD, 35));
        formNo.setHorizontalAlignment(SwingConstants.CENTER);
        add(formNo);

        // add logo to the frame
        ImageIcon logo2 = new ImageIcon(ClassLoader.getSystemResource("Icons/regLogo.png"));
        Image img = logo2.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon imgIcon = new ImageIcon(img);
        JLabel imglabel = new JLabel(imgIcon);
        imglabel.setBounds(110, 15, 60, 60);
        add(imglabel);

        // create a personal details label
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setBounds(290, 80, 300, 30);
        personalDetails.setForeground(CommonConstants.TEXT_COLOR);
        personalDetails.setFont(new Font("Tahoma", Font.BOLD, 23));
        add(personalDetails);

        // create a username label
        JLabel userNamelabel = new JLabel("Name:");
        userNamelabel.setBounds(100, 150, 100, 30);
        userNamelabel.setForeground(CommonConstants.TEXT_COLOR);
        userNamelabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(userNamelabel);

        // create a JTextField to get username
        userNameTextField = new JTextField();
        userNameTextField.setBounds(300, 150, 400, 30);
        userNameTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(userNameTextField);

        // create a father's name label
        JLabel fNamelabel = new JLabel("Father's Name:");
        fNamelabel.setBounds(100, 200, 170, 30);
        fNamelabel.setForeground(CommonConstants.TEXT_COLOR);
        fNamelabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(fNamelabel);

        // create a JTextField to get father's name
        fNameTextField = new JTextField();
        fNameTextField.setBounds(300, 200, 400, 30);
        fNameTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(fNameTextField);

        // create a Date of Birth label
        JLabel DOBlabel = new JLabel("Date of Birth:");
        DOBlabel.setBounds(100, 250, 170, 30);
        DOBlabel.setForeground(CommonConstants.TEXT_COLOR);
        DOBlabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(DOBlabel);

        // create a calender for DOB
        dateSelect = new JDateChooser();
        dateSelect.setBounds(300, 250, 400, 30);
        dateSelect.setFont(new Font("Arial", Font.BOLD, 15));
        add(dateSelect);

        // create a gender label
        JLabel genderlabel = new JLabel("Gender:");
        genderlabel.setBounds(100, 300, 100, 30);
        genderlabel.setForeground(CommonConstants.TEXT_COLOR);
        genderlabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(genderlabel);

        // create a radio button for gender selection
        male = new JRadioButton("Male");
        male.setBounds(300, 300, 60, 30);
        male.setFont(new Font("Arial", Font.BOLD, 15));
        male.setForeground(CommonConstants.TEXT_COLOR);
        male.setBackground(CommonConstants.REG_COLOR);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(435, 300, 80, 30);
        female.setFont(new Font("Arial", Font.BOLD, 15));
        female.setForeground(CommonConstants.TEXT_COLOR);
        female.setBackground(CommonConstants.REG_COLOR);
        add(female);

        transgender = new JRadioButton("Transgender");
        transgender.setBounds(580, 300, 130, 30);
        transgender.setFont(new Font("Arial", Font.BOLD, 15));
        transgender.setForeground(CommonConstants.TEXT_COLOR);
        transgender.setBackground(CommonConstants.REG_COLOR);
        add(transgender);

        // add fuctionality to select any one of the three options - Male, Female &
        // Transgender
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(transgender);

        // create a Email label
        JLabel emaillabel = new JLabel("Email Address:");
        emaillabel.setBounds(100, 350, 170, 30);
        emaillabel.setForeground(CommonConstants.TEXT_COLOR);
        emaillabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(emaillabel);

        // create a JTextField to get email
        emailTextField = new JTextField();
        emailTextField.setBounds(300, 350, 400, 30);
        emailTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(emailTextField);

        // create a Marital Status label
        JLabel maritalStatuslabel = new JLabel("Marital Status:");
        maritalStatuslabel.setBounds(100, 400, 170, 30);
        maritalStatuslabel.setForeground(CommonConstants.TEXT_COLOR);
        maritalStatuslabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(maritalStatuslabel);

        // create a radio button for gMarital Status
        married = new JRadioButton("Married");
        married.setBounds(300, 400, 100, 30);
        married.setFont(new Font("Arial", Font.BOLD, 15));
        married.setForeground(CommonConstants.TEXT_COLOR);
        married.setBackground(CommonConstants.REG_COLOR);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 400, 120, 30);
        unmarried.setFont(new Font("Arial", Font.BOLD, 15));
        unmarried.setForeground(CommonConstants.TEXT_COLOR);
        unmarried.setBackground(CommonConstants.REG_COLOR);
        add(unmarried);

        others = new JRadioButton("Other");
        others.setBounds(630, 400, 80, 30);
        others.setFont(new Font("Arial", Font.BOLD, 15));
        others.setForeground(CommonConstants.TEXT_COLOR);
        others.setBackground(CommonConstants.REG_COLOR);
        add(others);

        // add fuctionality to select any one of the three options - married, unmarried
        // & other
        ButtonGroup MStatusGroup = new ButtonGroup();
        MStatusGroup.add(married);
        MStatusGroup.add(unmarried);
        MStatusGroup.add(others);

        // create a user address label
        JLabel addresslabel = new JLabel("Address:");
        addresslabel.setBounds(100, 450, 100, 30);
        addresslabel.setForeground(CommonConstants.TEXT_COLOR);
        addresslabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(addresslabel);

        // create a JTextField to get address
        addressTextArea = new JTextArea();
        addressTextArea.setBounds(300, 450, 400, 30);
        addressTextArea.setFont(new Font("Arial", Font.BOLD, 15));
        addressTextArea.setMargin(new Insets(5, 3, 1, 3));
        add(addressTextArea);

        // create a user city label
        JLabel citylabel = new JLabel("City:");
        citylabel.setBounds(100, 500, 100, 30);
        citylabel.setForeground(CommonConstants.TEXT_COLOR);
        citylabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(citylabel);

        // create a JTextField to get city
        cityTextField = new JTextField();
        cityTextField.setBounds(300, 500, 400, 30);
        cityTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(cityTextField);

        // create a user pincode label
        JLabel pincodelabel = new JLabel("Pin Code:");
        pincodelabel.setBounds(100, 550, 100, 30);
        pincodelabel.setForeground(CommonConstants.TEXT_COLOR);
        pincodelabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(pincodelabel);

        // create a JTextField to get pincode
        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300, 550, 400, 30);
        pincodeTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(pincodeTextField);

        // create a user state label
        JLabel statelabel = new JLabel("State:");
        statelabel.setBounds(100, 600, 100, 30);
        statelabel.setForeground(CommonConstants.TEXT_COLOR);
        statelabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(statelabel);

        // create a JTextField to get state
        stateTextField = new JTextField();
        stateTextField.setBounds(300, 600, 400, 30);
        stateTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(stateTextField);

        // CREATE A NEXT BUTTON
        nextButton = new JButton("NEXT");
        nextButton.setBounds(600, 680, 150, 26);
        nextButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(nextButton);
        nextButton.addActionListener(this);

        // CREATE A BACK BUTTON
        backButton = new JButton("BACK");
        backButton.setBounds(100, 680, 150, 26);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(backButton);
        backButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == backButton) {

            // close the current window and open Login page window
            setVisible(false);
            new LoginPage().setVisible(true);

        } else if (ae.getSource() == nextButton) {

            String formNo = "" + randomNum; // ""+ --> used to convert int/long values to string
            String name = userNameTextField.getText();
            String fname = fNameTextField.getText();
            String dob = ((JTextField) dateSelect.getDateEditor().getUiComponent()).getText();
            String gender = null;

            // check which gender is selected
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            } else if (transgender.isSelected()) {
                gender = "Transgender";
            }

            String email = emailTextField.getText();
            String maritalS = null;

            // check which married status is selected
            if (married.isSelected()) {
                maritalS = "Married";
            } else if (unmarried.isSelected()) {
                maritalS = "Unmarried";
            } else if (others.isSelected()) {
                maritalS = "Other";
            }

            String address = addressTextArea.getText();
            String city = cityTextField.getText();
            String state = stateTextField.getText();
            String pinCode = pincodeTextField.getText();

            try {
                if (name.isBlank() || fname.isBlank() || dob.isBlank() || email.isBlank() || address.isBlank()
                        || city.isBlank() || pinCode.isBlank() || state.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Please fill up all the fields!");
                } else {
                    // access the CommonConstants class and write the table query
                    CommonConstants cc = new CommonConstants();
                    String query = "insert into signup values('" + formNo + "','" + name + "','" + fname + "','" + dob
                            + "','" + gender + "','" + email + "','" + maritalS + "','" + address + "','" + city + "','"
                            + pinCode + "','" + state + "')";
                    cc.s.executeUpdate(query);

                    // load SignUpPg2 ---> Application Form 2
                    setVisible(false);
                    new SignUpPg2(formNo).setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
