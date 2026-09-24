package persiapansmt22;
import java.util.*;
public class latihan3 {
	public static void main (String [] args) {
		Scanner z = new Scanner (System.in);
		System.out.print("How many days' temperatures :");
		int batashari = z.nextInt();
		int [] htemp = new int [batashari];
		double jumlahcuaca = 0;
		
		for (int i =0; i < batashari; i++) {
			System.out.print("Day " + (i+1) + " 's high temp :");
			htemp [i]= z.nextInt();
			jumlahcuaca += htemp [i];
		}
		double ratarata = jumlahcuaca/batashari;
		int uprata =0;
		for (int i = 0; i <batashari; i++) {
			if (htemp[i] > ratarata) {
				uprata++;
			}
		}
		
		System.out.println("Average temp =" + ratarata);
		System.out.println(uprata + " days were above average.");
		
		z.close();
	}
}
