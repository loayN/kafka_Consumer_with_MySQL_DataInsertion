package LoayNaser;

import java.sql.*;

public class QueryExc {
    private Connection connection;
    private String query;
    QueryExc(Connection myConnection, String insertedQuery) {
        this.connection = myConnection;
        this.query = insertedQuery;
    }

    protected void Execute() {

        //create a statment
        Statement myStatement = null;
        try {
            myStatement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println( "class QueryExc ERROR:"+e.getMessage() );
            //e.printStackTrace();
        }

        try {

            myStatement.execute( query );
            /*ResultSet rs = myStatement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("\nthe inserted query is: "+ query + "\nthe result:");
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(" ,  ");
                    String columnValue = rs.getString(i);
                    System.out.print(rsmd.getColumnName(i) + " => " +columnValue  );
                }
                System.out.println("");
            }*/
        }catch (Exception e){
            System.out.println( e.getMessage() );
        }
    }
}