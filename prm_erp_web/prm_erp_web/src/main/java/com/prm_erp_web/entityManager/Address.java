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
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id")
    , @NamedQuery(name = "Address.findByLineNo1", query = "SELECT a FROM Address a WHERE a.lineNo1 = :lineNo1")
    , @NamedQuery(name = "Address.findByLineNo2", query = "SELECT a FROM Address a WHERE a.lineNo2 = :lineNo2")
    , @NamedQuery(name = "Address.findByPinCode", query = "SELECT a FROM Address a WHERE a.pinCode = :pinCode")
    , @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country")
    , @NamedQuery(name = "Address.findByState", query = "SELECT a FROM Address a WHERE a.state = :state")
    , @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city")
    , @NamedQuery(name = "Address.findByAddressType", query = "SELECT a FROM Address a WHERE a.addressType = :addressType")
    , @NamedQuery(name = "Address.findByStatus", query = "SELECT a FROM Address a WHERE a.status = :status")
    , @NamedQuery(name = "Address.findByCreatedDate", query = "SELECT a FROM Address a WHERE a.createdDate = :createdDate")
    , @NamedQuery(name = "Address.findByUpdatedDate", query = "SELECT a FROM Address a WHERE a.updatedDate = :updatedDate")})
public class Address implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "line_no_1", nullable = false, length = 200)
    private String lineNo1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "line_no_2", nullable = false, length = 200)
    private String lineNo2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pin_code", nullable = false)
    private int pinCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String city;
    @Basic(optional = false)
    @NotNull
    @Column(name = "address_type", nullable = false)
    private int addressType;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Boolean status;
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

    public Address() {
    }

    public Address(Long id) {
        this.id = id;
    }

    public Address(Long id, String lineNo1, String lineNo2, int pinCode, String country, String state, String city, int addressType, Boolean status, Long createdDate, Long updatedDate) {
        this.id = id;
        this.lineNo1 = lineNo1;
        this.lineNo2 = lineNo2;
        this.pinCode = pinCode;
        this.country = country;
        this.state = state;
        this.city = city;
        this.addressType = addressType;
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

    public String getLineNo1() {
        return lineNo1;
    }

    public void setLineNo1(String lineNo1) {
        this.lineNo1 = lineNo1;
    }

    public String getLineNo2() {
        return lineNo2;
    }

    public void setLineNo2(String lineNo2) {
        this.lineNo2 = lineNo2;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAddressType() {
        return addressType;
    }

    public void setAddressType(int addressType) {
        this.addressType = addressType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.controllers.Address[ id=" + id + " ]";
    }
    
}
