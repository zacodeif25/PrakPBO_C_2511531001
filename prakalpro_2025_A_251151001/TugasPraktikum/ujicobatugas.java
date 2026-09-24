
import java.util.*;
public class ujicobatugas {

	    public static void main(String[] args) {
	        int[] data = getPrimes();
	        System.out.println("Deret awal:");
	        tampilArray(data);

	        System.out.println("\nAlgoritma: Bubble Sort\n");

	        int langkah = 1;
	        for (int i = 0; i < data.length - 1; i++) {
	            boolean tukar = false;
	            for (int j = 0; j < data.length - 1 - i; j++) {
	                if (data[j] < data[j + 1]) {
	                    int tmp = data[j];
	                    data[j] = data[j + 1];
	                    data[j + 1] = tmp;
	                    tukar = true;

	                    // Langkah pertukaran
	                    System.out.print("Langkah " + langkah + ": ");
	                    tampilArray(data);
	                    langkah++;
	                }
	            }
	            if (!tukar) break;
	        }
	        // Hasil akhir
	        System.out.println("\nHasil:");
	        tampilArray(data);
	    }
	    static boolean cekPrima(int x) {
	        if (x <= 1) return false;
	        for (int i = 2; i <= x / 2; i++) {
	            if (x % i == 0) return false;
	        }
	        return true;
	    }
	    static int[] getPrimes() {
	        ArrayList<Integer> hasil = new ArrayList<>();
	        for (int i = 1; i <= 50; i++) {
	            if (cekPrima(i)) {
	                hasil.add(i);
	            }
	        }

	        int[] arr = new int[hasil.size()];
	        for (int i = 0; i < hasil.size(); i++) {
	            arr[i] = hasil.get(i);
	        }

	        return arr;
	    }
	    // Cetak array
	    static void tampilArray(int[] arr) {
	        System.out.print("[");
	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(arr[i]);
	            if (i != arr.length - 1) System.out.print(", ");
	        }
	        System.out.println("]");
	    }
	}
