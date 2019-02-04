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
public class SpaarRekening extends Rekening{
    private double rente;

    public SpaarRekening(double rente, int nummer, double saldo, String eigenaar) {
        super(nummer, saldo, eigenaar);
        this.rente = rente;
    }

    public double getRente() {
        return rente;
    }

    public void setRente(double rente) {
        this.rente = rente;
    }
    
    public void voegRenteToe()
    {
        super.setSaldo(super.getSaldo()*rente);

    }
    
    
    
}
