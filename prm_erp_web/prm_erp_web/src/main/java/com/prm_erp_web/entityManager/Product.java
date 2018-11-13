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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PDP_Shiva
 */
@Entity
@Table(catalog = "prm_erp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id")
    , @NamedQuery(name = "Product.findByProName", query = "SELECT p FROM Product p WHERE p.proName = :proName")
    , @NamedQuery(name = "Product.findByProCategoryId", query = "SELECT p FROM Product p WHERE p.proCategoryId = :proCategoryId")
    , @NamedQuery(name = "Product.findByProDesc", query = "SELECT p FROM Product p WHERE p.proDesc = :proDesc")
    , @NamedQuery(name = "Product.findByProPrice", query = "SELECT p FROM Product p WHERE p.proPrice = :proPrice")
    , @NamedQuery(name = "Product.findByHsnCode", query = "SELECT p FROM Product p WHERE p.hsnCode = :hsnCode")
    , @NamedQuery(name = "Product.findByStatus", query = "SELECT p FROM Product p WHERE p.status = :status")
    , @NamedQuery(name = "Product.findByCreatedDate", query = "SELECT p FROM Product p WHERE p.createdDate = :createdDate")
    , @NamedQuery(name = "Product.findByUpdatedDate", query = "SELECT p FROM Product p WHERE p.updatedDate = :updatedDate")})
public class Product implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pro_name", nullable = false, length = 200)
    private String proName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_category_id", nullable = false)
    private int proCategoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pro_desc", nullable = false, length = 200)
    private String proDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_price", nullable = false)
    private int proPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hsn_code", nullable = false)
    private int hsnCode;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date", nullable = false)
    private int createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_date", nullable = false)
    private int updatedDate;
    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserMaster createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserMaster updatedBy;

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public Product(Long id, String proName, int proCategoryId, String proDesc, int proPrice, int hsnCode, int status, int createdDate, int updatedDate) {
        this.id = id;
        this.proName = proName;
        this.proCategoryId = proCategoryId;
        this.proDesc = proDesc;
        this.proPrice = proPrice;
        this.hsnCode = hsnCode;
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

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getProCategoryId() {
        return proCategoryId;
    }

    public void setProCategoryId(int proCategoryId) {
        this.proCategoryId = proCategoryId;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public int getProPrice() {
        return proPrice;
    }

    public void setProPrice(int proPrice) {
        this.proPrice = proPrice;
    }

    public int getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(int hsnCode) {
        this.hsnCode = hsnCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(int createdDate) {
        this.createdDate = createdDate;
    }

    public int getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(int updatedDate) {
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.controllers.Product[ id=" + id + " ]";
    }
    
}
