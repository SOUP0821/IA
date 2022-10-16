/*
used to find the sqft per tile
 */
package floorvisual;

import static java.lang.Double.parseDouble;


public class TileSqft
{

  //declaring variables
  private String dim;
  private Double result;

  //blank constructor
  public TileSqft()
  {
    this.dim = "";
    this.result = 0.0;
  }

  //constructor
  public TileSqft(String dim)
  {
    this.dim = dim;
    this.result = 0.0;
  }

  public String getDim() //getter
  {
    return dim;
  }

  public void setDim(String dim) //setter
  {
    this.dim = dim;
  }

  public Double getResult()//getter
  {
    return result;
  }

  public void setResult() //setter
  {
    //splitting string into 2 seperates strings
    String parts[] = this.dim.split("x");
    //finding doubles in both the seperate strings
    Double num1 = parseDouble(parts[0]);
    Double num2 = parseDouble(parts[1]);
    //actual calculation of string
    this.result = (num1 * num2)/144;
    //rounding answer
    this.result = Math.round(result*100.0)/100.0;
  }

  public static void main(String[] args)
  {
    
   TileSqft objectAdd = new TileSqft("12x24");
   objectAdd.setResult();
   System.out.println("the sqft is : " + objectAdd.getResult());

  }
}
