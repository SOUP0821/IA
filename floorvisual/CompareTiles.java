/*
Shows tile images next to each other
 */
package floorvisual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.MatteBorder;

public class CompareTiles extends JFrame implements ActionListener
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
  private JButton compareTiles;
  private JLabel pathLabel;
  private JTextField pathField;
  private int clicked = 1;
  private JLabel[] imageLabel = new JLabel[100];

  public CompareTiles(String name)
  {
    // constructing frame
    super(name);
    this.setBounds(300, 90, 850, 600);
    this.getContentPane().setBackground(Welcome.BACK);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());

    this.pathLabel = new JLabel("TILE PATH ");
    pathLabel.setFont(Welcome.MAIN_FONT);
    pathLabel.setForeground(Welcome.TEXT_COLOR);
    pathField = new JTextField(5);
    pathField.setFont(Welcome.MAIN_FONT);
    pathField.setForeground(Welcome.TEXT_COLOR);
    pathField.setBackground(Welcome.BACK);
    pathField.setBorder(new MatteBorder(5, 5, 5, 5, Welcome.TEXT_COLOR));

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

    this.compareTiles = new JButton("COMPARE TILES");
    compareTiles.addActionListener(this);
    compareTiles.setBorderPainted(false);
    compareTiles.setFont(Welcome.MAIN_FONT);
    compareTiles.setForeground(Welcome.TEXT_COLOR);

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

    comparePanel.add(pathLabel);
    comparePanel.add(pathField);
    comparePanel.add(compareTiles);

    // adding panel to frame
    this.add(buttonPanel, BorderLayout.NORTH);
    this.add(comparePanel, BorderLayout.CENTER);

    //makes frame visible
    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    CompareTiles frameObject = new CompareTiles("Compare Tiles"); // defining frame
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
    if (command.equals("COMPARE TILES"))
    {
      
      clicked++;
      String path = pathField.getText();
      TilesInfo tileInfo = new TilesInfo(path);
      double tileW = tileInfo.getWidth() * 32;
      double tileL = tileInfo.getLength() * 32;
      
      java.net.URL MY_PATH = getClass().getResource(path);
      ImageIcon tileIcon = new ImageIcon(new ImageIcon(
      MY_PATH).getImage().getScaledInstance((int) tileW, (int) tileL, Image.SCALE_SMOOTH));
      
      imageLabel[clicked] = new JLabel(tileIcon);
      
      comparePanel.add(imageLabel[clicked]);
      
      this.setVisible(true);
      this.validate();
      this.repaint();

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
}
