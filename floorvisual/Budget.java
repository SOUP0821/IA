/*
Supposed to calcualte the budget of the whole floor plan based on the users salary
 */
package floorvisual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class Budget extends JFrame implements ActionListener
{

  //declaring variables
  private JPanel buttonPanel;
  private JPanel insertPanel;
  private JTextField salaryField;
  private JLabel salaryLabel;
  private JTextField tileField;
  private JLabel tileLabel;
  private JLabel resultLabel;
  private JButton calculateButton;
  private JButton updateButton;
  private JButton deleteButton;
  private JButton exitButton;
  private JButton helpButton;
  private JButton displayButton;
  private JButton closeButton;
  private JButton insertButton;
  private JButton floorButton;

  public Budget(String name)
  {
    //constructing frame
    super(name);
    this.setBounds(180, 80, 1100, 600);
    this.getContentPane().setBackground(Welcome.BACK);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());

    // defining and constructing salary field and label for user to input info 
    this.salaryField = new JTextField(28);
    salaryField.setFont(Welcome.MAIN_FONT);
    salaryField.setForeground(Welcome.TEXT_COLOR);
    salaryField.setBackground(Welcome.BACK);
    salaryField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.salaryLabel = new JLabel("SALARY ");
    salaryLabel.setFont(Welcome.MAIN_FONT);
    salaryLabel.setForeground(Welcome.TEXT_COLOR);

    // defining and contructing tile field and label for user to input info
    this.tileField = new JTextField(22);
    tileField.setFont(Welcome.MAIN_FONT);
    tileField.setForeground(Welcome.TEXT_COLOR);
    tileField.setBackground(Welcome.BACK);
    tileField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));
    this.tileLabel = new JLabel("TOTAL FLOOR SIZE ");
    tileLabel.setFont(Welcome.MAIN_FONT);
    tileLabel.setForeground(Welcome.TEXT_COLOR);

    //defining and constructing buttons
    this.deleteButton = new JButton("DELETE");
    deleteButton.addActionListener(this);
    deleteButton.setBorderPainted(false);
    deleteButton.setFont(Welcome.MAIN_FONT);
    deleteButton.setForeground(Welcome.TEXT_COLOR);

    this.calculateButton = new JButton("CALCULATE");
    calculateButton.addActionListener(this);
    calculateButton.setBorderPainted(false);
    calculateButton.setFont(Welcome.MAIN_FONT);
    calculateButton.setForeground(Welcome.TEXT_COLOR);

    this.exitButton = new JButton("X");
    exitButton.addActionListener(this);
    exitButton.setBorderPainted(false);
    exitButton.setFont(Welcome.MAIN_FONT);
    exitButton.setForeground(Welcome.TEXT_COLOR);

    this.closeButton = new JButton("CLOSE");
    closeButton.addActionListener(this);
    closeButton.setBorderPainted(false);
    closeButton.setFont(Welcome.MAIN_FONT);
    closeButton.setForeground(Welcome.TEXT_COLOR);

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

    // defining button panel and constructing
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(Welcome.TOP_BAR);
    buttonPanel.setBorder(new MatteBorder(0, 0, 10, 0, Welcome.SEPERATOR)); // used to create border

    // declaring insert panel and constructing
    this.insertPanel = new JPanel(new FlowLayout());
    insertPanel.setBackground(Welcome.BACK);

    // adding elements to panels
    insertPanel.add(salaryLabel);
    insertPanel.add(salaryField);
    insertPanel.add(tileLabel);
    insertPanel.add(tileField);
    insertPanel.add(calculateButton);
    buttonPanel.add(exitButton);
    buttonPanel.add(closeButton);
    buttonPanel.add(updateButton);
    buttonPanel.add(displayButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(insertButton);
    buttonPanel.add(floorButton);
    buttonPanel.add(helpButton);

    // adding panels to frame
    this.add(buttonPanel, BorderLayout.NORTH);
    this.add(insertPanel, BorderLayout.CENTER);

    //making fram visible
    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    Budget frameObject = new Budget("Budget"); //defining frame
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    // declaring variables
    String command = e.getActionCommand();
    String salary;
    String tile;
    int num1;
    int num2;

    // if statements for buttons to open frames or close
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
    if (command.equals("INESRT"))
    {
      Insert frameObject = new Insert("Insert");
    }
    if (command.equals("DELETE"))
    {
      Delete frameObject = new Delete("Delete");
    }
    if (command.equals("FLOOR"))
    {
      Floor frameObject = new Floor("Floor");
    }
    if (command.equals("CLOSE"))
    {
      this.dispose();
    }
    // test statement to catch errors to see if characters inputted are numbers
    if (command.equals("CALCULATE"))
    {
      try
      {
        if (resultLabel != null)
        {
          insertPanel.remove(resultLabel);
        }

        // gets characters from text fields
        salary = salaryField.getText();
        tile = tileField.getText();
        //converts characters retreived to integers
        num1 = parseInt(salaryField.getText());
        num2 = parseInt(tileField.getText());

        BudgetCalc bCalc = new BudgetCalc(num2);
        FloorGroup floorGroup = bCalc.getFloorGroup();
        String name = bCalc.getName();

        resultLabel = new JLabel("<html>Floor Group Name: " + name + "<br> Floor Price: "
          + floorGroup.getFloorPrice() + "<br> Floor Size: " + floorGroup.getSqft()
          + "<br> Budget: " + (num1 * 0.06) + "</html>");
        resultLabel.setFont(Welcome.MAIN_FONT);
        resultLabel.setForeground(Welcome.TEXT_COLOR);

        insertPanel.add(resultLabel);
        this.validate();
        this.repaint();

      }
      catch (NumberFormatException nfe) // seeing if numbers are inputted if not open warning frame
      {
        Warning objWarning = new Warning("ENTER A NUMBER!");
      }
    }
  }
}
