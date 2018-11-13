/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prm_erp_web.hibernateConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

@Configuration
public class HibernateConfigs {

    @Autowired
    private HibernateTemplate ht;

    @Bean
    public Session session() {
        SessionFactory sessionFactory = ht.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        return openSession;
    }

    /**
     * To Commit Transaction in database
     *
     * @param session
     * @return
     */
    public static Boolean commit(Session session) {
        session.getTransaction().commit();
        return Boolean.TRUE;
    }
}
