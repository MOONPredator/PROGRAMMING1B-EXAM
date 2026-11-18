/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package guimattresssales;


/**
 *
 * @author Student
 */

import GetVat.ProductCalculations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations c = new ProductCalculations();
        assertEquals(525.0, c.GetVat(3500), 0.01);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations c = new ProductCalculations();
        assertEquals(4200.0, c.GetTotal(3500), 0.01);
    }
}
