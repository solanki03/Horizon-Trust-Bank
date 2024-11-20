package Constants;

import java.awt.Color;

import java.sql.*;

public class CommonConstants {
    // color in hex values
    public static final Color TEXT_COLOR = Color.decode("#FFC300");
    public static final Color REG_COLOR = Color.decode("#900C3F");
    public static final Color PRIMARY_COLOR = Color.decode("#170F5C");

    Connection c;
    public Statement s;

    // MySql
    public CommonConstants() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atmManagementSystem", "root", "PWD#23#octo"); // add your mysql password                                                                                                             
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
