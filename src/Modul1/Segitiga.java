package Modul1;



public class Segitiga<T extends Number> {
    private T alas;
    private T tinggi;

    public Segitiga(T alas, T tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public int getResultAsInt() {
        return (int) (0.5 * alas.doubleValue() * tinggi.doubleValue());
    }

    public double getResultAsDouble() {
        return 0.5 * alas.doubleValue() * tinggi.doubleValue();
    }

}