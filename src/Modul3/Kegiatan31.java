package Modul3;
import java.util.Scanner;


public class Kegiatan31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kalimat: ");
        String kalimat = scanner.nextLine();

        // membuat objek Stack dengan ukuran sebesar panjang kalimat
        Stack stack = new Stack(kalimat.length());

        // memasukkan setiap karakter kalimat ke dalam stack
        for (int i = 0; i < kalimat.length(); i++) {
            stack.push(kalimat.charAt(i));
        }

        System.out.print("Hasil pembalikan kalimat: ");

        // mengeluarkan setiap karakter dari stack satu per satu
        // sehingga menghasilkan kalimat yang terbalik
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}

class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;


    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }


    public void push(char character) {
        // jika stack penuh, cetak pesan Stack overflow dan keluar dari method
        if (top == maxSize - 1) {
            System.out.println("Stack overflow");
            return;
        }

        // jika masih ada ruang kosong di stack, tambahkan karakter ke dalam stack
        top++;
        stackArray[top] = character;
    }

    // method untuk mengeluarkan karakter teratas dari stack dan menghapusnya
    public char pop() {
        // jika stack kosong, cetak pesan Stack underflow dan kembalikan karakter spasi
        if (top == -1) {
            System.out.println("Stack underflow");
            return ' ';
        }

        // jika masih ada karakter dalam stack, ambil karakter teratas,
        char poppedChar = stackArray[top];
        top--;
        return poppedChar;
    }


    public boolean isEmpty() {
        return top == -1;
    }
}