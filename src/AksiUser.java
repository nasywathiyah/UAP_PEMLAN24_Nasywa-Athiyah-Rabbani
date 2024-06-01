import java.util.Scanner;

public class AksiUser extends Aksi {
    private User user;

    public AksiUser(User user) {
        this.user = user;
    }

    public void lihatSaldo() {
        tampilan.tampilkanPesan("Saldo anda: " + user.getSaldo());
    }

    public void lihatDaftarFilm() {
        for (Film film : PTB.getFilms()) {
            tampilan.tampilkanPesan(film.toString());
        }
    }

    public void pesanFilm() {
        Scanner scanner = new Scanner(System.in);
        String filmName = tampilan.inputString("Nama Film yang ingin dipesan: ");
        Film film = PTB.findFilm(filmName);
        
        if (film == null) {
            tampilan.tampilkanPesan("Film yang dicari tidak ditemukan.");
            return;
        }

        int jumlah = tampilan.inputInt("Jumlah tiket yang ingin dipesan: ");
        
        if (jumlah > film.getStok()) {
            tampilan.tampilkanPesan("Stok tiket tidak mencukupi.");
            return;
        }

        int hargaSatuan = film.getHarga();
        int totalHarga = hargaSatuan * jumlah;
        tampilan.tampilkanPesan("Harga satuan tiket " + hargaSatuan);
        tampilan.tampilkanPesan("Total harga " + totalHarga);

        if (totalHarga > user.getSaldo()) {
            tampilan.tampilkanPesan("Saldo tidak mencukupi, saldo yang dimiliki " + user.getSaldo());
            return;
        }

        film.kurangiStok(jumlah);
        user.kurangiSaldo(totalHarga);
        user.tambahPesanan(new Pesanan(film, jumlah, totalHarga));
        tampilan.tampilkanPesan("Tiket berhasil dipesan.");
    }

    public void lihatPesanan() {
        user.lihatPesanan();
    }
}