/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.proiectlab.bean;

import com.proiectlab.utility.ParseDateTimeValue;
import com.proiectlab.entity.Product;
import com.proiectlab.entity.TransactionType;
import com.proiectlab.entity.Transactions;
import com.proiectlab.entity.Users;
import static com.proiectlab.utility.ParseDateTimeValue.roundToTwoDecimals;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class TransactionBean {

    @PersistenceContext
    EntityManager entityManager;

    
    public List<Transactions> getAllTransactions() {
        try {
            TypedQuery<Transactions> query = entityManager.createNamedQuery("Transactions.findAll", Transactions.class);
            List<Transactions> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<Transactions> getTransactionsBetweenDates(String dateFrom, String dateTo) {
        try {
            Query query = entityManager.createQuery("SELECT t FROM Transactions t WHERE t.transactionDate BETWEEN '" + ParseDateTimeValue.parseTimestamp(dateFrom) + "' AND '" + ParseDateTimeValue.parseTimestamp(dateTo) + "'");
            List<Transactions> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<Transactions> getTransactionsBetweenValues(double valueFrom, double valueTo) {
        try {
            Query query = entityManager.createQuery("SELECT t FROM Transactions t WHERE t.value BETWEEN " + valueFrom + " AND " + valueTo);
            List<Transactions> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public Transactions findById(Integer transactionId) {
        Transactions transaction = entityManager.find(Transactions.class, transactionId);
        return transaction;
    }

    public Transactions createTransaction(java.sql.Date transactionDate, TransactionType type, Users user) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        Transactions transaction = new Transactions();
        transaction.setTransactionDate(transactionDate);

        transaction.setIdType(type);
        transaction.setIdCashier(user);

        entityManager.persist(transaction);
        return transaction;
    }

    public void calculateTotalValue(Transactions transaction, List<Product> products){
        Double sum = roundToTwoDecimals(products.stream().mapToDouble(x -> x.getPrice()).sum());
        
        if (!entityManager.contains(transaction)) {
            transaction = entityManager.merge(transaction);
        }
        
        if (transaction.getIdType().getType().equals("Return")) {
            sum = -sum;
        }
        
        transaction.setValue(sum);
    }

    public void deleteTransaction(Transactions transaction) {
        if (!entityManager.contains(transaction)) {
            transaction = entityManager.merge(transaction);
        }
        entityManager.remove(transaction);
    }
}
