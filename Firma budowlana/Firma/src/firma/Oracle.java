/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firma;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author student
 */
public class Oracle {
    private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    
    private static String DB = "jdbc:oracle:thin:@localhost:1521:test";
    private static String USER = "piotr1";
    private static String PASS = "piotr1234";
    
    private static Connection connection = null;
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}
