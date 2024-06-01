import java.util.List;

public class Admin extends Akun {
    public Admin(String username, String password) {
        super(username, password);
    }

    public boolean tambahFilm(List<Film> films, Film newFilm) {
        for (Film film : films) {
            if (film.getNama().equalsIgnoreCase(newFilm.getNama())) {
                return false;
            }
        }
        films.add(newFilm);
        return true;
    }
}
