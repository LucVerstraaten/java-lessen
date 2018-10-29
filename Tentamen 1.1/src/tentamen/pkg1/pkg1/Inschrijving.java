/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tentamen.pkg1.pkg1;

/**
 *
 * @author Luc Verstraaten
 */
public class Inschrijving {
    private Student student;
    private Voorlichtingsmoment voorlichtingsmoment;
    private Opleiding opleiding;

    public Inschrijving(Student student, Voorlichtingsmoment voorlichtingsmoment, Opleiding opleiding) {
        this.student = student;
        this.voorlichtingsmoment = voorlichtingsmoment;
        this.opleiding = opleiding;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Voorlichtingsmoment getVoorlichtingsmoment() {
        return voorlichtingsmoment;
    }

    public void setVoorlichtingsmoment(Voorlichtingsmoment voorlichtingsmoment) {
        this.voorlichtingsmoment = voorlichtingsmoment;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }

    @Override
    public String toString() {
        return "Inschrijving:" + "student:" + student + ", voorlichtingsmoment:" + voorlichtingsmoment + ", opleiding:" + opleiding;
    }
    
    
    
}
