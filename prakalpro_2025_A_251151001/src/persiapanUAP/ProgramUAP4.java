package persiapanUAP;
import java.util.*;
public class ProgramUAP4 {
	public static void main (String [] args) {
		
		        Scanner input = new Scanner(System.in);
		        
		        System.out.println("=== SELAMAT DATANG DI WARUNG MAKAN ENAK ===");
		        System.out.println("Daftar Menu:");
		        System.out.println("1. Bareh Kuruik Kusuik     - Rp15.000");
		        System.out.println("2. Bareh nak daro        - Rp12.000");
		        System.out.println("3. Bujang Marantau       - Rp20.000");
		        System.out.println("4. Sokan    - Rp5.000");
		        System.out.println("5. R42     - Rp3.000");
		        System.out.println("-------------------------------------------");

		        int totalBayar = 0;
		        char lanjut = 0;

		        do {
		            System.out.print("Pilih menu (1-5): ");
		            int pilihan = input.nextInt();

		            int harga = 0;
		            String namaMenu = "";

		            switch (pilihan) {
		                case 1:
		                    harga = 15000;
		                    namaMenu = "Bareh Kuruik Kusuik";
		                    break;
		                case 2:
		                    harga = 12000;
		                    namaMenu = "Bareh nak daro";
		                    break;
		                case 3:
		                    harga = 20000;
		                    namaMenu = "Bujang Marantau";
		                    break;
		                case 4:
		                    harga = 5000;
		                    namaMenu = "Sokan";
		                    break;
		                case 5:
		                    harga = 3000;
		                    namaMenu = "R42";
		                    break;
		                default:
		                    System.out.println("❌ Pilihan tidak valid! Silakan coba lagi.");
		                    continue; // kembali ke awal loop tanpa menambah total
		            }

		            System.out.print("Jumlah " + namaMenu + " yang dipesan: ");
		            int jumlah = input.nextInt();
		            int subtotal = harga * jumlah;
		            totalBayar += subtotal;

		            System.out.println("→ " + jumlah + "x " + namaMenu + " = Rp" + subtotal);
		            System.out.print("Tambah pesanan? (y/t): ");
		            lanjut = input.next().charAt(0);
		            System.out.println();

		        } while (lanjut == 'y' || lanjut == 'Y');

		        System.out.println("===========================================");
		        System.out.println("Total yang harus dibayar: Rp" + totalBayar);

		        // Diskon 10% jika total ≥ Rp50.000
		        int diskon = 0;
		        if (totalBayar >= 50000) {
		            diskon = (int) (totalBayar * 0.1);
		            totalBayar -= diskon;
		            System.out.println("Diskon 10%          : -Rp" + diskon);
		            System.out.println("Total setelah diskon: Rp" + totalBayar);
		        }

		        System.out.print("Masukkan uang bayar : Rp");
		        int uangBayar = input.nextInt();

		        while (uangBayar < totalBayar) {
		            System.out.println("❌ Uang kurang! Silakan masukkan minimal Rp" + totalBayar);
		            System.out.print("Masukkan ulang uang: Rp");
		            uangBayar = input.nextInt();
		        }

		        int kembalian = uangBayar - totalBayar;
		        System.out.println("Kembalian           : Rp" + kembalian);
		        System.out.println("\n✅ Terima kasih telah berbelanja!\n");

		        input.close();
		    }
		
	}

