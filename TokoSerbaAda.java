/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package praktikum8;

import java.util.Scanner;

public class TokoSerbaAda {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kodeBarang = {"a001", "a002", "a003"};
        String[] namaBarang = {"Buku", "Pensil", "Pulpen"};
        int[] hargaBarang = {3000, 4000, 5000};

        int jumlahItem = 0;
        do {
            System.out.print("Masukkan Item Barang: ");
            if (scanner.hasNextInt()) {
                jumlahItem = scanner.nextInt();
                if (jumlahItem > 0) {
                    break;
                } else {
                    System.out.println("Jumlah item harus lebih dari 0.");
                }
            } else {
                System.out.println("Input salah, harap masukkan angka.");
                scanner.next(); 
            }
        } while (true);

        String[] kodeBeli = new String[jumlahItem];
        int[] jumlahBeli = new int[jumlahItem];
        int[] totalPerItem = new int[jumlahItem];
        int totalBayar = 0;

        for (int i = 0; i < jumlahItem; i++) {
            System.out.println("Data ke " + (i + 1));
            System.out.print("Masukkan Kode Barang: ");
            kodeBeli[i] = scanner.next();

            int jumlah = 0;
            do {
                System.out.print("Masukkan Jumlah Beli: ");
                if (scanner.hasNextInt()) {
                    jumlah = scanner.nextInt();
                    if (jumlah > 0) {
                        jumlahBeli[i] = jumlah;
                        break; // Input valid, keluar dari loop
                    } else {
                        System.out.println("Jumlah beli harus lebih dari 0.");
                    }
                } else {
                    System.out.println("Input salah, harap masukkan angka.");
                    scanner.next(); 
                }
            } while (true);

            for (int j = 0; j < kodeBarang.length; j++) {
                if (kodeBeli[i].equals(kodeBarang[j])) {
                    totalPerItem[i] = hargaBarang[j] * jumlahBeli[i];
                    totalBayar += totalPerItem[i];
                }
            }
        }

        System.out.println("\nTOKO SERBA ADA");
        System.out.println("*");
        System.out.println("No  Kode Barang  Nama Barang  Harga  Jumlah Beli  Jumlah Bayar");
        System.out.println("=============================================================");

        for (int i = 0; i < jumlahItem; i++) {
            for (int j = 0; j < kodeBarang.length; j++) {
                if (kodeBeli[i].equals(kodeBarang[j])) {
                    System.out.printf("%-4d %-11s %-13s %-6d %-14d %-15d\n", 
                                      (i + 1), kodeBeli[i], namaBarang[j], hargaBarang[j], jumlahBeli[i], totalPerItem[i]);
                }
            }
        }

        System.out.println("=============================================================");
        System.out.printf("%-52s %d\n", "Total Bayar", totalBayar);
        System.out.println("=============================================================");
    }
}