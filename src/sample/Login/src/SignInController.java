import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    @FXML
    private Button SignInButton;
    @FXML
    private Button ForgetPasswordButton;
    @FXML
    private TextField LoginField;
    @FXML
    private TextField PasswordField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SignInButton.setOnAction(event -> {
            System.out.println(LoginField.getText());
            System.out.println(PasswordField.getText());
        });
        ForgetPasswordButton.setOnAction(event -> {
                System.out.println("Hello, motherfucker!!!");
        });
    }
}
