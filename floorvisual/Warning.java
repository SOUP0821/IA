/*
Warning frame for if anything goes wrong
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

public class Warning extends JFrame implements ActionListener
{

  //declaring variables
  private JPanel buttonPanel;
  private JPanel messagePanel;
  private JButton exitButton;
  private JButton helpButton;
  private JButton closeButton;
  private JLabel helpLabel;

  public Warning(String name)
  {
    //constructing frame
    super(name);
    this.setBounds(300, 90, 850, 600);
    this.getContentPane().setBackground(Welcome.BACK);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());

    //defining and constructing label
    helpLabel = new JLabel("<html><br><br><br>THERE SEEMS TO BE AN ERROR IN THE <br>DATA VALUES "
      + " YOU HAVE ENTERED <br>PLEASE MAKE SURE THEY ARE <br>NORMAL VALUES!!!!<html>");
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

    //defining and constructing panels
    this.buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(Welcome.TOP_BAR);
    buttonPanel.setBorder(new MatteBorder(0, 0, 10, 0, Welcome.SEPERATOR));

    this.messagePanel = new JPanel(new FlowLayout());
    messagePanel.setBackground(Welcome.BACK);

    //adding elements to panels
    messagePanel.add(helpLabel);
    buttonPanel.add(exitButton);
    buttonPanel.add(closeButton);
    buttonPanel.add(helpButton);

    //adding panels to frame
    this.add(buttonPanel, BorderLayout.NORTH);
    this.add(messagePanel, BorderLayout.CENTER);

    this.setVisible(true);
  }

  public static void main(String[] args)
  {
    Warning frameObject = new Warning("Warning");//defining frame
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    String command = e.getActionCommand();

    //if statements to open or close frames
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
  }
}
