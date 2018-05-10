package LoayNaser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerCon {

    private String choosen, username, password;

    protected ServerCon(String chosen, String username, String password){
        this.choosen = chosen;
        this.username = username;
        this.password = password;
    }


    protected Connection Connect() {

        try {
            String dburl = "jdbc:mysql://"+ choosen +":3306/the_name_of_the_DB"; //replace the BD name with ur own
            //get connection
            return (DriverManager.getConnection( dburl, username, password ));

            } catch (SQLException e) {
            System.out.println( "connection failed .... " );
            System.exit( 0 );
            //e.printStackTrace();
        }
        return null;
    }
}