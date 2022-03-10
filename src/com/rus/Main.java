package com.rus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] data = {
                {"БИШКЕК", "8:170.0;10:500.0;30:800.0;50:3495.0->1.0:-1.0"},
                {"ОШ", "8.0:350.0;10.0:900.0;30.0:2460.0;50.0:4926.0->1.0:-1.0"},
                {"АЛМАТЫ", "0.3:650.0;0.5:750.0->1.0:430.0"},
                {"ШЫМКЕНТ", "0.3:700.0;0.5:750.0->1.0:430.0"},
                {"МОСКВА", "0.5:1130.14->1.0:160.0"},
                {"САНКТ-ПЕТЕРБУРГ", "0.5:856.98->1.0:231.53"},
                {"ЛОНДОН", "0.5:2900.0->1.0:500.0"},
                {"МАДРИД", "0.5:3000.0->1.0:700.0"},
        };
        System.out.println("Введите вес товара в килограммах : ");
        String mas = scanner.nextLine();
        double weight = Double.parseDouble(mas);
        System.out.println("Введите код города из нижеперечисленных : ");
        for (int i = 0; i < data.length; i++) {
            System.out.println(i + "." + data[i][0]);
        }
        int cityId = scanner.nextInt();
        String[] arr = data[cityId][1].split("->1.0:");
        String eachNextKgPrice = arr[1];
        String[] arr1 = arr[0].split(";");
        for (int i = 0; i < arr1.length; i++) {
            String[] temp = arr1[i].split(":");
            double intervalWeight = Double.parseDouble(temp[0]);
            double intervalPrice = Double.parseDouble(temp[1]);
            if (weight <= intervalWeight) {
                System.out.println("Цена  = " + intervalPrice);
                break;
            } else {
                if (i == arr1.length - 1 && eachNextKgPrice.equals("-1.0")) {
                    System.out.println("Невозможно просчитать цену !");
                } else if (i == arr1.length - 1) {
                    double nextKg = Double.parseDouble(eachNextKgPrice);
                    double price = (intervalPrice + (weight - intervalWeight) * nextKg);
                    System.out.println("Цена = " + price);
                }
            }
        }
    }
}
