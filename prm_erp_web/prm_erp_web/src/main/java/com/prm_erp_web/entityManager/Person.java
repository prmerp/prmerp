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
@Table(schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id")
    , @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Person.findByBirthDate", query = "SELECT p FROM Person p WHERE p.birthDate = :birthDate")
    , @NamedQuery(name = "Person.findByIsUserCreate", query = "SELECT p FROM Person p WHERE p.isUserCreate = :isUserCreate")
    , @NamedQuery(name = "Person.findByIsActive", query = "SELECT p FROM Person p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "Person.findByCreatedDate", query = "SELECT p FROM Person p WHERE p.createdDate = :createdDate")
    , @NamedQuery(name = "Person.findByUpdatedDate", query = "SELECT p FROM Person p WHERE p.updatedDate = :updatedDate")})
public class Person implements Serializable, UserTrackManagerMaster {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(nullable = false, length = 10)
    private String salutation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "first_name", nullable = false, length = 25)
    private String firstName;
    @Column(name = "first_name", nullable = true, length = 25)
    private String email;
    @Size(max = 25)
    @Column(name = "last_name", length = 25)
    private String lastName;
    @Column(name = "birth_date")
    private Long birthDate;
    @Column(name = "is_user_create")
    private Boolean isUserCreate;
    @Column(name = "is_active")
    private Boolean isActive;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date", nullable = false)
    private Long createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_date", nullable = false)
    private Long updatedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<UserMaster> userMasterCollection;
    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = true)
    @ManyToOne(optional = true)
    private UserMaster createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "id", nullable = true)
    @ManyToOne(optional = true)
    private UserMaster updatedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<PersonContactMap> personContactMapCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<PersonDocsMap> personDocsMapCollection;
    @JoinColumn(name = "logo_id", referencedColumnName = "id")
    @ManyToOne
    private LogoMaster logoId;

    public Person() {
    }

    public Person(Long id) {
        this.id = id;
    }

    public Person(Long id, String firstName, Long createdDate, Long updatedDate) {
        this.id = id;
        this.firstName = firstName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getIsUserCreate() {
        return isUserCreate;
    }

    public void setIsUserCreate(Boolean isUserCreate) {
        this.isUserCreate = isUserCreate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @XmlTransient
    public Collection<UserMaster> getUserMasterCollection() {
        return userMasterCollection;
    }

    public void setUserMasterCollection(Collection<UserMaster> userMasterCollection) {
        this.userMasterCollection = userMasterCollection;
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

    @XmlTransient
    public Collection<PersonContactMap> getPersonContactMapCollection() {
        return personContactMapCollection;
    }

    public void setPersonContactMapCollection(Collection<PersonContactMap> personContactMapCollection) {
        this.personContactMapCollection = personContactMapCollection;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.controllers.Person[ id=" + id + " ]";
    }

    /**
     * @return the salutation
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * @param salutation the salutation to set
     */
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    /**
     * @return the personDocsMapCollection
     */
    public Collection<PersonDocsMap> getPersonDocsMapCollection() {
        return personDocsMapCollection;
    }

    /**
     * @param personDocsMapCollection the personDocsMapCollection to set
     */
    public void setPersonDocsMapCollection(Collection<PersonDocsMap> personDocsMapCollection) {
        this.personDocsMapCollection = personDocsMapCollection;
    }

    /**
     * @return the logoId
     */
    public LogoMaster getLogoId() {
        return logoId;
    }

    /**
     * @param logoId the logoId to set
     */
    public void setLogoId(LogoMaster logoId) {
        this.logoId = logoId;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
