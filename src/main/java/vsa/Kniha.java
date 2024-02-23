package vsa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Kniha {
    @Column(unique = true, nullable = false)
    private String nazov;
    private String autor;
    @Id
    private String isbn;
    private Double cena;
    @Enumerated(EnumType.STRING)
    private Dostupnost dostupnost;

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Dostupnost getDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(Dostupnost dostupnost) {
        this.dostupnost = dostupnost;
    }

    @Override
    public String toString() {
        return "Kniha {\n" + "nazov=" + nazov + '\n' + "autor=" + autor + '\n' + "isbn=" + isbn + '\n' + "cena=" + 
                cena + '\n' + "dostupnost=" + dostupnost + "\n}\n";
    }

}    

