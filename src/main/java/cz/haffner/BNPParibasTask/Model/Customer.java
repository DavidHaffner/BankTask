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
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long customerId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="birth_date")
    private Date birthDate;


    @Override
    public String toString() {
      return "[customerId=" + this.customerId
      + ", firstName=" + this.firstName
      + ", lastName=" + this.lastName
      + ", middleName=" + this.middleName
      + ", email=" + this.email
      + ", phoneNumber=" + this.phoneNumber
      + ", birthDate=" + this.birthDate
      + "]";
    }
}
