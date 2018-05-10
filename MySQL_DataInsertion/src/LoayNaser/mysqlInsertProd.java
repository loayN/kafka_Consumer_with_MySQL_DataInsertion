package LoayNaser;

import java.sql.Connection;

public class mysqlInsertProd {

    public static void start(String msg) {
        System.out.println( "connecting to Server..." );
        String serverIP = GetConfig.getConfig( "serverIP" );
        String username = GetConfig.getConfig( "username" );
        String password = GetConfig.getConfig( "password" );

       ServerCon con = new ServerCon( serverIP, username, password);
       Connection myConnection = con.Connect();



        //msg contain the consumer msg + time
        String cmdString = "INSERT INTO info_tbl ( msg )" + "VALUES ('" + msg +"');";
        QueryExc qe = new QueryExc( myConnection, cmdString );
        qe.Execute();
    }

}
