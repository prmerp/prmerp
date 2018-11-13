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
@Table(name = "org_contact_map", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgContactMap.findAll", query = "SELECT o FROM OrgContactMap o")
    , @NamedQuery(name = "OrgContactMap.findById", query = "SELECT o FROM OrgContactMap o WHERE o.id = :id")})
public class OrgContactMap implements Serializable {

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

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ContactNumbers contactId;
    @JoinColumn(name = "org_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Organization orgId;
    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    public OrgContactMap() {
    }

    public OrgContactMap(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactNumbers getContactId() {
        return contactId;
    }

    public void setContactId(ContactNumbers contactId) {
        this.contactId = contactId;
    }

    public Organization getOrgId() {
        return orgId;
    }

    public void setOrgId(Organization orgId) {
        this.orgId = orgId;
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
        if (!(object instanceof OrgContactMap)) {
            return false;
        }
        OrgContactMap other = (OrgContactMap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.controllers.OrgContactMap[ id=" + id + " ]";
    }

}
