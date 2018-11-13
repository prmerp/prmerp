/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web.entityManager;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PDP_Shiva
 */
@Entity
@Table(name = "logo_master", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogoMaster.findAll", query = "SELECT l FROM LogoMaster l")
    , @NamedQuery(name = "LogoMaster.findById", query = "SELECT l FROM LogoMaster l WHERE l.id = :id")
    , @NamedQuery(name = "LogoMaster.findByModule", query = "SELECT l FROM LogoMaster l WHERE l.modules = :modules")})
public class LogoMaster implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "logo_path", nullable = false, length = 65535)
    private String logoPath;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer modules;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logoId")
    private Collection<Person> person1Collection;

    public LogoMaster() {
    }

    public LogoMaster(Long id) {
        this.id = id;
    }

    public LogoMaster(String logoPath, Integer modules) {
        this.logoPath = logoPath;
        this.modules = modules;
    }

    public LogoMaster(Long id, String logoPath, Integer modules) {
        this.id = id;
        this.logoPath = logoPath;
        this.modules = modules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public Integer getModule() {
        return modules;
    }

    public void setModule(Integer modules) {
        this.modules = modules;
    }

    @XmlTransient
    public Collection<Person> getPerson1Collection() {
        return person1Collection;
    }

    public void setPerson1Collection(Collection<Person> person1Collection) {
        this.person1Collection = person1Collection;
    }

    @Override
    public int hashCode() {
        Integer hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogoMaster)) {
            return false;
        }
        LogoMaster other = (LogoMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.controllers.LogoMaster[ id=" + id + " ]";
    }

}
