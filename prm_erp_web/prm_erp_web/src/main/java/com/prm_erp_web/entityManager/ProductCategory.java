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
@Table(name = "product_category", catalog = "prm_erp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductCategory.findAll", query = "SELECT p FROM ProductCategory p")
    , @NamedQuery(name = "ProductCategory.findById", query = "SELECT p FROM ProductCategory p WHERE p.id = :id")
    , @NamedQuery(name = "ProductCategory.findByCategoryName", query = "SELECT p FROM ProductCategory p WHERE p.categoryName = :categoryName")
    , @NamedQuery(name = "ProductCategory.findByStatus", query = "SELECT p FROM ProductCategory p WHERE p.status = :status")
    , @NamedQuery(name = "ProductCategory.findByCreatedDate", query = "SELECT p FROM ProductCategory p WHERE p.createdDate = :createdDate")
    , @NamedQuery(name = "ProductCategory.findByUpdatedDate", query = "SELECT p FROM ProductCategory p WHERE p.updatedDate = :updatedDate")})
public class ProductCategory implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_name", nullable = false)
    private int categoryName;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int status;
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

    public ProductCategory() {
    }

    public ProductCategory(Long id) {
        this.id = id;
    }

    public ProductCategory(Long id, int categoryName, int status, Long createdDate, Long updatedDate) {
        this.id = id;
        this.categoryName = categoryName;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(int categoryName) {
        this.categoryName = categoryName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCategory)) {
            return false;
        }
        ProductCategory other = (ProductCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.controllers.ProductCategory[ id=" + id + " ]";
    }
    
}
