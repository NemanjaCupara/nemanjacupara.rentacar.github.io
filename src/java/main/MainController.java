/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author X
 */
@Controller
@RequestMapping("/")

public class MainController {

    @Autowired
    DriverManagerDataSource dataSource;

    @RequestMapping("home")
    public String homePage(ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from proizvodjac");
        rs = dataSource.getConnection().createStatement().executeQuery("select * from proizvodjac");
        List<Proizvodjac> lista = new ArrayList<>();
        while (rs.next()) {
            Proizvodjac p = new Proizvodjac(rs.getString("pro_ime"));
            lista.add(p);
        }
        map.addAttribute("listaProizvodjac", lista);
        rs = dataSource.getConnection().createStatement().executeQuery("select * from komentari");
        List<Komentari> listaKomentara = new ArrayList<>();
        while (rs.next()) {

            Komentari k = new Komentari(rs.getString("kmk_ime"), rs.getString("kmk_komentar"));
            listaKomentara.add(k);
        }
        map.addAttribute("listaKomentara", listaKomentara);

        return "index";
    }

    @RequestMapping("cars")
    public String carsPage(ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }
        map.addAttribute("listaAutomobili", lista);
        return "vozniPark";
    }

    @RequestMapping("zaposleni")
    public String zaposleniPage(ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from zaposleni");

        List<Zaposleni> lista = new ArrayList<>();
        while (rs.next()) {
            Zaposleni z = new Zaposleni(rs.getString("zap_ime"), rs.getString("zap_prezime"),
                    rs.getString("zap_pozicija"), rs.getString("zap_username"),
                    rs.getString("zap_password"));
            lista.add(z);
        }
        map.addAttribute("listaZaposleni", lista);
        return "zaposleni";

    }

    @RequestMapping("rent")
    public String rentPage(@RequestParam String username, @RequestParam String password,
            ModelMap map) throws SQLException {
        map.addAttribute("username", username);
        map.addAttribute("password", password);

        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from zaposleni where zap_username='" + username + "'");

        if (rs.next()) {
            if (password.equals(rs.getString("zap_password"))) {
                     ResultSet rs2 = dataSource.getConnection().createStatement().executeQuery("select * from zaposleni where zap_username='" + username + "' and zap_pozicija='Direktor'");
                     if(rs2.next()){
                         rs = dataSource.getConnection().createStatement().executeQuery("select * from rentiraniautomobili, korisnik, automobili where rentiraniautomobili.aut_id=automobili.aut_id AND rentiraniautomobili.kor_id=korisnik.kor_id");

                List<Rentirani> lista = new ArrayList<>();
                while (rs.next()) {
                    Rentirani r = new Rentirani(rs.getString("kor_ime"), rs.getString("kor_prezime"),
                            rs.getInt("kor_jmbg"), rs.getString("aut_model"),
                            rs.getString("rat_datumUzimanja"), rs.getString("rat_datumVracanja"),
                            rs.getString("aut_proizvodjac"));
                    lista.add(r);
                }
                
                map.addAttribute("listaRentirani", lista);
                         return "rentirani";
                     }
                rs = dataSource.getConnection().createStatement().executeQuery("select * from rentiraniautomobili, korisnik, automobili where rentiraniautomobili.aut_id=automobili.aut_id AND rentiraniautomobili.kor_id=korisnik.kor_id");

                List<Rentirani> lista = new ArrayList<>();
                while (rs.next()) {
                    Rentirani r = new Rentirani(rs.getString("kor_ime"), rs.getString("kor_prezime"),
                            rs.getInt("kor_jmbg"), rs.getString("aut_model"),
                            rs.getString("rat_datumUzimanja"), rs.getString("rat_datumVracanja"),
                            rs.getString("aut_proizvodjac"));
                    lista.add(r);
                }
                map.addAttribute("listaRentirani", lista);
                
                return "rentiraniZ";

            }   
        }

        rs.close();

        return "logIn";

    }
    @RequestMapping("dOprema")
    public String dOpremaPage(ModelMap map) throws SQLException{
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from dodatnaoprema");
        List<DodatnaOprema> lista = new ArrayList<>();
        while(rs.next()){
            DodatnaOprema d = new DodatnaOprema(rs.getString("dto_naziv"), rs.getInt("dto_cena"), rs.getInt("dto_kolicina"));
            lista.add(d);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        map.addAttribute("listaKorisnika",listaK);
        map.addAttribute("listaOpreme",lista);
        return "DOprema";
    }
    @RequestMapping("nZap")
    public String nZapPage() {

        return "nZap";
    }


    @RequestMapping("logIn")
    public String logInPage() {

        return "logIn";

    }

    @RequestMapping("unesi")
    public String unesiPage(@RequestParam String ime, @RequestParam String komentar, ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from proizvodjac");
        rs = dataSource.getConnection().createStatement().executeQuery("select * from proizvodjac");
        List<Proizvodjac> lista = new ArrayList<>();
        while (rs.next()) {
            Proizvodjac p = new Proizvodjac(rs.getString("pro_ime"));
            lista.add(p);
        }
        map.addAttribute("listaProizvodjac", lista);

        String s = "INSERT INTO  komentari(kmk_komentar, kmk_ime) VALUES(?,?)";
        PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
        statement.setString(1, komentar);
        statement.setString(2, ime);
        statement.execute();

        rs = dataSource.getConnection().createStatement().executeQuery("select * from komentari");
        List<Komentari> listaKomentara = new ArrayList<>();
        while (rs.next()) {
            Komentari k = new Komentari(rs.getString("kmk_ime"), rs.getString("kmk_komentar"));
            listaKomentara.add(k);
        }

        map.addAttribute("listaKomentara", listaKomentara);

        return "index";
    }

    @RequestMapping("dodaj")
    public String dodajPage(@RequestParam String ime, @RequestParam String prezime, @RequestParam String pozicija, @RequestParam String username, @RequestParam String password, @RequestParam Integer id, ModelMap map) throws SQLException {
        String s = "INSERT INTO zaposleni(zap_ime, zap_prezime, zap_pozicija, zap_username, zap_password, fir_id) VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
        statement.setString(1, ime);
        statement.setString(2, prezime);
        statement.setString(3, pozicija);
        statement.setString(4, username);
        statement.setString(5, password);
        statement.setInt(6, id);
        statement.execute();
        return "nZap";
    }

    @RequestMapping("RTwingo")
    public String rtwingoPage(ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Twingo'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        map.addAttribute("listaKorisnika",listaK);
        map.addAttribute("listaAutomobili", lista);
        return "RTwingo";
    }

    @RequestMapping("Iznajmi")
    public String iznajmiPage(@RequestParam Integer id, @RequestParam String datumUzimanja,
            @RequestParam String datumVracanja, @RequestParam String Ime, @RequestParam String Prezime,
            @RequestParam String JMBG, @RequestParam String kor,
            ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Twingo'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        

        String k = "INSERT INTO korisnik(kor_ime, kor_prezime, kor_jmbg) VALUES(?,?,?)";
        PreparedStatement statementK = dataSource.getConnection().prepareStatement(k);
        statementK.setString(1, Ime);
        statementK.setString(2, Prezime);
        statementK.setString(3, JMBG);
        statementK.execute();

        String s = "INSERT INTO rentiraniautomobili(aut_id, rat_datumUzimanja, rat_datumVracanja, kor_id) VALUES(?,?,?,?)";
        PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
        statement.setInt(1, id);
        statement.setString(2, datumUzimanja);
        statement.setString(3, datumVracanja);
        statement.setString(4, kor);
        statement.execute();
        
        map.addAttribute("listaKorisnika",listaK);
        map.addAttribute("listaAutomobili", lista);
        return "RTwingo";
    }

    @RequestMapping("OCorsa")
    public String oCorsaPage(ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Corsa'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        map.addAttribute("listaKorisnika",listaK);
        map.addAttribute("listaAutomobili", lista);
        return "OCorsa";
    }

    @RequestMapping("IznajmiO")
    public String iznajmiOPage(@RequestParam Integer id, @RequestParam String datumUzimanja,
            @RequestParam String datumVracanja, @RequestParam String Ime, @RequestParam String Prezime,
            @RequestParam String JMBG, @RequestParam String kor,
            ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Corsa'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }

        String k = "INSERT INTO korisnik(kor_ime, kor_prezime, kor_jmbg) VALUES(?,?,?)";
        PreparedStatement statementK = dataSource.getConnection().prepareStatement(k);
        statementK.setString(1, Ime);
        statementK.setString(2, Prezime);
        statementK.setString(3, JMBG);
        statementK.execute();

        String s = "INSERT INTO rentiraniautomobili(aut_id, rat_datumUzimanja, rat_datumVracanja, kor_id) VALUES(?,?,?,?)";
        PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
        statement.setInt(1, id);
        statement.setString(2, datumUzimanja);
        statement.setString(3, datumVracanja);
        statement.setString(4, kor);
        statement.execute();
        
        map.addAttribute("listaKorisnika", listaK);
        map.addAttribute("listaAutomobili", lista);
        return "OCorsa";
    }

    @RequestMapping("RClio")
    public String rClioPage(ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Clio'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        map.addAttribute("listaKorisnika", listaK);
        map.addAttribute("listaAutomobili", lista);
        return "RClio";
    }

    @RequestMapping("IznajmiR")
    public String iznajmiRPage(@RequestParam Integer id, @RequestParam String datumUzimanja,
            @RequestParam String datumVracanja, @RequestParam String Ime, @RequestParam String Prezime,
            @RequestParam String JMBG, @RequestParam String kor,
            ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Clio'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }

        String k = "INSERT INTO korisnik(kor_ime, kor_prezime, kor_jmbg) VALUES(?,?,?)";
        PreparedStatement statementK = dataSource.getConnection().prepareStatement(k);
        statementK.setString(1, Ime);
        statementK.setString(2, Prezime);
        statementK.setString(3, JMBG);
        statementK.execute();

        String s = "INSERT INTO rentiraniautomobili(aut_id, rat_datumUzimanja, rat_datumVracanja, kor_id) VALUES(?,?,?,?)";
        PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
        statement.setInt(1, id);
        statement.setString(2, datumUzimanja);
        statement.setString(3, datumVracanja);
        statement.setString(4, kor);
        statement.execute();
        
        map.addAttribute("listaKorisnika", listaK);
        map.addAttribute("listaAutomobili", lista);
        return "RClio";
    }

    @RequestMapping("SOctavia")
    public String sOctaviaPage(ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Octavia'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        map.addAttribute("listaKorisnika",listaK);
        map.addAttribute("listaAutomobili", lista);
        return "SOctavia";
    }

    @RequestMapping("IznajmiS")
    public String iznajmiSPage(@RequestParam Integer id, @RequestParam String datumUzimanja,
            @RequestParam String datumVracanja, @RequestParam String Ime, @RequestParam String Prezime,
            @RequestParam String JMBG, @RequestParam String kor,
            ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Octavia'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        

        String k = "INSERT INTO korisnik(kor_ime, kor_prezime, kor_jmbg) VALUES(?,?,?)";
        PreparedStatement statementK = dataSource.getConnection().prepareStatement(k);
        statementK.setString(1, Ime);
        statementK.setString(2, Prezime);
        statementK.setString(3, JMBG);
        statementK.execute();

        String s = "INSERT INTO rentiraniautomobili(aut_id, rat_datumUzimanja, rat_datumVracanja, kor_id) VALUES(?,?,?,?)";
        PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
        statement.setInt(1, id);
        statement.setString(2, datumUzimanja);
        statement.setString(3, datumVracanja);
        statement.setString(4, kor);
        statement.execute();
        
        map.addAttribute("listaKorisnika", listaK);
        map.addAttribute("listaAutomobili", lista);
        return "SOctavia";
    }

    @RequestMapping("OMeriva")
    public String oMerivaPage(ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Meriva'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        map.addAttribute("listaKorisnika", listaK);
        map.addAttribute("listaAutomobili", lista);
        return "OMeriva";
    }

    @RequestMapping("IznajmiM")
    public String iznajmiMPage(@RequestParam Integer id, @RequestParam String datumUzimanja,
            @RequestParam String datumVracanja, @RequestParam String Ime, @RequestParam String Prezime,
            @RequestParam String JMBG, @RequestParam String kor,
            ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Meriva'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        

        String k = "INSERT INTO korisnik(kor_ime, kor_prezime, kor_jmbg) VALUES(?,?,?)";
        PreparedStatement statementK = dataSource.getConnection().prepareStatement(k);
        statementK.setString(1, Ime);
        statementK.setString(2, Prezime);
        statementK.setString(3, JMBG);
        statementK.execute();

        String s = "INSERT INTO rentiraniautomobili(aut_id, rat_datumUzimanja, rat_datumVracanja, kor_id) VALUES(?,?,?,?)";
        PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
        statement.setInt(1, id);
        statement.setString(2, datumUzimanja);
        statement.setString(3, datumVracanja);
        statement.setString(4, kor);
        statement.execute();
        
        map.addAttribute("listaKorisnika", listaK);
        map.addAttribute("listaAutomobili", lista);
        return "OMeriva";
    }

    @RequestMapping("NQuashqai")
    public String nQuashaqaiPage(ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Quashqai'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        map.addAttribute("listaKorisnika",listaK);
        map.addAttribute("listaAutomobili", lista);
        return "NQuashqai";
    }

    @RequestMapping("IznajmiQ")
    public String iznajmiQPage(@RequestParam Integer id, @RequestParam String datumUzimanja,
            @RequestParam String datumVracanja, @RequestParam String Ime, @RequestParam String Prezime,
            @RequestParam String JMBG, @RequestParam String kor,
            ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Quashqai'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }

        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        

        String k = "INSERT INTO korisnik(kor_ime, kor_prezime, kor_jmbg) VALUES(?,?,?)";
        PreparedStatement statementK = dataSource.getConnection().prepareStatement(k);
        statementK.setString(1, Ime);
        statementK.setString(2, Prezime);
        statementK.setString(3, JMBG);
        statementK.execute();

        String s = "INSERT INTO rentiraniautomobili(aut_id, rat_datumUzimanja, rat_datumVracanja, kor_id) VALUES(?,?,?,?)";
        PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
        statement.setInt(1, id);
        statement.setString(2, datumUzimanja);
        statement.setString(3, datumVracanja);
        statement.setString(4, kor);
        statement.execute();
        
        map.addAttribute("listaKorisnika", listaK);
        map.addAttribute("listaAutomobili", lista);
        return "NQuashqai";
    }

    @RequestMapping("RMegane")
    public String rMeganePage(ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Megane'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        map.addAttribute("listaKorisnika", listaK);
        map.addAttribute("listaAutomobili", lista);
        return "RMegane";
    }

    @RequestMapping("IznajmiRM")
    public String iznajmiRMPage(@RequestParam Integer id, @RequestParam String datumUzimanja,
            @RequestParam String datumVracanja, @RequestParam String Ime, @RequestParam String Prezime,
            @RequestParam String JMBG, @RequestParam String kor,
            ModelMap map) throws SQLException {
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from automobili where aut_model='Megane'");

        List<Automobili> lista = new ArrayList<>();
        while (rs.next()) {
            Automobili a = new Automobili(rs.getString("aut_proizvodjac"), rs.getString("aut_model"), rs.getString("aut_gorivo"),
                    rs.getString("aut_menjac"), rs.getInt("aut_konjskihSnaga"), rs.getDouble("aut_kubikaza"),
                    rs.getInt("aut_brojVrata"), rs.getInt("aut_brojSedista"), rs.getString("aut_cena"));

            lista.add(a);
        }

        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        

        String k = "INSERT INTO korisnik(kor_ime, kor_prezime, kor_jmbg) VALUES(?,?,?)";
        PreparedStatement statementK = dataSource.getConnection().prepareStatement(k);
        statementK.setString(1, Ime);
        statementK.setString(2, Prezime);
        statementK.setString(3, JMBG);
        statementK.execute();

        String s = "INSERT INTO rentiraniautomobili(aut_id, rat_datumUzimanja, rat_datumVracanja, kor_id) VALUES(?,?,?,?)";
        PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
        statement.setInt(1, id);
        statement.setString(2, datumUzimanja);
        statement.setString(3, datumVracanja);
        statement.setString(4, kor);
        statement.execute();
        
        map.addAttribute("listaKorisnika", listaK);
        map.addAttribute("listaAutomobili", lista);
        return "RMegane";
    }
    @RequestMapping("IznjamiGPS")
    public String iznajmiGPSPage(@RequestParam String GPS, @RequestParam String Ime,
            @RequestParam String Prezime, @RequestParam String JMBG, @RequestParam String kor,
             ModelMap map) throws SQLException{
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from dodatnaoprema");
        List<DodatnaOprema> lista = new ArrayList<>();
        while(rs.next()){
            DodatnaOprema d = new DodatnaOprema(rs.getString("dto_naziv"), rs.getInt("dto_cena"), rs.getInt("dto_kolicina"));
            lista.add(d);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        String k = "INSERT INTO korisnik(kor_ime, kor_prezime, kor_jmbg) VALUES(?,?,?)";
        PreparedStatement statementK = dataSource.getConnection().prepareStatement(k);
        statementK.setString(1, Ime);
        statementK.setString(2, Prezime);
        statementK.setString(3, JMBG);
        statementK.execute();

        String s = "INSERT INTO dto_kor(dto_id, kor_id) VALUES(?,?)";
        PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
        statement.setString(1, GPS);
        statement.setString(2, kor);

        statement.execute();
        map.addAttribute("listaKorisnika", listaK);
        map.addAttribute("listaOpreme",lista);
        return "DOprema";
    }
    @RequestMapping("IznjamiBuster")
    public String iznajmiBusterPage(@RequestParam String Buster, @RequestParam String Ime,
            @RequestParam String Prezime, @RequestParam String JMBG, 
            @RequestParam String kor, ModelMap map) throws SQLException{
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from dodatnaoprema");
        List<DodatnaOprema> lista = new ArrayList<>();
        while(rs.next()){
            DodatnaOprema d = new DodatnaOprema(rs.getString("dto_naziv"), rs.getInt("dto_cena"), rs.getInt("dto_kolicina"));
            lista.add(d);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        String k = "INSERT INTO korisnik(kor_ime, kor_prezime, kor_jmbg) VALUES(?,?,?)";
        PreparedStatement statementK = dataSource.getConnection().prepareStatement(k);
        statementK.setString(1, Ime);
        statementK.setString(2, Prezime);
        statementK.setString(3, JMBG);
        statementK.execute();

        String s = "INSERT INTO dto_kor(dto_id, kor_id) VALUES(?,?)";
        PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
        statement.setString(1, Buster);
        statement.setString(2, kor);
        statement.execute();
        map.addAttribute("listaKorisnika", listaK);
        map.addAttribute("listaOpreme",lista);
        return "DOprema";
    }
    @RequestMapping("IznjamiSedisteZaBebe")
    public String iznajmiSedisteZaBebePage(@RequestParam String SedisteZaBebe, @RequestParam String Ime,
            @RequestParam String Prezime, @RequestParam String JMBG, 
            @RequestParam String kor, ModelMap map) throws SQLException{
        ResultSet rs = dataSource.getConnection().createStatement().executeQuery("select * from dodatnaoprema");
        List<DodatnaOprema> lista = new ArrayList<>();
        while(rs.next()){
            DodatnaOprema d = new DodatnaOprema(rs.getString("dto_naziv"), rs.getInt("dto_cena"), rs.getInt("dto_kolicina"));
            lista.add(d);
        }
        rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM korisnik ORDER BY korisnik.kor_id DESC LIMIT 1");
        List<Korisnik> listaK = new ArrayList<>();
        if(rs.next()){
            Korisnik ko = new Korisnik(rs.getInt("kor_id"));
            listaK.add(ko);
        }
        String k = "INSERT INTO korisnik(kor_ime, kor_prezime, kor_jmbg) VALUES(?,?,?)";
        PreparedStatement statementK = dataSource.getConnection().prepareStatement(k);
        statementK.setString(1, Ime);
        statementK.setString(2, Prezime);
        statementK.setString(3, JMBG);

        statementK.execute();

        String s = "INSERT INTO dto_kor(dto_id, kor_id) VALUES(?,?)";
        PreparedStatement statement = dataSource.getConnection().prepareStatement(s);
        statement.setString(1, SedisteZaBebe);
        statement.setString(2, kor);
        statement.execute();
        map.addAttribute("listaKorisnika", listaK);
        map.addAttribute("listaOpreme",lista);
        return "DOprema";
    }
    
}
