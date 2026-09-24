package persiapanUAP;
import java.util.*;
public class programUAP {
	public static void main (String []  args) {
		Scanner z = new Scanner (System.in);
		int[] padam = new int [5];
		int total = 0;
		System.out.println("PENDATAAN SURVEY KONDISI ALIRAN LISTRIK");
		System.out.println("Diharapkan untuk responden survey ini untuk memasukkan data asli");
		System.out.println("Silakan Masukkan intensitas mati lampu per minggu untuk bulan ini");
		for (int i = 0; i<5; i ++){
			System.out.print("Intensitas mati lampu pada minggu ke-" +(i+1)+ "= ");
			padam [i] = z.nextInt();
			total = total + padam[i];
		}
		if (total <10 ) {
			System.out.println("Status Aliran Listrik :  AMAN");
			System.out.println("Jangan lupa untuk mengisi survey ini kembali di bulan depan :)");
		} else {
			System.out.println("Status Aliran Listrik :  BERISIKO TINGGI ");
			System.out.println("Harap segera untuk melapor ke kantor PLN (Perseroan Listrik Negara) terdekat");
			System.out.println("untuk mengetahui informasi lengkap kondisi aliran listrik ");
		}
		
	}
}
