public class Dolgozo {
    private int id;
    private String nev;
    private String nem;
    private int kor;
    private int fizetes;

    public Dolgozo(int id, String nev, String nem, int kor, int fizetes) {
        this.id = id;
        this.nev = nev;
        this.nem = nem;
        this.kor = kor;
        this.fizetes = fizetes;
    }

    public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public String getNem() {
        return nem;
    }

    public int getKor() {
        return kor;
    }

    public int getFizetes() {
        return fizetes;
    }

    @Override
    public String toString() {
        return  "id: " + id +"\t nev: " + nev + "\t nem: " + nem + "\t kor: " + kor + "\t fizetes: " + fizetes;
    }
}
