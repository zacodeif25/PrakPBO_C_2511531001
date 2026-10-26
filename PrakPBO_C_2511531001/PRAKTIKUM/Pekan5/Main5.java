package Pekan5;
import java.util.ArrayList;
import java.util.Scanner;


public class Main5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		ArrayList<Rekening5> daftarRekening = new ArrayList<>();
		Rekening5 akunAktif = null; 

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
			System.out.println("8. Transfer ke Rekening Lain");
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
				for (Rekening5 r : daftarRekening) {
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
				
				System.out.println("Produk : 1. Tabungan Umum | 2. Giro Bisnis");
				System.out.print("Pilih produk (1/2) : ");
				
				if (!input.hasNextInt()) {
					System.out.println("Error : Input produk harus berupa angka 1 atau 2");
					input.nextLine();
					break;
				}
					
				int produk = input.nextInt();
				input.nextLine();

				Rekening5 rekeningBaru; //tipe superclass
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
					rekeningBaru = new RekeningTabungan1 (no, nama, saldo, pin, sukuBunga);
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
					rekeningBaru = new RekeningGiro1 (no, nama, saldo, pin, batas);
				
				} else {
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

				Rekening5 ditemukan = null;
				for (Rekening5 r : daftarRekening) {
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
			    	System.out.print("Masukkan PIN : ");
					String pinRiwayat= input.nextLine();
					if (!akunAktif.otentikasi(pinRiwayat)) {
						System.out.println("Akses Ditolak : PIN yang anda masukkan salah!");
						break;
					}
			    	
			        akunAktif.cekRiwayatTransaksi();
			    }
			    break;

			case 7 :
				if (akunAktif == null) {
					System.out.println("Error : Anda belum membuka rekening");
				} else if (akunAktif instanceof RekeningTabungan1) {
					RekeningTabungan1 tab = (RekeningTabungan1) akunAktif; //downcasting
					tab.tambahBungaAkhirBulan();
				}else {
					System.out.println("Gagal : Fitur bunga akhir bulan hanya berlaku untuk Rekening Tabungan");
				}
				break;
				
			case 8 :
				
			    if (akunAktif == null) {
			        System.out.println("Error : Mohon maaf, Anda belum memiliki nomor rekening!");
			        break;
			    }
			    
				System.out.print("Masukkan Nomor Rekening Tujuan: ");
				String noTujuan = input.nextLine();
				
				//mencari nomor tersebut di daftarRekening
				Rekening5 akunTujuan = null;
				for (Rekening5 r : daftarRekening) {
					if (r.getNomorRekening().equals(noTujuan)) {
						akunTujuan = r;
						break;
					}
				}
				
				if (akunTujuan == null) {
					System.out.println("Rekening tujuan tidak ditemukan!");
				} else {
					System.out.print("Masukkan nominal transfer: ");
			        if (!input.hasNextDouble()) {
			            System.out.println("Error : Input harus berupa angka");
			            input.nextLine();
			            break;
			        }
					double nominal = input.nextDouble();
					input.nextLine(); // membuang sisa enter
					
					System.out.print("Masukkan PIN: ");
					String pinTransfer = input.nextLine();
					
					akunAktif.transfer(akunTujuan, nominal, pinTransfer);
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


		

