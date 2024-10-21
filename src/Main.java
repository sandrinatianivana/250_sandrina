import java.util.ArrayList;
import java.util.Scanner;

class Barang {
    String kodeBarang;
    String namaBarang;
    int hargaBarang;
    int jumlahBarang;

    public Barang(String kodeBarang, String namaBarang, int hargaBarang, int jumlahBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBarang = jumlahBarang;
    }

    public int getSubTotal() {
        return hargaBarang * jumlahBarang;
    }

    public void displayBarang() {
        System.out.println(kodeBarang + " \t" + namaBarang + " \t" + hargaBarang + " \t" + jumlahBarang + " \t" + getSubTotal());
    }
}

class TransaksiKasir {
    ArrayList<Barang> barangs = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void tambahBarang() {
        System.out.print("Masukkan kode Barang: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga Barang: ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan jumlah Barang: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // consume newline

        barangs.add(new Barang(kode, nama, harga, jumlah));
    }

    public void tampilkanDaftarBarang() {
        System.out.println("Kode \tNama \tHarga \tJumlah \tSubtotal");
        for (Barang barang : barangs) {
            barang.displayBarang();
        }
    }

    public int hitungTotalHarga() {
        int total = 0;
        for (Barang barang : barangs) {
            total += barang.getSubTotal();
        }
        return total;
    }

    public void prosesPembayaran() {
        int totalHarga = hitungTotalHarga();
        System.out.println("Total Harga: " + totalHarga);
        System.out.print("Masukkan jumlah pembayaran: ");
        int bayar = scanner.nextInt();

        int kembali = bayar - totalHarga;
        System.out.println("Kembalian: " + kembali);
    }
}

public class Main {
    public static void main(String[] args) {
        TransaksiKasir kasir = new TransaksiKasir();
        Scanner scanner = new Scanner(System.in);
        boolean lanjut = true;

        while (lanjut) {
            kasir.tambahBarang();
            System.out.print("Apakah ingin menambah barang lagi? (y/n): ");
            String pilihan = scanner.nextLine();
            lanjut = pilihan.equalsIgnoreCase("y");
        }

        kasir.tampilkanDaftarBarang();
        kasir.prosesPembayaran();
    }
}