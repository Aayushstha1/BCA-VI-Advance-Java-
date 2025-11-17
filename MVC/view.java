package MVC;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Unit1.JFRAME;

public class View extends JFRAME {
    private JTextField tuser = new JTextField(20);
    private JPasswordField tpass = new JPasswordField(20);
    private JButton bLogin = new JButton("Login");
    private JLabel lMessage = new JLabel();

    public View(){
        super("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(4,1));
        p.add(new JLabel("Username"));
        p.add(tuser);
        p.add(new JLabel("Password"));
        p.add(tpass);
        p.add(bLogin);
        p.add(lMessage);
        
        add(p);
    }

    public String getUsername(){
        return tuser.getText();
    }

    public String getPassword(){
        return new String(tpass.getPassword());
    }

    public JButton getLoginButton(){
        return bLogin;
    }

    public void setMessage(String msg){
        lMessage.setText(msg);
    }
}
