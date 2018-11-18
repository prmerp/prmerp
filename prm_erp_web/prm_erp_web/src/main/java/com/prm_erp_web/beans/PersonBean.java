/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web.beans;

import com.prm_erp_web.entityManager.ContactNumbers;
import com.prm_erp_web.entityManager.DocsManager;
import com.prm_erp_web.entityManager.LogoMaster;
import com.prm_erp_web.entityManager.Person;
import com.prm_erp_web.entityManager.PersonContactMap;
import com.prm_erp_web.entityManager.PersonDocsMap;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import prm_erp.proxy.PersonProxy;
import prm_erp.utility.Constants;
import prm_erp.utility.ListUtility;
import prm_erp.utility.StringUtility;

/**
 *
 * @author PDP_Shiva
 */
@Component
@Transactional
@Repository
public class PersonBean {

    @Autowired
    private Session session;

    public void fillPersonMasterByPersonProfile(PersonProxy personProxy, Person person) {

        Boolean isUserCreate = personProxy.getIsUserCreate();
        Boolean isActive = personProxy.getIsActive();
        String firstName = personProxy.getFirstName();
        String lastName = personProxy.getLastName();
        String description = personProxy.getDescription();
        Long birthDate = personProxy.getBirthDate();
        String salutation = personProxy.getSalutation();
        String email = personProxy.getEmail();

        isUserCreate = null == isUserCreate ? Boolean.FALSE : isUserCreate;
        isActive = null == isActive ? Boolean.FALSE : isActive;
        firstName = StringUtility.isNullOrEmpty(firstName) ? null : firstName;
        lastName = StringUtility.isNullOrEmpty(lastName) ? null : lastName;
        description = StringUtility.isNullOrEmpty(description) ? null : description;
        birthDate = null == birthDate ? null : birthDate;
        salutation = StringUtility.isNullOrEmpty(salutation) ? null : salutation;
        email = StringUtility.isNullOrEmpty(email) ? null : email;

        person.setBirthDate(birthDate);
        person.setDescription(description);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setIsActive(isActive);
        person.setIsUserCreate(isUserCreate);
        person.setSalutation(salutation);
        person.setEmail(email);
        person.setCreatedDate(System.currentTimeMillis());
        person.setUpdatedDate(System.currentTimeMillis());
//        person = (Person) UserDataUtility.setUserDataForUpdate(person);

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public PersonProxy save(PersonProxy personProxy) {
        Person person = new Person();
        fillPersonMasterByPersonProfile(personProxy, person);

        String logoPath = personProxy.getLogoPath();
        if (null != logoPath) {
            LogoMaster logoMaster = new LogoMaster(logoPath, Constants.Modules.PERSON);
            session.save(logoMaster);
            person.setLogoId(logoMaster);
        }

        session.save(person);

        String[] docPath = personProxy.getDocPath();

        List<PersonDocsMap> docsMaps = new ArrayList<>();
        if (null != docPath) {
            for (String string : docPath) {

                if (!StringUtility.isNullOrEmpty(string)) {
                    DocsManager docsManager = new DocsManager(string, logoPath, true);
                    session.save(docsManager);
                    PersonDocsMap personDocsMap = new PersonDocsMap(docsManager, person, true);
                    session.save(personDocsMap);
                    docsMaps.add(personDocsMap);
                }
            }
        }
        person.setPersonDocsMapCollection(ListUtility.isNullOrEmpty(docsMaps) ? null : docsMaps);

        String[] contactNo = personProxy.getContactNo();
        List<PersonContactMap> personContactMaps = new ArrayList<>();

        if (null != contactNo) {
            for (String string : contactNo) {
                if (!StringUtility.isNullOrEmpty(string)) {
                    ContactNumbers contactNumbers = new ContactNumbers(string, Constants.Modules.PERSON);
                    session.save(contactNumbers);
                    PersonContactMap personContactMap = new PersonContactMap(person, contactNumbers, true);
                    session.save(personContactMap);
                    personContactMaps.add(personContactMap);
                }
            }
        }
        person.setPersonContactMapCollection(ListUtility.isNullOrEmpty(personContactMaps) ? null : personContactMaps);

        personProxy.setId(person.getId());
        return personProxy;
    }

    public List<PersonProxy> getList() {
        List<PersonProxy> findByNamedQuery = session.createQuery("SELECT new prm_erp.proxy.PersonProxy(P.id,CONCAT(P.salutation,' ',P.firstName, ' ',P.lastName),P.birthDate,P.isActive,CONCAT(person.salutation,' ',person.firstName, ' ',person.lastName),P.isUserCreate,P.updatedDate) FROM Person P LEFT JOIN P.updatedBy updateBy LEFT JOIN updateBy.personId person", PersonProxy.class).getResultList();
        return findByNamedQuery;
    }
}
