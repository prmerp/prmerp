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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "organization_type", catalog = "prm_erp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrganizationType.findAll", query = "SELECT o FROM OrganizationType o")
    , @NamedQuery(name = "OrganizationType.findById", query = "SELECT o FROM OrganizationType o WHERE o.id = :id")
    , @NamedQuery(name = "OrganizationType.findByCategory", query = "SELECT o FROM OrganizationType o WHERE o.category = :category")
    , @NamedQuery(name = "OrganizationType.findByTypeId", query = "SELECT o FROM OrganizationType o WHERE o.typeId = :typeId")
    , @NamedQuery(name = "OrganizationType.findByIsActive", query = "SELECT o FROM OrganizationType o WHERE o.isActive = :isActive")
    , @NamedQuery(name = "OrganizationType.findByCreatedDate", query = "SELECT o FROM OrganizationType o WHERE o.createdDate = :createdDate")
    , @NamedQuery(name = "OrganizationType.findByUpdateDate", query = "SELECT o FROM OrganizationType o WHERE o.updateDate = :updateDate")})
public class OrganizationType implements Serializable {

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
    private String category;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type_id", nullable = false)
    private int typeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date", nullable = false)
    private Long createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_date", nullable = false)
    private Long updateDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizationType")
    private Collection<Organization> organizationCollection;
    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserMaster createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserMaster updatedBy;

    public OrganizationType() {
    }

    public OrganizationType(Long id) {
        this.id = id;
    }

    public OrganizationType(Long id, String category, int typeId, Boolean isActive, Long createdDate, Long updateDate) {
        this.id = id;
        this.category = category;
        this.typeId = typeId;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    @XmlTransient
    public Collection<Organization> getOrganizationCollection() {
        return organizationCollection;
    }

    public void setOrganizationCollection(Collection<Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
    }

    public UserMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserMaster createdBy) {
        this.createdBy = createdBy;
    }

    public UserMaster getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserMaster updatedBy) {
        this.updatedBy = updatedBy;
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
        if (!(object instanceof OrganizationType)) {
            return false;
        }
        OrganizationType other = (OrganizationType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.controllers.OrganizationType[ id=" + id + " ]";
    }
    
}
