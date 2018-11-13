/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web.entityManager;

import com.prm_erp_web.utilities.UserTrackManagerMaster;
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
import javax.persistence.Lob;
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
@Table(catalog = "prm_erp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organization.findAll", query = "SELECT o FROM Organization o")
    , @NamedQuery(name = "Organization.findById", query = "SELECT o FROM Organization o WHERE o.id = :id")
    , @NamedQuery(name = "Organization.findByOrganizationName", query = "SELECT o FROM Organization o WHERE o.organizationName = :organizationName")
    , @NamedQuery(name = "Organization.findByOrganizationCode", query = "SELECT o FROM Organization o WHERE o.organizationCode = :organizationCode")
    , @NamedQuery(name = "Organization.findByContactPerson", query = "SELECT o FROM Organization o WHERE o.contactPerson = :contactPerson")
    , @NamedQuery(name = "Organization.findByGstNo", query = "SELECT o FROM Organization o WHERE o.gstNo = :gstNo")
    , @NamedQuery(name = "Organization.findByEmail", query = "SELECT o FROM Organization o WHERE o.email = :email")
    , @NamedQuery(name = "Organization.findByFaxNo", query = "SELECT o FROM Organization o WHERE o.faxNo = :faxNo")
    , @NamedQuery(name = "Organization.findByIsActive", query = "SELECT o FROM Organization o WHERE o.isActive = :isActive")
    , @NamedQuery(name = "Organization.findByWebSite", query = "SELECT o FROM Organization o WHERE o.webSite = :webSite")
    , @NamedQuery(name = "Organization.findByCreatedDate", query = "SELECT o FROM Organization o WHERE o.createdDate = :createdDate")
    , @NamedQuery(name = "Organization.findByUpdatedDate", query = "SELECT o FROM Organization o WHERE o.updatedDate = :updatedDate")})
public class Organization implements Serializable, UserTrackManagerMaster {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "organization_name", nullable = false, length = 20)
    private String organizationName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "organization_code", nullable = false, length = 45)
    private String organizationCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contact_person", nullable = false, length = 45)
    private String contactPerson;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "gst_no", nullable = false, length = 20)
    private String gstNo;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String description;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 25)
    @Column(length = 25)
    private String email;
    @Size(max = 20)
    @Column(name = "fax_no", length = 20)
    private String faxNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Size(max = 20)
    @Column(name = "web_site", length = 20)
    private String webSite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date", nullable = false)
    private Long createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_date", nullable = false)
    private Long updatedDate;
    @JoinColumn(name = "contact_no", referencedColumnName = "id")
    @ManyToOne
    private ContactNumbers contactNo;
    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserMaster createdBy;
    @JoinColumn(name = "organization_type", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OrganizationType organizationType;
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    @ManyToOne
    private UserMaster updatedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgId")
    private Collection<OrgContactMap> orgContactMapCollection;

    public Organization() {
    }

    public Organization(Long id) {
        this.id = id;
    }

    public Organization(Long id, String organizationName, String organizationCode, String contactPerson, String gstNo, Boolean isActive, Long createdDate, Long updatedDate) {
        this.id = id;
        this.organizationName = organizationName;
        this.organizationCode = organizationCode;
        this.contactPerson = contactPerson;
        this.gstNo = gstNo;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    public ContactNumbers getContactNo() {
        return contactNo;
    }

    public void setContactNo(ContactNumbers contactNo) {
        this.contactNo = contactNo;
    }

    public UserMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserMaster createdBy) {
        this.createdBy = createdBy;
    }

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(OrganizationType organizationType) {
        this.organizationType = organizationType;
    }

    public UserMaster getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserMaster updatedBy) {
        this.updatedBy = updatedBy;
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
        if (!(object instanceof Organization)) {
            return false;
        }
        Organization other = (Organization) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.controllers.Organization[ id=" + id + " ]";
    }

}
