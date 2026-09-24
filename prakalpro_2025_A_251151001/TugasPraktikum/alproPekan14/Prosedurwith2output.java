package alproPekan14;
import java.util.Scanner;
public class Prosedurwith2output {
	static double percepatan;
	static double jarak;
	
	public static void physics(double p, double q,double r,double s ) {
		percepatan= (q-p)/(s-r);
		jarak= ((p+q)*(s-r)/2);
	}
	public static void main(String[] args) {
		Scanner x = new Scanner (System.in);
		System.out.print("Masukkan v0 (kecepatan awal) =");
		double p = x.nextDouble();	
		System.out.print("Masukkan v1 (kecepatan akhir) =");
		double q = x.nextDouble();	
		System.out.print("Masukkan t0 (waktu awal) =");
		double r = x.nextDouble();	
		System.out.print("Masukkan t1 (waktu akhir) =");
		double s = x.nextDouble();	
		physics(p,q,r,s);
		System.out.println("Percepatan benda tersebut adalah = " +percepatan + " m/s2");
		System.out.println("Jarak yang ditempuhh ben datersebut adalah = " +jarak+ " m");
		x.close();
	}
}
