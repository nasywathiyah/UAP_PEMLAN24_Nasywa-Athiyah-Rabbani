import java.util.ArrayList;
import java.util.List;

public class User extends Akun {
    private int saldo;
    private List<Pesanan> pesananList;

    public User(String username, String password, int saldo) {
        super(username, password);
        this.saldo = saldo;
        this.pesananList = new ArrayList<>();
    }

    public int getSaldo() {
        return saldo;
    }

    public void kurangiSaldo(int jumlah) {
        saldo -= jumlah;
    }

    public void tambahPesanan(Pesanan pesanan) {
        pesananList.add(pesanan);
    }

    public void lihatPesanan() {
        if (pesananList.isEmpty()) {
            System.out.println("Kamu belum pernah melakukan pemesanan.");
        } else {
            for (Pesanan pesanan : pesananList) {
                System.out.println(pesanan);
            }
        }
    }
}