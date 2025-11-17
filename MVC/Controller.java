package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private User user;
    private View view;

    public Controller(User u, View v){
        this.user = u;
        this.view = v;
        this.view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = view.getUsername();
                String password = view.getPassword();
                if (username.isEmpty() || password.isEmpty()) {
                    view.setMessage("Please enter username and password");
                } else {
                    view.setMessage("Login successful: " + username);
                }
            }
        });
    }
}
