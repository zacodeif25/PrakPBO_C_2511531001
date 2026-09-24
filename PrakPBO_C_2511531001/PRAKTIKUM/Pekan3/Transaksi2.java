package Pekan3;

public class Transaksi2 {
	String idTransaksi;
	String jenis;
	double nominal;
	
	public Transaksi2(String id, String jenis, double nominal) {
		this.idTransaksi = id;
		this.jenis = jenis;
		this.nominal = nominal;
	}
	
	public String getIdTransaksi () {
		return idTransaksi;
	}
	
	public String getJenis() {
	    return jenis;
	}

	public double getNominal() {
	    return nominal;
	}

	
	public void cetakDetail () {
		System.out.println("ID: " + idTransaksi + " | Jenis : "+ jenis + " | Nominal : Rp" + nominal);
	}
	
}