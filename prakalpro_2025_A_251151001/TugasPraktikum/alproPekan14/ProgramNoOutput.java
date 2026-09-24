package alproPekan14;
import java.util.Scanner;;
public class ProgramNoOutput {
	public static void main (String[] args) {
		Scanner inp = new Scanner (System.in);
		System.out.print("Input Bilangan 1 =");
		int a = inp.nextInt();
		System.out.print("Input Bilangan 2 =");
		int b = inp.nextInt();
		System.out.println("Sebelum diurutkan dari yang terkecil");
		System.out.println("Angka 1 = "+a+ " dan Angka 2 = "+b);
		System.out.println("Setelah diurutkan dari yang terkecil ");
		urutkanNaik(a,b);
		inp.close();
	}
	public static void urutkanNaik(int x, int y) {
		if (x <= y) {
			System.out.println("Angka 1 = "+x+ " dan Angka 2 = "+y);
		}else {
			System.out.println("Angka 1 = "+y+ " dan Angka 2 = "+x);
		}
		
	}
}
