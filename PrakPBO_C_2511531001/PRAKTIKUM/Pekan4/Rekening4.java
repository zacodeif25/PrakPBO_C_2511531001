package Pekan4;
import java.util.ArrayList;

public class Rekening4 {
	 private String nomorRekening;
	 private String namaPemilik;
	 private String pin; // data sensistif
	 
	 //gunakan protected untuk subsclass bisa mengakses langsung
	 protected double saldo;
	 protected ArrayList <Transaksi3> riwayatTransaksi;
	 
	 //2. Modifikasi Constructor untuk menerima PIN di awal
	 
	 public Rekening4 (String nomor, String nama, double saldoAwal, String pinAwal) {
		 this.nomorRekening = nomor;
		 this.namaPemilik = nama;
		 this.saldo = saldoAwal;
		 this.pin = pinAwal;
	 
	 this.riwayatTransaksi = new ArrayList <>();
	 System.out.println("Rekening atas nama " + namaPemilik + " berhasil dibuat.");
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
				Transaksi3 trxBaru = new Transaksi3 (idTrx, "Kredit", nominal);
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
			 Transaksi3 trxBaru = new Transaksi3 (idTrx, "Debit" , nominal);
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
		        for (Transaksi3 t : riwayatTransaksi) {
		            t.cetakDetail();
		        }
		    }
		    System.out.println("-------------------------");
		}
}
