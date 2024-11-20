package GUI_files;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import Constants.CommonConstants;

public class SignUpPg2 extends JFrame implements ActionListener {

    JTextField PanNumTextField, AadhaarTextField;
    JButton nextButton;
    JComboBox<String> religionBox, CategoryBox, IncomeBox, EduBox, OccupationBox;
    JRadioButton YESbutton1, NObutton1, YESbutton2, NObutton2;
    String formno;

    public SignUpPg2(String formNo) {

        // set the tite of the game
        super("New Account Application Form - Page 2");

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

        this.formno = formNo;
        addComponents();
    }

    private void addComponents() {

        // create a additional details label
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setBounds(290, 80, 320, 30);
        additionalDetails.setForeground(CommonConstants.TEXT_COLOR);
        additionalDetails.setFont(new Font("Tahoma", Font.BOLD, 23));
        add(additionalDetails);

        // create a Religion label
        JLabel religionlabel = new JLabel("Religion:");
        religionlabel.setBounds(100, 150, 100, 30);
        religionlabel.setForeground(CommonConstants.TEXT_COLOR);
        religionlabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(religionlabel);

        // create a JCombobox for religion
        String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Others" };
        religionBox = new JComboBox<>(valReligion);
        religionBox.setBounds(300, 150, 400, 30);
        religionBox.setFont(new Font("Arial", Font.BOLD, 15));
        religionBox.setBackground(Color.WHITE);
        add(religionBox);

        // create a Category label
        JLabel categorylabel = new JLabel("Category:");
        categorylabel.setBounds(100, 200, 170, 30);
        categorylabel.setForeground(CommonConstants.TEXT_COLOR);
        categorylabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(categorylabel);

        // create a JCombobox for category
        String valCategory[] = { "General", "SC", "ST", "OBC", "Others" };
        CategoryBox = new JComboBox<>(valCategory);
        CategoryBox.setBounds(300, 200, 400, 30);
        CategoryBox.setFont(new Font("Arial", Font.BOLD, 15));
        CategoryBox.setBackground(Color.WHITE);
        add(CategoryBox);

        // create a Income label
        JLabel incomelabel = new JLabel("Income:");
        incomelabel.setBounds(100, 250, 170, 30);
        incomelabel.setForeground(CommonConstants.TEXT_COLOR);
        incomelabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(incomelabel);

        // create a JCombobox for Income
        String valIncome[] = { "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000" };
        IncomeBox = new JComboBox<>(valIncome);
        IncomeBox.setBounds(300, 250, 400, 30);
        IncomeBox.setFont(new Font("Arial", Font.BOLD, 15));
        IncomeBox.setBackground(Color.WHITE);
        add(IncomeBox);

        // create a Educational label
        JLabel educationalJLabel = new JLabel("Educational");
        educationalJLabel.setBounds(100, 300, 170, 30);
        educationalJLabel.setForeground(CommonConstants.TEXT_COLOR);
        educationalJLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(educationalJLabel);

        // create a Qualification label
        JLabel qualificationlabel = new JLabel("Qualification:");
        qualificationlabel.setBounds(100, 325, 170, 30);
        qualificationlabel.setForeground(CommonConstants.TEXT_COLOR);
        qualificationlabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(qualificationlabel);

        // create a JCombobox for Education
        String valEducation[] = { "Undergraduate", "Graduate", "Postgraduate", "Others" };
        EduBox = new JComboBox<>(valEducation);
        EduBox.setBounds(300, 315, 400, 30);
        EduBox.setFont(new Font("Arial", Font.BOLD, 15));
        EduBox.setBackground(Color.WHITE);
        add(EduBox);

        // create a Occupation label
        JLabel occupationlabel = new JLabel("Occupation:");
        occupationlabel.setBounds(100, 400, 170, 30);
        occupationlabel.setForeground(CommonConstants.TEXT_COLOR);
        occupationlabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(occupationlabel);

        // create a JCombobox for Occupation
        String valOccupation[] = { "Self-Employed", "Business", "Service", "Student", "Retired", "Others" };
        OccupationBox = new JComboBox<>(valOccupation);
        OccupationBox.setBounds(300, 400, 400, 30);
        OccupationBox.setFont(new Font("Arial", Font.BOLD, 15));
        OccupationBox.setBackground(Color.WHITE);
        add(OccupationBox);

        // create a PAN Number label
        JLabel PanNumlabel = new JLabel("PAN Number:");
        PanNumlabel.setBounds(100, 450, 170, 30);
        PanNumlabel.setForeground(CommonConstants.TEXT_COLOR);
        PanNumlabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(PanNumlabel);

        // create a JTextField to get PAN number
        PanNumTextField = new JTextField();
        PanNumTextField.setBounds(300, 450, 400, 30);
        PanNumTextField.setFont(new Font("Arial", Font.BOLD, 15));
        PanNumTextField.setMargin(new Insets(5, 3, 1, 3));
        add(PanNumTextField);

        // create a Aadhaar Number label
        JLabel adharNolabel = new JLabel("Aadhaar Number:");
        adharNolabel.setBounds(100, 500, 170, 30);
        adharNolabel.setForeground(CommonConstants.TEXT_COLOR);
        adharNolabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(adharNolabel);

        // create a JTextField to get Aadhaar Number
        AadhaarTextField = new JTextField();
        AadhaarTextField.setBounds(300, 500, 400, 30);
        AadhaarTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(AadhaarTextField);

        // create a Senior Citizen label
        JLabel seniorCitizenlabel = new JLabel("Senior Citizen:");
        seniorCitizenlabel.setBounds(100, 550, 170, 30);
        seniorCitizenlabel.setForeground(CommonConstants.TEXT_COLOR);
        seniorCitizenlabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(seniorCitizenlabel);

        // create a radio button for Senior Citizen
        YESbutton1 = new JRadioButton("YES");
        YESbutton1.setBounds(300, 550, 100, 30);
        YESbutton1.setFont(new Font("Arial", Font.BOLD, 15));
        YESbutton1.setForeground(CommonConstants.TEXT_COLOR);
        YESbutton1.setBackground(CommonConstants.REG_COLOR);
        add(YESbutton1);

        NObutton1 = new JRadioButton("NO");
        NObutton1.setBounds(450, 550, 120, 30);
        NObutton1.setFont(new Font("Arial", Font.BOLD, 15));
        NObutton1.setForeground(CommonConstants.TEXT_COLOR);
        NObutton1.setBackground(CommonConstants.REG_COLOR);
        add(NObutton1);

        // add fuctionality to select any one of the two options
        ButtonGroup SeniorSGroup = new ButtonGroup();
        SeniorSGroup.add(YESbutton1);
        SeniorSGroup.add(NObutton1);

        // create a Existing Account label
        JLabel existingAcclabel = new JLabel("Existing Account:");
        existingAcclabel.setBounds(100, 600, 170, 30);
        existingAcclabel.setForeground(CommonConstants.TEXT_COLOR);
        existingAcclabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(existingAcclabel);

        // create a radio button for Existing Account
        YESbutton2 = new JRadioButton("YES");
        YESbutton2.setBounds(300, 600, 100, 30);
        YESbutton2.setFont(new Font("Arial", Font.BOLD, 15));
        YESbutton2.setForeground(CommonConstants.TEXT_COLOR);
        YESbutton2.setBackground(CommonConstants.REG_COLOR);
        add(YESbutton2);

        NObutton2 = new JRadioButton("NO");
        NObutton2.setBounds(450, 600, 120, 30);
        NObutton2.setFont(new Font("Arial", Font.BOLD, 15));
        NObutton2.setForeground(CommonConstants.TEXT_COLOR);
        NObutton2.setBackground(CommonConstants.REG_COLOR);
        add(NObutton2);

        // add fuctionality to select any one of the two options
        ButtonGroup ExistingAccGroup = new ButtonGroup();
        ExistingAccGroup.add(YESbutton2);
        ExistingAccGroup.add(NObutton2);

        // CREATE A NEXT BUTTON
        nextButton = new JButton("NEXT");
        nextButton.setBounds(600, 680, 150, 26);
        nextButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(nextButton);

        // add ActionListener
        nextButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String Sreligion = (String) religionBox.getSelectedItem();
        String Scategory = (String) CategoryBox.getSelectedItem();
        String Sincome = (String) IncomeBox.getSelectedItem();
        String SEducation = (String) EduBox.getSelectedItem();
        String Soccupation = (String) OccupationBox.getSelectedItem();
        String seniorcitizen = null;

        // check which option is selected ---> Senior Citizen
        if (YESbutton1.isSelected()) {
            seniorcitizen = "Yes";
        } else if (NObutton1.isSelected()) {
            seniorcitizen = "No";
        }

        String existingAcc = null;

        // check which option is selected ---> Existing Account
        if (YESbutton2.isSelected()) {
            existingAcc = "Yes";
        } else if (NObutton2.isSelected()) {
            existingAcc = "No";
        }

        String Span = PanNumTextField.getText();
        String Saadhaar = AadhaarTextField.getText();

        try {
            if(!YESbutton1.isSelected() && !NObutton1.isSelected()){
                JOptionPane.showMessageDialog(null, "Please select your criteria from Senior Citizen field");
            } else if(!YESbutton2.isSelected() && !NObutton2.isSelected()){
                JOptionPane.showMessageDialog(null, "Please select your criteria from Existing Account field");
            }else if (Span.isBlank() || Saadhaar.isBlank()) {
                JOptionPane.showMessageDialog(null, "Please fill up all the fields");
            } else {
                // access the CommonConstants class and write the table query
                CommonConstants cc = new CommonConstants();
                String query = "insert into signupTwo values('" + formno + "','" + Sreligion + "','" + Scategory + "','" + Sincome
                        + "','" + SEducation + "','" + Soccupation + "','" + Span + "','" + Saadhaar + "','" + seniorcitizen + "','"
                        + existingAcc + "')";
                cc.s.executeUpdate(query);

                // load SignUpPg3 ---> Application Form 3
                setVisible(false);
                new SignUpPg3(formno).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
