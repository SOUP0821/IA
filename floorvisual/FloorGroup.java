/*
Object to get information needed from floor group
 */
package floorvisual;

/**
 *
 * @author Saurya21
 */
public class FloorGroup
{
    //declaring variables
  private double priceLoss;
  private double sqft;
  private double price;
  private double excessTile;

  //blank constructor
  public FloorGroup()
  {
    this.priceLoss = 0.0;
    this.sqft = 0.0;
    this.price = 0.0;
    this.excessTile = 0.0;
  }

  //constructor
  public FloorGroup(double priceLoss, double sqft, double floorPrice, double excessTile) // all values stored
  {
    this.priceLoss = priceLoss;
    this.sqft = sqft;
    this.price = floorPrice;
    this.excessTile = excessTile;
  }
  
  public double getPriceLoss() //getter
  {
    return priceLoss;
  }

  public void setPriceLoss(double priceLoss) //setter
  {
    this.priceLoss = priceLoss;
  }
  
  public double getSqft() //getter
  {
    return sqft;
  }

  public void setSqft(double sqft) //setter
  {
    this.sqft = sqft;
  }
  
  public double getFloorPrice() //getter
  {
    return price;
  }

  public void setFloorPrice(double floorPrice) //setter
  {
    this.price = floorPrice;
  }
  
  public double getExcessTile() //getter
  {
    return excessTile;
  }

  public void setExcessTile(double excessTile) //setter
  {
    this.excessTile = excessTile;
  }
  
  @Override
   public String toString()
  {//overriding the toString() method  
    return priceLoss + " " + sqft + " " + price + " " + excessTile;
  }

}
