package modelo;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    public Connection getConnection() {
        try {                     
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection("jdbc:mysql://localhost/uabteca",
                    "root", "mysql");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
