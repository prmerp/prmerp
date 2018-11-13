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
@Table(name = "contact_numbers", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactNumbers.findAll", query = "SELECT c FROM ContactNumbers c")
    , @NamedQuery(name = "ContactNumbers.findById", query = "SELECT c FROM ContactNumbers c WHERE c.id = :id")
    , @NamedQuery(name = "ContactNumbers.findByNumber", query = "SELECT c FROM ContactNumbers c WHERE c.number = :number")
    , @NamedQuery(name = "ContactNumbers.findByModule", query = "SELECT c FROM ContactNumbers c WHERE c.modules = :modules")})
public class ContactNumbers implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String number;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer modules;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactId")
    private Collection<PersonContactMap> personContactMapCollection;
    @OneToMany(mappedBy = "contactNo")
    private Collection<Organization> organizationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactId")
    private Collection<OrgContactMap> orgContactMapCollection;

    public ContactNumbers() {
    }

    public ContactNumbers(Long id) {
        this.id = id;
    }

    public ContactNumbers(String number, Integer modules) {
        this.number = number;
        this.modules = modules;
    }

    public ContactNumbers(Long id, String number, Integer modules) {
        this.id = id;
        this.number = number;
        this.modules = modules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getModule() {
        return modules;
    }

    public void setModule(Integer modules) {
        this.modules = modules;
    }

    @XmlTransient
    public Collection<PersonContactMap> getPersonContactMapCollection() {
        return personContactMapCollection;
    }

    public void setPersonContactMapCollection(Collection<PersonContactMap> personContactMapCollection) {
        this.personContactMapCollection = personContactMapCollection;
    }

    @XmlTransient
    public Collection<Organization> getOrganizationCollection() {
        return organizationCollection;
    }

    public void setOrganizationCollection(Collection<Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
    }

    @XmlTransient
    public Collection<OrgContactMap> getOrgContactMapCollection() {
        return orgContactMapCollection;
    }

    public void setOrgContactMapCollection(Collection<OrgContactMap> orgContactMapCollection) {
        this.orgContactMapCollection = orgContactMapCollection;
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
        if (!(object instanceof ContactNumbers)) {
            return false;
        }
        ContactNumbers other = (ContactNumbers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.controllers.ContactNumbers[ id=" + id + " ]";
    }
    
}
