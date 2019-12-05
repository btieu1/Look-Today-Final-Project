import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class login extends JFrame {
  JButton blogin;
  JPanel loginpanel;
  JTextField pass;
  JButton changePassword;
  JLabel password;

  public TabDemoEXP demo;
  public TabDemoEXP recordedVersion;

  public login(){
    
    super("Login Autentification");
   
    blogin = new JButton("Login");
    loginpanel = new JPanel();
    pass = new JPasswordField(15);
    changePassword = new JButton("Change Password");
    password = new JLabel("Pass - ");

    setSize(300,200);
    setLocation(500,280);
    loginpanel.setLayout (null); 


    pass.setBounds(70,65,150,20);
    blogin.setBounds(110,100,80,20);
    changePassword.setBounds(110,135,80,20);
    password.setBounds(20,63,80,20);

    loginpanel.add(blogin);
    loginpanel.add(pass);
    loginpanel.add(changePassword);
    loginpanel.add(password);

    getContentPane().add(loginpanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    Writer writer = null;
    File check = new File("userPass.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("userPass.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }




    blogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          File file = new File("userPass.txt");
          Scanner scan = new Scanner(file);;
          String line = null;
          FileWriter filewrite = new FileWriter(file, true);

          String passtxt = " ";
          String ppaswd = pass.getText();


          while (scan.hasNext()) {
            passtxt = scan.nextLine();

          }




          if(ppaswd.equals(passtxt)) {
            JFrame frame = new JFrame("WardDrobe");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
            //Create and set up the content pane.
            
               demo = new TabDemoEXP();
               demo.addComponentToPane(frame.getContentPane());
             
           
            
            //Display the window.
            frame.pack();
            frame.setVisible(true);
                        
            dispose();
          } 
          else if(ppaswd.equals("")){
            JOptionPane.showMessageDialog(null,"Please insert Username and Password");
          }
          else {

            JOptionPane.showMessageDialog(null,"Wrong Username / Password");
            pass.setText("");
            //txuser.requestFocus();
          }
        } catch (IOException d) {
          d.printStackTrace();
        }

      }
    });

    changePassword.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        ChangePassword diffPass = new ChangePassword();
        dispose();

      }
    });
  } 
  public static void main(String[] args) {
      // Creates SalaryLabelFrame and its components
      login loginScreen = new login();

      /*myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);*/
   }
   
   
}
