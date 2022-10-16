/*
Gets information of tiles from database
 */
package floorvisual;

import static java.lang.Double.parseDouble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TilesInfo
{
//declaring variables

  private double length;
  private double width;
  private String filePath;
  private double sqft;
  private double price;
  private String name;

  private void intialize(String filePath)
  {
    // declaring databse
    String dbName = "tileInfo";
    String tableName = "Tiles";
    String[] columnHeaders =
    {
      "tileName", "filePath", "tileDimensions", "tileSqft", "tilePricePerSqft"
    };

    try
    {
      JavaDatabase objDb = new JavaDatabase(dbName);
      Connection myDbConn = objDb.getDbConn();

      String dbQuery = "SELECT tileName, filePath, tileDimensions, tileSqft, tilePricePerSqft FROM Tiles WHERE filePath =?";
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      ps.setString(1, filePath);
      ResultSet rs = ps.executeQuery();

      while (rs.next())
      {
        this.name = rs.getString("tileName");
        this.filePath = filePath;
        String tempDim = rs.getString("tileDimensions");
        //splitting string into 2 seperates strings
        String parts[] = tempDim.split("x");
        //finding doubles in both the seperate strings
        Double num1 = parseDouble(parts[0]);
        Double num2 = parseDouble(parts[1]);
        num1 = num1 / 12;
        num2 = num2 / 12;
        this.length = num1;
        this.width = num2;
        this.sqft = num1 * num2;
        this.price = rs.getInt("tilePricePerSqft");
        break;
      }
    }
    catch (SQLException se)
    {
      System.out.println("Error updating data");
      se.printStackTrace(System.err);
    }
  }

  //constructor
  public TilesInfo(String filePath)
  {
    intialize(filePath);
  }

  public double getLength() //getter
  {
    return length;
  }

  public void setLength(double L) //setter
  {
    this.length = L;
  }
  
  public double getWidth() //getter
  {
    return width;
  }

   public void setWidth(double W) //setter
  {
    this.width = W;
  }
  
  public Double getGrout() //getter
  {
    return sqft;
  }
  
   public void setGrout(double G) //setter
  {
    this.sqft = G;
  }

  public String getFilePath() //getter
  {
    return filePath;
  }

   public void setFilePath(String fileP) //setter
  {
    this.filePath = fileP;
  }
  
  public double getPrice()//getter
  {
    return price;
  }
  
   public void setPrice(double P)//setter
  {
    this.price = P;
  }

  public static void main(String[] args)
  {
  }
}
