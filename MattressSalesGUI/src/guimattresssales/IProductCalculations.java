/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guimattresssales;

/**
 *
 * @author Student
 */

public interface IProductCalculations {
    double GetVat(double price);
    double GetCommission(double price);
    double GetTotal(double price);
}
