import java.sql.*;
import java.util.ArrayList;

public class Feladatok {

    public Feladatok() {

        System.out.print("1: Összes dolgozó megjelenítése\n 2: Új dolgozó felvétele \n 3: Dolgozó keresése");
    }

    private void Lekerdezes(String statement) {
        try {
            String url = "jdbc:mysql://localhost:3306/dolgozok";
            String user = "root";
            String password = "";

            Connection kapcsolat = DriverManager.getConnection(url, user, password);
            Statement allapot = kapcsolat.createStatement();
            ResultSet rs = allapot.executeQuery(statement);
            //System.out.println("Sikeres kapcsolat");
            while (rs.next()) {
                String nyelv = rs.getString(1);
                ArrayList<Integer> data = new ArrayList<>();
                for (int i = 2; i < 12; i++) {
                    data.add(rs.getInt(i));
                }
            }
            kapcsolat.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
