package gameFX.control.events;

import gameFX.Jeu;
import gameFX.model.item.Item;
import gameFX.model.personnage.player.Inventory;
import gameFX.model.personnage.pnj.Marchand;
import gameFX.view.stage.Shop;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class ShopController implements Initializable {

    private Shop shop;
    private Item[] articlesVente;

    @FXML
    private Label welcome, namePNJ;
    @FXML
    private VBox articles;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shop = new Shop();
        articlesVente = shop.getArticlesVente();
        setLabel();
        showArticles();

    }

    private void setLabel(){
        if ((Jeu.player.getSexe()).equals("Masculin")) {
            welcome.setText("Bienvenue étranger ! Approchez !! Approchez !!");
        } else if ((Jeu.player.getSexe()).equals("Féminin")) {
            welcome.setText("Bienvenue étrangère ! Approchez !! Approchez !!");
        }
    }

    private void showArticles(){
        Marchand marchand = new Marchand("Pierre", "Marchand");
        namePNJ.setText("Marchand " + marchand.getNom());
        namePNJ.setTextFill(Color.GREEN);
        for (Item article : articlesVente){
            HBox hbox = new HBox();
            Label label = new Label(article.getNameItem() + " : " + article.getPrice() + " pièces d'or");
            label.setStyle("-fx-font-size: 20px;-fx-text-alignment: center;");
            HBox.setMargin(label, new Insets(0,10,0,0));
            Button buy = new Button("ACHETER");
            buy.setStyle("-fx-background-color: green; -fx-text-fill: white;");

            hbox.getChildren().addAll(label, buy);
            hbox.setPadding(new Insets(10));

            articles.getChildren().add(hbox);
        }
    }

    private void showInventory(){
        Inventory inventory = Jeu.player.getInventory();
        for (Item item : inventory.getInventory()){
            HBox hbox = new HBox();
            Label label = new Label(item.getNameItem() + " : " + item.getPrice() + " pièces d'or");
            label.setStyle("-fx-font-size: 20px;-fx-text-alignment: center;");
            HBox.setMargin(label, new Insets(0,10,0,0));
            Button buy = new Button("VENDRE");
            buy.setStyle("-fx-background-color: orange; -fx-text-fill: white;");

            hbox.getChildren().addAll(label, buy);
            hbox.setPadding(new Insets(10));

            articles.getChildren().add(hbox);
        }
    }
}
