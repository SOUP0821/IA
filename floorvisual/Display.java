/*
used to display database
 */
package floorvisual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.MatteBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class Display extends JFrame implements ActionListener
{

  //declaring variables
  private JPanel buttonPanel;
  private JButton closeButton;
  private JButton exitButton;
  private JButton helpButton;
  private JButton compareButton;
  private JButton insertButton;
  private JButton floorButton;
  
  private ArrayList<ArrayList<String>> dataList;
  private Object[][] data;

  private JTable dbTable;
  private JScrollPane scrollTable;

  private JTableHeader header;
  private TableColumn column;


  public Display(String dbName, String tableName, String[] tableHeaders)
  {
    //constructing frame
    super("Display");
    this.setBounds(20, 90, 1400, 600);
    this.getContentPane().setBackground(Welcome.BACK);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());

   // construct data
    JavaDatabase dbObj = new JavaDatabase(dbName);
    dataList = dbObj.getData(tableName, tableHeaders);
    data = dbObj.to2dArray(dataList);
    dbObj.closeDbConn();
// construct table
    dbTable = new JTable(data, tableHeaders);
//format table
    dbTable.setGridColor(Color.BLACK);
    dbTable.setBackground(Welcome.BACK);
    dbTable.setFont(Welcome.MAIN_FONT);
    dbTable.setForeground(Welcome.TEXT_COLOR);

// format header
    header = dbTable.getTableHeader();
    header.setBackground(Welcome.BACK);
    header.setForeground(Welcome.TEXT_COLOR);
    header.setFont(Welcome.MAIN_FONT);
// format rows
    dbTable.setRowHeight(25);
// format columns
    column = dbTable.getColumnModel().getColumn(0);
    column.setPreferredWidth(50);
    column = dbTable.getColumnModel().getColumn(1);
    column.setPreferredWidth(50);
    column = dbTable.getColumnModel().getColumn(2);
    column.setPreferredWidth(50);
    column = dbTable.getColumnModel().getColumn(3);
    column.setPreferredWidth(50);

    scrollTable = new JScrollPane();
    scrollTable.getViewport().add(dbTable);
    dbTable.setFillsViewportHeight(true);

    //constructing and defining buttons
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

    this.compareButton = new JButton("COMPARE TILES");
    compareButton.addActionListener(this);
    compareButton.setBorderPainted(false);
    compareButton.setFont(Welcome.MAIN_FONT);
    compareButton.setForeground(Welcome.TEXT_COLOR);

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

    //constructing and defining button panel
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(Welcome.TOP_BAR);
    buttonPanel.setBorder(new MatteBorder(0, 0, 10, 0, Welcome.SEPERATOR));

    //adding elements to panel
    buttonPanel.add(exitButton);
    buttonPanel.add(closeButton);
    buttonPanel.add(compareButton);
    buttonPanel.add(insertButton);
    buttonPanel.add(floorButton);
    buttonPanel.add(helpButton);

    //adding panel and table to frame
    this.add(scrollTable, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.NORTH);

    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    // Creates database table
    String dbName = "tileInfo";
    String tableName = "Tiles";
    String[] columnHeaders = {"tileName", "filePath", "tileDimensions", "tileSqft", "tilePricePerSqft"};
    new Display(dbName, tableName, columnHeaders);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    String command = e.getActionCommand();

    //if statements to close or open frames from button
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
    if (command.equals("COMPARE TILES"))
    {
      CompareTiles frameObject = new CompareTiles("Compare Tiles"); // defining frame
    }
  }
}
