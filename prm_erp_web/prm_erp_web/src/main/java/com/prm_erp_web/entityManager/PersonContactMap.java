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
@Table(name = "person_contact_map", catalog = "prm_erp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonContactMap.findAll", query = "SELECT p FROM PersonContactMap p")
    , @NamedQuery(name = "PersonContactMap.findById", query = "SELECT p FROM PersonContactMap p WHERE p.id = :id")})
public class PersonContactMap implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ContactNumbers contactId;
    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    public PersonContactMap() {
    }

    public PersonContactMap(Person personId, ContactNumbers contactId, Boolean isActive) {
        this.personId = personId;
        this.contactId = contactId;
        this.isActive = isActive;
    }

    public PersonContactMap(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public ContactNumbers getContactId() {
        return contactId;
    }

    public void setContactId(ContactNumbers contactId) {
        this.contactId = contactId;
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
        if (!(object instanceof PersonContactMap)) {
            return false;
        }
        PersonContactMap other = (PersonContactMap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.controllers.PersonContactMap[ id=" + id + " ]";
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
