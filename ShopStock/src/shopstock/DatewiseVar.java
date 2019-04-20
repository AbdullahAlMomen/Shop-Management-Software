/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopstock;

/**
 *
 * @author User
 */
public class DatewiseVar {
    int OpeningStock;
    int Purchase;
    int Sale;
    int Damage;
    int ClosingStock;

    public int getOpeningStock() {
        return OpeningStock;
    }

    public int getPurchase() {
        return Purchase;
    }

    public int getSale() {
        return Sale;
    }

    public int getDamage() {
        return Damage;
    }

    public int getClosingStock() {
        return ClosingStock;
    }
    
    public DatewiseVar(String p,int a,int b, int c,int d,int e){
        OpeningStock=a;
        Purchase=b;
        Sale=c;
        Damage=d;
        ClosingStock=e;
    }

   
    
}
