public class Film {
    private String nama;
    private String deskripsi;
    private int harga;
    private int stok;

    public Film(String nama, String deskripsi, int harga, int stok) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok(int jumlah) {
        stok -= jumlah;
    }

    @Override
    public String toString() {
        return nama + " - " + deskripsi + " - Harga: " + harga + " - Stok: " + stok;
    }
}