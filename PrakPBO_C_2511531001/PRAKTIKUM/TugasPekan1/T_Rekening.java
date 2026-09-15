package TugasPekan1;

public class T_Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;

	public T_Rekening(String nomor, String nama, double saldoAwal) {
		nomorRekening = nomor;
		namaPemilik = nama;
		saldo = saldoAwal;
		System.out.println("Rekening atas nama " + namaPemilik + " berhasil dibuat dengan saldo Rp" + saldo);
	}

	public void setorTunai(double nominal) {
		if (nominal > 0) {
			saldo += nominal;
			System.out.println("Setor tunai Rp" + nominal + " berhasil. Saldo saat ini : Rp" + saldo);
		} else {
			System.out.println("Gagal : Nominal setor harus lebih dari 0!");
		}
	}

	public void tarikTunai(double nominal) {
		if (nominal > saldo) {
			System.out.println("Transaksi Gagal : Saldo Anda tidak cukup. Saldo Anda : Rp" + saldo);
		} else if (nominal < 10000) {
			System.out.println("Transaksi Gagal : Minimal nominal penarikan 10.000");
		} else {
			saldo -= nominal;
			System.out.println("Tarik tunai Rp" + nominal + " berhasil. Saldo saat ini : Rp" + saldo);
		}
	}

	public void cekInformasi() {
		System.out.println("--- INFO REKENING ---");
		System.out.println("No. Rekening : " + nomorRekening);
		System.out.println("Nama Pemilik : " + namaPemilik);
		System.out.print("Saldo Akhir : Rp" + saldo);
		System.out.println();
		System.out.println("---------------------");
	}
}