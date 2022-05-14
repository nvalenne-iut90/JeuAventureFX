package gameFX.control.events;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HubController {
    @FXML
    private Label welcome;

    private Parent root;
    private Stage stage;
    private Scene scene;

    public void setLabel(String pseudo, String sexe){
        if (sexe.equals("Masculin")){
            welcome.setText("Bienvenue Guerrier " + pseudo);
        } else {
            welcome.setText("Bienvenue Guerrière " + pseudo);
        }
    }

    @FXML
    public void goToStages(MouseEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/gameFX/view/stage/stageMenu.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void goToShop(MouseEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/gameFX/view/stage/shop.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void goToInventory(MouseEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/gameFX/view/stage/inventory.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void quit(MouseEvent e){
        System.out.println("Au revoir....");
        System.exit(0);
    }
}
