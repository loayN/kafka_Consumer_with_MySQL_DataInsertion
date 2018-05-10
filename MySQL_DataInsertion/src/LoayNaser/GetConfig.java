package LoayNaser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class GetConfig {

    protected static String getConfig(String Choose) {
        String result = null;
        Properties prop = new Properties();
        InputStream input = null;
        try {
            if (new File( "mysqlCoordinate.properties"  ).exists()) {
                input = new FileInputStream( "mysqlCoordinate.properties" );
                // load a properties file
                prop.load( input );
                // get the property value and print it out
                result = String.valueOf( prop.getProperty( Choose ) );
            }
            //return result;


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}