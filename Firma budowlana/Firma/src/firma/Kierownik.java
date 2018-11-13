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
public class Kierownik {
    private int id;
    private String imie;
    private String nazwisko;
    
    private String login;
    private String haslo;

    public Kierownik(int id, String imie, String nazwisko, String login, String haslo) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        
        this.login = login;
        this.haslo = haslo;
    }
    public Kierownik(){}

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

    @Override
    public String toString() {
        return "Kierownik{" + "id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", login=" + login + ", haslo=" + haslo + '}';
    }

    
    
}
