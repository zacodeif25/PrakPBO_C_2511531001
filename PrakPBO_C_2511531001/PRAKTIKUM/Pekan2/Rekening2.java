package Pekan2;
import java.util.*;

public class Rekening2 {

 String nomorRekening;
 String namaPemilik;
 double saldo;
 
 //implementasi asosiasi (1-to-many)
 ArrayList <Transaksi> riwayatTransaksi;
 
 public Rekening2 (String nomor, String nama, double saldoAwal) {
	 this.nomorRekening = nomor;
	 this.namaPemilik = nama;
	 this.saldo = saldoAwal;
	 
	 //wajib menginisiasi arraylist di dalam constructor agar tidak nullpointerException
	 this.riwayatTransaksi = new ArrayList <> ();
	 
	 System.out.println("Rekening atas nama " + namaPemilik + " berhasil dibuat dengan saldo awal : Rp" + saldo);
 }
 
 public void setorTunai(double nominal) {
		if (nominal > 0) {
			saldo += nominal;
			String idTrx = "TRX-S-" + System.currentTimeMillis();
			Transaksi trxBaru = new Transaksi (idTrx, "Kredit", nominal);
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
		 Transaksi trxBaru = new Transaksi (idTrx, "Debit" , nominal);
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
	        for (Transaksi t : riwayatTransaksi) {
	            t.cetakDetail();
	        }
	    }
	    System.out.println("-------------------------");
	}
 
 public void challenge3() {
	    double totalSetor = 0;
	    double totalTarik = 0;

	    for (Transaksi t : riwayatTransaksi) {
	        if (t.getJenis().equalsIgnoreCase("Kredit")) {
	            totalSetor += t.getNominal();
	        } else if (t.getJenis().equalsIgnoreCase("Debit")) {
	            totalTarik += t.getNominal();
	        }
	    }

	    double akumulasi = totalSetor - totalTarik;

	    System.out.println("--- RINGKASAN TRANSAKSI ---");
	    System.out.println("No. Rekening         : " + nomorRekening);
	    System.out.println("Total Setor          : Rp" + totalSetor);
	    System.out.println("Total Tarik          : Rp" + totalTarik);
	    System.out.println("Akumulasi Transaksi  : Rp" + akumulasi);
	    System.out.println("Saldo Akhir          : Rp" + saldo);
	    System.out.println("---------------------------");
	}
 
 public void challenge2 () {
	    System.out.println("--- 3 TRANSAKSI TERAKHIR ---");
	    System.out.println("No. Rekening : " + nomorRekening);

	    if (riwayatTransaksi.isEmpty()) {
	        System.out.println("Belum ada transaksi pada rekening ini");
	    } else {
	        int totalTransaksi = riwayatTransaksi.size();
	        int mulai = Math.max(0, totalTransaksi - 3); // cegah index negatif kalau transaksi < 3

	        for (int i = mulai; i < totalTransaksi; i--) {
	            Transaksi t = riwayatTransaksi.get(i);
	            t.cetakDetail();
	        }
	    }
	    System.out.println("----------------------------");
	}
}
