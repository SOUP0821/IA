/*
Used to update database
 */
package floorvisual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.sql.ResultSet;

public class Update extends JFrame implements ActionListener
{

  //declaring variables
  private JPanel buttonPanel;
  private JPanel insertPanel;
  private JTextField keyField;
  private JLabel keyLabel;
  private JTextField nameField;
  private JLabel nameLabel;
  private JTextField tileField;
  private JLabel tileLabel;
  private JTextField sqftField;
  private JLabel sqftLabel;
  private JButton updateButton;
  private JButton deleteButton;
  private JButton exitButton;
  private JButton helpButton;
  private JButton displayButton;
  private JButton insertButton;
  private JButton closeButton;
  private JButton floorButton;
  private JRadioButton priceButton;
  private JRadioButton sqftButton;
  private JRadioButton nameButton;

  public Update(String name)
  {
    //constructing frame
    super(name);
    this.setBounds(180, 80, 1100, 600);
    this.getContentPane().setBackground(Welcome.BACK);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());

    //constructing and defining labels and textfields
    this.keyField = new JTextField(26);
    keyField.setFont(Welcome.MAIN_FONT);
    keyField.setForeground(Welcome.TEXT_COLOR);
    keyField.setBackground(Welcome.BACK);
    keyField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.keyLabel = new JLabel("FILE PATH ");
    keyLabel.setFont(Welcome.MAIN_FONT);
    keyLabel.setForeground(Welcome.TEXT_COLOR);

    this.nameField = new JTextField(28);
    nameField.setFont(Welcome.MAIN_FONT);
    nameField.setForeground(Welcome.TEXT_COLOR);
    nameField.setBackground(Welcome.BACK);
    nameField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.nameLabel = new JLabel("NAME ");
    nameLabel.setFont(Welcome.MAIN_FONT);
    nameLabel.setForeground(Welcome.TEXT_COLOR);

    this.tileField = new JTextField(22);
    tileField.setFont(Welcome.MAIN_FONT);
    tileField.setForeground(Welcome.TEXT_COLOR);
    tileField.setBackground(Welcome.BACK);
    tileField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.tileLabel = new JLabel("TILE DIMENSIONS ");
    tileLabel.setFont(Welcome.MAIN_FONT);
    tileLabel.setForeground(Welcome.TEXT_COLOR);

    this.sqftField = new JTextField(23);
    sqftField.setFont(Welcome.MAIN_FONT);
    sqftField.setForeground(Welcome.TEXT_COLOR);
    sqftField.setBackground(Welcome.BACK);
    sqftField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.sqftLabel = new JLabel("PRICE PER SQFT ");
    sqftLabel.setFont(Welcome.MAIN_FONT);
    sqftLabel.setForeground(Welcome.TEXT_COLOR);

    this.deleteButton = new JButton("DELETE");
    deleteButton.addActionListener(this);
    deleteButton.setBorderPainted(false);
    deleteButton.setFont(Welcome.MAIN_FONT);
    deleteButton.setForeground(Welcome.TEXT_COLOR);
    
    this.closeButton = new JButton("CLOSE");
    closeButton.addActionListener(this);
    closeButton.setBorderPainted(false);
    closeButton.setFont(Welcome.MAIN_FONT);
    closeButton.setForeground(Welcome.TEXT_COLOR);

    //defining and constructing buttons
    this.nameButton = new JRadioButton("NAME");
    nameButton.setFont(Welcome.MAIN_FONT);
    nameButton.setForeground(Welcome.TEXT_COLOR);
    this.priceButton = new JRadioButton("SQFT PER PRICE");
    priceButton.setFont(Welcome.MAIN_FONT);
    priceButton.setForeground(Welcome.TEXT_COLOR);
    this.sqftButton = new JRadioButton("TILE DIMENSIONS");
    sqftButton.setFont(Welcome.MAIN_FONT);
    sqftButton.setForeground(Welcome.TEXT_COLOR);

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

    this.floorButton = new JButton("FLOOR");
    floorButton.addActionListener(this);
    floorButton.setBorderPainted(false);
    floorButton.setFont(Welcome.MAIN_FONT);
    floorButton.setForeground(Welcome.TEXT_COLOR);

    //defining and creating panels
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(Welcome.TOP_BAR);
    buttonPanel.setBorder(new MatteBorder(0, 0, 10, 0, Welcome.SEPERATOR));

    this.insertPanel = new JPanel(new FlowLayout());
    insertPanel.setBackground(Welcome.BACK);

    //adding elements to panels
    insertPanel.add(keyLabel);
    insertPanel.add(keyField);
    insertPanel.add(nameLabel);
    insertPanel.add(nameField);
    insertPanel.add(tileLabel);
    insertPanel.add(tileField);
    insertPanel.add(sqftLabel);
    insertPanel.add(sqftField);
    insertPanel.add(updateButton);
    insertPanel.add(nameButton);
    insertPanel.add(priceButton);
    insertPanel.add(sqftButton);
    buttonPanel.add(exitButton);
    buttonPanel.add(closeButton);
    buttonPanel.add(displayButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(insertButton);
    buttonPanel.add(floorButton);
    buttonPanel.add(helpButton);

    //adding panels to frame
    this.add(buttonPanel, BorderLayout.NORTH);
    this.add(insertPanel, BorderLayout.CENTER);

    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    Update frameObject = new Update("Update");//defining frame
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    //declaring variables
    String command = e.getActionCommand();
    String dbName = "tileInfo";
    String tableName = "Tiles";
    String[] columnHeaders =
    {
      "tileName", "filePath", "tileDimensions", "tileSqft", "tilePricePerSqft"
    };

    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    String key = (keyField.getText());

    //if statements for buttons to either close or open frames
    if (command.equals("X"))
    {
      System.exit(0);
    }
    if (command.equals("?"))
    {
      Help frameObject = new Help("Help");
    }
    if (command.equals("DISPLAY"))
    {
      new Display(dbName, tableName, columnHeaders);
    }
    if (command.equals("CLOSE"))
    {
      this.dispose();
    }
    if (command.equals("DELETE"))
    {
      Delete frameObject = new Delete("Delete");
    }
    if (command.equals("FLOOR"))
    {
      Floor frameObject = new Floor("Floor");
    }
    if (command.equals("INSERT"))
    {
      Insert frameObject = new Insert("Insert");
    }
    if (command.equals("CLOSE"))
    {
      this.dispose();
    }
    if (command.equals("UPDATE"))
    {
      if (nameButton.isSelected())
      {
        //querty to run
        String dbQuery1 = "UPDATE Tiles SET tileName=? WHERE filePath =?";
        //read 
        String name = (nameField.getText());
        try
        {
          //prepare statment
          PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
          //enter data into query
          ps.setString(1, name);
          ps.setString(2, key);

          System.out.println(ps);
          //execute the query
          ps.executeUpdate();
          System.out.println("Data updated successfully");
        }
        catch (SQLException se)
        {
          System.out.println("Error updating data");
          se.printStackTrace(System.err);
        }
        catch (NumberFormatException nfe)
        {
          Warning objWarning = new Warning("ENTER A NUMBER!"); //test catch to see if numbers are not inputted and open warning frame
        }
      }
      if (sqftButton.isSelected())
      {
        //query to run
        String dbQuery2 = "UPDATE Tiles SET tileDimensions=?, tileSqft=? WHERE filePath=?";
        Double sqft;
        String tile = (tileField.getText());
        TileSqft objectAdd = new TileSqft(tile);
        objectAdd.setResult();
        sqft = objectAdd.getResult();

        try
        {
          //prepare statment
          PreparedStatement ps1 = myDbConn.prepareStatement(dbQuery2);
          //enter data into query
          ps1.setString(1, tile);
          ps1.setString(3, key);
          ps1.setDouble(2, sqft);
          
          System.out.println(ps1);
          //execute the query
          ps1.executeUpdate();
          System.out.println("Data updated successfully");
        }
        catch (SQLException se)
        {
          System.out.println("Error deleting data"); // catch sql error
          se.printStackTrace(System.err);
        }
        catch (NumberFormatException nfe)
        {
          Warning objWarning = new Warning("ENTER A NUMBER!"); //test catch to see if numbers are not inputted and open warning frame
        }
      }
      if (priceButton.isSelected())
      {
        //query to run
        String dbQuery3 = "UPDATE Tiles SET tilePricePerSqft=? WHERE filePath=?";
        //read 
        int sqftPrice = Integer.parseInt(sqftField.getText());

        try
        {
          //prepare statment
          PreparedStatement ps2 = myDbConn.prepareStatement(dbQuery3);
          //enter data into query
          ps2.setInt(1, sqftPrice);
          ps2.setString(2, key);
          System.out.println(ps2);
          //execute the query
          ps2.executeUpdate();
          System.out.println("Data updated successfully");
        }
        catch (SQLException se)
        {
          System.out.println("Error deleting data"); // catch sql error
          se.printStackTrace(System.err);
        }
        catch (NumberFormatException nfe)
        {
          Warning objWarning = new Warning("ENTER A NUMBER!"); //test catch to see if numbers are not inputted and open warning frame
        }
      }
    }
  }
}
