package com.decapitator;

import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ExampleEJB {
        @PersistenceContext(unitName = "examplePU")
        private EntityManager entityManager;

        public boolean checkPassword(String login, String password){
            if (StringUtils.isEmpty(login)||StringUtils.isEmpty(password)){
                return false;
            }
            UserEntity userEntity = entityManager.find(UserEntity.class, login);
            if (userEntity==null){

            }
            if (password.equals(userEntity.getPassword())) {
                return true;
            }
            return false;
        }

}
