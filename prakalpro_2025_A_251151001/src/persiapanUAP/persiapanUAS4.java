package persiapanUAP;
import java.util.*;
public class persiapanUAS4 {
	static Scanner a = new Scanner(System.in);
	public static void main (String [] args) {
		Scanner a = new Scanner(System.in);
		System.out.print("Masukkan batas = ");
		int batas = a.nextInt();
		
		int tabelAngka [] = new int [batas];
		isiData(tabelAngka);
		cariMax(tabelAngka);
		a.close();
	}
	public static void isiData(int [] arr){
		for (int i = 0; i< arr.length; i++) {
			System.out.print("Nilai ke- " + (i+1) + " =");
			arr[i]= a.nextInt();	
		}	
	}
	public static void cariMax(int [] arr) {
		int max = arr[0];
		for (int i =1; i< arr.length; i++) {
			if (arr[i]>max) {
				max=arr[i];
			}
		}
		System.out.println("Nilai maksimum dari inputan anda adalah "+max);
	}
	}
