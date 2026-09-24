package strukdat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Hotel {
    private String nama;
    private ArrayList<String> kamar;        // 1. ArrayList
    private LinkedList<String> booking;     // 2. LinkedList
    private Queue<String> antrian;          // 3. Queue
    private Stack<String> riwayat;          // 4. Stack

    // Konstruktor
    public Hotel(String nama) {
        this.nama = nama;
        this.kamar = new ArrayList<>();
        this.booking = new LinkedList<>();
        this.antrian = new LinkedList<>();
        this.riwayat = new Stack<>();
        System.out.println(">> Hotel '" + nama + "' siap.\n");
    }

    // Getter
    public String getNama() { return nama; }
    public int getJumlahBooking() { return booking.size(); }

    // Setter
    public void setNama(String newName) { this.nama = newName; }

    // I/O
    public void tulisHotel() {
        System.out.println("Hotel [" + this.nama + "]");
    }

    // --- ArrayList ---
    public void tambahKamar(String namaKamar) {
        kamar.add(namaKamar);
        System.out.println("{Kamar} Ditambahkan: " + namaKamar);
    }

    public void tampilkanKamar() {
        System.out.println("\n=== Kamar (ArrayList) ===");
        for (int i = 0; i < kamar.size(); i++) {
            System.out.println((i + 1) + ". " + kamar.get(i));
        }
    }

    // --- LinkedList ---
    public void booking(String tamu, String kamar) {
        String data = tamu + ":" + kamar;
        booking.add(data);
        riwayat.push("BOOKING:" + data);
        System.out.println("{Booking} " + data);
    }

    public void cancel(String tamu) {
        for (String b : booking) {
            if (b.startsWith(tamu + ":")) {
                booking.remove(b);
                riwayat.push("CANCEL:" + b);
                System.out.println("{Cancel} " + b);
                break;
            }
        }
    }

    public void tampilkanBooking() {
        System.out.println("\n=== Booking (LinkedList) ===");
        System.out.println("Total: " + getJumlahBooking());
        for (String b : booking) {
            System.out.println("- " + b);
        }
    }

    // --- Queue ---
    public void antrian(String tamu) {
        antrian.offer(tamu);
        System.out.println("{Antrian} Masuk: " + tamu);
    }

    public String layaniAntrian() {
        if (antrian.isEmpty()) return "Antrian kosong";
        String tamu = antrian.poll();
        riwayat.push("ANTRIAN:" + tamu);
        return "Layani: " + tamu;
    }

    public boolean isEmptyAntrian() { return antrian.isEmpty(); }

    // --- Stack ---
    public String undo() {
        if (riwayat.isEmpty()) return "Tidak ada undo";
        return "Undo: " + riwayat.pop();
    }

    public boolean isEmptyStack() { return riwayat.isEmpty(); }
}

// --- MAIN ---
public class tugaspertemuan6 {
    public static void main(String[] args) {
        // 1. Konstruktor
        Hotel hotel = new Hotel("Hotel Deluxe'za");
        hotel.tulisHotel();

        // 2. ArrayList (Kamar)
        System.out.println("--- 1. Kamar (ArrayList) ---");
        hotel.tambahKamar("101");
        hotel.tambahKamar("102");
        hotel.tambahKamar("103");
        hotel.tampilkanKamar();

        // 3. LinkedList (Booking)
        System.out.println("\n--- 2. Booking (LinkedList) ---");
        hotel.booking("Zaza", "101");
        hotel.booking("Aliifah", "102");
        hotel.tampilkanBooking();

        // 4. Queue (Antrian)
        System.out.println("\n--- 3. Antrian (Queue) ---");
        hotel.antrian("Khaula");
        hotel.antrian("Endy");
        System.out.println(hotel.layaniAntrian());
        System.out.println(hotel.layaniAntrian());

        // 5. Stack (Undo)
        System.out.println("\n--- 4. Undo (Stack) ---");
        System.out.println(hotel.undo());
        System.out.println(hotel.undo());

        // 6. Cancel (LinkedList Remove)
        System.out.println("\n--- 5. Cancel (LinkedList) ---");
        hotel.cancel("Endy");
        hotel.tampilkanBooking();

        // 7. Status
        System.out.println("\n--- 6. Status ---");
        System.out.println("Antrian Kosong? " + hotel.isEmptyAntrian());
        System.out.println("Stack Kosong? " + hotel.isEmptyStack());
        System.out.println("Total Booking: " + hotel.getJumlahBooking());
    }
}


