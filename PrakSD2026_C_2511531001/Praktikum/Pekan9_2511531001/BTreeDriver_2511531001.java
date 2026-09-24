package Pekan9_2511531001;
public class BTreeDriver_2511531001 {
	public static void main (String [] args) {
		//membuat pohon
		BTree_2511531001 tree_1001 = new BTree_2511531001 ();
		System.out.print("Jumlah Simpul Awal Pohon : ");
		System.out.println(tree_1001.countNodes_1001());// memanggil method countNodes untuk menampilkan jumlah awal node pohon
		
		//menambahkan simpul data 1
		Node_2511531001 root_1001 = new Node_2511531001 (1);
		
		//menjadikan simpul 1 sebagai root
		tree_1001.setRoot_1001(root_1001);
		System.out.print("Jumlah simpul jika hanya ada root :");
		System.out.println(tree_1001.countNodes_1001());// menampilkan jumlah simpul yang mana pada saat ini hanya root yang dihitung
		Node_2511531001 node2_1001 = new Node_2511531001 (2); // menambahkan nilai untuk dijadikan node //
		Node_2511531001 node3_1001 = new Node_2511531001 (3);
		Node_2511531001 node4_1001 = new Node_2511531001 (4);
		Node_2511531001 node5_1001 = new Node_2511531001 (5);
		Node_2511531001 node6_1001 = new Node_2511531001 (6);
		Node_2511531001 node7_1001 = new Node_2511531001 (7);
		Node_2511531001 node8_1001 = new Node_2511531001 (8);
		Node_2511531001 node9_1001 = new Node_2511531001 (9);
		
		root_1001.setLeft_1001(node2_1001);//menjadikan node2 sebagai anak kiri dari root
		node2_1001.setLeft_1001(node4_1001);//menjadikan node4 sebagai anak kiri dari node2
		node2_1001.setRight_1001(node5_1001);//menjadikan node5 sebagai anak kanan dari node2
		node4_1001.setRight_1001(node8_1001);//menjadikan node8 sebagai anak kanan dari node4
		root_1001.setRight_1001(node3_1001);//menjadikan node3 sebagai anak kanan dari root
		node3_1001.setLeft_1001(node6_1001);//menjadikan node6 sebagai anak kiri dari node3
		node3_1001.setRight_1001(node7_1001);//menjadikan node7 sebagai anak kanan dari node3
		node6_1001.setLeft_1001(node9_1001);//menjadikan node9 sebagai anak kiri dari node6
		
		//set root
		tree_1001.setCurrent_1001(tree_1001.getRoot_1001());
		System.out.println("menampilkan simpul terakhir :");
		System.out.println(tree_1001.getCurrent_1001().getData_1001());
		System.out.println("Jumlah simpul ; setelah simpul 7 ditambahkan :");
		System.out.println(tree_1001.countNodes_1001());
		System.out.println("InOrder:"); //menampilkan hasil penelusuran dengan method inorder
		tree_1001.printInorder_1001();
		System.out.println("\nPreOrder:"); //menampilkan hasil penelusuran dengan method preorder
		tree_1001.printPreorder_1001();
		System.out.println("\nPostOrder:");//menampilkan hasil penelesuran dengan method postorder
		tree_1001.printPostorder_1001();
		System.out.println("\nmenampilkan simpul dalam bentuk phon : ");//menampilkan tampilan visual dari pohon
		tree_1001.print_1001();
		}
}
