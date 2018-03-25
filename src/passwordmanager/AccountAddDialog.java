package passwordmanager;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Mario Alvarez on 2/12/2016.
 */
public class AccountAddDialog {
    private double initX;
    private double initY;
    
    private boolean flag;
    public AccountAddDialog() {

    }
    public boolean showDialog(Stage addDialog){

            //████████████CONTAINERS████████████\\
            Pane mainScreen = new Pane();
            //Pane bannerScreen=new Pane();
            VBox vbLabels = new VBox();
            VBox vbTextFields = new VBox();
            HBox hbButtons = new HBox();

            //bannerScreen.setId("banner");
            hbButtons.setId("hbButtons");
            vbLabels.setId("vbLabels");
            vbTextFields.setId("vbTextFields");
            mainScreen.setId("mainScreen");
            //████████████IMAGES████████████\\

        Blend blend = new Blend();
        blend.setMode(BlendMode.OVERLAY);

        Lighting efLight=new Lighting();
        Reflection rf=new Reflection();
        rf.setFraction(.25);
        rf.setTopOffset(-10);

        blend.setBottomInput(rf);
        blend.setTopInput(efLight);

        Image image = new Image("resources/Images/Icons/1455755423_FAQ.png");
            ImageView imgView=new ImageView(image);
            imgView.setEffect(rf);

            imgView.setId("imgIcon");
            imgView.setFitWidth(80);
            imgView.setFitHeight(80);
            imgView.setSmooth(true);
            //████████████TEXT████████████\\
            final TextField txfUserName = new TextField();
            final TextField txfAccountName = new TextField();
            final TextField txfUrl = new TextField();
            final TextField txfEmail = new TextField();
            final TextField txfPassword = new TextField();
            final TextField txfDescription = new TextField();
            


            //████████████LABELS████████████\\
            final Label lblUserName = new Label("User Name");
            final Label lblAccountName = new Label("Account Name");
            final Label lblUrl = new Label("URL");
            final Label lblEmail = new Label("Email");
            final Label lblPassword = new Label("Password");
            final Label lblDescription = new Label("Description");
            
            final Label lblMessage = new Label("Add New Address");
            final Tooltip msg=new Tooltip();

            lblMessage.setId("lblMessage");
            //████████████BUTTONS████████████\\
            final Button btnSave = new Button("Save");
            final Button btnCancel = new Button("Cancel");
            final Button btnExit = new Button("X");

            btnExit.setId("btnExit");
            //████████████LISTENERS████████████\\
            btnExit.setOnAction(action -> {
                flag=false;
                addDialog.hide();
            });

            btnCancel.setOnAction(action -> {
                flag=false;
                addDialog.hide();
            });
            btnSave.setOnAction(saveAction -> {
                //this.address = new House(txfStreetNumber.getText(), txfStreet.getText(), txfColonia.getText(), txfQuinta.getText());
                flag=true;
                addDialog.hide();
            });
            mainScreen.setOnMousePressed(me -> {
                this.initX = (me.getScreenX() - addDialog.getX());
                this.initY = (me.getScreenY() - addDialog.getY());
            });

            mainScreen.setOnMouseDragged(me -> {
                addDialog.setX(me.getScreenX() - this.initX);
                addDialog.setY(me.getScreenY() - this.initY);
            });
            //████████████CHILDRENS████████████\\

            vbLabels.getChildren().addAll(lblUserName,lblAccountName,lblUrl,lblEmail,lblPassword, lblDescription);
            vbTextFields.getChildren().addAll(txfUserName,txfAccountName,txfUrl,txfEmail,txfPassword, txfDescription);
            hbButtons.getChildren().addAll(btnSave, btnCancel);
            //bannerScreen.getChildren().addAll(imgView,lblMessage);
            mainScreen.getChildren().addAll(vbLabels, vbTextFields, hbButtons);//, btnExit);
            //████████████STAGE/SCENE████████████\\

            //████████████STAGE/SCENE████████████\\
            Scene scene = new Scene(mainScreen, Color.TRANSPARENT);
            scene.getStylesheets().add("resources/css/dialogs.css");

            addDialog.centerOnScreen();
            //addDialog.initStyle(StageStyle.TRANSPARENT);
            addDialog.setResizable(false);
            addDialog.setScene(scene);
            addDialog.initModality(Modality.WINDOW_MODAL);
            //editDialog.setAlwaysOnTop(true);
            addDialog.showAndWait();

            return flag;
    }
    

}
