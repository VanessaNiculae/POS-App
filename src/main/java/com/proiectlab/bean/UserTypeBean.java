
package com.proiectlab.bean;

import com.proiectlab.entity.TransactionType;
import com.proiectlab.entity.UserType;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class UserTypeBean {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserType> getAllTypes() {
        try {
            TypedQuery<UserType> query = entityManager.createNamedQuery("UserType.findAll", UserType.class);
            List<UserType> result = (List<UserType>) query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public UserType findById(Integer userTypeId) {
        return entityManager.find(UserType.class, userTypeId);
    }

    public UserType findByName(String userTypeName) {
    TypedQuery<UserType> query = entityManager.createNamedQuery("UserType.findByType", UserType.class);
        query.setParameter("type", userTypeName);
        UserType result = query.getSingleResult();

        return result;
}

    public void createUserType(String typeName) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        UserType type = new UserType();
        type.setType(typeName);

        entityManager.persist(type);
    }

    public void updateUserType(UserType type, String newUserTypeName) {
        if (!entityManager.contains(type)) {
            type = entityManager.merge(type);
        }
        type.setType(newUserTypeName);
    }

    public void deleteUserType(UserType type) {
        if (!entityManager.contains(type)) {
            type = entityManager.merge(type);
        }
        entityManager.remove(type);
    }

}
