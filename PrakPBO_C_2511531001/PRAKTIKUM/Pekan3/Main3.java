package Pekan3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		ArrayList<Rekening3> daftarRekening = new ArrayList<>();
		Rekening3 akunAktif = null; 

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
				for (Rekening3 r : daftarRekening) {
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
				
				//TUGAS NO 1
				System.out.print("Masukkan PIN (6 Digit) : ");
				String pin = input.nextLine();

				try {
				    Rekening3 rekeningBaru = new Rekening3(no, nama, saldo, pin);
				    daftarRekening.add(rekeningBaru);
				    akunAktif = rekeningBaru;
				} catch (IllegalArgumentException e) {
				    System.out.println("Gagal membuat rekening : " + e.getMessage());
				}
				break;
				
			case 2:
				if (akunAktif == null) {
					System.out.println("Error : Mohon maaf, Anda belum memiliki nomor rekening!");
				} else {
					// TUGAS NO 2
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

				Rekening3 ditemukan = null;
				for (Rekening3 r : daftarRekening) {
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
			    	System.out.println("Masukkan PIN : ");
					String pinRiwayat= input.nextLine();
					if (!akunAktif.otentikasi(pinRiwayat)) {
						System.out.println("Akses Ditolak : PIN yang anda masukkan salah!");
						break;
					}
			    	
			        akunAktif.cekRiwayatTransaksi();
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


		
