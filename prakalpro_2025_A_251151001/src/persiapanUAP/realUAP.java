package persiapanUAP;
import java.util.*;
public class realUAP {
	public static void main (String [] args) {
		Scanner z = new Scanner (System.in);
		System.out.print("Silakan Masukkan Jumlah Siswa=");
		int batas = z.nextInt();
		double siswa [] = new double [batas];
		double totalNilai = 0;
		double max =0;
		for (int i = 0; i<batas; i++) {
			System.out.print("Nilai siswa ke-" + (i+1) + " =");
			siswa [i] = z.nextDouble();
			totalNilai+= siswa[i];
			if (max<siswa[i]) {
				max = siswa[i];
			}
		}
		double rata2 = totalNilai/batas;
		System.out.println("Nilai rata-rata=" +rata2);
		System.out.println("Nilai Tertinggi=" +max);
		z.close();	
	}

}
