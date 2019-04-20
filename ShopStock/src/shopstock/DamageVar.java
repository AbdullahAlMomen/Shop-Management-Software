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

public class DamageVar {
    String ProductName;
    String DamageDate;
    int DamageQuantity;
    float DamagePrice;
    float DamageTotal;
    
    public DamageVar(String a,String b, int c,float d,float e){
        ProductName=a;
        DamageDate=b;
        DamageQuantity=c;
        DamagePrice=d;
        DamageTotal=e;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getDamageDate() {
        return DamageDate;
    }

    public int getDamageQuantity() {
        return DamageQuantity;
    }

    public float getDamagePrice() {
        return DamagePrice;
    }

    public float getDamageTotal() {
        return DamageTotal;
    }
}
