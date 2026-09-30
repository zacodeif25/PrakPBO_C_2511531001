package Pekan4;

public class RekeningVIP extends Rekening4 {
	
	private static final double bonus_vip = 100000;
	public RekeningVIP (String nomor, String nama, double saldoAwal, String pinAwal) {
		super(nomor, nama, saldoAwal, pinAwal);
	}
	
	public void tambahBonusSaldo() {
		saldo += bonus_vip;
		
		//mencatat riwayat transaksi
		String idTrx = "TRX-Bonus-" + System.currentTimeMillis();
		riwayatTransaksi.add(new Transaksi3(idTrx, "Bonus", bonus_vip));
		
		System.out.println("Bonus VIP berhasil ditambahkan: Rp" + bonus_vip);
		System.out.println("Saldo setelah penambahan: Rp" + saldo);
	}

}
