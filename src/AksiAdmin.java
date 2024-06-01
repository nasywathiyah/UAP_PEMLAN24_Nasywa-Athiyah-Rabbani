public class AksiAdmin extends Aksi {
    private Admin admin;

    public AksiAdmin(Admin admin) {
        this.admin = admin;
    }

    public void lihatDaftarFilm() {
        for (Film film : PTB.getFilms()) {
            tampilan.tampilkanPesan(film.toString());
        }
    }

    public void tambahFilm() {
        String nama = tampilan.inputString("Nama Film: ");
        String deskripsi = tampilan.inputString("Deskripsi Film: ");
        int harga = tampilan.inputInt("Harga Tiket: ");
        int stok = tampilan.inputInt("Stok Tiket: ");
        
        if (admin.tambahFilm(PTB.getFilms(), new Film(nama, deskripsi, harga, stok))) {
            tampilan.tampilkanPesan("Film " + nama + " berhasil ditambahkan.");
        } else {
            tampilan.tampilkanPesan("Film " + nama + " sudah ada.");
        }
    }
}
