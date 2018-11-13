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
@Table(name = "permission_master", catalog = "prm_erp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermissionMaster.findAll", query = "SELECT p FROM PermissionMaster p")
    , @NamedQuery(name = "PermissionMaster.findById", query = "SELECT p FROM PermissionMaster p WHERE p.id = :id")
    , @NamedQuery(name = "PermissionMaster.findByPermission", query = "SELECT p FROM PermissionMaster p WHERE p.permission = :permission")
    , @NamedQuery(name = "PermissionMaster.findByPermissionId", query = "SELECT p FROM PermissionMaster p WHERE p.permissionId = :permissionId")
    , @NamedQuery(name = "PermissionMaster.findByParentPermissionId", query = "SELECT p FROM PermissionMaster p WHERE p.parentPermissionId = :parentPermissionId")
    , @NamedQuery(name = "PermissionMaster.findByIsActive", query = "SELECT p FROM PermissionMaster p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PermissionMaster.findByOperationId", query = "SELECT p FROM PermissionMaster p WHERE p.operationId = :operationId")
    , @NamedQuery(name = "PermissionMaster.findByModules", query = "SELECT p FROM PermissionMaster p WHERE p.modules = :modules")
    , @NamedQuery(name = "PermissionMaster.findByCreatedDate", query = "SELECT p FROM PermissionMaster p WHERE p.createdDate = :createdDate")
    , @NamedQuery(name = "PermissionMaster.findByUpdatedDate", query = "SELECT p FROM PermissionMaster p WHERE p.updatedDate = :updatedDate")})
public class PermissionMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String permission;
    @Basic(optional = false)
    @NotNull
    @Column(name = "permission_id", nullable = false)
    private Integer permissionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parent_permission_id", nullable = false)
    private Integer parentPermissionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active", nullable = false)
    private short isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "operation_id", nullable = false)
    private Integer operationId;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer modules;
    @Column(name = "created_date")
    private Long createdDate;
    @Column(name = "updated_date")
    private Long updatedDate;
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    @ManyToOne
    private UserMaster updatedBy;

    public PermissionMaster() {
    }

    public PermissionMaster(Integer id) {
        this.id = id;
    }

    public PermissionMaster(Integer id, String permission, Integer permissionId, Integer parentPermissionId, short isActive, Integer operationId, Integer modules) {
        this.id = id;
        this.permission = permission;
        this.permissionId = permissionId;
        this.parentPermissionId = parentPermissionId;
        this.isActive = isActive;
        this.operationId = operationId;
        this.modules = modules;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getParentPermissionId() {
        return parentPermissionId;
    }

    public void setParentPermissionId(Integer parentPermissionId) {
        this.parentPermissionId = parentPermissionId;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public Integer getModules() {
        return modules;
    }

    public void setModules(Integer modules) {
        this.modules = modules;
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
        Integer hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermissionMaster)) {
            return false;
        }
        PermissionMaster other = (PermissionMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prm_erp_web.entityManager.PermissionMaster[ id=" + id + " ]";
    }
    
}
