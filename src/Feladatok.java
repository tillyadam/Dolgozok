import java.io.Console;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Feladatok {

    public Feladatok() {
        Scanner sc = new Scanner(System.in);
        int valasztas = 0;
        do {
            System.out.print("1: Összes dolgozó megjelenítése\n2: Új dolgozó felvétele \n3: Dolgozó keresése");
            System.out.println();
            valasztas = sc.nextInt();
        } while (valasztas < 1 || valasztas > 3);
        switch (valasztas) {
            case 1:
                Select("SELECT * FROM `dolgozok`;");
                break;
            case 2:
                System.out.println("Ez még nincs kész");
                break;
            case 3:
                System.out.print("Adja meg a dolgozó nevét: ");
                String nev = sc.nextLine();
                System.out.println();
                Select("SELECT * FROM `dolgozok` WHERE `nev` LIKE '"+nev+"';");
                break;
            default:
                break;
        }

    }

    private void Select(String statement) {
        try {
            String url = "jdbc:mysql://localhost:3306/dolgozok";
            String user = "root";
            String password = "";

            Connection kapcsolat = DriverManager.getConnection(url, user, password);
            Statement allapot = kapcsolat.createStatement();
            ResultSet rs = allapot.executeQuery(statement);
            //System.out.println("Sikeres kapcsolat");
            while (rs.next()) {
                System.out.println("id: " + rs.getString(1) + "\t nev: " + rs.getString(2) + "\t nem: " + rs.getString(3) +
                        "\t kor: " + rs.getString(4) + "\t fizetes: " + rs.getString(5));
            }
            kapcsolat.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
