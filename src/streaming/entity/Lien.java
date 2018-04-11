/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author romua
 */
@Entity
public class Lien implements Serializable {

    public enum Version {
        VF,
        VO,
        VOSTFR                
    }
    
    public enum Qualite {
        HD,
        SD,
    }
    
    @Column(unique = true, nullable = false)
    private String url;
    
    @ManyToOne // définit la cardinalité de la relation
    @JoinColumn(name="film_id") // définit la clé étrangère
    private Film film; // création variable film de type Film
    
    @ManyToOne
    @JoinColumn(name="episode_id")
    private Episode episode;
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 16)
    private Version version;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 16)
    private Qualite qualite;
    
    public Long getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }
    
    public Version getVersion () {
        return version;
    }

    public Qualite getQualite() {
        return qualite;
    }

    public String getUrl() {
        return url;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lien)) {
            return false;
        }
        Lien other = (Lien) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "streaming.entity.Lien[ id=" + id + " ]";
    }
    
    
    
}
