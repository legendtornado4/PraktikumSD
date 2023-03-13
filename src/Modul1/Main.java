package Modul1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double Alas;
        double Tinggi;
        int Pilih;
        boolean Infinity= true;

        do {
            System.out.println("=== HITUNG LUAS SEGITIGA===");
            System.out.println("Masukan Pilihan Anda untuk Hasil Type Output:\n1. Integer\n2. Double\n Pilih 1/2 : ");

            try {
                Pilih = sc.nextInt();

                switch (Pilih) {
                    case 1:
                        System.out.print("Masukkan Alas dan Tinggi: ");
                        Alas = sc.nextDouble();
                        Tinggi = sc.nextDouble();
                        Segitiga<Double> segitigaint = new Segitiga<>(Alas, Tinggi);
                        System.out.println("\n Luas Segitiga Dalam Integer: " + segitigaint.getResultAsInt());
                        break;
                    case 2:
                        System.out.print("Masukkan Alas dan Tinggi: ");
                        Alas = sc.nextDouble();
                        Tinggi = sc.nextDouble();
                        Segitiga<Double> segitigadouble = new Segitiga<>(Alas, Tinggi);
                        System.out.println("\n Luas Segitiga Dalam Double: " + segitigadouble.getResultAsDouble());
                        break;
                    default:
                        System.out.println("Masukkan pilihan yang benar (1 atau 2):");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid, silakan masukkan angka");
                sc.nextLine();
            }
        } while (Infinity);
    }
}