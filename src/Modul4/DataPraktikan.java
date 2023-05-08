package Modul4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DataPraktikan {
    private Map<String, String> tabelData;
    private Map<String, String> tabelSesiLogin;

    public DataPraktikan() {
        tabelData = new HashMap<String, String>();
        tabelSesiLogin = new HashMap<String, String>();
    }

    public boolean tambahData(String nimPraktikan, String namaAsisten) {
        if (nimPraktikan.startsWith("IF") && !tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
            return true;
        }
        return false;
    }

    public void tampil() {
        System.out.println("Data Praktikan:");
        for (String nim : tabelData.keySet()) {
            System.out.println(nim + " - " + tabelData.get(nim));
        }
    }

    public void listNimPraktikan() {
        System.out.println("List NIM Praktikan:");
        for (String nim : tabelData.keySet()) {
            System.out.println(nim);
        }
    }

    public void listNamaAsisten() {
        System.out.println("List Nama Asisten:");
        for (String nama : tabelData.values()) {
            System.out.println(nama);
        }
    }

    public int totalEmail() {
        return tabelData.size();
    }

    public boolean hapusData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan) && tabelData.get(nimPraktikan).equals(namaAsisten)) {
            tabelData.remove(nimPraktikan);
            return true;
        }
        return false;
    }

    public void editData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
        }
    }


    public void search(String namaAsisten) {
        System.out.println("NIM Praktikan dengan Nama Asisten " + namaAsisten + ":");
        for (String nim : tabelData.keySet()) {
            if (tabelData.get(nim).equals(namaAsisten)) {
                System.out.println(nim);
            }
        }
    }

    public void login(String email, String password) {
        if (tabelSesiLogin.containsKey(email) && tabelSesiLogin.get(email).equals(password)) {
            if (email.endsWith("@umm.ac.id")) {
                System.out.println("Berhasil Login");
                System.out.println("Daftar Fitur:");
                System.out.println("- tambahData");
                System.out.println("- tampil");
                System.out.println("- listNimPraktikan");
                System.out.println("- listNamaAsisten");
                System.out.println("- totalEmail");
                System.out.println("- hapusData");
                System.out.println("- editData");
                System.out.println("- search");
            } else {
                System.out.println("Gagal Login");
            }
        }
    }

    public void logout() {
        System.out.println("Anda telah keluar dari program.");

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataPraktikan dataPraktikan = new DataPraktikan();
        boolean isLogin = false;

        while (true) {
            System.out.println("=== Sistem Informasi Praktikum ===");
            System.out.println("Silahkan Login Terlebih Dahulu");

            if (!isLogin) {
                System.out.print("Email : ");
                String email = scanner.nextLine();

                System.out.print("Password : ");
                String password = scanner.nextLine();

                dataPraktikan.login(email, password);

                if (email.endsWith("@umm.ac.id")) {
                    isLogin = true;
                }
            } else {
                System.out.println("Daftar Fitur:");
                System.out.println("1. Tambah Data");
                System.out.println("2. Tampil");
                System.out.println("3. List NIM Praktikan");
                System.out.println("4. List Nama Asisten");
                System.out.println("5. Total Email");
                System.out.println("6. Hapus Data");
                System.out.println("7. Edit Data");
                System.out.println("8. Search");
                System.out.println("9. Logout");

                System.out.print("Pilih fitur: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("NIM Praktikan: ");
                        String nim = scanner.nextLine();
                        System.out.print("Nama Asisten: ");
                        String nama = scanner.nextLine();
                        boolean isBerhasil = dataPraktikan.tambahData(nim, nama);
                        if (isBerhasil) {
                            System.out.println("Data berhasil ditambahkan.");
                        } else {
                            System.out.println("Data gagal ditambahkan.");
                        }
                        dataPraktikan.tampil();
                        break;
                    case 2:
                        dataPraktikan.tampil();
                        break;
                    case 3:
                        dataPraktikan.listNimPraktikan();
                        break;
                    case 4:
                        dataPraktikan.listNamaAsisten();
                        break;
                    case 5:
                        int total = dataPraktikan.totalEmail();
                        System.out.println("Total email yang terdaftar: " + total);
                        break;
                    case 6:
                        System.out.print("NIM Praktikan: ");
                        String nimHapus = scanner.nextLine();
                        System.out.print("Nama Asisten: ");
                        String namaHapus = scanner.nextLine();
                        boolean isTerhapus = dataPraktikan.hapusData(nimHapus, namaHapus);
                        if (isTerhapus) {
                            System.out.println("Data berhasil dihapus.");
                        } else {
                            System.out.println("Data gagal dihapus.");
                        }
                        break;
                    case 7:
                        System.out.print("NIM Praktikan: ");
                        String nimEdit = scanner.nextLine();
                        System.out.print("Nama Asisten: ");
                        String namaEdit = scanner.nextLine();
                        dataPraktikan.editData(nimEdit, namaEdit);
                        break;
                    case 8:
                        System.out.print("Nama Asisten: ");
                        String namaAsisten = scanner.nextLine();
                        dataPraktikan.search(namaAsisten);
                        break;
                    case 9:
                        dataPraktikan.logout();
                        isLogin = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            }
        }
    }
}