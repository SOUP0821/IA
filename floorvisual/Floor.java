/*
Floor frame is main frame that lets user create floor
 */
package floorvisual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import static java.lang.Integer.parseInt;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Floor extends JFrame implements ActionListener, ItemListener
{
//declaring variables

  private TileDesigner designer1 = new TileDesigner();
  private TileDesigner designer2 = new TileDesigner();
  private TileDesigner designer3 = new TileDesigner();
  private TileDesigner designer4 = new TileDesigner();
  private TileDesigner designer5 = new TileDesigner();
  private PriceLoss priceLoss;
  private TilesInfo tilesInfo;
  private int groutN = 0;
  private int layout = 0;
  private String laborCost;
  private JPanel buttonPanel;
  private JPanel insertPanel;
  private JLabel groutLabel;
  private JLabel laborLabel;
  private JLabel layoutsLabel;
  private JTextField roomSizeFieldL;
  private JLabel roomSizeLabelL;
  private JTextField roomSizeFieldW;
  private JLabel roomSizeLabelW;
  private JTextField tilePathField;
  private JLabel tilePathLabel;
  private JTextField tilePathField2;
  private JLabel tilePathLabel2;
  private JTextField floorGroupField;
  private JLabel floorGroupLabel;
  private JButton updateButton;
  private JButton budgetButton;
  private JButton infoButton;
  private JButton addButton;
  private JButton deleteButton;
  private JButton exitButton;
  private JButton helpButton;
  private JButton displayButton;
  private JButton insertButton;
  private JButton createButton;
  private JButton compareButton;
  private JButton closeButton;
  public static HashMap<String, ArrayList<FloorGroup>> hash_map = new HashMap<String, ArrayList<FloorGroup>>();

  private JComboBox<String> grout;
  private String[] groutArray =
  {
    "1/4", "1/8", "1/16"
  };
  private JComboBox<String> layouts;
  private String[] layoutsArray =
  {
    "Layout 1", "Layout 2", "Layout 3", "Layout 4", "Layout 5"
  };
  private JComboBox<String> labor;
  private String[] laborArray =
  {
    "Low", "Medium", "High"
  };

  private JComboBox<String> floorPlans;
  private String[] floorPlansArray =
  {
  };

  public Floor(String name)
  {
    //constructing frame
    super(name);
    this.setBounds(0, 80, 500, 500);
    this.getContentPane().setBackground(Welcome.BACK);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());

    // constructing comboboxes
    grout = new JComboBox<>(groutArray);
    grout.setSelectedItem(groutArray[0]);
    grout.addItemListener(this);
    grout.setBackground(Welcome.BACK);
    grout.setFont(new Font("Futura", Font.BOLD, 24));
    grout.setForeground(Welcome.TEXT_COLOR);
    this.groutLabel = new JLabel("GROUT ");
    groutLabel.setFont(Welcome.MAIN_FONT);
    groutLabel.setForeground(Welcome.TEXT_COLOR);

    labor = new JComboBox<>(laborArray);
    labor.addItemListener(this);
    labor.setBackground(Welcome.BACK);
    labor.setFont(new Font("Futura", Font.BOLD, 24));
    labor.setForeground(Welcome.TEXT_COLOR);
    this.laborLabel = new JLabel("LABOR COST ");
    laborLabel.setFont(Welcome.MAIN_FONT);
    laborLabel.setForeground(Welcome.TEXT_COLOR);

    layouts = new JComboBox<>(layoutsArray);
    layouts.setSelectedItem(layoutsArray[0]);
    layouts.addItemListener(this);
    layouts.setBackground(Welcome.BACK);
    layouts.setFont(new Font("Futura", Font.BOLD, 24));
    layouts.setForeground(Welcome.TEXT_COLOR);
    this.layoutsLabel = new JLabel("LAYOUTS ");
    layoutsLabel.setFont(Welcome.MAIN_FONT);
    layoutsLabel.setForeground(Welcome.TEXT_COLOR);

    // constructing and defining data field and label
    this.tilePathField = new JTextField(5);
    tilePathField.setFont(Welcome.MAIN_FONT);
    tilePathField.setForeground(Welcome.TEXT_COLOR);
    tilePathField.setBackground(Welcome.BACK);
    tilePathField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.tilePathLabel = new JLabel("TILE PATH ");
    tilePathLabel.setFont(Welcome.MAIN_FONT);
    tilePathLabel.setForeground(Welcome.TEXT_COLOR);

    this.tilePathField2 = new JTextField(5);
    tilePathField2.setFont(Welcome.MAIN_FONT);
    tilePathField2.setForeground(Welcome.TEXT_COLOR);
    tilePathField2.setBackground(Welcome.BACK);
    tilePathField2.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.tilePathLabel2 = new JLabel("TILE PATH 2 ");
    tilePathLabel2.setFont(Welcome.MAIN_FONT);
    tilePathLabel2.setForeground(Welcome.TEXT_COLOR);

    this.floorGroupField = new JTextField(5);
    floorGroupField.setFont(Welcome.MAIN_FONT);
    floorGroupField.setForeground(Welcome.TEXT_COLOR);
    floorGroupField.setBackground(Welcome.BACK);
    floorGroupField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.floorGroupLabel = new JLabel("FLOOR PLAN # ");
    floorGroupLabel.setFont(Welcome.MAIN_FONT);
    floorGroupLabel.setForeground(Welcome.TEXT_COLOR);
    floorGroupField.setText("0");

    // constructing and defining data field and label
    this.roomSizeFieldL = new JTextField(5);
    roomSizeFieldL.setFont(Welcome.MAIN_FONT);
    roomSizeFieldL.setForeground(Welcome.TEXT_COLOR);
    roomSizeFieldL.setBackground(Welcome.BACK);
    roomSizeFieldL.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.roomSizeLabelL = new JLabel("ROOM LENGTH ");
    roomSizeLabelL.setFont(Welcome.MAIN_FONT);
    roomSizeLabelL.setForeground(Welcome.TEXT_COLOR);

    this.roomSizeFieldW = new JTextField(5);
    roomSizeFieldW.setFont(Welcome.MAIN_FONT);
    roomSizeFieldW.setForeground(Welcome.TEXT_COLOR);
    roomSizeFieldW.setBackground(Welcome.BACK);
    roomSizeFieldW.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.roomSizeLabelW = new JLabel("ROOM WIDTH ");
    roomSizeLabelW.setFont(Welcome.MAIN_FONT);
    roomSizeLabelW.setForeground(Welcome.TEXT_COLOR);

    // defining and constructing buttons
    this.deleteButton = new JButton("DELETE");
    deleteButton.addActionListener(this);
    deleteButton.setBorderPainted(false);
    deleteButton.setFont(Welcome.MAIN_FONT);
    deleteButton.setForeground(Welcome.TEXT_COLOR);

    this.infoButton = new JButton("INFO");
    infoButton.addActionListener(this);
    infoButton.setBorderPainted(false);
    infoButton.setFont(Welcome.MAIN_FONT);
    infoButton.setForeground(Welcome.TEXT_COLOR);

    this.closeButton = new JButton("CLOSE");
    closeButton.addActionListener(this);
    closeButton.setBorderPainted(false);
    closeButton.setFont(Welcome.MAIN_FONT);
    closeButton.setForeground(Welcome.TEXT_COLOR);

    this.exitButton = new JButton("X");
    exitButton.addActionListener(this);
    exitButton.setBorderPainted(false);
    exitButton.setFont(Welcome.MAIN_FONT);
    exitButton.setForeground(Welcome.TEXT_COLOR);

    this.addButton = new JButton("ADD THIS TO PLAN");
    addButton.addActionListener(this);
    addButton.setBorderPainted(false);
    addButton.setFont(Welcome.MAIN_FONT);
    addButton.setForeground(Welcome.TEXT_COLOR);

    this.createButton = new JButton("VIEW LAYOUT");
    createButton.addActionListener(this);
    createButton.setBorderPainted(false);
    createButton.setFont(Welcome.MAIN_FONT);
    createButton.setForeground(Welcome.TEXT_COLOR);

    this.budgetButton = new JButton("BUDGET");
    budgetButton.addActionListener(this);
    budgetButton.setBorderPainted(false);
    budgetButton.setFont(Welcome.MAIN_FONT);
    budgetButton.setForeground(Welcome.TEXT_COLOR);

    this.helpButton = new JButton("?");
    helpButton.addActionListener(this);
    helpButton.setBorderPainted(false);
    helpButton.setFont(Welcome.MAIN_FONT);
    helpButton.setForeground(Welcome.TEXT_COLOR);

    this.updateButton = new JButton("UPDATE");
    updateButton.addActionListener(this);
    updateButton.setBorderPainted(false);
    updateButton.setFont(Welcome.MAIN_FONT);
    updateButton.setForeground(Welcome.TEXT_COLOR);

    this.displayButton = new JButton("DISPLAY");
    displayButton.addActionListener(this);
    displayButton.setBorderPainted(false);
    displayButton.setFont(Welcome.MAIN_FONT);
    displayButton.setForeground(Welcome.TEXT_COLOR);

    this.insertButton = new JButton("INSERT");
    insertButton.addActionListener(this);
    insertButton.setBorderPainted(false);
    insertButton.setFont(Welcome.MAIN_FONT);
    insertButton.setForeground(Welcome.TEXT_COLOR);

    this.compareButton = new JButton("COMPARE PLANS");
    compareButton.addActionListener(this);
    compareButton.setBorderPainted(false);
    compareButton.setFont(Welcome.MAIN_FONT);
    compareButton.setForeground(Welcome.TEXT_COLOR);

    //constructing and defining panels
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(Welcome.TOP_BAR);
    buttonPanel.setBorder(new MatteBorder(0, 0, 10, 0, Welcome.SEPERATOR));

    this.insertPanel = new JPanel(new GridBagLayout());
    insertPanel.setBackground(Welcome.BACK);
    GridBagConstraints c = new GridBagConstraints();

    c.gridx = 0;//set the x location of the grid for the next component
    c.gridy = 0;//set the y location of the grid for the next component
    insertPanel.add(groutLabel, c);
    c.gridx = 1;
    insertPanel.add(grout, c);

    c.gridx = 2;//set the x location of the grid for the next component
    c.gridy = 0;//set the y location of the grid for the next component
    insertPanel.add(floorGroupLabel, c);
    c.gridx = 3;
    insertPanel.add(floorGroupField, c);

    c.gridx = 2;//set the x location of the grid for the next component
    c.gridy = 1;//set the y location of the grid for the next component
    insertPanel.add(addButton, c);

    c.gridx = 2;//set the x location of the grid for the next component
    c.gridy = 2;//set the y location of the grid for the next component
    insertPanel.add(compareButton, c);

    c.gridy = 1;//change the y location
    c.gridx = 0;
    insertPanel.add(layoutsLabel, c);
    c.gridx = 1;
    insertPanel.add(layouts, c);

    c.gridy = 2;//change the y location
    c.gridx = 0;
    insertPanel.add(laborLabel, c);
    c.gridx = 1;
    insertPanel.add(labor, c);

    c.gridy = 3;//change the y location
    c.gridx = 0;
    insertPanel.add(roomSizeLabelL, c);
    c.gridx = 1;
    insertPanel.add(roomSizeFieldL, c);

    c.gridy = 4;//change the y location
    c.gridx = 0;
    insertPanel.add(roomSizeLabelW, c);
    c.gridx = 1;
    insertPanel.add(roomSizeFieldW, c);

    c.gridy = 5;//change the y location
    c.gridx = 0;
    insertPanel.add(tilePathLabel, c);
    c.gridx = 1;
    insertPanel.add(tilePathField, c);

    c.gridy = 6;//change the y location
    c.gridx = 0;
    insertPanel.add(tilePathLabel2, c);
    c.gridx = 1;
    insertPanel.add(tilePathField2, c);

    c.gridy = 7;//change the y location
    insertPanel.add(createButton, c);

    //adding elements to panels
    buttonPanel.add(exitButton);
    buttonPanel.add(closeButton);
    buttonPanel.add(updateButton);
    buttonPanel.add(displayButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(insertButton);
    buttonPanel.add(budgetButton);
    buttonPanel.add(infoButton);
    buttonPanel.add(helpButton);

    //adding panels to frame
    this.add(insertPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.NORTH);

    this.setVisible(true);
    this.pack();
  }

  public static void main(String[] args)
  {
    Floor frameObject = new Floor("Floor"); //defining frame
  }

  private void GroutLayoutLabor()
  {
    // method to set get index of selected item in combobox
    int index = grout.getSelectedIndex();
    System.out.println("GROUT INDEX " + index);
    if (index == 0)
    {
      groutN = 8;
    }
    else if (index == 1)
    {
      groutN = 4;
    }
    else if (index == 2)
    {
      groutN = 2;
    }

    int layoutIndex = layouts.getSelectedIndex();
    if (layoutIndex == 0)
    {
      layout = 1;
    }
    else if (layoutIndex == 1)
    {
      layout = 2;
    }
    else if (layoutIndex == 2)
    {
      layout = 3;
    }
    else if (layoutIndex == 3)
    {
      layout = 4;
    }
    else if (layoutIndex == 4)
    {
      layout = 5;
    }

    int laborIndex = labor.getSelectedIndex();
    if (laborIndex == 0)
    {
      laborCost = "Low";
    }
    else if (laborIndex == 1)
    {
      laborCost = "Med";
    }
    else if (laborIndex == 2)
    {
      laborCost = "High";
    }
  }

  @Override
  public void itemStateChanged(ItemEvent e)
  {
    GroutLayoutLabor();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    //declaring variables
    String command = e.getActionCommand();
    String path = tilePathField.getText();
    String path2 = tilePathField2.getText();

    java.net.URL MY_PATH = getClass().getResource(path);

    JFrame info = new JFrame("INFO");
    info.getContentPane().setBackground(Welcome.BACK);
    info.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    info.setLayout(new BorderLayout());
    JLabel infoLabel;
    JLabel infoLabel2;

    GroutLayoutLabor();

    // if statements for buttons for opening and closing frames
    if (command.equals("X"))
    {
      System.exit(0);
    }
    if (command.equals("CLOSE"))
    {
      this.dispose();
    }
    if (command.equals("BUDGET"))
    {
      Budget frameObject = new Budget("Budget");
    }
    if (command.equals("?"))
    {
      Help frameObject = new Help("Help");
    }
    if (command.equals("VIEW LAYOUT"))
    {
      // used to create layouts with given parameters from user
      int width = parseInt(roomSizeFieldW.getText());
      int length = parseInt(roomSizeFieldL.getText());
      try
      {
        if (layout == 1)
        {
          System.out.println(groutN);
          designer1 = new TileDesigner();
          designer1.tileDesignOne(length, width, groutN, path);

        }
        if (layout == 2)
        {
          System.out.println(groutN);
          designer2 = new TileDesigner();
          designer2.tileDesignTwo(length, width, groutN, path);
        }
        if (layout == 3)
        {
          int width1 = (parseInt(roomSizeFieldW.getText())) + 1;
          System.out.println(groutN);
          designer3 = new TileDesigner();
          designer3.tileDesignThree(length, width, groutN, path);
        }
        if (layout == 4)
        {
          System.out.println(groutN);
          designer4 = new TileDesigner();
          designer4.tileDesignFour(length, width, groutN, path);
        }
        if (layout == 5)
        {
          designer5 = new TileDesigner();
          designer5.tileDesignFive(length, width, groutN, path, path2);
        }

      }
      catch (Exception s)
      {
        Warning objWarning = new Warning("ENTER A NUMBER!");
      }
    }

    // opens display frame
    if (command.equals("DISPLAY"))
    {
      String dbName = "tileInfo";
      String tableName = "Tiles";
      String[] columnHeaders =
      {
        "tileName", "filePath", "tileDimensions", "tileSqft", "tilePricePerSqft"
      };
      new Display(dbName, tableName, columnHeaders);
    }
    if (command.equals("DELETE"))
    {
      Delete frameObject = new Delete("Delete");
    }
    if (command.equals("COMPARE PLANS"))
    {
      Compare frameObject = new Compare("Compare");
    }
    if (command.equals("INSERT"))
    {
      Insert frameObject = new Insert("Insert");
    }

    if (command.equals("INFO"))
    {
      // info frame all variables are set to be seen in info frame
      System.out.println("INFO");

      int width = parseInt(roomSizeFieldW.getText());
      int length = parseInt(roomSizeFieldL.getText());
      tilesInfo = new TilesInfo(path);
      priceLoss = new PriceLoss(path, (double) width, (double) length, (double) groutN, laborCost);
      double price = tilesInfo.getPrice();
      // Floor Price, Excess Tile, Money Lost, Layout, Sqft, Tile Sqft, Grout
      double floorPrice = (width * length) * price;
      int sqft = (width * length);
      double tileSqft = tilesInfo.getLength() * tilesInfo.getWidth();
      priceLoss.setExcessTile(sqft, tileSqft);
      double excessTile = priceLoss.getExcessTile();
      priceLoss.setPriceLoss(sqft, tileSqft, laborCost, path);
      double moneyLoss = priceLoss.getPriceLoss();

      double groutW = groutN / (double) 32;

      // constructing and adding to frame
      System.out.println(groutW);
      infoLabel = new JLabel("<html>Floor Price: " + floorPrice + "‎<br><br>"
        + "Excess Tile: " + excessTile + "<br>"
        + "<br>Money Lost: " + moneyLoss + "<br><br>Layout: " + layout + "<br><br>Sqft: " + sqft
        + "<br><br>Tile Sqft: " + tileSqft + "<html>");
      infoLabel.setFont(Welcome.MAIN_FONT);
      infoLabel.setForeground(Welcome.TEXT_COLOR);

      infoLabel2 = new JLabel("‎‎‎Grout: " + groutW);
      infoLabel2.setFont(Welcome.MAIN_FONT);
      infoLabel2.setForeground(Welcome.TEXT_COLOR);

      info.add(infoLabel, BorderLayout.WEST);
      info.add(infoLabel2, BorderLayout.EAST);

      // set frame to visible
      info.setVisible(true);
      info.pack();
      info.setResizable(false);
    }

    if (command.equals("UPDATE"))
    {
      Update frameObject = new Update("Update");
    }

    if (command.equals("ADD THIS TO PLAN"))
    {
      try
      {
        // adds floor information to hashmap
        // declaring variables
        String key = floorGroupField.getText();
        tilesInfo = new TilesInfo(path);

        int width = parseInt(roomSizeFieldW.getText());
        int length = parseInt(roomSizeFieldL.getText());

        priceLoss = new PriceLoss();

        double sqft = (width * length);
        double price = tilesInfo.getPrice();

        double tileSqft = tilesInfo.getLength() * tilesInfo.getWidth();

        priceLoss.setExcessTile(sqft, tileSqft);
        double excessTile = priceLoss.getExcessTile();

        priceLoss.setPriceLoss(sqft, tileSqft, laborCost, path);
        double moneyLoss = priceLoss.getPriceLoss();

        double floorPrice = ((double) width * (double) length) * price;
        System.out.println(floorPrice);

        ArrayList<FloorGroup> currentFloorGroup = hash_map.get(key);

        for (String s : hash_map.keySet())
        {
          String[] floorPlansArray =
          {
            s
          };
        }

        // adds floorGroup to hash map if empty
        if (currentFloorGroup == null)
        {
          currentFloorGroup = new ArrayList<FloorGroup>();
          hash_map.put(key, currentFloorGroup);
        }
        FloorGroup floorGroup = new FloorGroup(moneyLoss, sqft, floorPrice, excessTile);
        currentFloorGroup.add(floorGroup);

        //System.out.println(hash_map);
        //for each loop to get key from hashmap
        for (String s : hash_map.keySet())
        {
          // base values
          excessTile = 0;
          moneyLoss = 0;
          floorPrice = 0;
          sqft = 0;
          System.out.println("Current key: " + s); //Prints keys

          // for loop to add all values in array list together
          for (int i = 0; i < hash_map.get(s).size(); i++)
          {
            moneyLoss += hash_map.get(s).get(i).getPriceLoss();
            excessTile += hash_map.get(s).get(i).getExcessTile();
            floorPrice += hash_map.get(s).get(i).getFloorPrice();
            sqft += hash_map.get(s).get(i).getSqft();
          }
          hash_map.get(s).clear();
          hash_map.get(s).add(new FloorGroup(moneyLoss, sqft, floorPrice, excessTile));
          System.out.println(hash_map.get(s));
        }
      }
      // see if numbers were entered if not open warning frame
      catch (NumberFormatException nfe)
      {
        Warning objWarning = new Warning("ENTER A NUMBER!");
      }
    }
  }
}
