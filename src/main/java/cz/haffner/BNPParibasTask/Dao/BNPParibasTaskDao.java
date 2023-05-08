package cz.haffner.BNPParibasTask.Dao;

import cz.haffner.BNPParibasTask.Model.Customer;
import cz.haffner.BNPParibasTask.Model.Quotation;
import cz.haffner.BNPParibasTask.Model.Subscription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class BNPParibasTaskDao {

    private static Logger log = LogManager.getLogger(BNPParibasTaskDao.class);

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public void save(Quotation quotation) {
      log.info("Saving into DB: quotation=" + quotation.toString());
      entityManager.persist(quotation);
    }

    @Transactional
    public void save(Subscription subscription) {
      log.info("Saving into DB: subscription=" + subscription.toString());
      entityManager.persist(subscription);
    }

    @Transactional
    public Subscription get(String subscriptionId) {
      Subscription response = entityManager.find(Subscription.class, subscriptionId);
      log.info("Getting from DB: subscription=" + response.toString());
      return response;
    }

    @Transactional
    public void update(Customer customer) {
      log.info("Updating DB: customer=" + customer.toString());
      entityManager.merge(customer);
    }
}
