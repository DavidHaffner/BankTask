package cz.haffner.BNPParibasTask.REST;

import cz.haffner.BNPParibasTask.Model.Customer;
import cz.haffner.BNPParibasTask.Model.Quotation;
import cz.haffner.BNPParibasTask.Model.Subscription;
import cz.haffner.BNPParibasTask.Service.BNPParibasTaskService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-service")
public class TaskRESTController {

    private static Logger log = LogManager.getLogger(TaskRESTController.class);

    @Autowired
    BNPParibasTaskService service;


    @PutMapping(value="/update-customer")
    @ResponseStatus(HttpStatus.OK)
    public String updateCustomer(@RequestBody Customer customer) {
        log.info("PUT /update-customer: customer=" + customer.toString());
        service.updateCustomer(customer);
        return "Customer updated.";
    }

    @PostMapping(value="/create-quotation")
    @ResponseStatus(HttpStatus.CREATED)
    public String createQuotation(@RequestBody Quotation quotation) {
      log.info("POST /create-quotation: quotation=" + quotation.toString());
      service.saveQuotation(quotation);
      return "Quotation created.";
    }

    @PostMapping(value="/create-subscription")
    @ResponseStatus(HttpStatus.CREATED)
    public String createSubscription(@RequestBody Subscription subscription) {
      log.info("POST /create-subscription: subscription=" + subscription.toString());
      service.saveSubscription(subscription);
      return "Subscription created.";
    }

    @GetMapping(value="/get-subscription", produces="application/json")
    @ResponseStatus(HttpStatus.OK)
    public Subscription getSubscription(@RequestHeader("SubscriptionID") String id) {
      log.info("GET /get-subscription: subscriptionId=" + id);
      return service.getSubscription(id);
    }
}
