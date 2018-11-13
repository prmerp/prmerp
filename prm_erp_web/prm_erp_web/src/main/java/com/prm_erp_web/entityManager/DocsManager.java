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
@Table(name = "docs_manager", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocsManager.findAll", query = "SELECT d FROM DocsManager d")
    , @NamedQuery(name = "DocsManager.findById", query = "SELECT d FROM DocsManager d WHERE d.id = :id")
    , @NamedQuery(name = "DocsManager.findByFileName", query = "SELECT d FROM DocsManager d WHERE d.fileName = :fileName")
    , @NamedQuery(name = "DocsManager.findByFilePath", query = "SELECT d FROM DocsManager d WHERE d.filePath = :filePath")
    , @NamedQuery(name = "DocsManager.findByIsActive", query = "SELECT d FROM DocsManager d WHERE d.isActive = :isActive")
    , @NamedQuery(name = "DocsManager.findByCreatedDate", query = "SELECT d FROM DocsManager d WHERE d.createdDate = :createdDate")
    , @NamedQuery(name = "DocsManager.findByUpdatedDate", query = "SELECT d FROM DocsManager d WHERE d.updatedDate = :updatedDate")})
public class DocsManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "file_name", nullable = false, length = 45)
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "file_path", nullable = false, length = 45)
    private String filePath;
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
    @Column(name = "updated_date", nullable = false)
    private Long updatedDate;
    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserMaster createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserMaster updatedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docsId")
    private Collection<PersonDocsMap> personDocsMapCollection;

    public DocsManager() {
    }

    public DocsManager(Long id) {
        this.id = id;
    }

    public DocsManager(String fileName, String filePath, Boolean isActive) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.isActive = isActive;
    }

    public DocsManager(Long id, String fileName, String filePath, Boolean isActive, Long createdDate, Long updatedDate) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
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
    public Collection<PersonDocsMap> getPersonDocsMapCollection() {
        return personDocsMapCollection;
    }

    public void setPersonDocsMapCollection(Collection<PersonDocsMap> personDocsMapCollection) {
        this.personDocsMapCollection = personDocsMapCollection;
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
        if (!(object instanceof DocsManager)) {
            return false;
        }
        DocsManager other = (DocsManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
