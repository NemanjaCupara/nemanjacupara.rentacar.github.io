/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Grupa5
 */
public class Automobili {

    String proizvodjac;
    String model;
    String gorivo;
    String menjac;
    Integer konjskihSnaga;
    Double kubikaza;
    Integer brojVrata;
    Integer brojSedista;
    String cena;

    public Automobili() {

    }

    public Automobili(String proizvodjac, String model, String gorivo, String menjac, Integer konjskihSnaga, Double kubikaza, Integer brojVrata, Integer brojSedista, String cena) {
        this.proizvodjac = proizvodjac;
        this.model = model;
        this.gorivo = gorivo;
        this.menjac = menjac;
        this.konjskihSnaga = konjskihSnaga;
        this.kubikaza = kubikaza;
        this.brojVrata = brojVrata;
        this.brojSedista = brojSedista;
        this.cena = cena;
    }

    Automobili(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGorivo() {
        return gorivo;
    }

    public void setGorivo(String gorivo) {
        this.gorivo = gorivo;
    }

    public String getMenjac() {
        return menjac;
    }

    public void setMenjac(String menjac) {
        this.menjac = menjac;
    }

    public Integer getKonjskihSnaga() {
        return konjskihSnaga;
    }

    public void setKonjskihSnaga(Integer konjskihSnaga) {
        this.konjskihSnaga = konjskihSnaga;
    }

    public Double getKubikaza() {
        return kubikaza;
    }

    public void setKubikaza(Double kubikaza) {
        this.kubikaza = kubikaza;
    }

    public Integer getBrojVrata() {
        return brojVrata;
    }

    public void setBrojVrata(Integer brojVrata) {
        this.brojVrata = brojVrata;
    }

    public Integer getBrojSedista() {
        return brojSedista;
    }

    public void setBrojSedista(Integer brojSedista) {
        this.brojSedista = brojSedista;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

}
