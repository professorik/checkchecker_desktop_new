

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class MainController implements Initializable {
    @FXML
    private VBox vbox;
    private Parent fxml;

    public MainController() {
    }

    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.0D), this.vbox);
        t.setToX(this.vbox.getLayoutX() * 32.0D);
        t.play();
        t.setOnFinished((e) -> {
            try {
                this.fxml = (Parent)FXMLLoader.load(this.getClass().getResource("SignIn.fxml"));
                this.vbox.getChildren().removeAll(new Node[0]);
                this.vbox.getChildren().setAll(new Node[]{this.fxml});
            } catch (IOException var3) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, (String)null, var3);
            }

        });
    }

    @FXML
    private void open_signup(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.0D), this.vbox);
        t.setToX(14.0D);
        t.play();
        t.setOnFinished((e) -> {
            try {
                this.fxml = (Parent)FXMLLoader.load(this.getClass().getResource("SignUp.fxml"));
                this.vbox.getChildren().removeAll(new Node[0]);
                this.vbox.getChildren().setAll(new Node[]{this.fxml});
            } catch (IOException var3) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, (String)null, var3);
            }

        });
    }

    @FXML
    private void open_signin(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.0D), this.vbox);
        t.setToX(this.vbox.getLayoutX() * 32.0D);
        t.play();
        t.setOnFinished((e) -> {
            try {
                this.fxml = (Parent)FXMLLoader.load(this.getClass().getResource("SignIn.fxml"));
                this.vbox.getChildren().removeAll(new Node[0]);
                this.vbox.getChildren().setAll(new Node[]{this.fxml});
            } catch (IOException var3) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, (String)null, var3);
            }

        });
    }
}
