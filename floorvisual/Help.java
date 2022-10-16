/*
Help frame to help users
 */
package floorvisual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.MatteBorder;

public class Help extends JFrame implements ActionListener
{

  // declaring variables
  private JPanel buttonPanel;
  private JPanel messagePanel;
  private JButton exitButton;
  private JButton closeButton;
  private JButton helpButton;
  private JButton backButton;
  private JLabel helpLabel;

  public Help(String name)
  {
    //constructing frame
    super(name);
    this.setBounds(300, 90, 850, 600);
    this.getContentPane().setBackground(Welcome.BACK);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());

    // defining and constructing label
    helpLabel = new JLabel("<html><br><br>THIS PROGRAM WILL HELP ASSIST THE USER <br>VISUALIZE WHAT THEIR FLOOR LAYOUT"
      + " <br>WILL LOOK LIKE AND COMPARE IT WITH <br>OTHER FLOORS. IT ALSO HELPS WITH <br>FINDING THE PRICES"
      + " OF TILES AND FLOORS <br>THAT YOU ADD OR CREATE<html>");
    helpLabel.setFont(Welcome.MAIN_FONT);
    helpLabel.setForeground(Welcome.TEXT_COLOR);

    //defining and constructing buttons
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

    this.closeButton = new JButton("CLOSE");
    closeButton.addActionListener(this);
    closeButton.setBorderPainted(false);
    closeButton.setFont(Welcome.MAIN_FONT);
    closeButton.setForeground(Welcome.TEXT_COLOR);

    this.backButton = new JButton("BACK");
    backButton.addActionListener(this);
    backButton.setBorderPainted(false);
    backButton.setFont(Welcome.MAIN_FONT);
    backButton.setForeground(Welcome.TEXT_COLOR);

    //definign and contructing panel
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(Welcome.TOP_BAR);
    buttonPanel.setBorder(new MatteBorder(0, 0, 10, 0, Welcome.SEPERATOR));

    //definign and contructing panel
    this.messagePanel = new JPanel(new FlowLayout());
    messagePanel.setBackground(Welcome.BACK);

    //adding elements to panel
    messagePanel.add(helpLabel);
    buttonPanel.add(exitButton);
    buttonPanel.add(closeButton);
    buttonPanel.add(backButton);
    buttonPanel.add(helpButton);

    //adding panels to frame
    this.add(buttonPanel, BorderLayout.NORTH);
    this.add(messagePanel, BorderLayout.CENTER);

    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    Help frameObject = new Help("Help"); //defining frame
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    String command = e.getActionCommand();

    //if statement to close or open frames
    if (command.equals("X"))
    {
      System.exit(0);
    }
    if (command.equals("?"))
    {
      Help frameObject = new Help("Help");
    }
    if (command.equals("BACK"))
    {
      Welcome frameObject = new Welcome("Welcome");
      this.dispose();
    }
    if (command.equals("CLOSE"))
    {
      this.dispose();
    }
  }
}
