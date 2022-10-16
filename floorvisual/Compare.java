/*
Used to compared two different floors or floor groups
 */
package floorvisual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class Compare extends JFrame implements ActionListener, ItemListener
{
// declaring variables

  private JPanel buttonPanel;
  private JPanel comparePanel;
  private JButton closeButton;
  private JButton exitButton;
  private JButton helpButton;
  private JButton backButton;
  private JButton insertButton;
  private JButton floorButton;
  private JLabel differenceLabel;

  private JLabel key1Label;
  private JComboBox<String> key1;
  private String[] key1Array;

  private JLabel key2Label;
  private JComboBox<String> key2;
  private String[] key2Array;

  public Compare(String name)
  {
    // constructing frame
    super(name);
    this.setBounds(300, 90, 850, 600);
    this.getContentPane().setBackground(Welcome.BACK);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());

    int i = 0;
    key1Array = new String[Floor.hash_map.keySet().size()];
    // for each loop to add hash map key to combo box
    for (String s : Floor.hash_map.keySet())
    {
      key1Array[i] = s;
      i++;
    }

    int k = 0;
    key2Array = new String[Floor.hash_map.keySet().size()];
    // for each loop to add hash map key to combo box
    for (String s : Floor.hash_map.keySet())
    {
      key2Array[k] = s;
      k++;
    }

    // creating combo boxes
    key1 = new JComboBox<>(key1Array);
    key1.addItemListener(this);
    key1.setBackground(Welcome.BACK);
    key1.setFont(new Font("Futura", Font.BOLD, 24));
    key1.setForeground(Welcome.TEXT_COLOR);
    this.key1Label = new JLabel("FLOOR GROUP 1 ");
    key1Label.setFont(Welcome.MAIN_FONT);
    key1Label.setForeground(Welcome.TEXT_COLOR);

    key2 = new JComboBox<>(key1Array);
    key2.addItemListener(this);
    key2.setBackground(Welcome.BACK);
    key2.setFont(new Font("Futura", Font.BOLD, 24));
    key2.setForeground(Welcome.TEXT_COLOR);
    this.key2Label = new JLabel("FLOOR GROUP 2 ");
    key2Label.setFont(Welcome.MAIN_FONT);
    key2Label.setForeground(Welcome.TEXT_COLOR);

    // defining buttons and constructing
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

    this.helpButton = new JButton("?");
    helpButton.addActionListener(this);
    helpButton.setBorderPainted(false);
    helpButton.setFont(Welcome.MAIN_FONT);
    helpButton.setForeground(Welcome.TEXT_COLOR);

    this.backButton = new JButton("BACK");
    backButton.addActionListener(this);
    backButton.setBorderPainted(false);
    backButton.setFont(Welcome.MAIN_FONT);
    backButton.setForeground(Welcome.TEXT_COLOR);

    this.insertButton = new JButton("INSERT");
    insertButton.addActionListener(this);
    insertButton.setBorderPainted(false);
    insertButton.setFont(Welcome.MAIN_FONT);
    insertButton.setForeground(Welcome.TEXT_COLOR);

    this.floorButton = new JButton("FLOOR");
    floorButton.addActionListener(this);
    floorButton.setBorderPainted(false);
    floorButton.setFont(Welcome.MAIN_FONT);
    floorButton.setForeground(Welcome.TEXT_COLOR);

    // constructing and defining panel
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(Welcome.TOP_BAR);
    buttonPanel.setBorder(new MatteBorder(0, 0, 10, 0, Welcome.SEPERATOR));

    this.comparePanel = new JPanel(new FlowLayout());
    comparePanel.setBackground(Welcome.BACK);

    //adding elements to panel
    buttonPanel.add(exitButton);
    buttonPanel.add(closeButton);
    buttonPanel.add(backButton);
    buttonPanel.add(insertButton);
    buttonPanel.add(floorButton);
    buttonPanel.add(helpButton);

    comparePanel.add(key1Label);
    comparePanel.add(key1);
    comparePanel.add(key2Label);
    comparePanel.add(key2);

    // adding panel to frame
    this.add(buttonPanel, BorderLayout.NORTH);
    this.add(comparePanel, BorderLayout.CENTER);

    //makes frame visible
    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    Compare frameObject = new Compare("Compare"); // defining frame
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    String command = e.getActionCommand();

    //if statements for buttons to open other frame or close frame
    if (command.equals("X"))
    {
      System.exit(0);
    }
    if (command.equals("?"))
    {
      Help frameObject = new Help("Help");
    }
    if (command.equals("CLOSE"))
    {
      this.dispose();
    }
    if (command.equals("FLOOR"))
    {
      Floor frameObject = new Floor("Floor");
    }
    if (command.equals("BACK"))
    {
      String dbName = "tileInfo";
      String tableName = "Tiles";
      String[] columnHeaders =
      {
        "tileName", "filePath", "tileDimensions", "tileSqft", "tilePricePerSqft"
      };
      new Display(dbName, tableName, columnHeaders);
      this.dispose();
    }
    if (command.equals("INSERT"))
    {
      Insert frameObject = new Insert("Insert");
    }
  }

  @Override
  public void itemStateChanged(ItemEvent e)
  {
    //if label isnt empty deletes it each time one is created
    if(differenceLabel != null)
    {
    comparePanel.remove(differenceLabel);
    }
    
    // declaring variables
    String key1String = String.valueOf(key1.getSelectedItem());
    String key2String = String.valueOf(key2.getSelectedItem());
    System.out.println(Floor.hash_map.get(key1String));
    System.out.println(Floor.hash_map.get(key2String));

    double moneyLoss;
    double excessTile;
    double floorPrice;
    double sqft;

    FloorGroup floorGroup1;
    FloorGroup floorGroup2;

    floorGroup1 = Floor.hash_map.get(key1String).get(0);
    floorGroup2 = Floor.hash_map.get(key2String).get(0);
    
    // subtracting to find the difference
    moneyLoss = floorGroup1.getPriceLoss() - floorGroup2.getPriceLoss();
    excessTile = floorGroup1.getExcessTile() - floorGroup2.getExcessTile();
    floorPrice = floorGroup1.getFloorPrice() -  floorGroup2.getFloorPrice();
    sqft = floorGroup1.getSqft() - floorGroup2.getSqft();
    
//    System.out.println(moneyLoss);
//    System.out.println(excessTile);
//    System.out.println(floorPrice);
//    System.out.println(sqft);

//label to display information
    differenceLabel = new JLabel("<html>Price Loss: " + moneyLoss + "‎<br><br>"
      + "Excess Tile: " + excessTile + "<br>"
      + "<br>Floor Price: " + floorPrice + "<br><br>Sqft: " + sqft);
    differenceLabel.setFont(Welcome.MAIN_FONT);
    differenceLabel.setForeground(Welcome.TEXT_COLOR);
    
    comparePanel.add(differenceLabel);
    
    this.validate();
    this.repaint();
  }
}
