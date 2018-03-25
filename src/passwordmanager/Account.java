/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import javafx.scene.image.Image;

/**
 *
 * @author Mario Alvarez
 */
public class Account {
    private String userName;
    private String accountName;
    private String url;
    private String email;
    private Password password;
    private String description;
    private Image logoImage;
    
    public Account(String userName,String accountName,String url,String email,String password,String description){
        this.userName=userName;
        this.accountName=accountName;
        this.url=url;
        this.email=email;
        this.password=new Password(password);
        this.description=description;
    }
    
    public Account(String userName,String accountName,String email,String password,String description){
        this.userName=userName;
        this.accountName=accountName;
        this.email=email;
        this.password=new Password(password);
        this.description=description;
    }
    
    public Account(String userName,String accountName,String email,String password){
        this.userName=userName;
        this.accountName=accountName;
        this.email=email;
        this.password=new Password(password);
    }
    
}
