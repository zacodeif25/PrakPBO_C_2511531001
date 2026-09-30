package Pekan4;
import java.util.ArrayList;
import java.util.Scanner;


public class Main4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		ArrayList<Rekening4> daftarRekening = new ArrayList<>();
		Rekening4 akunAktif = null; 

		boolean isRunning = true;

		System.out.println("=== SISTEM PERBANKAN MINI ===");

		while (isRunning) {
			System.out.println("\nMenu Utama:");
			System.out.println("Akun Aktif saat ini: " + (akunAktif == null ? "-" : akunAktif.getNomorRekening() + " (" + akunAktif.getNamaPemilik() + ")"));
			System.out.println("1. Buka Rekening Baru");
			System.out.println("2. Setor Tunai");
			System.out.println("3. Tarik Tunai");
			System.out.println("4. Cek Informasi Rekening");
			System.out.println("5. Ganti Akun");
			System.out.println("6. Cek Riwayat Transaksi (Mutasi)");
			System.out.println("7. Simulasi Akhir Bulan (Khusus Tabungan)");
			System.out.println("0. Keluar");
			System.out.print("Pilih menu: ");

			if (!input.hasNextInt()) {
				System.out.println("Error : Input harus berupa angka");
				input.nextLine();
				continue;
			}

			int pilihan = input.nextInt();
			input.nextLine();

			switch (pilihan) {
			
			case 1:
				System.out.print("Masukkan No Rekening: ");
				String no = input.nextLine();

				boolean sudahAda = false;
				for (Rekening4 r : daftarRekening) {
					if (r.getNomorRekening().equalsIgnoreCase(no)) {
						sudahAda = true;
						break;
					}
				}
				if (sudahAda) {
					System.out.println("Error : Nomor rekening sudah terdaftar!");
					break;
				}

				System.out.print("Masukkan Nama Pemilik: ");
				String nama = input.nextLine();

				System.out.print("Masukkan Saldo Awal : ");
				if (!input.hasNextDouble()) {
					System.out.println("Error : Input harus berupa angka");
					input.nextLine();
					break;
				}
				double saldo = input.nextDouble();
				input.nextLine();
				
				System.out.print("Masukkan PIN (6 Digit) : ");
				String pin = input.nextLine();
				
				//TUGAS NO 1
				System.out.println("Produk : 1. Tabungan Umum | 2. Giro Bisnis |3. Rekening VIP");
				System.out.print("Pilih produk (1/2/3) : ");
				
				if (!input.hasNextInt()) {
					System.out.println("Error : Input produk harus berupa angka 1 atau 2");
					input.nextLine();
					break;
				}
					
				int produk = input.nextInt();
				input.nextLine();

				Rekening4 rekeningBaru; //tipe superclass
				if (produk == 1 ) {
					System.out.println("Masukkan suku bunga tabungan yang anda inginkan");
					System.out.print("Suku Bunga (%): ");
					if (!input.hasNextDouble()) {
						System.out.println("Error : Input harus berupa angka");
						input.nextLine();
						break;
					}
					double sukuBunga = input.nextDouble();
					input.nextLine();
					rekeningBaru = new RekeningTabungan (no, nama, saldo, pin, sukuBunga);
				}
				else if (produk == 2) {
					System.out.print("Batas Overdraft: ");
					if (!input.hasNextDouble()) {
						System.out.println("Error : Input harus berupa angka");
						input.nextLine();
						break;
					}
					double batas = input.nextDouble();
					input.nextLine();
					rekeningBaru = new RekeningGiro (no, nama, saldo, pin, batas);
				
				//CHALLENGE NOMOR 1
				} else if (produk == 3 ) {
					RekeningVIP vip = new RekeningVIP (no, nama, saldo, pin);
					vip.tambahBonusSaldo();
					rekeningBaru = vip;
				}
				else {
					System.out.println("Error : Pilihan produk tidak valid!");
					break;
				}
				
				daftarRekening.add(rekeningBaru);
				akunAktif = rekeningBaru;
				break;
				
			case 2:
				if (akunAktif == null) {
					System.out.println("Error : Mohon maaf, Anda belum memiliki nomor rekening!");
				} else {
				
					System.out.print("Masukkan nominal setor : ");
					if (!input.hasNextDouble()) {
						System.out.println("Error : Input harus berupa angka");
						input.nextLine();
						break;
					}
					double setor = input.nextDouble();
					input.nextLine();
					akunAktif.setorTunai(setor);
				}
				break;

			case 3:
				if (akunAktif == null) {
					System.out.println("Error : Mohon maaf, Anda belum memiliki nomor rekening!");
				} else {
					// TUGAS NO 2
					System.out.print("Masukkan PIN : ");
					String pinTarik = input.nextLine();
					if (!akunAktif.otentikasi(pinTarik)) {
						System.out.println("Akses Ditolak : PIN yang anda masukkan salah!");
						break;
					}
					
					System.out.print("Masukkan nominal tarik : ");
					if (!input.hasNextDouble()) {
						System.out.println("Error : Input harus berupa angka");
						input.nextLine();
						break;
					}
					double tarik = input.nextDouble();
					input.nextLine();
					akunAktif.tarikTunai(tarik);
				}
				break;

			case 4:
				if (akunAktif == null) {
					System.out.println("Error : Anda belum membuka rekening");
				} else {
					akunAktif.cekInformasi();
				}
				break;

			case 5:
				if (daftarRekening.isEmpty()) {
					System.out.println("Error : Belum ada rekening yang terdaftar!");
					break;
				}
				System.out.print("Masukkan No Rekening yang ingin diaktifkan: ");
				String cariNo = input.nextLine();

				Rekening4 ditemukan = null;
				for (Rekening4 r : daftarRekening) {
					if (r.getNomorRekening().equalsIgnoreCase(cariNo)) {
						ditemukan = r;
						break;
					}
				}

				if (ditemukan != null) {
					akunAktif = ditemukan;
					System.out.println("Berhasil beralih ke rekening " + akunAktif.getNomorRekening() + " (" + akunAktif.getNamaPemilik() + ")");
				} else {
					System.out.println("Error : Nomor rekening tidak ditemukan!");
				}
				break;
				
			case 6 :
				if (akunAktif == null) {
			        System.out.print("Error : Anda belum membuka rekening");
			    } else {
			    	//TUGAS NO 2
			    	System.out.print("Masukkan PIN : ");
					String pinRiwayat= input.nextLine();
					if (!akunAktif.otentikasi(pinRiwayat)) {
						System.out.println("Akses Ditolak : PIN yang anda masukkan salah!");
						break;
					}
			    	
			        akunAktif.cekRiwayatTransaksi();
			    }
			    break;
			    
			//TUGAS NO 2
			case 7 :
				if (akunAktif == null) {
					System.out.println("Error : Anda belum membuka rekening");
				} else if (akunAktif instanceof RekeningTabungan) {
					RekeningTabungan tab = (RekeningTabungan) akunAktif; //downcasting
					tab.tambahBungaAkhirBulan();
				}else {
					System.out.println("Gagal : Fitur bunga akhir bulan hanya berlaku untuk Rekening Tabungan");
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


		

