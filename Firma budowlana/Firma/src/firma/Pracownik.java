/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firma;

/**
 *
 * @author student
 */
public class Pracownik {
    private int id;
    private String imie;
    private String nazwisko;
    private String stanowisko;
    private int wynagrodzenie;
    private int premia;
    private int dzialID;
    private String login;
    private String haslo;
    

    public Pracownik(int id, String imie, String nazwisko, String stanowisko, int wynagrodzenie, int premia, int dzialID, String login, String haslo) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.wynagrodzenie = wynagrodzenie;
        this.premia = premia;
        this.dzialID = dzialID;
        this.login = login;
        this.haslo = haslo;
        
    }
    public Pracownik(){}

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(int wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public int getPremia() {
        return premia;
    }

    public void setPremia(int premia) {
        this.premia = premia;
    }

    public int getDzialID() {
        return dzialID;
    }

    public void setDzialID(int dzialID) {
        this.dzialID = dzialID;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    public float getWynagrodzenieExtra() {
        return wynagrodzenie + premia;
    }

   

    @Override
    public String toString() {
        return "Pracownik{" + "id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", stanowisko=" + stanowisko + ", wynagrodzenie=" + wynagrodzenie + ", premia=" + premia + ", dzialID=" + dzialID + ", login=" + login + ", haslo=" + haslo  + '}';
    }
    
   

    
}
