package Pekan9_2511531001;
public class BTree_2511531001 {
	private Node_2511531001 root_1001; // deklarasi dari variabel root atau data awal dari penelusuran
	private Node_2511531001 currentNode_1001; // deklarasi variabel dari node yang sedang dikunjungi atau sedang aktif
	public BTree_2511531001 () { // konstruktor untuk kelas BTree
		root_1001 = null; // dengan kondisi nilai awal root adalah kosong atau null
		// ini berarti binary tree yang baru dibuat benar benar dalam kondisi kosong
	}
	
	public boolean search_1001 (int data_1001) {// method luaran untuk melakukan pencarian data
		/*method ini akan bernilai true jika data_1001 berhasil ditemukan dalam pohon
		 *dan akan bernilai false jika data_100 tidak berhasil ditemukan dalam phon
		 */
		
		return search_1001 (root_1001, data_1001); // meneruskan tugas pencarian ke method search_1001 yang lebih lanjut
		// root_1001 ditetapkan sebagai nilai awal dari pencarian
	}
	
	private boolean search_1001 (Node_2511531001 node_1001 , int data_1001) { // method untuk mencari data node tertentu di dalam pohon
		if (node_1001.getData_1001() == data_1001)// memeriksa node yang sedang dikunci apakah bernilai sama dengan nilai yang dicari
			return true;
			//jika sama persis, maka program akan langsung mengembalikan nilai true dan proses pencaria di cabang tsb dianggap selesai
		if(node_1001.getLeft_1001() != null) //memeriksa apakah anak node kiri tidak kosong
			if (search_1001(node_1001.getLeft_1001(),data_1001))//jika tidak kosong, maka akan dilakukan pencarian pada anak node kiri
				return true;
				//jika menemukan data yang dicari, maka program akan mengembalikan nilai true
		if(node_1001.getRight_1001() != null)//memeriksa apakah anak node kanan kosong
			if (search_1001(node_1001.getRight_1001(),data_1001))//jika tidak kosong maka akan dilakukan pencarian pada anak node kanan
				return true;
				//jika menemukannnya pada anak kanan, maka program akan mengembalikan nilai true dan menghentikan penelusuran
		return false;
		//program akan mengembalikan nilai false jika node yang diinginkan tidak ditemukan pada anak kiri dan kanan
	}
	
	public void printInorder_1001 () {//method ini akan memanggil method printInorder yang dimiliki oleh objek root_1001
		root_1001.printInorder_1001(root_1001);
		//lalu melempar root_1001 sebagai parameter awal untuk memulai rantai rekursi
	}
	
	public void printPreorder_1001 () {//method ini akan memanggil method printPreorder yang dimiliki oleh objek root_1001
		root_1001.printPreorder_1001(root_1001);
		//lalu melempar root_1001 sebagai parameter awal untuk memulai rantai rekursi
	}
	
	public void printPostorder_1001 () {//method ini akan memanggil method printPostorder yang dimiliki oleh objek root_1001
		root_1001.printPostorder_1001(root_1001);
		//lalu melempar root_1001 sebagai parameter awal untuk memulai rantai rekursi
	}
	
	public Node_2511531001 getRoot_1001 () {// method untuk mendapatkan nilai dari root dari suatu pohon
		return root_1001; // dan mengembalikan nilai yang tersimpan pada variabel root_1001
	}
	
	public boolean isEmpty_1001 () {// mengembalikan nilai true jika root_100 bernilai kosong atau null
		return root_1001 == null;
	}
	
	public int countNodes_1001 () {// method yang akan menghitung node yang sudah dikunjungi dimulai dari root_1001 sampai data akhir
		return countNodes_1001 (root_1001);
	}
	
	private int countNodes_1001 (Node_2511531001 node_1001) {
		int count_1001 = 1; // nilai awal dari count_1001 adalah 1
		if (node_1001 == null){ // lalu jika node_1001 tidak ada maka kembalikan nilai 0
			return 0;
		} else { // atau jika node_1001 tidak null maka
			count_1001 += countNodes_1001 (node_1001.getLeft_1001());//menelusuri node anak kiri dan jumlah nodenya ditambahkan kepada variabel count_1001
			count_1001 += countNodes_1001 (node_1001.getRight_1001()); //menelusuri node anak kanan dan jumlah nodenya ditambahkan kepada variabel count_1001
			return count_1001;// lalu mengembalikan akumulasi keseluruhan dari node node yang ada
		}
	}
	
	public void print_1001 () {//memanggil method untuk menampilkan visualisasi dari pohon
		root_1001.print_1001();
	}
	
	public Node_2511531001 getCurrent_1001 () {//method untuk mengambil nilai dari referensi variabel currentNode_1001
		return currentNode_1001;
	}
	
	public Node_2511531001 setCurrent_1001 (Node_2511531001 node_1001) {//method untuk mengubah nilai currentNode_1001
		return currentNode_1001 = node_1001;
	}
	
	public void setRoot_1001 (Node_2511531001 root_1001) {//method ini mengizinkn penggantian totol akar pohon dari luar kelas
		this.root_1001 = root_1001;
	}
}
