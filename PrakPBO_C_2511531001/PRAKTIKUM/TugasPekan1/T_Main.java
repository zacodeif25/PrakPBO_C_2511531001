package TugasPekan1;

import java.util.ArrayList;
import java.util.Scanner;

public class T_Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		ArrayList<T_Rekening> daftarRekening = new ArrayList<>();
		T_Rekening akunAktif = null; 

		boolean isRunning = true;

		System.out.println("=== SISTEM PERBANKAN MINI ===");

		while (isRunning) {
			System.out.println("\nMenu Utama:");
			System.out.println("Akun Aktif saat ini: " + (akunAktif == null ? "-" : akunAktif.nomorRekening + " (" + akunAktif.namaPemilik + ")"));
			System.out.println("1. Buka Rekening Baru");
			System.out.println("2. Setor Tunai");
			System.out.println("3. Tarik Tunai");
			System.out.println("4. Cek Informasi Rekening");
			System.out.println("5. Ganti Akun");
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
				for (T_Rekening r : daftarRekening) {
					if (r.nomorRekening.equalsIgnoreCase(no)) {
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

				T_Rekening rekeningBaru = new T_Rekening(no, nama, saldo);
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

				T_Rekening ditemukan = null;
				for (T_Rekening r : daftarRekening) {
					if (r.nomorRekening.equalsIgnoreCase(cariNo)) {
						ditemukan = r;
						break;
					}
				}

				if (ditemukan != null) {
					akunAktif = ditemukan;
					System.out.println("Berhasil beralih ke rekening " + akunAktif.nomorRekening + " (" + akunAktif.namaPemilik + ")");
				} else {
					System.out.println("Error : Nomor rekening tidak ditemukan!");
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