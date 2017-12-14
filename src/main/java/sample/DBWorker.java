package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker {

    /**
     * JDBC Driver and database url
     *  User and Password
     */

    private final String URL ="jdbc:mysql://localhost:3306/Notices";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private Connection connection;
    //private Statement statement;

    public Connection getConnection() {
        return connection;
    }

    public DBWorker(){
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
