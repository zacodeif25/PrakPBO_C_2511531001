package alproPekan15;
import java.util.Scanner;
public class SurveiPadamListrik {
	static Scanner y = new Scanner (System.in);
	public static void inputData(int[] arr) {
		for (int i = 0; i < 4; i++) {
			System.out.print("Input Jumlah Pemadaman Pada Minggu ke- " + (i+1) + " :");
			arr[i] = y.nextInt();
			while (arr[i] < 0) {
				System.out.println("Jumlah Pemadaman Tidak Valid");
				arr[i] = y.nextInt();
			}
		}
	}
	
	public static int HitungPemadaman(int [] arr) {
		int sum = 0;
		for ( int x : arr) sum +=x;
		return sum;
	}
	
	public static String outputKondisi(int total) {
		  if (total > 10) {
	            return "Kondisi: tidak normal\n" +
	                   "Silakan datang pada kantor PLN terdekat untuk mendapatkan konfirmasi keadaan aliran listrik anda";
	        } else {
	            return "Kondisi: normal\n" +
	                   "Terima kasih sudah mengisi survey ini, dan jangan lupa untuk mengisi survey ini lagi untuk bulan depan";
	        }
		
	}
	public static void main(String[] args) {
		int[] padam = new int [4];
		System.out.println("Survei Pemadaman Listrik");
		
		inputData(padam);
		int total = HitungPemadaman(padam);
		String kondisi = outputKondisi(total);
		
		System.out.println("\nHasil Analisis Survey");
		System.out.println("Total pemadaman dalam sebulan terakhir: " +total+ " kali");
		System.out.println(kondisi);
	}

}
