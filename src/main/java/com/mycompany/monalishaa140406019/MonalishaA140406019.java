/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.monalishaa140406019;

import java.util.Scanner;

/**
 *
 * @author 40406019
 */
public class MonalishaA140406019 {
     // Helper class to store (year, month, value)
    static class DataPoint {
        int year;
        int month;
        int value;

        DataPoint(int year, int month, int value) {
            this.year = year;
            this.month = month;
            this.value = value;
        }
    }

    

    // Bubble Sort (ascending)
    static void bubbleSort(DataPoint[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].value > arr[j + 1].value) {
                    DataPoint temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Month names
    static String monthName(int m) {
        String[] names = {
            "Jan","Feb","Mar","Apr","May","Jun",
            "Jul","Aug","Sep","Oct","Nov","Dec"
        };
        return names[m - 1];
    }

    // Calculate average
    static double average(int[] arr) {
        int sum = 0;
        for (int v : arr) sum += v;
        return (double) sum / arr.length;
    }


    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

        int[] data2003 = new int[12];
        int[] data2004 = new int[12];

        System.out.println("Enter monthly temperatures for YEAR 2003:");
        for (int i = 0; i < 12; i++) {
            System.out.print(monthName(i + 1) + ": ");
            data2003[i] = sc.nextInt();
        }

        System.out.println("\nEnter monthly temperatures for YEAR 2004:");
        for (int i = 0; i < 12; i++) {
            System.out.print(monthName(i + 1) + ": ");
            data2004[i] = sc.nextInt();
        }
         // Combine into one array
        DataPoint[] combined = new DataPoint[24];
        int idx = 0;

        for (int m = 1; m <= 12; m++)
            combined[idx++] = new DataPoint(2003, m, data2003[m - 1]);

        for (int m = 1; m <= 12; m++)
            combined[idx++] = new DataPoint(2004, m, data2004[m - 1]);

        // Sort combined data
        bubbleSort(combined);

        // Display sorted data
        System.out.println("\nAll monthly temperatures (2003 & 2004) in ascending order:");
        for (DataPoint dp : combined) {
            System.out.printf("%d %s : %d%n", dp.year, monthName(dp.month), dp.value);
        }

        // Averages
        System.out.printf("\nAverage temperature for 2003: %.2f%n", average(data2003));
        System.out.printf("Average temperature for 2004: %.2f%n", average(data2004));
    }
}
