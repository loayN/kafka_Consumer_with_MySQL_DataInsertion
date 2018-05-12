kafka_Consumer_with_MySQL_DataInsertion

Author: Loay Naser 


the program is about a Kafka Consumer that listen for new updates
and insert them to MySQL DB 

update the "mysqlCoordinate.properties" as needed 
also the cmdString -> command string need to be change in *mysqlInsertProd.java* class

//String cmdString = "INSERT INTO info_tbl ( msg )" + "VALUES ('" + msg +"');";