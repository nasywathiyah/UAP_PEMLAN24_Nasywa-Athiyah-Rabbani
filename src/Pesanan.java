public class Pesanan {
    private Film film;
    private int jumlah;
    private int totalHarga;

    public Pesanan(Film film, int jumlah, int totalHarga) {
        this.film = film;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
    }

    @Override
    public String toString() {
        return "Film: " + film.getNama() + " - Jumlah: " + jumlah + " - Total Harga: " + totalHarga;
    }
}
