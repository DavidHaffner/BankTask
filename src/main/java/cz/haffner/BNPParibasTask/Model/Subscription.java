package cz.haffner.BNPParibasTask.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="subscription_id")
    private Long subscriptionId;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="valid_until")
    private Date validUntil;

    @OneToOne
    @JoinColumn(name="quotation_id")
    private Quotation quotation;


    @Override
    public String toString() {
        return "[subscriptionId=" + this.subscriptionId
                + ", startDate=" + this.startDate
                + ", validUntil=" + this.validUntil
                + ", quotation=" + (this.quotation == null ? "null" : this.quotation.toString())
                + "]";
    }
}
