/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web.entityManager;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "role_master", catalog = "prm_erp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleMaster.findAll", query = "SELECT r FROM RoleMaster r")
    , @NamedQuery(name = "RoleMaster.findById", query = "SELECT r FROM RoleMaster r WHERE r.id = :id")
    , @NamedQuery(name = "RoleMaster.findByRoleName", query = "SELECT r FROM RoleMaster r WHERE r.roleName = :roleName")
    , @NamedQuery(name = "RoleMaster.findByRoleId", query = "SELECT r FROM RoleMaster r WHERE r.roleId = :roleId")
    , @NamedQuery(name = "RoleMaster.findByCreatedDate", query = "SELECT r FROM RoleMaster r WHERE r.createdDate = :createdDate")
    , @NamedQuery(name = "RoleMaster.findByUpdatedDate", query = "SELECT r FROM RoleMaster r WHERE r.updatedDate = :updatedDate")
    , @NamedQuery(name = "RoleMaster.findByIsActive", query = "SELECT r FROM RoleMaster r WHERE r.isActive = :isActive")})
public class RoleMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "role_name", nullable = false, length = 20)
    private String roleName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id", nullable = false)
    private int roleId;
    @Column(name = "created_date")
    private BigInteger createdDate;
    @Column(name = "updated_date")
    private BigInteger updatedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active", nullable = false)
    private short isActive;
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    @ManyToOne
    private UserMaster updatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne
    private UserMaster createdBy;

    public RoleMaster() {
    }

    public RoleMaster(Integer id) {
        this.id = id;
    }

    public RoleMaster(Integer id, String roleName, int roleId, short isActive) {
        this.id = id;
        this.roleName = roleName;
        this.roleId = roleId;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public BigInteger getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(BigInteger createdDate) {
        this.createdDate = createdDate;
    }

    public BigInteger getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(BigInteger updatedDate) {
        this.updatedDate = updatedDate;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public UserMaster getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserMaster updatedBy) {
        this.updatedBy = updatedBy;
    }

    public UserMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserMaster createdBy) {
        this.createdBy = createdBy;
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
        if (!(object instanceof RoleMaster)) {
            return false;
        }
        RoleMaster other = (RoleMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.entityManager.RoleMaster[ id=" + id + " ]";
    }
    
}
