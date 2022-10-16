/*
Welcome frame and hub to all main frames
 */
package floorvisual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.MatteBorder;

class Welcome extends JFrame implements ActionListener
{

  //declaring variables 
  public static final Font MAIN_FONT = new Font("Futura", Font.BOLD, 32);
  public static final Color TOP_BAR = new Color(107, 5, 41);
  public static final Color SEPERATOR = new Color(63, 2, 38);
  public static final Color BACK = new Color(34, 15, 33);
  public static final Color DISPLAY_BG = new Color(184, 24, 50);
  public static final Color TEXT_COLOR = new Color(232, 46, 49);
  java.net.URL MY_PATH = getClass().getResource("welcome.png");
  ImageIcon welcomeIcon = new ImageIcon(new ImageIcon(
    MY_PATH).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));

  private JPanel buttonPanel;
  private JButton closeButton;
  private JButton exitButton;
  private JButton helpButton;
  private JButton displayButton;
  private JButton insertButton;
  private JButton floorButton;
  private JLabel imageLabel;

  public Welcome(String name)
  {
    //constructing frame
    super(name);
    this.setBounds(300, 90, 850, 600);
    this.getContentPane().setBackground(BACK);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    //constructing and defining buttons
    this.closeButton = new JButton("CLOSE");
    closeButton.addActionListener(this);
    closeButton.setBorderPainted(false);
    closeButton.setFont(MAIN_FONT);
    closeButton.setForeground(TEXT_COLOR);

    this.exitButton = new JButton("X");
    exitButton.addActionListener(this);
    exitButton.setBorderPainted(false);
    exitButton.setFont(MAIN_FONT);
    exitButton.setForeground(TEXT_COLOR);

    this.helpButton = new JButton("?");
    helpButton.addActionListener(this);
    helpButton.setBorderPainted(false);
    helpButton.setFont(MAIN_FONT);
    helpButton.setForeground(TEXT_COLOR);

    this.displayButton = new JButton("DISPLAY");
    displayButton.addActionListener(this);
    displayButton.setBorderPainted(false);
    displayButton.setFont(MAIN_FONT);
    displayButton.setForeground(TEXT_COLOR);

    this.insertButton = new JButton("INSERT");
    insertButton.addActionListener(this);
    insertButton.setBorderPainted(false);
    insertButton.setFont(MAIN_FONT);
    insertButton.setForeground(TEXT_COLOR);

    this.floorButton = new JButton("FLOOR");
    floorButton.addActionListener(this);
    floorButton.setBorderPainted(false);
    floorButton.setFont(MAIN_FONT);
    floorButton.setForeground(TEXT_COLOR);
    
    //adding image to Label
    imageLabel = new JLabel(welcomeIcon);

    //defining and constructing panels
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(TOP_BAR);
    buttonPanel.setBorder(new MatteBorder(0, 0, 10, 0, SEPERATOR));

    //adding elements to panel
    buttonPanel.add(exitButton);
    buttonPanel.add(closeButton);
    buttonPanel.add(displayButton);
    buttonPanel.add(insertButton);
    buttonPanel.add(floorButton);
    buttonPanel.add(helpButton);

    //adding panel to frame
    this.add(buttonPanel, BorderLayout.NORTH);
    this.add(imageLabel, BorderLayout.CENTER);

    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    Welcome frameObject = new Welcome("Floor Visualizer");//defining frame
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    String command = e.getActionCommand();

    //if statements for buttons to open or close frames
    if (command.equals("CLOSE"))
    {
      this.dispose();
    }
    if (command.equals("X"))
    {
      System.exit(0);
    }
    if (command.equals("?"))
    {
      Help frameObject = new Help("Help");
    }
    if (command.equals("INSERT"))
    {
      Insert frameObject = new Insert("Insert");
    }
    if (command.equals("FLOOR"))
    {
      Floor frameObject = new Floor("Floor");
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
  }
}
