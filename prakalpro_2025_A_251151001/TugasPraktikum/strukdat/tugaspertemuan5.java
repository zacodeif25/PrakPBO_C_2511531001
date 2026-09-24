package strukdat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ManajemenToko {
    // Definisi Tipe < namaToko, katalog, antrian, riwayat >
    private String namaToko;
    private ArrayList<String> katalog;    // Struktur Data 1: ArrayList
    private Queue<String> antrian;        // Struktur Data 2: Queue
    private Stack<String> riwayat;        // Struktur Data 3: Stack

    // --- KONSTRUKTOR ---
    public ManajemenToko(String nama) {
        this.namaToko = nama;
        this.katalog = new ArrayList<>();
        this.antrian = new LinkedList<>();
        this.riwayat = new Stack<>();}

    // --- SELEKTOR (GETTER) ---
    public String getNama() {
        return this.namaToko;}
    public int getJumlahProduk() {
        return this.katalog.size();}

    // --- SETTER ---
    public void setNama(String newName) {
        this.namaToko = newName;}

    // --- I/O DEVICE ---
    // procedure BacaToko (output T)
    // (Diimplementasikan via Konstruktor di Java, ini helper untuk simulasi)
    public static ManajemenToko bacaToko(String nama) {
        return new ManajemenToko(nama);}

    // procedure TulisToko (input T)
    public void tulisToko() {
        System.out.println("Toko [" + this.namaToko + "]");}

    // --- OPERASI ARRAYLIST (KATALOG) ---
    // procedure TambahProduk (input/output T, input namaProduk)
    public void tambahProduk(String namaProduk) {
        katalog.add(namaProduk);
        System.out.println("{Produk} Ditambahkan: " + namaProduk);}

    // procedure TampilkanKatalog (input T)
    public void tampilkanKatalog() {
        System.out.println("\n--- Katalog Produk ---");
        if (katalog.isEmpty()) {
            System.out.println("Katalog kosong.");
        } else {
            for (int i = 0; i < katalog.size(); i++) {
                System.out.println((i + 1) + ". " + katalog.get(i));
            }
        }
        System.out.println("Total: " + getJumlahProduk());
    }

    // --- OPERASI QUEUE (ANTRIAN) ---
    // procedure TerimaPesanan (input/output T, input pelanggan)
    public void terimaPesanan(String pelanggan) {
        antrian.offer(pelanggan); // Enqueue
        System.out.println("{Antrian} Masuk: " + pelanggan);
    }

    // function LayaniPesanan (input/output T) → string
    public String layaniPesanan() {
        if (isEmptyAntrian()) {
            return "Tidak ada antrian.";
        } else {
            String pelanggan = antrian.poll(); // Dequeue (FIFO)
            // Simpan ke riwayat stack saat melayani
            riwayat.push("Transaksi: " + pelanggan); 
            return "Melayani: " + pelanggan;
        }
    }

    // function IsEmptyAntrian (T) → boolean
    public boolean isEmptyAntrian() {
        return antrian.isEmpty();
    }

    // --- OPERASI STACK (RIWAYAT) ---
    // function BatalkanTransaksi (input/output T) → string
    public String batalkanTransaksi() {
        if (isEmptyRiwayat()) {
            return "Tidak ada riwayat untuk dibatalkan.";
        } else {
            String transaksi = riwayat.pop(); // Pop (LIFO)
            return "Batal: " + transaksi;
        }
    }

    // function IsEmptyRiwayat (T) → boolean
    public boolean isEmptyRiwayat() {
        return riwayat.isEmpty();
    }
}

// --- MAIN CLASS ---
public class tugaspertemuan5 {
    public static void main(String[] args) {
        System.out.println("=== IMPLEMENTASI ADT MANAJEMEN_TOKO ===\n");
        ManajemenToko toko = ManajemenToko.bacaToko("_-_ ZAZA's SHOP _-_"); //nama toko "konstruktor"
        toko.tulisToko();

        System.out.println("\n--- Mengisi Katalog Produk ---"); // menggunakan arrayList
        toko.tambahProduk("Kripik Kentang");
        toko.tambahProduk("Choco Pie");
        toko.tambahProduk("Kopi");
        toko.tambahProduk("Soda");
        toko.tambahProduk("Lolipop");
        toko.tampilkanKatalog();
        System.out.println("Jumlah Produk: " + toko.getJumlahProduk());

        System.out.println("\n--- Antrian Pelanggan ---"); // menggunakan queque
        toko.terimaPesanan("Dzhillan");
        toko.terimaPesanan("Rayya");
        toko.terimaPesanan("Tifa");
        toko.terimaPesanan("Afif");
        toko.terimaPesanan("Endy");
        
        System.out.println("\n--- Pelayanan (FIFO) ---");
        System.out.println(toko.layaniPesanan()); // melayani Dzhillan dan menghapus Dzhillan dari antrian
        System.out.println(toko.layaniPesanan()); // melayani Rayya dan menghapus Rayya dari antrian
        System.out.println(toko.layaniPesanan()); //melayani Tifa dan menghapus Tifa dari antrian
        
        System.out.println("\n--- Pembatalan Transaksi (LIFO) ---"); // stack
        System.out.println(toko.batalkanTransaksi()); // membatalkan transaksi tifa karena merupakan transaksi terakhir
        
        System.out.println("\n--- Status Akhir ---");
        System.out.println("Antrian Kosong? " + toko.isEmptyAntrian());
        System.out.println("Riwayat Kosong? " + toko.isEmptyRiwayat());
        System.out.println(toko.layaniPesanan()); // melayani Afif & Endy (Sisa antrian)
        System.out.println(toko.layaniPesanan());
    }
}