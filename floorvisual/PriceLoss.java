/*
Calculates how much is money is lost and other important information
 */
package floorvisual;

import static java.lang.Double.parseDouble;

/**
 *
 * @author Saurya21
 */
public class PriceLoss
{

  //declaring variables
  private double floorW;
  private double floorL;
  private String tileDim;
  private double tileW;
  private double tileL;
  private double priceLoss;
  private double excessTile;
  private double floorPrice;
  private String layout;
  private double grout;
  private String labor;
  private TilesInfo tilesInfo = new TilesInfo(tileDim);

  //blank constructor
  public PriceLoss()
  {
    this.tileDim = "";
    this.grout = 0.0;
    this.floorW = 0.0;
    this.floorL = 0.0;
    this.priceLoss = 0.0;
    this.excessTile = 0.0;
    this.layout = "";
    this.floorPrice = 0.0;
    this.labor = "";
  }

  //constructor
  public PriceLoss(String tileDim, double floorW, double floorL, double grout, String labor)
  {
    this.tileDim = tileDim;
    this.tileW = tileW;
    this.tileL = tileL;
    this.grout = grout;
    this.floorW = floorW;
    this.floorL = floorL;
    this.priceLoss = priceLoss;
    this.excessTile = excessTile;
    this.floorPrice = floorPrice;
    this.labor = labor;
  }

  public double getTileW() //getter
  {
    return tileW;
  }

  public void setTileW(String tileDim) //setter
  {
    tileW = tilesInfo.getWidth();
  }

  public double getTileL()//getter
  {
    return tileL;
  }

  public void setTileL(String tileDim) //setter
  {
    tileL = tilesInfo.getLength();
  }

   public double getPrice()//getter
  {
    return floorPrice;
  }

  public void setPrice(double sqft, double tileSqft, String path) //setter
  {
    // gets price of floor by getting number of tiles and multiplying by price
    TilesInfo tilesInfo = new TilesInfo(tileDim);
    double tilePrice = tilesInfo.getPrice();
    this.floorPrice = (sqft/tileSqft)*tilePrice;
  }
  
  public double getExcessTile()//getter
  {
    return excessTile;
  }

  public void setExcessTile(double floorSqft, double tileSqft) //setter
  {
    // gets excess tiles by getting remaineder and adding to number of tiles * 10%
    this.excessTile = (floorSqft % tileSqft) + (floorSqft / tileSqft * 0.1);
  }

  public double getFloorL()//getter
  {
    return floorL;
  }

  public void setFloorL(double floorL) //setter
  {
    this.floorL = floorL;
  }

  public double getFloorW()//getter
  {
    return floorW;
  }

  public void setFloorW(double floorW) //setter
  {
    this.floorW = floorW;
  }

  public double getGrout()//getter
  {
    return grout;
  }

  public void setGrout(double grout) //setter
  {
    this.grout = grout;
  }

  public String getLabor()//getter
  {
    return labor;
  }

  public void setLabor(String labor) //setter
  {
    this.labor = labor;
  }

  public double getPriceLoss()//getter
  {
    return priceLoss;
  }

  public void setPriceLoss(double sqft, double tileSqft, String labor, String tileDim) //setter
  {
    // number of money lost including labor costs
    TilesInfo tilesInfo = new TilesInfo(tileDim);
    priceLoss = this.excessTile * tilesInfo.getPrice();

    if (labor.equals("High"))
    {
      this.priceLoss = (sqft / tileSqft) * 24;
    }
    else if (labor.equals("Med"))
    {
      this.priceLoss = (sqft / tileSqft) * 12;
    }
    else if (labor.equals("Low"))
    {
      this.priceLoss = (sqft / tileSqft) * 8;
    }
  }

  public static void main(String[] args)
  {
    double floorSqft = 100;
    double tileSqft = 2;
    PriceLoss pLoss = new PriceLoss("test.png", 10, 10, 0.125, "High");
    pLoss.setExcessTile(floorSqft, tileSqft);
    System.out.println(pLoss.getExcessTile());
    double test = (floorSqft % tileSqft) + (floorSqft / tileSqft * 0.1);
    System.out.println(test);
    pLoss.setPriceLoss(100, 2, "Med", "test.png");
    System.out.println(pLoss.getPriceLoss());
  }
}
