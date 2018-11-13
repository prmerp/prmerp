/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web.entityManager;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "user_master", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMaster.findAll", query = "SELECT u FROM UserMaster u")
    , @NamedQuery(name = "UserMaster.findById", query = "SELECT u FROM UserMaster u WHERE u.id = :id")
    , @NamedQuery(name = "UserMaster.findByUserName", query = "SELECT u FROM UserMaster u WHERE u.userName = :userName")
    , @NamedQuery(name = "UserMaster.findByPassword", query = "SELECT u FROM UserMaster u WHERE u.password = :password")
    , @NamedQuery(name = "UserMaster.findByCreateDate", query = "SELECT u FROM UserMaster u WHERE u.createDate = :createDate")
    , @NamedQuery(name = "UserMaster.findByUpdatedDate", query = "SELECT u FROM UserMaster u WHERE u.updatedDate = :updatedDate")
    , @NamedQuery(name = "UserMaster.findByIsActive", query = "SELECT u FROM UserMaster u WHERE u.isActive = :isActive")})
public class UserMaster implements Serializable {

    /**
     * @return the permissionMasterCollection
     */
    public Collection<PermissionMaster> getPermissionMasterCollection() {
        return permissionMasterCollection;
    }

    /**
     * @param permissionMasterCollection the permissionMasterCollection to set
     */
    public void setPermissionMasterCollection(Collection<PermissionMaster> permissionMasterCollection) {
        this.permissionMasterCollection = permissionMasterCollection;
    }

    /**
     * @return the permissionMasterCollection1
     */
    public Collection<PermissionMaster> getPermissionMasterCollection1() {
        return permissionMasterCollection1;
    }

    /**
     * @param permissionMasterCollection1 the permissionMasterCollection1 to set
     */
    public void setPermissionMasterCollection1(Collection<PermissionMaster> permissionMasterCollection1) {
        this.permissionMasterCollection1 = permissionMasterCollection1;
    }

    /**
     * @return the roleMasterCollection
     */
    public Collection<RoleMaster> getRoleMasterCollection() {
        return roleMasterCollection;
    }

    /**
     * @param roleMasterCollection the roleMasterCollection to set
     */
    public void setRoleMasterCollection(Collection<RoleMaster> roleMasterCollection) {
        this.roleMasterCollection = roleMasterCollection;
    }

    /**
     * @return the roleMasterCollection1
     */
    public Collection<RoleMaster> getRoleMasterCollection1() {
        return roleMasterCollection1;
    }

    /**
     * @param roleMasterCollection1 the roleMasterCollection1 to set
     */
    public void setRoleMasterCollection1(Collection<RoleMaster> roleMasterCollection1) {
        this.roleMasterCollection1 = roleMasterCollection1;
    }

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_name", nullable = false, length = 20)
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createBy")
    private Collection<UserMaster> userMasterCollection;
    @JoinColumn(name = "create_by", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserMaster createBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private Collection<UserMaster> userMasterCollection1;
    @JoinColumn(name = "updated_by", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserMaster updatedBy;
    @Column(name = "joining_date")
    private BigInteger joiningDate;
    @Column(name = "leaving_date")
    private BigInteger leavingDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date", nullable = false)
    private long createDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_date", nullable = false)
    private long updatedDate;
    @JoinColumn(name = "logo_id", referencedColumnName = "id")
    @ManyToOne
    private LogoMaster logoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private Collection<DocsManager> docsManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private Collection<DocsManager> docsManagerCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private Collection<Person> personCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private Collection<Person> personCollection1;
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private Collection<Product> productCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private Collection<Product> productCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private Collection<Address> addressCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private Collection<Address> addressCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private Collection<Organization> organizationCollection;
    @JoinColumn(name = "reportingPerson", referencedColumnName = "id")
    @ManyToOne
    private UserMaster reportingPerson;
    @OneToMany(mappedBy = "updatedBy")
    private Collection<Organization> organizationCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private Collection<OrganizationType> organizationTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private Collection<OrganizationType> organizationTypeCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private Collection<ProductCategory> productCategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy")
    private Collection<ProductCategory> productCategoryCollection1;
    @OneToMany(mappedBy = "updatedBy")
    private Collection<RoleMaster> roleMasterCollection;
    @OneToMany(mappedBy = "createdBy")
    private Collection<RoleMaster> roleMasterCollection1;
    @OneToMany(mappedBy = "createdBy")
    private Collection<PermissionMaster> permissionMasterCollection;
    @OneToMany(mappedBy = "updatedBy")
    private Collection<PermissionMaster> permissionMasterCollection1;

    public UserMaster() {
    }

    public UserMaster(UserMaster master) {
        this.id = master.getId();
        this.userName = master.getUserName();
        this.password = master.getPassword();
        this.isActive = master.getIsActive();
    }

    public UserMaster(Long id) {
        this.id = id;
    }

    public UserMaster(Long id, String userName, String password, Long createDate, Long updatedDate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.createDate = createDate;
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    @XmlTransient
    public Collection<UserMaster> getUserMasterCollection() {
        return userMasterCollection;
    }

    public void setUserMasterCollection(Collection<UserMaster> userMasterCollection) {
        this.userMasterCollection = userMasterCollection;
    }

    public UserMaster getCreateBy() {
        return createBy;
    }

    public void setCreateBy(UserMaster createBy) {
        this.createBy = createBy;
    }

    @XmlTransient
    public Collection<UserMaster> getUserMasterCollection1() {
        return userMasterCollection1;
    }

    public void setUserMasterCollection1(Collection<UserMaster> userMasterCollection1) {
        this.userMasterCollection1 = userMasterCollection1;
    }

    public UserMaster getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserMaster updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LogoMaster getLogoId() {
        return logoId;
    }

    public void setLogoId(LogoMaster logoId) {
        this.logoId = logoId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @XmlTransient
    public Collection<Product> getProductCollection1() {
        return productCollection1;
    }

    public void setProductCollection1(Collection<Product> productCollection1) {
        this.productCollection1 = productCollection1;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection1() {
        return addressCollection1;
    }

    public void setAddressCollection1(Collection<Address> addressCollection1) {
        this.addressCollection1 = addressCollection1;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection1() {
        return personCollection1;
    }

    public void setPersonCollection1(Collection<Person> personCollection1) {
        this.personCollection1 = personCollection1;
    }

    @XmlTransient
    public Collection<Organization> getOrganizationCollection() {
        return organizationCollection;
    }

    public void setOrganizationCollection(Collection<Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
    }

    @XmlTransient
    public Collection<Organization> getOrganizationCollection1() {
        return organizationCollection1;
    }

    public void setOrganizationCollection1(Collection<Organization> organizationCollection1) {
        this.organizationCollection1 = organizationCollection1;
    }

    @XmlTransient
    public Collection<OrganizationType> getOrganizationTypeCollection() {
        return organizationTypeCollection;
    }

    public void setOrganizationTypeCollection(Collection<OrganizationType> organizationTypeCollection) {
        this.organizationTypeCollection = organizationTypeCollection;
    }

    @XmlTransient
    public Collection<OrganizationType> getOrganizationTypeCollection1() {
        return organizationTypeCollection1;
    }

    public void setOrganizationTypeCollection1(Collection<OrganizationType> organizationTypeCollection1) {
        this.organizationTypeCollection1 = organizationTypeCollection1;
    }

    @XmlTransient
    public Collection<ProductCategory> getProductCategoryCollection() {
        return productCategoryCollection;
    }

    public void setProductCategoryCollection(Collection<ProductCategory> productCategoryCollection) {
        this.productCategoryCollection = productCategoryCollection;
    }

    @XmlTransient
    public Collection<ProductCategory> getProductCategoryCollection1() {
        return productCategoryCollection1;
    }

    public void setProductCategoryCollection1(Collection<ProductCategory> productCategoryCollection1) {
        this.productCategoryCollection1 = productCategoryCollection1;
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
        if (!(object instanceof UserMaster)) {
            return false;
        }
        UserMaster other = (UserMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.controllers.UserMaster[ id=" + id + " ]";
    }

    public UserMaster(Long id, String password, Long createDate, Long updatedDate) {
        this.id = id;
        this.password = password;
        this.createDate = createDate;
        this.updatedDate = updatedDate;
    }

    @XmlTransient
    public Collection<DocsManager> getDocsManagerCollection() {
        return docsManagerCollection;
    }

    public void setDocsManagerCollection(Collection<DocsManager> docsManagerCollection) {
        this.docsManagerCollection = docsManagerCollection;
    }

    @XmlTransient
    public Collection<DocsManager> getDocsManagerCollection1() {
        return docsManagerCollection1;
    }

    public void setDocsManagerCollection1(Collection<DocsManager> docsManagerCollection1) {
        this.docsManagerCollection1 = docsManagerCollection1;
    }

    public UserMaster(Long id, String password, long createDate, long updatedDate) {
        this.id = id;
        this.password = password;
        this.createDate = createDate;
        this.updatedDate = updatedDate;
    }

    public BigInteger getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(BigInteger joiningDate) {
        this.joiningDate = joiningDate;
    }

    public BigInteger getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(BigInteger leavingDate) {
        this.leavingDate = leavingDate;
    }

    public UserMaster(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public UserMaster getReportingPerson() {
        return reportingPerson;
    }

    public void setReportingPerson(UserMaster reportingPerson) {
        this.reportingPerson = reportingPerson;
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
