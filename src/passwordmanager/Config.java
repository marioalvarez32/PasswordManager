/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import javafx.stage.Screen;

/**
 *
 * @author Unkown
 */
public class Config {
    
    public static final double MANAGER_WIDTH = 1000;
    public static final double MANAGER_HEIGHT = 750;
    public static final double LOGIN_HEIGHT=500;
    public static final double LOGIN_WIDTH=400;

    private int cnt;
    public Config(){
        cnt=0;
    }
    
    public int getCnt(){
        return this.cnt;
    }
    
    public void setCnt(int x){
        this.cnt=x;
    }
    
}
