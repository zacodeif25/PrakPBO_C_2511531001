package strukdat;
import java.util.Scanner;
//CLASS ADT
class Mahasiswa {
 String nim;
 String nama;
 double ipk;

 public Mahasiswa(String nim, String nama, double ipk) {
     this.nim = nim;
     this.nama = nama;
     this.ipk = ipk;
 }

 public void tampilkan() {
     System.out.println(nim + " - " + nama + " (" + ipk + ")");
 }
}

//CLASS 2: StackMahasiswa 
class StackMahasiswa {
 private static final int MAX = 10;
 Mahasiswa[] stack = new Mahasiswa[MAX];
 int top = -1;

 public void push(Mahasiswa data) {
     if (top == MAX - 1) {
         System.out.println("Stack penuh!");
         return;
     } else {
         top++;
         stack[top] = data;
         System.out.println("Data berhasil ditambahkan");
     }
 }

 public Mahasiswa pop() {
     if (top == -1) {
         System.out.println("Stack kosong!");
         return null;
     } else {
         Mahasiswa data = stack[top];
         top--;
         return data;
     }
 }

 public Mahasiswa peek() {
     if (top == -1) {
         System.out.println("Stack kosong!");
         return null;
     } else {
         return stack[top];
     }
 }

 public void tampilkanStack() {
     if (top == -1) {
         System.out.println("Stack kosong");
     } else {
         System.out.println("--- Isi Stack ---");
         for (int i = top; i >= 0; i--) {
             stack[i].tampilkan();
         }
         System.out.println("-----------------");
     }
 }
}

//CLASS 3: Main Program
public class Main {
 public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     StackMahasiswa stack = new StackMahasiswa();
     int pilihan = 0;

     do {
         System.out.println("\n=== MENU STACK MAHASISWA ===");
         System.out.println("1. Push Data");
         System.out.println("2. Pop Data");
         System.out.println("3. Peek Data");
         System.out.println("4. Tampilkan Stack");
         System.out.println("5. Keluar");
         System.out.print("Pilih: ");

         if (input.hasNextInt()) {
             pilihan = input.nextInt();
             input.nextLine();
         } else {
             System.out.println("Input tidak valid! Masukkan angka.");
             input.nextLine();
             continue;
         }

         switch (pilihan) {
             case 1:
                 System.out.print("NIM: ");
                 String nim = input.nextLine();

                 System.out.print("Nama: ");
                 String nama = input.nextLine();

                 System.out.print("IPK: ");
                 if (input.hasNextDouble()) {
                     double ipk = input.nextDouble();
                     input.nextLine();
                     Mahasiswa m = new Mahasiswa(nim, nama, ipk);
                     stack.push(m);
                 } else {
                     System.out.println("IPK harus berupa angka!");
                     input.nextLine();
                 }
                 break;

             case 2:
                 Mahasiswa keluar = stack.pop();
                 if (keluar != null) {
                     System.out.println("Data keluar:");
                     keluar.tampilkan();
                 }
                 break;

             case 3:
                 Mahasiswa atas = stack.peek();
                 if (atas != null) {
                     System.out.println("Data paling atas:");
                     atas.tampilkan();
                 }
                 break;

             case 4:
                 stack.tampilkanStack();
                 break;

             case 5:
                 System.out.println("Program selesai");
                 break;

             default:
                 System.out.println("Pilihan tidak valid!");
         }

     } while (pilihan != 5);

     input.close();
 }
}

