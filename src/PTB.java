import java.util.*;

public class PTB {
    private static Map<String, Akun> akunMap = new HashMap<>();
    private static List<Film> films = new ArrayList<>();
    private static TampilanInterface tampilan = new TampilanInterface();

    static {
        // Inisialisasi akun dan saldo
        akunMap.put("user", new User("user", "123", 90000));
        akunMap.put("admin", new Admin("admin", "adminpass"));
        
        // Inisialisasi film
        films.add(new Film("Film A", "Deskripsi A", 50000, 10));
        films.add(new Film("Film B", "Deskripsi B", 60000, 5));
    }

    public static void main(String[] args) {
        while (true) {
            tampilan.tampilkanMenu();
            String username = tampilan.inputUsername();
            String password = tampilan.inputPassword();

            Akun akun = authenticate(username, password);
            if (akun != null) {
                tampilan.tampilkanPesan("Selamat datang " + username);
                if (akun instanceof Admin) {
                    AksiAdmin aksiAdmin = new AksiAdmin((Admin) akun);
                    adminMenu(aksiAdmin);
                } else {
                    AksiUser aksiUser = new AksiUser((User) akun);
                    userMenu(aksiUser);
                }
            } else {
                tampilan.tampilkanPesan("Username atau password salah. Silakan coba lagi.");
            }
        }
    }

    private static Akun authenticate(String username, String password) {
        Akun akun = akunMap.get(username);
        if (akun != null && akun.getPassword().equals(password)) {
            return akun;
        }
        return null;
    }

    public static List<Film> getFilms() {
        return films;
    }

    public static Film findFilm(String name) {
        for (Film film : films) {
            if (film.getNama().equalsIgnoreCase(name)) {
                return film;
            }
        }
        return null;
    }

    private static void userMenu(AksiUser aksiUser) {
        while (true) {
            tampilan.tampilkanMenuUser();
            int choice = tampilan.inputPilihan();
            switch (choice) {
                case 1:
                    aksiUser.lihatSaldo();
                    break;
                case 2:
                    aksiUser.lihatDaftarFilm();
                    break;
                case 3:
                    aksiUser.pesanFilm();
                    break;
                case 4:
                    aksiUser.lihatPesanan();
                    break;
                case 5:
                    tampilan.tampilkanPesan("Anda telah logout.");
                    return;
                case 6:
                    tampilan.tampilkanPesan("Aplikasi ditutup.");
                    System.exit(0);
                    break;
                default:
                    tampilan.tampilkanPesan("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void adminMenu(AksiAdmin aksiAdmin) {
        while (true) {
            tampilan.tampilkanMenuAdmin();
            int choice = tampilan.inputPilihan();
            switch (choice) {
                case 1:
                    aksiAdmin.lihatDaftarFilm();
                    break;
                case 2:
                    aksiAdmin.tambahFilm();
                    break;
                case 3:
                    tampilan.tampilkanPesan("Anda telah logout.");
                    return;
                case 4:
                    tampilan.tampilkanPesan("Aplikasi ditutup.");
                    System.exit(0);
                    break;
                default:
                    tampilan.tampilkanPesan("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}