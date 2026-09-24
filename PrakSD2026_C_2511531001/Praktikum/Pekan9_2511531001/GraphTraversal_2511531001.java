package Pekan9_2511531001;
import java.util.*;
public class GraphTraversal_2511531001 {
	private Map <String, List <String>> graph_1001 = new HashMap <> ();
	//deklarasi dan inisialisasi struktur data graph menggunakan representasi adjacency list di java
	
	//Menambahkan edge (graf tak berarah)
	public void addEdge_1001 (String node1_1001, String node2_1001) { //method untuk menambahkan sisi untuk menghubungkan satu node dengan node lainnya
		graph_1001.putIfAbsent(node1_1001, new ArrayList<>());//memeriksa apakah node1_1001 sudah terdaftar sebagai key dalam HashMap
		//jika belum maka method ini akan otomastis menambahkan node1_1001 dengan nilai awal berupa arraylist yang kosong
		graph_1001.putIfAbsent(node2_1001, new ArrayList<>());//memeriksa apakah node2_1001 sudah terdaftar sebagai key dalam HashMap
		//jika belum maka method ini akan otomatis menambahkan node2_1001 dengan nilai awal berupa arraylist yang kosong
		graph_1001.get(node1_1001).add(node2_1001);//mengambil daftar tetangga miliki node1_1001 lalu menambahkan node2_1001 ke dalam daftar tersebut
		//menciptakan jalur node 1 ke node 2
		graph_1001.get(node2_1001).add(node1_1001);//mengambil daftar tetangga miliki node2_1001 lalu menambahkan node1_1001 ke dalam daftar tersebut
		//menciptakan jalur node 2 ke node 1
	}
	
	//menampilkan graf awal
	public void printGraph_1001() {//method ini berfungsi untuk menampilkan representasi visual dari struktur graf
		System.out.println("Graf Awal (Adjancency List) : ");
		for (String node_1001 : graph_1001.keySet()) {//perulangan ini berfungsi untuk menampilkan semua node yang ada
			System.out.print(node_1001 + "-> ");
			List<String> neighbors_1001 = graph_1001.get(node_1001);//mengambil daftar tetangga dari node yang aktif
			System.out.println(String.join(",", neighbors_1001));
		}
		System.out.println();
	}
	
	//DFS rekursif 
	public void dfs_1001 (String start_1001) {//method yang menjadi awal dari penelusuran dengan algoritma DFS
		Set <String> visited_1001 = new HashSet <>(); //membuat himpunan dari node yang sudah dikunjungi dengan naman visited_1001
		System.out.println("Penelusuran DFS : ");
		dfsHelper_1001(start_1001,visited_1001);//memanggil method dfsHelper untuk meneruskan node awal dan objek visted_1001 agar dapat diisi dan diperiksa
		System.out.println();
	}
	
	private void dfsHelper_1001 (String current_1001, Set <String> visited_1001) {// method inilah yang melakukan penelusuran dfs
		if (visited_1001.contains(current_1001)) return;// percabangan ini bertugas untuk mengecek apakah node saat ini sudah dikunjungi
		visited_1001.add(current_1001); //jika belum dikunjungi maka node tersebut ditandai sebagai sudah dikunjudi dengan memasukkannnya ke dalam set
		System.out.print(current_1001 + " ");// node ditampilkan ke layar
		for (String neighbor_1001 : graph_1001.getOrDefault(current_1001, new ArrayList<>())) {// perulangan ini untuk menelusurio semua tetangga node saat ini
			dfsHelper_1001(neighbor_1001, visited_1001);
		}
	}
	
	private void bfs_1001 (String start_1001) {// method ini berfungsi untuk melakukan penelusuran dengan method bfs
		Set<String> visited_1001 = new HashSet <>();// membuat set dengan nama visited_1001 untuk node yang sudah dikunjungi
		Queue <String> queue_1001 = new LinkedList<>();// logika ini untuk memastikan node yang pertama kali dimasukkan ke antrean akan menjadi node pertama yang diproses
		queue_1001.add(start_1001);
		visited_1001.add(start_1001); //node awal yang dimasukkan ke dalam antrian akan langsung ditandai bahwa sudah dikunjungiu
		System.out.println("Penelusuran BFS :");
		while (!queue_1001.isEmpty()) {// perulangan akan berjalan jika antriannya masih belum kosong
			String current_1001 = queue_1001.poll();// mengambil node yang berada paling depan antrean lalu menghapusnya dari antrean
			System.out.print(current_1001 + " ");// mencetak dan menampilkan node yang aktif pada saat ini
			for (String neighbor_1001 : graph_1001.getOrDefault(current_1001, new ArrayList<>())) {
				if (!visited_1001.contains(neighbor_1001)) {//mengecek apakah tetangga tersebut sudah pernah dikunjungi apa belum
					queue_1001.add(neighbor_1001);// jika belum dikunjungi 
					//maka tetangga akan akan dimasukkan ke dalam antrean dan langsung ditandai dengan sudah dikunjungi
					visited_1001.add(neighbor_1001);
				}
			}
		}
		System.out.println();
	}
	//main
	public static void main (String [] Args) {
		GraphTraversal_2511531001 graph_1001 = new GraphTraversal_2511531001();
		//mendeklarasikan graph baru bernama graph_1001
		//contoh graf = A-B, A-C, B-D, B-E
		graph_1001.addEdge_1001("A", "B"); //memberikan sisi untuk menguhungkan node A dengan node B
		graph_1001.addEdge_1001("A", "C"); //memberikan sisi untuk menguhungkan node A dengan node C
		graph_1001.addEdge_1001("B", "D"); //memberikan sisi untuk menguhungkan node B dengan node D
		graph_1001.addEdge_1001("B", "E"); //memberikan sisi untuk menguhungkan node B dengan node E
		
		//cetak graph awal
		System.out.println("Graf Awal adalah : ");
		graph_1001.printGraph_1001();// memanggil method printGraph untuk menampilkan graph awal
		
		//lakukan penelusuran
		graph_1001.dfs_1001("A");//melakukan penelusuran dengan method dfs dengan titik awalnya adalah node A
		graph_1001.bfs_1001("A");//melakukan penelusuran dengan method bfs dengan titik awalnya adalah node A
	}
}
