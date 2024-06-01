import java.util.Scanner;

public class TampilanInterface {
    private Scanner scanner = new Scanner(System.in);

    public void tampilkanMenu() {
        System.out.println("Silakan login >_<");
    }

    public void tampilkanMenuUser() {
        System.out.println("1. Lihat Saldo");
        System.out.println("2. Lihat Daftar Film");
        System.out.println("3. Pesan Film");
        System.out.println("4. Lihat Pesanan");
        System.out.println("5. Logout");
        System.out.println("6. Tutup Aplikasi");
    }

    public void tampilkanMenuAdmin() {
        System.out.println("1. Lihat Daftar Film");
        System.out.println("2. Tambah Film");
        System.out.println("3. Logout");
        System.out.println("4. Tutup Aplikasi");
    }

    public String inputUsername() {
        System.out.print("Username: ");
        return scanner.nextLine();
    }

    public String inputPassword() {
        System.out.print("Password: ");
        return scanner.nextLine();
    }

    public String inputString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public int inputInt(String message) {
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputPilihan() {
        System.out.print("Pilihan: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void tampilkanPesan(String message) {
        System.out.println(message);
    }
}