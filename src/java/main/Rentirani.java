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
public class Rentirani {

    String ime;
    String prezime;
    Integer jmbg;
    String automobili;
    String proizvodjac;
    String datumUzimanja;
    String datumVracanja;


    public Rentirani() {

    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }
 

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Integer getJmbg() {
        return jmbg;
    }

    public void setJmbg(Integer jmbg) {
        this.jmbg = jmbg;
    }

    public String getAutomobili() {
        return automobili;
    }

    public void setAutomobili(String automobili) {
        this.automobili = automobili;
    }

    public String getDatumUzimanja() {
        return datumUzimanja;
    }

    public void setDatumUzimanja(String datumUzimanja) {
        this.datumUzimanja = datumUzimanja;
    }

    public String getDatumVracanja() {
        return datumVracanja;
    }

    public void setDatumVracanja(String datumVracanja) {
        this.datumVracanja = datumVracanja;
    }

    public Rentirani(String ime, String prezime, Integer jmbg, String automobili, String datumUzimanja, String datumVracanja, String proizvodjac) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.automobili = automobili;
        this.datumUzimanja = datumUzimanja;
        this.datumVracanja = datumVracanja;
        this.proizvodjac = proizvodjac;

    }
}
