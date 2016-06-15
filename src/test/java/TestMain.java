import de.albritter.sql.MySQLHandler;

/**
 * Created by hhalbritter on 15.06.2016.
 */
public class TestMain {
    public static void main(String[] argv) {
        MySQLHandler.setUser("root");
        MySQLHandler.setDb("vmail");
        MySQLHandler.setServer("188.40.102.139");
        MySQLHandler.setPassword("a6HlhVzFR2Gcxdg9vA7C");
        MySQLHandler.openConnection();
        Main.main(null);

    }
}
