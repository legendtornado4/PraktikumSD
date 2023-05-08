package Modul2;

import java.util.ArrayList;

public class Kegiatan1 {
    public static void main(String[] args) {
        // 1. Buatlah object kosong untuk menambahkan ketentuan diatas yang bertipe data String.
        ArrayList<String> animalList = new ArrayList<String>();

        // Tambahkan elemen Angsa, Bebek, Cicak, Domba, Elang, dan Gajah
        animalList.add("Angsa");
        animalList.add("Bebek");
        animalList.add("Cicak");
        animalList.add("Domba");
        animalList.add("Elang");
        animalList.add("Gajah");

        // 2. Tambahkan elemen lagi “Badak” dan ”Bebek”, hitung jumlah elemen “Bebek” dan tampilkan posisi index dari elemen “Bebek” pada object kosong yang telah dibuat.
        animalList.add("Badak");
        animalList.add("Bebek");
        int numBebek = 0;
        for(int i=0; i<animalList.size(); i++) {
            if(animalList.get(i).equals("Bebek")) {
                numBebek++;
                System.out.println("Index Bebek: " + i);
            }
        }
        System.out.println("Jumlah Bebek: " + numBebek);

        // 3. Hapus posisi “Bebek” yang pertama.
        animalList.remove("Bebek");

        // 4. Tampilkan elemen pada index ke-0 dan ke-2, selanjutnya hapus index ke-0.
        System.out.println("Elemen pada index ke-0: " + animalList.get(0));
        System.out.println("Elemen pada index ke-2: " + animalList.get(2));
        animalList.remove(0);

        // 5. Ubahlah index ke-0 dari “Cicak” Menjadi “Ular”, selanjutnya tambahkan elemen baru pada index ke-2 dengan “Itik”.
        animalList.set(0, "Ular");
        animalList.add(2, "Itik");

        // 6. Hapus elemen diantara index ke-1 dan ke-5.
        animalList.subList(1, 5).clear();

        // 7. Tampilkan elemen pertama dan terakhir.
        System.out.println("Elemen pertama: " + animalList.get(0));
        System.out.println("Elemen terakhir: " + animalList.get(animalList.size()-1));

        // 8. Tampilkan jumlah elemen pada ArrayList.
        System.out.println("Jumlah elemen: " + animalList.size());

        // 9. Carilah posisi index dari “Badak”.
        System.out.println("Index Badak: " + animalList.indexOf("Badak"));
    }
}