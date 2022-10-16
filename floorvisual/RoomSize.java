/*
Used to calculate room size and number of rows and cols
 */
package floorvisual;

public class RoomSize
{

  //declaring variables
  private double floorLength;
  private double floorWidth;
  private String filePath;
  private double grout;
  private double tileRows;
  private double tileColumns;
  private TilesInfo tilesInfo;

  //blank constructor
  public RoomSize()
  {
    this.floorWidth = 0.0;
    this.floorLength = 0.0;
    this.filePath = "";
    this.grout = 0.0;
    this.tileRows = 0.0;
    this.tileColumns = 0.0;
  }

  //constructor
  public RoomSize(double floorLength, double floorWidth, String filePath, double grout)
  {
    this.floorLength = floorLength;
    this.floorWidth = floorWidth;
    this.filePath = filePath;
    this.grout = grout;
    this.tilesInfo = new TilesInfo(filePath);
    this.tileRows = (floorWidth/(tilesInfo.getWidth()+grout));
    this.tileColumns = (floorLength/(tilesInfo.getLength()+grout));
  }
  

  public double getFloorLength() //getter
  {
    return floorLength;
  }
  
  public double getFloorWidth() //getter
  {
    return floorWidth;
  }
  
  public Double getGrout() //getter
  {
    return grout;
  }
  
  public String getFilePath() //getter
  {
    return filePath;
  }

  public double getTileRows()//getter
  {
    return tileRows;
  }

   public double getTileColumns()//getter
  {
    return tileColumns;
  }

  public static void main(String[] args)
  {
    
  }
}
