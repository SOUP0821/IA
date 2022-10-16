/*
Delete rows from databse
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
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class Delete extends JFrame implements ActionListener
{

  // declaring variables
  private JPanel buttonPanel;
  private JPanel insertPanel;
  private JTextField keyField;
  private JLabel keyLabel;
  private JButton updateButton;
  private JButton deleteButton;
  private JButton exitButton;
  private JButton helpButton;
  private JButton displayButton;
  private JButton insertButton;
  private JButton floorButton;
  private JButton closeButton;

  public Delete(String name)
  {
    //constructing frame
    super(name);
    this.setBounds(180, 80, 1100, 600);
    this.getContentPane().setBackground(Welcome.BACK);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());

    //constructing and defining text field and label for id
    this.keyField = new JTextField(28);
    keyField.setFont(Welcome.MAIN_FONT);
    keyField.setForeground(Welcome.TEXT_COLOR);
    keyField.setBackground(Welcome.BACK);
    keyField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.keyLabel = new JLabel("File Path: ");
    keyLabel.setFont(Welcome.MAIN_FONT);
    keyLabel.setForeground(Welcome.TEXT_COLOR);

    //defining and constructing buttons
    this.deleteButton = new JButton("DELETE");
    deleteButton.addActionListener(this);
    deleteButton.setBorderPainted(false);
    deleteButton.setFont(Welcome.MAIN_FONT);
    deleteButton.setForeground(Welcome.TEXT_COLOR);

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

    this.closeButton = new JButton("CLOSE");
    closeButton.addActionListener(this);
    closeButton.setBorderPainted(false);
    closeButton.setFont(Welcome.MAIN_FONT);
    closeButton.setForeground(Welcome.TEXT_COLOR);

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

    // defining and constructing panels
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(Welcome.TOP_BAR);
    buttonPanel.setBorder(new MatteBorder(0, 0, 10, 0, Welcome.SEPERATOR));

    this.insertPanel = new JPanel(new FlowLayout());
    insertPanel.setBackground(Welcome.BACK);

    //adding elements to panels
    insertPanel.add(keyLabel);
    insertPanel.add(keyField);
    insertPanel.add(deleteButton);
    buttonPanel.add(exitButton);
    buttonPanel.add(closeButton);
    buttonPanel.add(updateButton);
    buttonPanel.add(displayButton);
    buttonPanel.add(insertButton);
    buttonPanel.add(floorButton);
    buttonPanel.add(helpButton);

    // adding panels to frame
    this.add(buttonPanel, BorderLayout.NORTH);
    this.add(insertPanel, BorderLayout.CENTER);

    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    Delete frameObject = new Delete("Delete"); // definig frame
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    //declaring variables
    String command = e.getActionCommand();
    String keyDelete;

    // if statements for buttons to open frames or close them
    if (command.equals("X"))
    {
      System.exit(0);
    }
    if (command.equals("CLOSE"))
    {
      this.dispose();
    }
    if (command.equals("?"))
    {
      Help frameObject = new Help("Help");
    }
     if (command.equals("INSERT"))
    {
      Insert frameObject = new Insert("Insert");
    }
    if (command.equals("UPDATE"))
    {
      Update frameObject = new Update("Update");
    }
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
    if (command.equals("FLOOR"))
    {
      Floor frameObject = new Floor("Floor");
    }
    if (command.equals("DELETE"))
    {
      keyDelete = keyField.getText();
      // db info
      String dbName = "tileInfo";
      String tableName = "Tiles";
      String[] columnNames =
      {
        "tileName", "filePath", "tileDimensions", "tileSqft", "tilePricePerSqft"
      };
      // create connection
      JavaDatabase objDb = new JavaDatabase(dbName);
      Connection myDbConn = objDb.getDbConn();
      //query to run
      String dbQuery = "DELETE FROM Tiles WHERE filePath = ?";
      //read 
      String readKey = keyDelete;

      try
      {
        //prepare statment
        PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
        //enter data into query
        ps.setString(1, readKey);
        //execute the query
        ps.executeUpdate();
        System.out.println("Data deleted successfully");
      }
      catch (SQLException se)
      {
        System.out.println("Error deleting data"); // to catch exception
        se.printStackTrace(System.err);
      }
      catch (NumberFormatException nfe)
      {
        Error objError = new Error("ENTER A NUMBER!"); // catch if there is letters instead of numbers
      }
      if (command.equals("CLOSE"))
      {
        this.dispose();
      }
    }
  }
}
