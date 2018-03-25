/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Unkown
 */
public class Person {
    private String firstName;
    private String lastName;
    private String fullName;
    private String address;
    private Date birthDate;
    private String gender;//true=male false=female
    private String phoneNumber;
    /*fasdlkfja;df
    
    //integer.valueOf(str);
    //integer.parseInt(str);
    */
    public Person(String firstName,String lastName,String gender,String phoneNumber,Date birthDate){
        this.firstName=formatText(firstName);
        this.lastName=formatText(lastName);
        this.fullName=this.firstName+" "+this.lastName;
        //this.address=address;
        this.birthDate=birthDate;
        this.gender=formatText(gender);
        this.phoneNumber=phoneNumber;
    }
    public Person(String firstName,String lastName,String gender){
        this.firstName=formatText(firstName);
        this.lastName=formatText(lastName);
        this.gender=formatText(gender);
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getFullName(){
        return this.fullName;
    }
    public String getAddress(){
        return this.address;
    }
    public Date getBirthDate(){
        return birthDate;
    }
    public String getBirthDateString(){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(this.getBirthDate());
        return calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DAY_OF_MONTH)+"/"+calendar.get(Calendar.YEAR);
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
        this.fullName=firstName+this.lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName=lastName;
        this.fullName=this.firstName+lastName;
    }
    private String formatText(String text){

        return text.substring(0,1).toUpperCase()+text.substring(1).toLowerCase();
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setBirthDate(Date birthDate){
        this.birthDate=birthDate;
    }
}
