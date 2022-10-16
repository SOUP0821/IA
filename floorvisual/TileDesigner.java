/*
This program allows for the tile patterns to be designed
methods for the patterns
 */
package floorvisual;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TileDesigner extends JFrame
{

  // declaring variables
  GridBagLayout gridBag;
  GridBagConstraints constraints;
  GridBagLayout rowLayout;

  private JFrame frame1 = new JFrame("Design 1");
  private JFrame frame2 = new JFrame("Design 2");
  private JFrame frame3 = new JFrame("Design 3");
  private JFrame frame4 = new JFrame("Design 4");
  private JFrame frame5 = new JFrame("Design 5");

  private TilesInfo tilesInfo;

  public TileDesigner()
  {
    super();
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //this.setBounds(100, 200, 800, 800);
  }

  // first design methond
  public void tileDesignOne(int rows, int cols, int groutWidth, String path) // parameters to pass
  {
    //declaring variables
    gridBag = new GridBagLayout();
    constraints = new GridBagConstraints();
    constraints.ipadx = groutWidth;
    constraints.ipady = groutWidth;
    JPanel panel = new JPanel(gridBag);

    //refrencing TilesInfo class in order to get info
    TilesInfo tilesInfo = new TilesInfo(path);
    // declaring more variables
    int tileL = (int) tilesInfo.getLength() * 32;
    int tileW = (int) tilesInfo.getWidth() * 32;
    rows = rows / (int) tilesInfo.getLength();
    cols = cols / (int) tilesInfo.getWidth();

    java.net.URL MY_PATH = getClass().getResource(path);
    ImageIcon tileIcon = new ImageIcon(new ImageIcon(
      MY_PATH).getImage().getScaledInstance(tileW, tileL, Image.SCALE_SMOOTH));

    // setting constriants for layout
    gridBag.setConstraints(panel, constraints);
    // for loops to get number of tiles in designated size
    for (int i = 0; i < rows; i++)
    {
      for (int j = 0; j < cols; j++)
      {
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST; // sets images to the west
        if (j == cols - 1)
        {
          // fills in cell
          constraints.gridwidth = GridBagConstraints.REMAINDER;
        }
        // adds image to each cell
        JLabel tile = new JLabel(tileIcon);
        gridBag.setConstraints(tile, constraints);
        panel.add(tile);
      }
    }
    // adding components to frame and packing it
    frame1.add(panel);
    frame1.pack();
    frame1.setVisible(true);
    frame1.setResizable(false);
  }

  // second design 
  public void tileDesignTwo(int rows, int cols, int groutWidth, String path)
  {
    // declaring variables
    gridBag = new GridBagLayout();
    constraints = new GridBagConstraints();
    constraints.insets = new Insets(groutWidth, 0, 0, 0);

    //setting constraints
    constraints.gridx = 0;
    constraints.anchor = GridBagConstraints.WEST;

    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(groutWidth, 0, 0, groutWidth);
    constraints.anchor = GridBagConstraints.WEST;

    //the panel for arranging tiles in a row
    JPanel rowPanel = null;

    //the main panel for arranging all the tiles
    JPanel panel = new JPanel(gridBag);
    gridBag.setConstraints(panel, constraints);
    JLabel tile;

    // declaring variables
    TilesInfo tilesInfo = new TilesInfo(path);
    int tileL = (int) tilesInfo.getLength() * 32;
    int tileW = (int) (tilesInfo.getWidth() * 32) - groutWidth;
    rows = rows / (int) tilesInfo.getLength();
    cols = cols / (int) tilesInfo.getWidth();

    java.net.URL MY_PATH = getClass().getResource(path);
    ImageIcon tileIcon = new ImageIcon(new ImageIcon(
      MY_PATH).getImage().getScaledInstance(tileW, tileL, Image.SCALE_SMOOTH));
    // setting size for second image/tile
    ImageIcon tileIcon1 = new ImageIcon(new ImageIcon(
      MY_PATH).getImage().getScaledInstance(tileW / 2, tileL, Image.SCALE_SMOOTH));

    int colSize = 0;

    for (int i = 0; i < rows; i++)
    {
      rowLayout = new GridBagLayout();
      rowPanel = new JPanel(rowLayout);
      rowLayout.setConstraints(rowPanel, c);

      // for rows that have 2 partial tiles , add additional tile
      if (i % 2 != 0)
      {
        colSize = cols + 1;
      }
      else
      {
        colSize = cols;
      }

      for (int j = 0; j < colSize; j++)
      {
        if ((i % 2) != 0 && ((j == 0) || (j == colSize - 1)))
        {
          tile = new JLabel(tileIcon1); // adding smaller image to cell
        }
        else
        {
          tile = new JLabel(tileIcon);
        }
        if (j == colSize - 1)
        {
          c.insets = new Insets(groutWidth, 0, 0, 0);
        }
        else
        {
          c.insets = new Insets(groutWidth, 0, 0, groutWidth);
        }
        //adding cells to row panel
        rowLayout.setConstraints(tile, c);
        rowPanel.add(tile);
      }
      if (i == 0)
      {
        constraints.insets = new Insets(0, 0, 0, 0);
      }
      gridBag.setConstraints(rowPanel, constraints);
      panel.add(rowPanel);
    }
    // setting up frame
    frame2.add(panel);
    frame2.pack();
    frame2.setVisible(true);
    frame2.setResizable(false);
  }

  // design three
  public void tileDesignThree(int rows, int cols, int groutWidth, String path)
  {

    // declaring variables
    gridBag = new GridBagLayout();
    constraints = new GridBagConstraints();
    constraints.insets = new Insets(groutWidth, 0, 0, 0);

    constraints.gridx = 0;
    constraints.anchor = GridBagConstraints.WEST;

    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(groutWidth, 0, 0, groutWidth);

    //the panel for arranging tiles in a row
    JPanel rowPanel = null;

    //the main panel for arranging all the tiles
    JPanel panel = new JPanel(gridBag);
    gridBag.setConstraints(panel, constraints);
    JLabel tile;

    TilesInfo tilesInfo = new TilesInfo(path);
    int tileL = (int) tilesInfo.getLength() * 32;
    int tileW = (int) (tilesInfo.getWidth() * 32);
    rows = rows / (int) tilesInfo.getLength();
    cols = (cols + 1);
    cols = cols / (int) tilesInfo.getWidth();

    java.net.URL MY_PATH = getClass().getResource(path);
    ImageIcon tileIcon = new ImageIcon(new ImageIcon(
      MY_PATH).getImage().getScaledInstance(tileW, tileL, Image.SCALE_SMOOTH));
    ImageIcon tileIcon1 = new ImageIcon(new ImageIcon(
      MY_PATH).getImage().getScaledInstance(tileW / 2, tileL, Image.SCALE_SMOOTH));

    // loops for total tiles
    for (int i = 0; i < rows; i++)
    {
      rowLayout = new GridBagLayout();
      rowPanel = new JPanel(rowLayout);
      rowLayout.setConstraints(rowPanel, c);

      for (int j = 0; j < cols; j++)
      {
        if ((j == 0) || (j == cols - 1))
        {
          tile = new JLabel(tileIcon1); // adding smaller tile to edges
        }
        else
        {
          tile = new JLabel(tileIcon);
        }
        if (j == cols - 1)
        {
          c.insets = new Insets(groutWidth, 0, 0, 0);
        }
        else
        {
          c.insets = new Insets(groutWidth, 0, 0, groutWidth);
        }
        rowLayout.setConstraints(tile, c);
        rowPanel.add(tile);
      }
      if (i == 0)
      {
        constraints.insets = new Insets(0, 0, 0, 0);
      }
      gridBag.setConstraints(rowPanel, constraints);
      panel.add(rowPanel);
    }
    frame3.add(panel);
    frame3.pack();
    frame3.setVisible(true);
    frame3.setResizable(false);
  }

  // forth design
  public void tileDesignFour(int rows, int cols, int groutWidth, String path)
  {
    //declaring variables
    gridBag = new GridBagLayout();
    constraints = new GridBagConstraints();
    constraints.insets = new Insets(groutWidth, 0, 0, groutWidth);

    constraints.gridx = 0;
    constraints.anchor = GridBagConstraints.WEST;

    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(groutWidth, 0, 0, groutWidth);
    //the panel for arranging tiles in a row
    JPanel rowPanel = null;

    //the main panel for arranging all the tiles
    JPanel panel = new JPanel(gridBag);
    gridBag.setConstraints(panel, constraints);

    JLabel tile;

    TilesInfo tilesInfo = new TilesInfo(path);
    int tileL = (int) tilesInfo.getLength() * 32;
    int tileW = (int) (tilesInfo.getWidth() * 32);
    rows = rows / (int) tilesInfo.getLength();
    cols = cols / (int) tilesInfo.getWidth();

    java.net.URL MY_PATH = getClass().getResource(path);
    ImageIcon tileIcon = new ImageIcon(new ImageIcon(
      MY_PATH).getImage().getScaledInstance(tileW, tileL, Image.SCALE_SMOOTH));
    ImageIcon tileIcon2 = new ImageIcon(new ImageIcon(
      MY_PATH).getImage().getScaledInstance(tileW, tileL / 2, Image.SCALE_SMOOTH));

    for (int i = 0; i < rows; i++)
    {
      rowLayout = new GridBagLayout();
      rowPanel = new JPanel(rowLayout);
      rowLayout.setConstraints(rowPanel, c);

      for (int j = 0; j < cols; j++)
      {
        if ((i + j) % 2 != 0)
        {
          //the panel for arranging half tiles alternately
          GridBagLayout patternLayout = new GridBagLayout();
          JPanel patternPanel = new JPanel(patternLayout);
          patternLayout.setConstraints(patternPanel, constraints);

          tile = new JLabel(tileIcon2);
          patternLayout.setConstraints(tile, constraints);
          patternPanel.add(tile);

          tile = new JLabel(tileIcon2);
          patternLayout.setConstraints(tile, constraints);
          patternPanel.add(tile);
          rowLayout.setConstraints(tile, constraints);
          rowPanel.add(patternPanel);

        }
        else
        {
          tile = new JLabel(tileIcon);
          rowLayout.setConstraints(tile, c);
          rowPanel.add(tile);

        }

      }

      gridBag.setConstraints(rowPanel, constraints);
      panel.add(rowPanel);
    }
    frame4.add(panel);
    frame4.pack();
    frame4.setVisible(true);
    frame4.setResizable(false);
  }

  // fifth design
  public void tileDesignFive(int rows, int cols, int groutWidth, String path, String path2)
  {
    //declaring variables
    gridBag = new GridBagLayout();
    constraints = new GridBagConstraints();
    constraints.insets = new Insets(groutWidth, 0, 0, groutWidth);

    constraints.gridx = 0;
    constraints.anchor = GridBagConstraints.WEST;

    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(groutWidth, 0, 0, groutWidth);
    //the panel for arranging tiles in a row
    JPanel rowPanel = null;

    //the main panel for arranging all the tiles
    JPanel panel = new JPanel(gridBag);
    gridBag.setConstraints(panel, constraints);
    JLabel tile;

    TilesInfo tilesInfo = new TilesInfo(path);
    int tileL = (int) tilesInfo.getLength() * 32;
    int tileW = (int) (tilesInfo.getWidth() * 32);
    rows = rows / (int) tilesInfo.getLength();
    cols = cols / (int) tilesInfo.getWidth();

    java.net.URL MY_PATH = getClass().getResource(path);
    ImageIcon tileIcon = new ImageIcon(new ImageIcon(
      MY_PATH).getImage().getScaledInstance(tileW, tileL, Image.SCALE_SMOOTH));
    java.net.URL MY_PATH1 = getClass().getResource(path2);
    ImageIcon secondIcon = new ImageIcon(new ImageIcon(
      MY_PATH1).getImage().getScaledInstance(tileW, tileL, Image.SCALE_SMOOTH));

    // for loop for tiles and to alterante inbewtween images
    for (int i = 0; i < rows; i++)
    {
      rowLayout = new GridBagLayout();
      rowPanel = new JPanel(rowLayout);
      rowLayout.setConstraints(rowPanel, c);

      for (int j = 0; j < cols; j++)
      {
        if ((i % 2) != 0)
        {
          tile = new JLabel(tileIcon);
        }
        else
        {
          tile = new JLabel(secondIcon);
        }
        rowLayout.setConstraints(tile, c);
        rowPanel.add(tile);
      }
      gridBag.setConstraints(rowPanel, constraints);
      panel.add(rowPanel);
    }
    frame5.add(panel);
    frame5.pack();
    frame5.setVisible(true);
    frame5.setResizable(false);
  }

  public static void main(String[] args)
  {
  }
}
