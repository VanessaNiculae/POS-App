/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.proiectlab.bean;

import com.proiectlab.entity.UserType;
import com.proiectlab.entity.Users;
import com.proiectlab.utility.Password;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


@Stateless
public class UserBean {

    @PersistenceContext
    private EntityManager entityManager;

    public void createUser(String username, String password, UserType userType) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        Users user = new Users();

        user.setUsername(username);

        String hashPassword = Password.convertToSha256(password);
        user.setPassword(hashPassword);

        if (userType.getType().equals("CASHIER")) {
            user.setIdUserType(getTypeByName("PENDING"));
        } else {
            user.setIdUserType(userType);
        }

        entityManager.persist(user);
    }

    public void updateUser(Users user, String newUsername, String newPassword, UserType newUserType) {
        if (!entityManager.contains(user)) {
            user = entityManager.merge(user);
        }
        if (newUsername != null) {
            user.setUsername(newUsername);
        }
        if (newPassword != null) {
            user.setPassword(newPassword);
        }
        if (newUserType != null) {
            user.setIdUserType(newUserType);
        }
    }

    public void deleteUsersByIds(Users user) {
        if (!entityManager.contains(user)) {
            user = entityManager.merge(user);
        }
        entityManager.remove(user);
    }

    public UserType getTypeByName(String type) {
        Query query = entityManager.createQuery("SELECT u FROM UserType u WHERE u.type = :type").setParameter("type", type).setMaxResults(1);
        UserType u = (UserType) query.getSingleResult();

        return u;
    }

    public List<Users> getAllUsers() {
        try {
            TypedQuery<Users> query = entityManager.createNamedQuery("Users.findAll", Users.class);
            List<Users> users = query.getResultList();
            return users;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public Users getByUsername(String username) {
        TypedQuery<Users> query = entityManager.createNamedQuery("Users.findByUsername", Users.class);
        query.setParameter("username", username);
        Users result = query.getSingleResult();

        return result;
    }

    public Users getById(int id) {
        TypedQuery<Users> query = entityManager.createNamedQuery("Users.findById", Users.class);
        query.setParameter("id", id);
        Users result = query.getSingleResult();

        return result;
    }

    public String getPasswordByUsername(String username) {
        Query query = entityManager.createQuery("SELECT u FROM Users u WHERE u.username = :username").setParameter("username", username).setMaxResults(1);
        Users user = (Users) query.getSingleResult();

        return user.getPassword();
    }

}
