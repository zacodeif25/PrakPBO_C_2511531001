package persiapansmt22;
import java.util.*;
public class latihan4 {
	public static void main (String [] args) {
		Scanner z = new Scanner (System.in);
		System.out.print("How Many Days Temperature :");
		int banyak = z.nextInt();
		double jumlah = 0;
		int [] array = new int [banyak];
		for (int i =0; i<banyak; i++) {
			System.out.print("Day " +(i+1)+ " s high temp :");
			array[i] = z.nextInt();
			jumlah += array[i];
		}
		double ave = jumlah/banyak;
		int count = 0;
		for (int i = 0; i<banyak; i++) {
			if (array[i] > ave) {
				count++;
			}
		}
		
		System.out.println("Average temp :" + ave);
		System.out.println(count + " days were above average");
		
		System.out.println();
		System.out.println("Temperatures :" + Arrays.toString(array));;
		
		Arrays.sort(array);
		System.out.println("Two Coldest days :" + array [0] + ", " + array[1]);
		System.out.println("Two Hottest days :" + array[array.length -1] + ", "+ array[array.length - 2]);
			
		z.close();
		}
	}
