package persiapanUAP;
import java.util.*;
public class programUAP2 {
	public static void main ( String [] args) {
		Scanner x = new Scanner (System.in);
		System.out.println("Pendataan Survey Status Aliran Listrik ");
		System.out.println("Silakan disisi intensitas mati lampu");
		System.out.println("Intensitas mati lampu minggu ke-1 =");
		int a = x.nextInt();
		System.out.println("Intensitas mati lampu minggu ke-2 =");
		int b = x.nextInt();
		System.out.println("Intensitas mati lampu minggu ke-3 =");
		int c = x.nextInt();
		System.out.println("Intensitas mati lampu minggu ke-4 =");
		int d = x.nextInt();
		System.out.println("Intensitas mati lampu minggu ke-5 =");
		int e = x.nextInt();
		int total = a+b+c+d+e;
		switch (total = 10) {
		case 1 :
			System.out.println("Status Aliran Listrik : AMAN");
			System.out.println("Jangan lupa untuk mengisi survey ini kembali di bulan depan ya ");
		break;
		default :
			System.out.println("Status Aliran Listrik : TIDAK AMAN");
			System.out.println("Silakan menghubungi kantor PLN terdekat untuk mengtahui detail kondisi aliran listrik anda ");
		
		}
		
	}
}
