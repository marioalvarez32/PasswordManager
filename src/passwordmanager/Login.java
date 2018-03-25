package passwordmanager;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.control.Label;


/**
 * Created by Mario Alvarez on 2/2/2016.
 */

public class Login {
    private double initX;
    private double initY;
    final Administrator mainAdmin = new Administrator(new Person("Juan", "Alvarez", "Male"), "test", "test");
    private ManagerGUI manager;

    public Login(final Stage userStage ){
        logInit();
    }

    private void logInit() {
        final Stage loginStage = new Stage(StageStyle.TRANSPARENT);

        //████████████CONTAINERS████████████\\

        Group rootGroup = new Group();

        Pane pnFrame = new Pane();
        pnFrame.setId("pnFrame");

        pnFrame.setMinSize(Config.LOGIN_HEIGHT, Config.LOGIN_HEIGHT);

        //pnFrame.setBackground(new Background(new BackgroundImage(new Image("resources/Images/hd_wallpaper.1504.jpg"),
        //BackgroundRepeat.SPACE,BackgroundRepeat.REPEAT,
        //BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
        
            pnFrame.setStyle("-fx-background-image:url(resources/Images/background_4.png)");
        
        //█████████████████EFFECTS█████████████████\\
        
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-500.0D);
        
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(100.0D);
        
        Lighting lightingText = new Lighting();
        lightingText.setLight(light);
        lightingText.setSurfaceScale(200.0D);
        
        //████████████TEXT/Labels CONTROLS████████████\\
        
        final Label txtLogo = new Label("Manager");
        final Label lblInvalidData=new Label("Invalid username or password");
        final PasswordField txfPass = new PasswordField();
        final TextField txfUsn = new TextField();
        
        //Blend blend=new Blend(BlendMode.ADD);
        //blend.setBottomInput()
        
        lblInvalidData.setId("lblInvalidData");
        lblInvalidData.setVisible(false);
        txtLogo.setId("txtLogo");
        //txtLogo.setEffect(new Lighting());
        //txtLogo.setEffect(new Bloom());
        //txtLogo.setBoundsType(TextBoundsType.VISUAL);
        //txtLogo.setFont(Font.font( Font.getFamilies().get(0), 70.0D));
        
        txfPass.setVisible(false);
        txfPass.setOpacity(0.0D);
        txfPass.setId("txfPass");
        txfPass.setDisable(true);
        txfPass.setPromptText("Password");
        
        txfUsn.setId("txfUsn");
        txfUsn.setOpacity(0.0D);
        txfUsn.setVisible(false);
        txfUsn.setDisable(true);
        txfUsn.setPromptText("Username");
        
        //████████████CONTROLS████████████\\
        
        final Button btnExit = new Button("X");
        final Button btnAdmin = new Button("Log In");
        
        final Button btnLogIn = new Button("Log In");
        final Button btnBack = new Button("Cancel");
        
        btnExit.setId("btnExit");
        btnExit.setMinSize(40.0D, 40.0D);
        
        btnAdmin.setMinSize(200.0D, 50.0D);
        btnAdmin.setId("btnAdmin");
        
        btnLogIn.setMinSize(200.0D, 50.0D);
        btnLogIn.setId("btnLogIn");
        btnLogIn.setDisable(true);
        btnLogIn.setVisible(false);
        btnLogIn.setOpacity(0.0D);

        btnBack.setMinSize(200.0D, 50.0D);
        btnBack.setId("btnCancel");
        btnBack.setDisable(true);
        btnBack.setVisible(false);
        btnBack.setOpacity(0.0D);

        Rectangle r1 = new Rectangle(25.0D, 200.0D);

        r1.setEffect(lighting);
        r1.setY(375.0D);
        r1.setX(350.0D);
        r1.setRotate(45.0D);

        Rectangle r2 = new Rectangle(25.0D, 300.0D);

        //r2.setEffect(lighting);
        r2.setY(275.0D);
        r2.setX(350.0D);
        r2.setEffect(lighting);
        r2.setRotate(45.0D);

        r1.setId("recRibbon");
        r2.setId("recRibbon");

        //████████████LISTENERS████████████\\
        pnFrame.setOnMousePressed(me -> {
            this.initX = (me.getScreenX() - loginStage.getX());
            this.initY = (me.getScreenY() - loginStage.getY());
        });

        pnFrame.setOnMouseDragged(me ->{
            loginStage.setX(me.getScreenX() - this.initX);
            loginStage.setY(me.getScreenY() - this.initY);

        });

        btnExit.setOnAction(event -> loginStage.close());

        btnAdmin.setOnAction(event -> {
            btnLogIn.setDisable(false);
            btnLogIn.setVisible(true);
            btnBack.setDisable(false);
            btnBack.setVisible(true);
            txfUsn.setVisible(true);
            txfUsn.setDisable(false);
            txfPass.setVisible(true);
            txfPass.setDisable(false);

            Timeline timeline = new Timeline();
            timeline.setCycleCount(1);
            timeline.setAutoReverse(false);

            KeyValue anmAdmin = new KeyValue(btnAdmin.layoutYProperty(), 125);
            KeyValue anmAdmin2 = new KeyValue(btnAdmin.layoutXProperty(), -75);
            KeyValue anmAdmin3 = new KeyValue(btnAdmin.minWidthProperty(), 150);
            KeyValue anmAdmin4 = new KeyValue(btnAdmin.opacityProperty(), 0);

            KeyValue anmLogIn = new KeyValue(btnLogIn.layoutYProperty(), 125);
            KeyValue anmLogIn2 = new KeyValue(btnLogIn.layoutXProperty(), -75);
            KeyValue anmLogIn3 = new KeyValue(btnLogIn.minWidthProperty(), 150);
            KeyValue anmLogIn4 = new KeyValue(btnLogIn.opacityProperty(), 1);

            //KeyValue anmBack = new KeyValue(btnUser.layoutYProperty(), 50);
            //KeyValue anmBack2 = new KeyValue(btnUser.layoutXProperty(), 125);
            //KeyValue anmBack3 = new KeyValue(btnUser.minWidthProperty(), 150);
            //KeyValue anmBack4 = new KeyValue(btnUser.opacityProperty(), 0);
            
            KeyValue anmUser = new KeyValue(btnBack.layoutYProperty(), 50);
            KeyValue anmUser2 = new KeyValue(btnBack.layoutXProperty(), 125);
            KeyValue anmUser3 = new KeyValue(btnBack.minWidthProperty(), 150);
            KeyValue anmUser4 = new KeyValue(btnBack.opacityProperty(), 1);
            
            KeyValue anmTxfUsn = new KeyValue(txfUsn.opacityProperty(),1);
            
            KeyValue anmTxfPass = new KeyValue(txfPass.opacityProperty(),1);
            
            KeyFrame kf = new KeyFrame(Duration.millis(800.0D), anmAdmin, anmAdmin2, anmAdmin3, anmAdmin4, anmLogIn,
                    anmLogIn2, anmLogIn3, anmLogIn4, anmUser, anmUser2,
                    anmUser3, anmUser4, anmTxfPass, anmTxfUsn); //anmBack, anmBack2, anmBack3, anmBack4

            timeline.getKeyFrames().add(kf);
            timeline.play();

        });
        
        btnBack.setOnAction(event -> {
            lblInvalidData.setVisible(false);
            txfPass.setDisable(true);
            txfUsn.setDisable(true);
            Timeline timeline = new Timeline();
            timeline.setCycleCount(1);
            timeline.setAutoReverse(false);
            
            KeyValue anmAdmin = new KeyValue(btnAdmin.layoutYProperty(), 0);
            KeyValue anmAdmin2 = new KeyValue(btnAdmin.layoutXProperty(), 0);
            KeyValue anmAdmin3 = new KeyValue(btnAdmin.minWidthProperty(), 200);
            KeyValue anmAdmin4 = new KeyValue(btnAdmin.opacityProperty(), 1);
            
            KeyValue anmLogIn = new KeyValue(btnLogIn.layoutYProperty(), 0);
            KeyValue anmLogIn2 = new KeyValue(btnLogIn.layoutXProperty(), 0);
            KeyValue anmLogIn3 = new KeyValue(btnLogIn.minWidthProperty(), 200);
            KeyValue anmLogIn4 = new KeyValue(btnLogIn.opacityProperty(), 0);
            
            //KeyValue anmBack = new KeyValue(btnUser.layoutYProperty(), 0);
            //KeyValue anmBack2 = new KeyValue(btnUser.layoutXProperty(), 0);
            //KeyValue anmBack3 = new KeyValue(btnUser.minWidthProperty(), 200);
            //KeyValue anmBack4 = new KeyValue(btnUser.opacityProperty(), 1);
            
            KeyValue anmUser = new KeyValue(btnBack.layoutYProperty(), 0);
            KeyValue anmUser2 = new KeyValue(btnBack.layoutXProperty(),0);
            KeyValue anmUser3 = new KeyValue(btnBack.minWidthProperty(), 200);
            KeyValue anmUser4 = new KeyValue(btnBack.opacityProperty(), 0);
            
            KeyValue anmTxfUsn = new KeyValue(txfUsn.opacityProperty(),0);
            
            KeyValue anmTxfPass = new KeyValue(txfPass.opacityProperty(), 0);
            
            KeyFrame kf = new KeyFrame(Duration.millis(700.0D), anmAdmin, anmAdmin2, anmAdmin3, anmAdmin4, anmLogIn,
                    anmLogIn2, anmLogIn3, anmLogIn4, anmUser, anmUser2, anmUser3,anmUser4, anmTxfUsn, anmTxfPass);
                    //anmBack, anmBack2, anmBack3, anmBack4

            timeline.getKeyFrames().add(kf);
            timeline.play();
            
            btnLogIn.setDisable(true);
            btnLogIn.setVisible(false);
            btnBack.setDisable(true);
            btnBack.setVisible(false);
        });
        
        btnLogIn.setOnAction(event -> {
            if ((txfUsn.getText().equals(mainAdmin.getUsername())) && (txfPass.getText().equals(mainAdmin.getPassword()))) {
                loginStage.close();
                this.manager=new ManagerGUI();
            } else {
                Timeline timeline = new Timeline();
                timeline.setCycleCount(4);
                timeline.setAutoReverse(true);

                KeyValue anmErrorUsn = new KeyValue(txfUsn.layoutXProperty(), -10);
                KeyValue anmErrorUsn1 = new KeyValue(txfUsn.layoutXProperty(), 10);
                KeyValue anmErrorPass = new KeyValue(txfPass.layoutXProperty(), -10);
                KeyValue anmErrorPass1 = new KeyValue(txfPass.layoutXProperty(), 10);
                KeyFrame kf = new KeyFrame(Duration.millis(25.0D), anmErrorUsn, anmErrorUsn1, anmErrorPass, anmErrorPass1);
                timeline.getKeyFrames().add(kf);
                timeline.play();
                lblInvalidData.setVisible(true);
            }
        });
        
        txtLogo.setWrapText(true);
        //████████████CHILDRENS████████████\\
        pnFrame.getChildren().addAll(txtLogo,lblInvalidData, r1, r2, btnAdmin,txfUsn, txfPass, btnLogIn, btnBack,btnExit);
        //rootGroup.getChildren().addAll(pnFrame, btnExit);
        
        //████████████STAGE/SCENE████████████\\
        Scene scene = new Scene(pnFrame, Config.LOGIN_WIDTH, Config.LOGIN_HEIGHT, Color.TRANSPARENT);
        
        scene.getStylesheets().add("resources/css/logIn.css");
        //loginStage.getIcons().add(new Image("resources/images/Icons/1455755373_Lock.png"));
        loginStage.setScene(scene);
        loginStage.centerOnScreen();
        loginStage.show();
    }
}
