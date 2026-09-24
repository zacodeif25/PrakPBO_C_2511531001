package Pekan2;

public class Transaksi {
	String idTransaksi;
	String jenis;
	double nominal;
	
	public String getJenis() {
	    return jenis;
	}

	public double getNominal() {
	    return nominal;
	}

	public Transaksi(String id, String jenis, double nominal) {
		this.idTransaksi = id;
		this.jenis = jenis;
		this.nominal = nominal;
	}
	
	public void cetakDetail () {
		System.out.println("ID: " + idTransaksi + " | Jenis : "+ jenis + " | Nominal : Rp" + nominal);
	}
	
}