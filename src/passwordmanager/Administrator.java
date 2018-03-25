/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

/**
 *
 * @author Unkown
 */
public class Administrator {
    private Person admin;
    private String username;
    private String password;
    public Administrator(Person admin,String username,String password){
        this.admin=admin;
        this.username=username;
        this.password=password;
    }
    
    public Person getPerson(){
        return this.admin;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
}
