/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.Model;

/**
 *
 * @author Heber
 */
public class Student {
    
    String Id;
    String name;
    String lastName;
    String phone;

    public Student(String Id, String name, String lastName, String phone) {
        this.Id = Id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    
}
