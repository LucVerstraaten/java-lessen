/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author Luc Verstraaten
 */
public class Rekening {

    private int nummer;
    private double saldo;
    private String eigenaar;

    public Rekening(int nummer, double saldo, String eigenaar) {
        this.nummer = nummer;
        this.saldo = saldo;
        this.eigenaar = eigenaar;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEigenaar() {
        return eigenaar;
    }

    public void setEigenaar(String eigenaar) {
        this.eigenaar = eigenaar;
    }

    public void opwaarderen(double s) {
        saldo += s;
    }

    public void opnemen(double s) {
        saldo -= s;
    }
}
