package Pekan9_2511531001;
public class Node_2511531001 {
	int data_1001;// pendeklarasian untuk data dan tipe datanya bisa diganti dengan string 
	Node_2511531001 left_1001;// mendeklarasikan pointer untuk data yang berada di kiri
	Node_2511531001 right_1001; //mendeklarasikan pointer untuk data yang berada di kanan
	
	public Node_2511531001 (int data_1001) { // konstruktor variabel data dan pointer
		this.data_1001= data_1001;
		left_1001 = null;
		right_1001 = null;
		}
	public void setLeft_1001 (Node_2511531001 node_1001) {// setter untuk variabel pointer Left
		if (left_1001 == null) // jika pointer left masih kosong
			left_1001 = node_1001;//maka node akan ditetapkan sebagai nilai dari pointer left
	}
	public void setRight_1001 (Node_2511531001 node_1001) {// setter untuk variabel pointer Right
		if (right_1001 == null) //jika pointer Right masih kosong
			right_1001 = node_1001; // maka node akan ditetapkan sebagai nilai dari pointer right
	}
	public Node_2511531001 getLeft_1001 () { //getter untuk pointer Left
		return left_1001; //mengembalikan nilai yang tersimpan pada pointer left, saat  getLeft dipanggil
	}
	public Node_2511531001 getRight_1001 () {//getter untuk pointer Right
		return right_1001;//mengembalikan nilai yang tersimpan pada pointer right, saat getRight dipanggil
	}
	public int getData_1001 () { //getter untuk mengambil nilai data yang bertipe integer
		return data_1001; //mengembalikan nilai data saat getData dipanggil
	}
	public void setData_1001 (int data_1001) {// setter untuk menetapkan nilai variabel data
		this.data_1001 = data_1001;
	}
	
	void printPreorder_1001 (Node_2511531001 node_1001) {// method untuk menelusuri data dengan method preorder
		// method ini akan melakukan penelusuran dengan mengunjungi root, left node lalu baru right node
		if (node_1001 ==null)// perbangan untuk mengembalikan program ke pemanggilan sebelumnya saat node yang dikunjungi sudah kosong
		return ;
		System.out.print(node_1001.data_1001 + " ");// menelusuri root dari binary tree terlebih dahulu (data_100 adalah node yang sedang aktif)
		printPreorder_1001 (node_1001.left_1001); // menelusuri left subtree
		printPreorder_1001 (node_1001.right_1001); // menelusuri right subtree
	}
	
	void printPostorder_1001 (Node_2511531001 node_1001) {// method untuk menelusuri data dengan method postorder
		// method ini melakukan penelusuran dengan menelusuri left subtree lalu right subtree sebelum mengunjungi root 
		if (node_1001 ==null) // percabangan untuk memberhentikan method, 
			//jika node yang dikunjungi sudah kosong maka akan kembali ke pemanggil sebelumnya
		return ;
		printPostorder_1001 (node_1001.left_1001); // menelusuri seluruh subtree sebelah kiri terlebih dahulu sampai menemukan node null
		printPostorder_1001 (node_1001.right_1001); // menelusuri seluruh subtree sebelah kanan
		System.out.print(node_1001.data_1001 + " "); // menelusuri root
	}
	
	void printInorder_1001 (Node_2511531001 node_1001) { // method untuk menelusuri data dengan method inorder
		// method ini akan melakukan penelusuran dimulai dengan left subtree lalu root dan terakhir akan mengunjungi right subtree dari data
		if (node_1001 ==null) // penelusuran akan berhenti jika node yang ditelusuri sudah bernilai null
		return ; // mengembalikan program ke pemanggilan sebelumnya jika percabangan bernilai true
		printInorder_1001 (node_1001.left_1001); // menelusuri node yang terdapat pada left subtree
		System.out.print(node_1001.data_1001 + " "); // menelusuri root dari data atau node yang sedang aktif
		printInorder_1001 (node_1001.right_1001); // menelusuri node yang terdapat pada right subtree
	}
	
	public String print_1001() { 
		return this.print_1001("",true,""); // method ini memberikan nilai default kepada variabel
		// prefix_1001 = "", yang artinya belum ada identasi
		// isTail_1001 = true, artinya node root dianggap sebagai 'ekor'
		//sb_1001= "", artinya belum ada identasi
	}
	
	// method dibawah ini digunakan untuk menggambarkan binary tree dengan penggambaran visual sederhana
	public String print_1001(String prefix_1001, boolean isTail_1001, String sb_1001) {
		// method ini akan menampilkan node dari kanan terlebih dahulu untuk menggambarkan visualisasi dengan urutan dengan terbalik
		if (right_1001 !=null) { // percabangan ini akan bernilai true jika pointer right tidak mengarahkan pada node yang kosong
			right_1001.print_1001(prefix_1001 + (isTail_1001 ? "|   " : "   "), false,sb_1001);
			/* jika percabangan benar, maka program akan menampilkan node kanan dengan secara rekursif isTail bernilai false 
			 * karena node kanan belum mencapai "ujung" dari penelusuran*/
		}
		System.out.println(prefix_1001 + (isTail_1001 ? "\\--" : "/--") + data_1001);
		//perintah untuk mencetak node yang aktif saat ini 
		
		if (left_1001 !=null) {// percabangan ini bernilai true jika pointer left tidak mengarah ke node yang bernilai kosong
			left_1001.print_1001(prefix_1001 + (isTail_1001 ? "   " : "|   "), true, sb_1001);
			/* jika percabangan benar, maka program akan menampilkan node kiri secara rekursif dengan isTail bernilai true
			 * karena node kiri merupakan ujung dari penelusuran dalam proses ini*/
		}
		return sb_1001;// mengembalikan nilai dari parameter sb_1001
	}
}
