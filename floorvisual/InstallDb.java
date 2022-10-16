/*
 Installs Database
 */
package floorvisual;

public class InstallDb
{
   public static void main(String[] args)
    {
        String dbName = "tileInfo";
        // Creating an Object of DB class
        JavaDatabase objDb = new JavaDatabase();
        //creating a new databse
        objDb.createDb(dbName);
        
        //creating a new table
        String newTable = "CREATE TABLE Tiles (tileName varchar(255), filePath varchar(255), tileDimensions varchar(255), "
                + "tileSqft double, tilePricePerSqft int)";
        objDb.createTable(newTable, dbName);
    }
    
}