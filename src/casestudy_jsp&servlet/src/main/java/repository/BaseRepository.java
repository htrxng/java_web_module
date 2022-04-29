package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private final String jdbcUrl = "jdbc:mysql://localhost:3306/furama_manager_1";
    private String username = "root";
    private String password = "codegym";
    private Connection connection;
    
    public BaseRepository() {}

    public Connection getConnectionJavaToDataBase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
