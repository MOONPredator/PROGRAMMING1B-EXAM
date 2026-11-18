/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productsalesreport;

/**
 *
 * @author Student
 */

public class Product implements IProduct {
    // 1D array for product names
    private String[] products;
    // 2D array for sales showing product and month
    private int[][] sales;

    public Product(String[] products, int[][] sales) {
        this.products = products;
        this.sales = sales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total = total + sales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = sales.length * sales[0].length;
        return (double) total / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int highest = -1;
        int index = 0;
        for (int i = 0; i < sales.length; i++) {
            int prodTotal = 0;
            for (int j = 0; j < sales[i].length; j++) {
                prodTotal = prodTotal + sales[i][j];
            }
            if (prodTotal > highest) {
                highest = prodTotal;
                index = i;
            }
        }
        return products[index] + "(" + highest + ")";
    }
}
