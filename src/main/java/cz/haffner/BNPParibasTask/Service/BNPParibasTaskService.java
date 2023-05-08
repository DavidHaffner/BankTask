package cz.haffner.BNPParibasTask.Service;

import cz.haffner.BNPParibasTask.Dao.BNPParibasTaskDao;
import cz.haffner.BNPParibasTask.Model.Customer;
import cz.haffner.BNPParibasTask.Model.Quotation;
import cz.haffner.BNPParibasTask.Model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BNPParibasTaskService {

    @Autowired
    BNPParibasTaskDao dao;


    public void saveQuotation(Quotation quotation) {
      dao.save(quotation);
    }

    public void saveSubscription(Subscription subscription) {
        dao.save(subscription);
    }

    public Subscription getSubscription(String subscriptionId) {
      return dao.get(subscriptionId);
    }

    public void updateCustomer(Customer customer) {
      dao.update(customer);
    }
}
