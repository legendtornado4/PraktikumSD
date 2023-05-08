package Modul4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataManagementProgram {
    private static List<Data> dataList = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("=== Data Management Program ===");
            System.out.println("1. Lihat Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    lihatData();
                    break;
                case 2:
                    buatData();
                    break;
                case 3:
                    editData();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void lihatData() {
        if (dataList.isEmpty()) {
            System.out.println("Tidak ada data yang tersedia.");
        } else {
            System.out.println("=== Daftar Data ===");
            for (Data data : dataList) {
                System.out.println(data);
            }
        }
    }

    private static void buatData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nomor ID: ");
        int id = scanner.nextInt();
        System.out.print("Masukkan nama: ");
        scanner.nextLine(); // Membersihkan buffer
        String nama = scanner.nextLine();

        Data newData = new Data(id, nama);
        dataList.add(newData);

        System.out.println("Data berhasil ditambahkan.");
    }

    private static void editData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nomor ID data yang akan diedit: ");
        int id = scanner.nextInt();

        boolean found = false;
        for (Data data : dataList) {
            if (data.getId() == id) {
                found = true;
                System.out.print("Masukkan nomor ID baru: ");
                int newId = scanner.nextInt();
                System.out.print("Masukkan nama baru: ");
                scanner.nextLine(); // Membersihkan buffer
                String newName = scanner.nextLine();
                data.setId(newId);
                data.setNama(newName);
                System.out.println("Data berhasil diubah.");
                break;
            }
        }

        if (!found) {
            System.out.println("Data dengan nomor ID " + id + " tidak ditemukan.");
        }
    }

    private static class Data {
        private int id;
        private String nama;

        public Data(int id, String nama) {
            this.id = id;
            this.nama = nama;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Nama: " + nama;
        }
    }
}