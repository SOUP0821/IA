/*
computation class to calculate budget
 */
package floorvisual;

import java.util.ArrayList;
import java.util.HashMap;

public class BudgetCalc
{

  //declaring variables
  private double sqft;
  private FloorGroup floorGroup;
  private String floorGroupName;

  private HashMap<String, ArrayList<FloorGroup>> hash_map_bysize = new HashMap<String, ArrayList<FloorGroup>>();

  //constructor
  public BudgetCalc(double sqft)
  {
    this.sqft = sqft;
    this.floorGroup = null;
    this.floorGroupName = null;
    process();
  }

  public String getName() //getter
  {
    return floorGroupName;
  }
  
   public void setName(String N) //setter
  {
    this.floorGroupName = N;
  }

  public FloorGroup getFloorGroup()
  {
    return floorGroup;
  }
  
   public void setFloorGroup(FloorGroup F)
  {
    this.floorGroup = F;
  }

  private void findBySize()
  {
    // find all floor plans with sqft smaller than input sqft
    for (String s : Floor.hash_map.keySet())
    {
      FloorGroup floorGroupTemp = Floor.hash_map.get(s).get(0);
      System.out.println("Current key: " + s); //Optional for better understanding

      if (floorGroupTemp.getSqft() <= this.sqft)
      {
        ArrayList<FloorGroup> floorGroups = new ArrayList<FloorGroup>();
        floorGroups.add(floorGroupTemp);
        // add all floors smaller than given size to hash map
        hash_map_bysize.put(s, floorGroups);
      }
    }
  }

  public void process()
  {
    findBySize(); // method go get sizes
    // goes through all possible floors and diplays best one
    for (String s : hash_map_bysize.keySet())
    {
      FloorGroup floorGroupTemp = hash_map_bysize.get(s).get(0);
      System.out.println("Current key: " + s); //Optional for better understanding

      if (floorGroup == null)
      {
        //System.out.println("1111 Current key: " + s);
        floorGroup = floorGroupTemp;
        floorGroupName = s;
      }
      //System.out.println("2222 floorGroupTemp price: " + floorGroupTemp.getFloorPrice() + "; floorGroup price: " + floorGroup.getFloorPrice());
      if (floorGroupTemp.getFloorPrice() < floorGroup.getFloorPrice()) // comapres sizes of floors
      {
        //System.out.println("3333 Current key: " + s);
        floorGroup = floorGroupTemp;
        floorGroupName = s;
      }
    }
  }

  public static void main(String[] args)
  {

  }
}
