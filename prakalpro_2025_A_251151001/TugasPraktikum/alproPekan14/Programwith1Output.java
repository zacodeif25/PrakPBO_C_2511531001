package alproPekan14;
import java.util.Scanner;
public class Programwith1Output {
	static double hypotenusa;
	
	public static void sisihypotenusa(double a, double b) {
		double a2 = Math.pow(a, 2);
        double b2 = Math.pow(b, 2);
        hypotenusa = Math.sqrt(a2 + b2);
	}
	public static void main (String[] args) {
		Scanner r = new Scanner (System.in);
		System.out.println("Program Sisi Hipotenusa Segitiga Siku Siku");
		System.out.print("Masukkan Nilai Sisi Segitiga Di depan sudut 60 =");
		double a = r.nextDouble();
		System.out.print("Masukkan Nilai Sisi Segitiga Di depan sudut 30 =");
		double b = r.nextDouble();
		sisihypotenusa(a,b);
		System.out.println("Sisi Hipotenusa Segitiga tsb adalah = " +hypotenusa);
		r.close();
	}
	
}
