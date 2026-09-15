package Pekan1;

import java.util.Scanner;

 
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Rekening akunAktif = null; // Objek belum diinisialisasi (null)
        boolean isRunning = true;
 
        System.out.println("=== SISTEM PERBANKAN MINI ===");
 
        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Buka Rekening Baru");
            System.out.println("2. Setor Tunai");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Cek Informasi Rekening");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
 
            int pilihan = input.nextInt();
            input.nextLine(); // Membersihkan buffer enter
 
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan No Rekening: ");
                    String no = input.nextLine();
                    System.out.print("Masukkan Nama Pemilik: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan Saldo Awal: ");
                    double saldo = input.nextDouble();
                    
                    // Instansiasi Object / Menjalankan Constructor
                    akunAktif = new Rekening(no, nama, saldo);
                    break;
 
                case 2:
                    if (akunAktif == null) {
                        System.out.println("Error: Mohon maaf, Anda belum memiliki nomor rekening!");
                    } else {
                        System.out.print("Masukkan nominal setor (minimal Rp10.000): ");
                        double setor = input.nextDouble();
                        akunAktif.setorTunai(setor); // Memanggil Behavior / method
                    }
                    break;
 
                case 3:
                    System.out.println("Fitur ini akan dikerjakan sebagai Tugas Mandiri.");
                    break;
 
                case 4:
                    if (akunAktif == null) {
                        System.out.println("Error: Anda belum membuka rekening!");
                    } else {
                        akunAktif.cekInformasi();
                    }
                    break;
 
                case 0:
                    isRunning = false;
                    System.out.println("Sistem ditutup. Terima kasih!");
                    break;
 
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        input.close();
    }
}
 
