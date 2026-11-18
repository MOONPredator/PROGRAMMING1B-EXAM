/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guimattresssales;

/**
 *
 * @author Student
 */

public class ProductCalculations implements IProductCalculations {

    @Override
    public double GetVat(double price) {
        return price * 0.15;
    }

    @Override
    public double GetCommission(double price) {
        return price * 0.05;
    }

    @Override
    public double GetTotal(double price) {
        return price + GetVat(price) + GetCommission(price);
    }
}
