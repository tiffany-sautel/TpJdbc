package fr.univ_amu.iut;

import java.sql.*;

/**
 * Created by s16004678 on 25/09/17.
 */
public class ConnexionUnique {
    private Connection connection;
    private static ConnexionUnique instance = null;
    private static final String CONNECT_URL = "jdbc:mysql://mysql-tiff2983.alwaysdata.net:3306/tiff2983_jdbc1";
    private static final String LOGIN = "tiff2983_user1";
    private static final String PASSWORD = "bball";

    private ConnexionUnique(){
        try {
            connection = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){return connection;}

    public static ConnexionUnique getInstance(){
        if(instance == null)
            instance = new ConnexionUnique();
        return instance;
    }
}
