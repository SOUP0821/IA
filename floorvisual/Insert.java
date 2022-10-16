/*
Allow user to input information
 */
package floorvisual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.MatteBorder;

public class Insert extends JFrame implements ActionListener
{
//declaring variables

  private JPanel buttonPanel;
  private JPanel insertPanel;
  private JTextField sqftField;
  private JLabel sqftLabel;
  private JTextField pathField;
  private JLabel pathLabel;
  private JTextField tileNameField;
  private JLabel tileNameLabel;
  private JTextField tileDimField;
  private JLabel tileDimLabel;
  private JButton updateButton;
  private JButton deleteButton;
  private JButton exitButton;
  private JButton helpButton;
  private JButton displayButton;
  private JButton insertButton;
  private JButton closeButton;
  private JButton floorButton;

  public Insert(String name)
  {
    //constructing frame
    super(name);
    this.setBounds(180, 80, 1100, 600);
    this.getContentPane().setBackground(Welcome.BACK);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());

    //defining and constructing text fields and labels
    this.sqftField = new JTextField(23);
    sqftField.setFont(Welcome.MAIN_FONT);
    sqftField.setForeground(Welcome.TEXT_COLOR);
    sqftField.setBackground(Welcome.BACK);
    sqftField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.sqftLabel = new JLabel("PRICE PER SQFT    ");
    sqftLabel.setFont(Welcome.MAIN_FONT);
    sqftLabel.setForeground(Welcome.TEXT_COLOR);

    this.pathField = new JTextField(25);
    pathField.setFont(Welcome.MAIN_FONT);
    pathField.setForeground(Welcome.TEXT_COLOR);
    pathField.setBackground(Welcome.BACK);
    pathField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.pathLabel = new JLabel("FILE PATH    ");
    pathLabel.setFont(Welcome.MAIN_FONT);
    pathLabel.setForeground(Welcome.TEXT_COLOR);

    this.tileDimField = new JTextField(23);
    tileDimField.setFont(Welcome.MAIN_FONT);
    tileDimField.setForeground(Welcome.TEXT_COLOR);
    tileDimField.setBackground(Welcome.BACK);
    tileDimField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.tileDimLabel = new JLabel("TILE DIMENSIONS ");
    tileDimLabel.setFont(Welcome.MAIN_FONT);
    tileDimLabel.setForeground(Welcome.TEXT_COLOR);

    this.tileNameField = new JTextField(23);
    tileNameField.setFont(Welcome.MAIN_FONT);
    tileNameField.setForeground(Welcome.TEXT_COLOR);
    tileNameField.setBackground(Welcome.BACK);
    tileNameField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.tileNameLabel = new JLabel("TILE NAME      ");
    tileNameLabel.setFont(Welcome.MAIN_FONT);
    tileNameLabel.setForeground(Welcome.TEXT_COLOR);

    //defining and constructing buttons
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

    //defining and constructing panels
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(Welcome.TOP_BAR);
    buttonPanel.setBorder(new MatteBorder(0, 0, 10, 0, Welcome.SEPERATOR));

    this.insertPanel = new JPanel(new FlowLayout());
    insertPanel.setBackground(Welcome.BACK);

    //adding elements to panels
    insertPanel.add(tileNameLabel);
    insertPanel.add(tileNameField);
    insertPanel.add(tileDimLabel);
    insertPanel.add(tileDimField);
    insertPanel.add(pathLabel);
    insertPanel.add(pathField);
    insertPanel.add(sqftLabel);
    insertPanel.add(sqftField);
    insertPanel.add(insertButton);
    insertPanel.add(deleteButton);
    buttonPanel.add(exitButton);
    buttonPanel.add(closeButton);
    buttonPanel.add(updateButton);
    buttonPanel.add(displayButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(floorButton);
    buttonPanel.add(helpButton);

    //adding panels to frame
    this.add(buttonPanel, BorderLayout.NORTH);
    this.add(insertPanel, BorderLayout.CENTER);

    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    Insert frameObject = new Insert("Insert");//defining frame
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

    //insert query with ? to avoid sql injection
    String dbQuery = "INSERT INTO tiles VALUES (?,?,?,?,?)";
    //create object for db class
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    //if statements for buttons to open and close frames
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
    if (command.equals("DISPLAY"))
    {
      new Display(dbName, tableName, columnHeaders);
    }
    if (command.equals("DELETE"))
    {
      Delete frameObject = new Delete("Delete");
    }
    if (command.equals("FLOOR"))
    {
      Floor frameObject = new Floor("Floor");
    }
    if (command.equals("UPDATE"))
    {
      Update frameObject = new Update("Update");
    }

    String tileDim;
    String filePath;
    String name;
    Double sqft;
    int price;
    if (command.equals("INSERT"))
    {
      //declare variables
      tileDim = tileDimField.getText();
      name = tileNameField.getText();
      filePath = pathField.getText();
      price = parseInt(sqftField.getText());
      tileDimField.setText("");
      tileNameField.setText("");
      pathField.setText("");
      sqftField.setText("");
      TileSqft objectAdd = new TileSqft(tileDim);
      objectAdd.setResult();
      sqft = objectAdd.getResult();
      try
      {
        //create prepare statement ps using connection
        PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
        //pass values into ps to fill in ?
        ps.setString(1, name);
        ps.setString(2, filePath);
        ps.setString(3, tileDim);
        ps.setDouble(4, sqft);
        ps.setInt(5, price);
        //execute update (not query) to db table (insert in this case)
        ps.executeUpdate();
        System.out.println("Data inserted successfully");
      }
      catch (SQLException se)
      {
        System.out.println("Error inserting data"); // catch sql exception
        se.printStackTrace(System.err);
      }
      catch (NumberFormatException nfe)
      {
        Error objError = new Error("ENTER A NUMBER!"); // catch if there is letters instead of numbers
      }
    }
  }
}
