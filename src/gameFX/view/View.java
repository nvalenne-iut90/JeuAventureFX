package gameFX.view;

import gameFX.model.Model;
import javafx.stage.Stage;

public class View {
    private Model model;
    private Stage stage;
    public View(Model model, Stage stage){
        this.model = model;
        this.stage = stage;
    }
}
