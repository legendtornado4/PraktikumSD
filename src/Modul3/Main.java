package Modul3;

import java.util.Scanner;

class Node {
    String namaPelanggan;
    String namaObat;
    int dosisObat;
    boolean anakAnak;
    Node next;

    public Node(String namaPelanggan, String namaObat, int dosisObat, boolean anakAnak) {
        this.namaPelanggan = namaPelanggan;
        this.namaObat = namaObat;
        this.dosisObat = dosisObat;
        this.anakAnak = anakAnak;
        this.next = null;
    }
}

class Queue {
    Node front, rear;
    int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(String namaPelanggan, String namaObat, int dosisObat, boolean anakAnak) {
        Node newNode = new Node(namaPelanggan, namaObat, dosisObat, anakAnak);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Pelanggan " + namaPelanggan + " telah ditambahkan dalam antrian.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        Node temp = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        size--;
        System.out.println("Pelanggan " + temp.namaPelanggan + " telah selesai dilayani.");
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Pelanggan pertama dalam antrian: " + front.namaPelanggan);
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Tambahkan pelanggan dalam antrian
        queue.enqueue("Ali", "Paracetamol", 1, true);
        queue.enqueue("Budi", "Amoxicillin", 2, false);
        queue.enqueue("Cici", "Ibuprofen", 3, true);

        // Cek jumlah pelanggan dalam antrian
        System.out.println("Jumlah pelanggan dalam antrian: " + queue.size());

        // Cek pelanggan pertama dalam antrian
        queue.peek();

        // Layani pelanggan dalam antrian
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        // Cek jumlah pelanggan dalam antrian
        System.out.println("Jumlah pelanggan dalam antrian: " + queue.size());

        // Cek pelanggan pertama dalam antrian setelah antrian kosong
        queue.peek();
    }
}