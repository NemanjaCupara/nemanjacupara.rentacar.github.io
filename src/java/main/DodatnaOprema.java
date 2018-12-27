/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author win 7
 */
public class DodatnaOprema {
    String Naziv;
    Integer Cena;
    Integer Kolicina;
    
    public DodatnaOprema(){
        
    }
    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String Naziv) {
        this.Naziv = Naziv;
    }

    public Integer getCena() {
        return Cena;
    }

    public void setCena(Integer Cena) {
        this.Cena = Cena;
    }

    public Integer getKolicina() {
        return Kolicina;
    }

    public void setKolicina(Integer Kolicina) {
        this.Kolicina = Kolicina;
    }

    public DodatnaOprema(String Naziv, Integer Cena, Integer Kolicina) {
        this.Naziv = Naziv;
        this.Cena = Cena;
        this.Kolicina = Kolicina;
    }
    
    
}
