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
public class Lopenderekening extends Rekening{
    
    private int duur;

    public Lopenderekening(int duur, int nummer, double saldo, String eigenaar) {
        super(nummer, saldo, eigenaar);
        this.duur = duur;
    }

    public int getDuur() {
        return duur;
    }

    public void setDuur(int duur) {
        this.duur = duur;
    }
    
    
}
