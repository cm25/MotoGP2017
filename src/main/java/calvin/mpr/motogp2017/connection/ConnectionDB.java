/*
 * [Copyrights by Calvin Mampioper - Tangerang Selatan, Ciputat 2017]
 * [Telp/HP : 081353000852, 081322631783]
 * [visit   : www.biriosisoftware.com]
 */
package calvin.mpr.motogp2017.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Calvin Mampioper
 */
public class ConnectionDB {

    private static Connection connection = null;

    public static Connection getConnectionDB() {
        if (connection != null) {
            return connection;
        } else {
            try {

                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/web_motogp";
                String user = "cm25";
                String password = "cm25";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex);
            }
            return connection;
        }

    }
}
