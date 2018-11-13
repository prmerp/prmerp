package com.prm_erp_web.interceptor;

import com.prm_erp_web.entityManager.UserMaster;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import prm_erp.utility.ListUtility;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private HibernateTemplate ht;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        List<UserMaster> userList = (List<UserMaster>) ht.findByNamedQuery("UserMaster.findByUserName", string);

        if (ListUtility.isNullOrEmpty(userList)) {
            throw new UsernameNotFoundException("User Name Not Found");
        } else {
            for (UserMaster userMaster : userList) {
                return new CustomUserDetails(userMaster);
            }
            throw new UsernameNotFoundException("User Name Not Found");
        }
    }

}
