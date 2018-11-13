/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web.entityManager;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PDP_Shiva
 */
@Entity
@Table(name = "person_docs_map", catalog = "prm_erp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonDocsMap.findAll", query = "SELECT p FROM PersonDocsMap p")
    , @NamedQuery(name = "PersonDocsMap.findById", query = "SELECT p FROM PersonDocsMap p WHERE p.id = :id")})
public class PersonDocsMap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @JoinColumn(name = "docs_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private DocsManager docsId;
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;
    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    public PersonDocsMap() {
    }

    public PersonDocsMap(DocsManager docsId, Person personId,Boolean isActive) {
        this.docsId = docsId;
        this.personId = personId;
        this.isActive = isActive;
    }

    public PersonDocsMap(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocsManager getDocsId() {
        return docsId;
    }

    public void setDocsId(DocsManager docsId) {
        this.docsId = docsId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
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
        if (!(object instanceof PersonDocsMap)) {
            return false;
        }
        PersonDocsMap other = (PersonDocsMap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.entityManager.PersonDocsMap[ id=" + id + " ]";
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
