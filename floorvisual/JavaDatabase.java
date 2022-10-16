/*
initializes database
*/

package floorvisual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JavaDatabase
{
  private String dbName;
  private Connection dbConn;
  private ArrayList<ArrayList<String>> data;

  public JavaDatabase()
  {
    dbName = "";
    dbConn = null;
    data = null;
  }

  public JavaDatabase(String dbName)
  {
    setDbName(dbName);
    setDbConn();
    data = null;
  }

  public String getDbName()
  {
    return dbName;
  }

  public void setDbName(String dbName)
  {
    this.dbName = dbName;
  }

  public Connection getDbConn()
  {
    return dbConn;
  }

  public void setDbConn()
  {
    String connectionURL = "jdbc:derby:" + this.dbName;
    this.dbConn = null;
    try
    {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      this.dbConn = DriverManager.getConnection(connectionURL);
    }
    catch (ClassNotFoundException ex)
    {
      System.out.println("Driver not found, check Library");
    }
    catch (SQLException se)
    {
      System.out.println("SQL Connection error!");
    }
  }

  public void closeDbConn()
  {
    try
    {
      this.dbConn.close();
    }
    catch (Exception err)
    {
      System.out.println("DB closing error.");
    }
  }

  public ArrayList<ArrayList<String>> getData(String tableName, String[] tableHeaders)
  {
    int columnCount = tableHeaders.length;
    Statement s = null;
    ResultSet rs = null;
    String dbQuery = "SELECT * FROM " + tableName;
    this.data = new ArrayList<>();
    // read the data
    try
    {
      // send the query and receive data
      s = this.dbConn.createStatement();
      rs = s.executeQuery(dbQuery);

      // read the data using rs and store in ArrayList data
      while (rs.next())
      {
        // row object to hold one row data
        ArrayList<String> row = new ArrayList<>();
        // go through the row and read each cell
        for (int i = 0; i < columnCount; i++)
        {
          String cell = rs.getString(tableHeaders[i]);
          row.add(cell);
        }
        this.data.add(row);
      }
    }
    catch (SQLException se)
    {
      System.out.println("SQL Error: Not able to get data");
    }
    return data;
  }

  public void setData(ArrayList<ArrayList<String>> data)
  {
    this.data = data;
  }

  public void createDb(String newDbName)
  {
    setDbName(newDbName);
    // create a db if not existing
    String connectionURL = "jdbc:derby:" + this.dbName
        + ";create=true";
    this.dbConn = null;
    try
    {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      this.dbConn = DriverManager.getConnection(connectionURL);
      System.out.println("New Database " + this.dbName + " created!");
    }
    catch (ClassNotFoundException ex)
    {
      System.out.println("Driver not found, check library");
    }
    catch (SQLException se)
    {
      System.out.println("SQL Connection error, Db was not created!");
    }
  }

  public void createTable(String newTable, String dbName)
  {
    System.out.println(newTable);
    setDbName(dbName);
    setDbConn();
    Statement s;
    try
    {
      s = this.dbConn.createStatement();
      s.execute(newTable);
      System.out.println("New table created!");
      this.dbConn.close();
    }
    catch (SQLException se)
    {
      System.out.println("Error creating table " + newTable);
    }
  }
// to conver a 2d arraylist to 2d array:
  public Object[][] to2dArray(ArrayList<ArrayList<String>> data)
  {
    if (data.size() == 0) // empty table
    {
      Object[][] dataList = new Object[0][0];
      return dataList;
    }
    else // table w existing data
    {
      int columnCount = data.get(0).size(); // number of columns
      Object[][] dataList = new Object[data.size()][columnCount];
      // read each cell of each row into array
      for (int r = 0; r < data.size(); r++)
      {
        ArrayList<String> row = data.get(r); // get the row
        for (int c = 0; c < columnCount; c++)
        {
          dataList[r][c] = row.get(c); // get the cell
        }
      }
      return dataList;
    }
  }

  public static void main(String[] args)
  {
    // db info
    String dbName = "tileInfo";
    String tableName = "Tiles";
    String[] columnNames = {"tileName", "filePath", "tileDimensions", "tileSqft", "tilePricePerSqft"};
    String dbQuery = "INSERT INTO tileInfo VALUES (?,?,?,?,?)";
    
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    
    // data to be entered (to be replaced with textfields in GUI)
    String tileName = "Marble";
    String filePath = "test";
    String tileDimensions = "12 x 24";
    int tileSqft = 2;
    int tilePricePerSqft = 4;

    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setString(1, tileName);
      ps.setString(2, filePath);
      ps.setString(3, tileDimensions);
      ps.setInt(4, tileSqft);
      ps.setInt(5, tilePricePerSqft);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data inserted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error inserting data");
    }
    // read the data from database
    ArrayList<ArrayList<String>> myData = objDb.getData(tableName, columnNames);
    System.out.println(myData);
  }
}