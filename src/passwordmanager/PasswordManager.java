/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Mario Alvarez
 */
public class PasswordManager extends Application {
    private Login log;
    private ManagerGUI manager;
    
    @Override
    public void start(Stage primaryStage) {
        //log=new Login(primaryStage);
        manager=new ManagerGUI();
        final Stage accountAddStage = new Stage();
            AccountAddDialog accountAddDialog;
            accountAddStage.initOwner(primaryStage);
            accountAddDialog = new AccountAddDialog();

            //if(accountAddDialog.showDialog(accountAddStage)) {
             //   accountAddStage.close(); 
            //}
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
