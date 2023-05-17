package cz.haffner.BNPParibasTask.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="quotation")
public class Quotation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="quotation_id")
    private UUID quotationId;

    @Column(name="beginning_of_insurance")
    private Date beginningOfInsurance;

    @Column(name="insured_amount")
    private int insuredAmount;

    @Column(name="date_of_signing_mortgage")
    private Date dateOfSigningMortgage;

    @JoinColumn(name="customer_id")
    @ManyToOne
    private Customer customer;


    @Override
    public String toString() {
        return "[quotationId=" + this.quotationId
                + ", beginningOfInsurance=" + this.beginningOfInsurance
                + ", insuredAmount=" + this.insuredAmount
                + ", dateOfSigningMortgage=" + this.dateOfSigningMortgage
                + ", customer=" + (this.customer == null ? "null" : this.customer.toString())
                + "]";
    }
}
