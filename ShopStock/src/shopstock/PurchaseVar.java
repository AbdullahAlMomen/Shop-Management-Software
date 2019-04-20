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

public class PurchaseVar {
    String ProductName;
    String PurchaseDate;
    int PurchaseQuantity;
    float PurchasePrice;
    float PurchaseTotal;
    
    public PurchaseVar(String a,String b, int c,float d,float e){
        ProductName=a;
        PurchaseDate=b;
        PurchaseQuantity=c;
        PurchasePrice=d;
        PurchaseTotal=e;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getPurchaseDate() {
        return PurchaseDate;
    }

    public int getPurchaseQuantity() {
        return PurchaseQuantity;
    }

    public float getPurchasePrice() {
        return PurchasePrice;
    }

    public float getPurchaseTotal() {
        return PurchaseTotal;
    }
}
