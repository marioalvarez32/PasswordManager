/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Mario Alvarez
 */
public class ManagerGUI {
   
    private double initX;
    private double initY;
    
    public ManagerGUI(){
        this.initManager();
    }
    
    public void initManager(){

         
        AnchorPane apMainFrame=new AnchorPane();
        
     /*╔════════════╡ FRAME BORDERPANE ╞════════════╗*/
        //
        BorderPane bpFrame= new BorderPane();//This will cntain the inside content and will have the mneu and a toolbar
        
              
        apMainFrame.setStyle("-fx-background-image: url(resources/Images/Backgrounds/BackgroundWood2.jpg);-fx-background-size:stretch;");
        bpFrame.setId("anchor");
        
        apMainFrame.setPrefSize(Config.MANAGER_WIDTH, Config.MANAGER_HEIGHT);
     /*╠════════════╡     TOP/MENU     ╞════════════╣*/
        //
        MenuBar menuBar=new MenuBar();
        menuBar.setPrefSize(Config.MANAGER_WIDTH, 50);
        Menu mnFile=new Menu("File");
        Menu mnAbout=new Menu("About");
        
        mnFile.setId("menu");
        mnAbout.setId("menu");
        
        MenuItem mniExit=new MenuItem("Exit");
        MenuItem mniNew=new MenuItem("New");
        
        menuBar.setId("menuBar");
     /*╠════════════╡   CENTER/TOOLS   ╞════════════╣*/
        //
        HBox toolSection=new HBox();
        Label lblNew=new Label("New");
        Button btnNew=new Button();
        Button btn1=new Button("Btn 1");
        Button btn2=new Button("Btn 2");
        Button btn3=new Button("Btn 3");
        Button btn4=new Button("Btn 4");
        Button btn5=new Button("Btn 5");
        
        btnNew.setGraphic(lblNew);
        lblNew.setId("toolBut");
        btnNew.setWrapText(true);
        btnNew.setId("xd");
        btnNew.setStyle("-fx-background-image:url(resources/Images/Wood/button3.png);");
        btnNew.setEffect(new DropShadow());
        
        toolSection.setPrefSize(Config.MANAGER_WIDTH, 150);
        toolSection.setId("tools");
        
        toolSection.setAlignment(Pos.CENTER);
        toolSection.setSpacing(50);
        
        btnNew.setPrefSize(60,60);
        btn1.setPrefSize(60,60);
        btn2.setPrefSize(60,60);
        btn3.setPrefSize(60,60);
        btn4.setPrefSize(60,60);
        btn5.setPrefSize(60,60);
            
        toolSection.getChildren().addAll(btnNew,btn1,btn2,btn3,btn4,btn5);
        
        
     /*╠════════════╡  BOTTOM/CONTENT  ╞════════════╣*/
        //
        
        /*┌───────────┤ CONTENT BORDERPANE├──────────┐*/ 
           BorderPane bpContent = new BorderPane();//This will contain the passwords and main content
            
                      
           bpContent.setId("bpContent");
           
           
           bpContent.setPrefSize(Config.MANAGER_WIDTH, 511);
        /*├───────────┤      TOP       ├────────────┤*/
           Pane pnTop=new Pane();
           pnTop.setPrefSize(bpContent.getWidth(), 40);
           pnTop.setId("pnTop");
        /*├───────────┤     CENTER     ├────────────┤*/
           Pane pnCenter=new Pane();
           FlowPane flowScreen=new FlowPane();
           ScrollPane scroll=new ScrollPane(); 
           
           //scroll.setMaxHeight(400);
           flowScreen.setPadding(new Insets(20,0,20,10));
           flowScreen.setVgap(25);
           flowScreen.setHgap(20);
           flowScreen.setId("flow");
           flowScreen.setMinWidth(900);
           //flowScreen.setPrefWrapLength(300);
           flowScreen.setOrientation(Orientation.HORIZONTAL);
           flowScreen.setAlignment(Pos.TOP_CENTER);
           //for(int cnt=0;cnt<60;cnt++){
           //    flowScreen.getChildren().add(new Rectangle(250,75,Color.GRAY));
           //    flowScreen.getChildren().get(cnt).setStyle("-fx-effect:dropshadow( one-pass-box , black , 5 , 2 , 2 , 1 );");
           //}
           
           scroll.setContent(flowScreen);
           //scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
           
        /*├───────────┤     LEFT       ├────────────┤*/
           Pane pnLeft=new Pane();
           pnLeft.setPrefSize(35, bpContent.getHeight());
           pnLeft.setId("pnLeft");
        /*├───────────┤     RIGHT      ├────────────┤*/
           Pane pnRight=new Pane();
           pnRight.setPrefSize(35, bpContent.getHeight());
           pnRight.setId("pnRight");
        /*├───────────┤     BOTTOM     ├────────────┤*/
           bpContent.setTop(pnTop);
           bpContent.setLeft(pnLeft);
           bpContent.setRight(pnRight);
           bpContent.setCenter(scroll);
        /*└───────────────────────────────────┘*/
     /*╚═════════════════════════════════════╝*/
        
        Stage managerStage = new Stage(StageStyle.TRANSPARENT);
        
        //████████████CHILDREN ADD████████████\\
        //bpFrame.setBottom(bpContent);
        //bpFrame.setTop(menu);
        //bpFrame.setCenter(toolSection);
        
        AnchorPane.setTopAnchor(menuBar, 0d);
        AnchorPane.setLeftAnchor(menuBar, 0d);
        
        AnchorPane.setTopAnchor(toolSection, 50d);
        AnchorPane.setRightAnchor(toolSection,0d);
        
        AnchorPane.setTopAnchor(bpContent,200d);
        AnchorPane.setRightAnchor(bpContent,0d);
        mnFile.getItems().addAll(mniExit,mniNew);
        menuBar.getMenus().addAll(mnFile,mnAbout);
       for(int cnt=0;cnt<10;cnt++){
        HBox win=new HBox();   
        Button x=new Button();
        Label l=new Label("Facebook"+cnt);
        
        x.setPrefSize(225,75);
        
        x.setGraphic(l);
        l.setId("xdL");
        
        x.setId("xd");
        x.setStyle("-fx-background-image:url(resources/Images/Wood/button3.png);");
        x.setEffect(new DropShadow());
        flowScreen.getChildren().add(x);
       }
       
        
        //x.setStyle("-fx-border-color:red;-fx-background-image: url(resources/Images/Backgrounds/backgroundWood2.jpg);");
        
        apMainFrame.getChildren().addAll(menuBar,toolSection,bpContent);
              
        //bpFrame.getChildren().addAll(scroll,rec7);
        
        //████████████LISTENERS████████████\\
        
        bpFrame.setOnMousePressed(me -> {
            this.initX = (me.getScreenX() - managerStage.getX());
            this.initY = (me.getScreenY() - managerStage.getY());
        });
        
        bpFrame.setOnMouseDragged(me ->{
            managerStage.setX(me.getScreenX() - this.initX);
            managerStage.setY(me.getScreenY() - this.initY);
        });
        
        btnNew.setOnAction(action ->{
            //
            final Stage accountAddStage = new Stage();
            AccountAddDialog accountAddDialog;
            accountAddStage.initOwner(managerStage);
            accountAddDialog = new AccountAddDialog();

            if(accountAddDialog.showDialog(accountAddStage)) {
                accountAddStage.close(); 
            }
            else{
                accountAddStage.close();
            }
                //for(int cnt=0;cnt<60;cnt++){
               //flowScreen.getChildren().add(new Rectangle(250,75,Color.GRAY));
              //flowScreen.getChildren().get(cnt).setStyle("-fx-effect:dropshadow( one-pass-box , black ,"+cnt+",10 , 2 , 1 );");
           //}
        });
        //████████████STAGE/SCENE████████████\\
              
        //mainScreen.setCenter(centerScreen);
        //scroll.setContent(flowScreen);
        //AnchorPane.setRightAnchor(scroll, 50d);
        
        //AnchorPane.setLeftAnchor(scroll, 50d);
        //AnchorPane.setTopAnchor(scroll, Config.MANAGER_HEIGHT/2 - 225);
        
        //AnchorPane.setLeftAnchor(rec7,0d);
        //AnchorPane.setTopAnchor(rec7,0d);
        
        //mainScreen.setCenter(centerLayout);
        Scene scene = new Scene(apMainFrame);
        scene.getStylesheets().add("resources/css/managerGUI.css");
        
        //mainScreen.setPrefSize(Config.MANAGER_HEIGHT, Config.MANAGER_WIDTH);
        
        //mainScreen.setTop(mbMenu);
        //mainScreen.setLeft(pnLeft);
        
        //mainScreen.setCenter(pnCenter);
        //managerStage.initModality(Modality.NONE);
        managerStage.initStyle(StageStyle.DECORATED);
        //managerStage.setFullScreenExitHint("Welcome");
        managerStage.setMinWidth(500);
        managerStage.setMaxHeight(750);
        //adminStage.setAlwaysOnTop(true);
        managerStage.setFullScreen(false);
        managerStage.setResizable(true);
        managerStage.setScene(scene);
        managerStage.centerOnScreen();
        managerStage.show();
    }
}
