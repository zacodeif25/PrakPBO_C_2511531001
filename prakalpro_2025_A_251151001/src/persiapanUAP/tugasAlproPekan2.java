package persiapanUAP;

public class tugasAlproPekan2 {

	public static void main(String[] args) {
		float magnitudo = 6.5f;
	    char risiko = 'H'; // High Risk
	    boolean potensi = true;
	    int wilayah = 3;

	    System.out.println("=== LAPORAN BENCANA GEMPA ===");
	    System.out.println("Kekuatan Gempa : " + magnitudo);
	    System.out.println("Status Gempa   : " + risiko );
	    System.out.println("Potensi Tsunami: " + (potensi ? "ADA" : "TIDAK ADA"));
	    System.out.println("Wilayah Terdampak: " + wilayah);

	}

}
