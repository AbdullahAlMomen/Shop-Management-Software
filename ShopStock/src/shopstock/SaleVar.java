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
public class SaleVar {
    String ProductName;
    String SaleDate;
    int SaleQuantity;
    float SalePrice;
    float SaleTotal;
    
    public SaleVar(String a,String b, int c,float d,float e){
        ProductName=a;
        SaleDate=b;
        SaleQuantity=c;
        SalePrice=d;
        SaleTotal=e;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getSaleDate() {
        return SaleDate;
    }

    public int getSaleQuantity() {
        return SaleQuantity;
    }

    public float getSalePrice() {
        return SalePrice;
    }

    public float getSaleTotal() {
        return SaleTotal;
    }
    
}
