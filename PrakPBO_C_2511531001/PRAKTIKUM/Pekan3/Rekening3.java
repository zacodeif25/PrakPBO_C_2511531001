package Pekan3;
import java.util.ArrayList;

public class Rekening3 {
	//1. Mengunci atribut dengan 'private'
	 private String nomorRekening;
	 private String namaPemilik;
	 private double saldo;
	 private String pin; // data sensistif
	 
	 private ArrayList <Transaksi2> riwayatTransaksi;
	 
	 //2. Modifikasi Constructor untuk menerima PIN di awal
	 
	 public Rekening3 (String nomor, String nama, double saldoAwal, String pinAwal) {
		 
		//CHALLENGE NO 3 — validasi PIN
			if (!pinAwal.matches("\\d+")) {
				throw new IllegalArgumentException("PIN harus berupa angka!");
			} else if (pinAwal.length() != 6) {
				throw new IllegalArgumentException("PIN harus 6 digit!");
			}  else if (isAngkaBerulang(pinAwal)) {
		        throw new IllegalArgumentException("PIN tidak boleh menggunakan angka yang berulang semua (contoh: 111111)!");
		    } else if (isAngkaBerurutan(pinAwal)) {
		        throw new IllegalArgumentException("PIN tidak boleh menggunakan angka berurutan (contoh: 123456 atau 654321)!");
		    }
		 this.nomorRekening = nomor;
		 this.namaPemilik = nama;
		 this.saldo = saldoAwal;
		 this.pin = pinAwal;
	 
	 this.riwayatTransaksi = new ArrayList <>();
	 System.out.println("Rekening atas nama " + namaPemilik + " berhasil dibuat.");
	 }
	 
	 	//CHALLENGE NO 4 -- LARANGAN PIN ANGKA BERULANG DAN ANGKA BERURUTAN
	 		//mengechek untuk digit yang berulang
	 			private boolean isAngkaBerulang(String pin) {
	 				for (int i = 1; i < pin.length(); i++) {
	 					if (pin.charAt(i) != pin.charAt(0)) {
	 						return false;
	 					}
	 				}
	 				return true;
	 			}
	 		// mengecheck untuk digit berurutan naik atau turun 
	 			private boolean isAngkaBerurutan(String pin) {
	 				boolean naik = true;
	 				boolean turun = true;

	 				for (int i = 1; i < pin.length(); i++) {
	 					int sebelumnya = pin.charAt(i - 1) - '0';
	 					int sekarang = pin.charAt(i) - '0';

	 					if (sekarang != sebelumnya + 1) {
	 						naik = false;
	 					}
	 					if (sekarang != sebelumnya - 1) {
	 						turun = false;
	 					}
	 				}
	 				return naik || turun;
	 			}
	 
	 //3. Getter untuk atribut yang diizinkan dibaca publik
	 public String getNomorRekening () {
		 return nomorRekening;
	 }
	 
	 public String getNamaPemilik() {
		 return namaPemilik;
	 }
	 
	 //4. Method Otentikasi Internal (Validasi Enkapsulasi)
	 public boolean otentikasi (String inputPin) {
		 return this.pin.equals(inputPin);
	 }
	 
	 public void setorTunai(double nominal) {
			if (nominal > 0) {
				saldo += nominal;
				String idTrx = "TRX-S-" + System.currentTimeMillis();
				Transaksi2 trxBaru = new Transaksi2 (idTrx, "Kredit", nominal);
				riwayatTransaksi.add(trxBaru);
				
				System.out.println("Setor tunai Rp" + nominal + " berhasil. Saldo saat ini : Rp" + saldo);
			} else {
				System.out.println("Gagal : Nominal setor harus lebih dari 0!");
			}
		}
	 
	 public void tarikTunai (double nominal) {
		 if (nominal > saldo ) {
			 System.out.println("Transaksi Gagal : Saldo Anda tidak cukup. Saldo Anda : Rp" + saldo);
		 } else if (nominal < 10000) {
			 System.out.println("Transaksi Gagal : Minimal transaksi tarik tunai adalah sebesar Rp10000");
		 } else {
			 saldo -= nominal;
			 String idTrx = "TRX-T-" + System.currentTimeMillis();
			 Transaksi2 trxBaru = new Transaksi2 (idTrx, "Debit" , nominal);
			 riwayatTransaksi.add(trxBaru);
			 System.out.println("Tarik tunai Rp" + nominal + " berhasil. Saldo saat ini : Rp" + saldo);
		 }
	 }
	 
	 public void cekInformasi() {
			System.out.println("--- INFO REKENING ---");
			System.out.println("No. Rekening : " + nomorRekening);
			System.out.println("Nama Pemilik : " + namaPemilik);
			System.out.print("Saldo Akhir : Rp" + saldo);
			System.out.println();
			System.out.println("---------------------");	
		}
	 
	 public void cekRiwayatTransaksi() {
		    System.out.println("--- RIWAYAT TRANSAKSI ---");
		    System.out.println("No. Rekening : " + nomorRekening);
		    if (riwayatTransaksi.isEmpty()) {
		        System.out.println("Belum ada transaksi.");
		    } else {
		        for (Transaksi2 t : riwayatTransaksi) {
		            t.cetakDetail();
		        }
		    }
		    System.out.println("-------------------------");
		}
}