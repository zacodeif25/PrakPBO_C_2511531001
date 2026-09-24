package persiapanUAP;
import java.util.*;
public class UAPC {
		public static boolean Prima(int n) {
			int factors = 0;
			for (int i=1; i <= n; i ++) {
				if (n % i == 0) {
					factors++;
				}
			}
			return (factors ==2);
		}
		
		public static boolean Ganjil(int n) {
			if (n % 2 ==1) {
			}
			return (true);	
		}

		public static void main (String [] args) {
		Scanner s = new Scanner (System.in);
		System.out.print(" Silakan Masukkan Angka : ");
		int angka = s.nextInt();
		
			if (!Ganjil (angka)&&(Prima(angka))) {
				System.out.println(angka + " adalah bilangan Genap dan bilangan Prima");
			}
			else if (Ganjil (angka) && Prima(angka)){
				System.out.println(angka + " adalah bilangan Ganjil dan bilangan Prima");
			}
			else if  (!Ganjil(angka)) {
				System.out.println(angka + " adalah bilangan Genap");
			}
			else{
				System.out.println(angka + " adalah bilangan Ganjil");
			}
		}}

