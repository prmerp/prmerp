package prm_erp.proxy;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import java.io.Serializable;
import javafx.scene.control.CheckBox;

/**
 *
 * @author PDP_Shiva
 */
@JsonSerialize(include = Inclusion.NON_NULL)
public class PersonProxy implements Serializable {

    private Long id;
    private String salutation;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String updateByName;
    private Long birthDate;
    private Boolean isUserCreate;
    private String isUserCreateStr;
    private Boolean isActive;
    private String isActiveStr;
    private String description;
    private Long createdDate;
    private Long updatedDate;
    private Long createdBy;
    private Long updatedBy;
    private String logoPath;
    private String[] docPath;
    private String[] contactNo;
//    private CheckBox select;

    public PersonProxy() {
//        select = new CheckBox();
    }

    public PersonProxy(Long id, String fullName, Long birthDate, Boolean isActive, String updateByName, Boolean isUserCreate, Long updatedDate) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.isActive = isActive;
        this.updateByName = updateByName;
        this.isUserCreate = isUserCreate;
        this.updatedDate = updatedDate;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the birthDate
     */
    public Long getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the isUserCreate
     */
    public Boolean getIsUserCreate() {
        return isUserCreate;
    }

    /**
     * @param isUserCreate the isUserCreate to set
     */
    public void setIsUserCreate(Boolean isUserCreate) {
        this.isUserCreate = isUserCreate;
        this.isUserCreateStr = null == isUserCreate ? "Is not created" : isUserCreate ? "Is created" : "Is not created";

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
        this.isActiveStr = null == isActive ? "Disabled" : isActive ? "Enabled" : "Disabled";
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the createdDate
     */
    public Long getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the updatedDate
     */
    public Long getUpdatedDate() {
        return updatedDate;
    }

    /**
     * @param updatedDate the updatedDate to set
     */
    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * @return the createdBy
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the updatedBy
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @return the contactNo
     */
    public String[] getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(String[] contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * @return the logoPath
     */
    public String getLogoPath() {
        return logoPath;
    }

    /**
     * @param logoPath the logoPath to set
     */
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    /**
     * @return the docPath
     */
    public String[] getDocPath() {
        return docPath;
    }

    /**
     * @param docPath the docPath to set
     */
    public void setDocPath(String[] docPath) {
        this.docPath = docPath;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the updateByName
     */
    public String getUpdateByName() {
        return updateByName;
    }

    /**
     * @param updateByName the updateByName to set
     */
    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
    }

//    /**
//     * @return the select
//     */
//    public CheckBox getSelect() {
//        return select;
//    }
//
//    /**
//     * @param select the select to set
//     */
//    public void setSelect(CheckBox select) {
//        this.select = select;
//    }
    /**
     * @return the isActiveStr
     */
    public String getIsActiveStr() {
        return isActiveStr;
    }

    /**
     * @param isActiveStr the isActiveStr to set
     */
    public void setIsActiveStr(String isActiveStr) {
        this.isActiveStr = isActiveStr;
    }

    /**
     * @return the isUserCreateStr
     */
    public String getIsUserCreateStr() {
        return isUserCreateStr;
    }

    /**
     * @param isUserCreateStr the isUserCreateStr to set
     */
    public void setIsUserCreateStr(String isUserCreateStr) {
        this.isUserCreateStr = isUserCreateStr;
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
