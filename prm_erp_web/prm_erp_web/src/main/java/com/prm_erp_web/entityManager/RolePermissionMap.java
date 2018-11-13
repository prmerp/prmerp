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
@Table(name = "role_permission_map", catalog = "prm_erp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolePermissionMap.findAll", query = "SELECT r FROM RolePermissionMap r")
    , @NamedQuery(name = "RolePermissionMap.findById", query = "SELECT r FROM RolePermissionMap r WHERE r.id = :id")
    , @NamedQuery(name = "RolePermissionMap.findByRoleId", query = "SELECT r FROM RolePermissionMap r WHERE r.roleId = :roleId")
    , @NamedQuery(name = "RolePermissionMap.findByPermissionId", query = "SELECT r FROM RolePermissionMap r WHERE r.permissionId = :permissionId")
    , @NamedQuery(name = "RolePermissionMap.findByIsActive", query = "SELECT r FROM RolePermissionMap r WHERE r.isActive = :isActive")})
public class RolePermissionMap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "role_id", nullable = false, length = 45)
    private String roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "permission_id", nullable = false, length = 45)
    private String permissionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active", nullable = false)
    private short isActive;

    public RolePermissionMap() {
    }

    public RolePermissionMap(Integer id) {
        this.id = id;
    }

    public RolePermissionMap(Integer id, String roleId, String permissionId, short isActive) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
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
        if (!(object instanceof RolePermissionMap)) {
            return false;
        }
        RolePermissionMap other = (RolePermissionMap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.entityManager.RolePermissionMap[ id=" + id + " ]";
    }
    
}
