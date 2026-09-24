package persiapanUAP;
import java.util.Scanner;
public class persiapanUAS {

	public static void main(String[] args) {
		Scanner a = new Scanner (System.in);
		System.out.print("Input Nilai = ");
		int batas= a.nextInt();
		double [] arraySuhu = new double [batas];
		double sum = 0;
		for (int i = 0; i<batas; i++) {
			System.out.print("Input suhu hari ke- " + (i+1)+ " cuaca =");
			arraySuhu[i] = a.nextDouble();
			sum = sum + arraySuhu[i];	
		}
		double average = sum/batas;
		int j = 0;
		
		for (int i = 0; i< batas; i ++) {
			if (arraySuhu[i]>average) {
				j++;
			}
		}
		
		System.out.println("Rata rata cuaca = " +average);
		System.out.println("Jumlah hari cuaca di atas rata rata = " +j);
	}}