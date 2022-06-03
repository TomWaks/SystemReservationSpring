package com.tomwaks.systemreservation.model;

import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import java.util.concurrent.TimeUnit;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter

@Table(name = "reservations")
@NamedEntityGraph(
        name = "reservation-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("rentalFrom"),
                @NamedAttributeNode("rentalTo"),
                @NamedAttributeNode("totalCost"),
                @NamedAttributeNode("host"),
                @NamedAttributeNode("tenant"),
                @NamedAttributeNode("flat")
        }
)
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="rental_from")
    private Date rentalFrom;

    @Column(name="rental_to")
    private Date rentalTo;

    @Column(name="total_cost")
    private float totalCost;

    @ManyToOne()
    @JoinColumn(name = "host_id", updatable = true, insertable = true)
    private Person host;

    @ManyToOne()
    @JoinColumn(name = "tenant_id", updatable = true, insertable = true)
    private Person tenant;

    @ManyToOne()
    @JoinColumn(name = "flat_id", updatable = true, insertable = true)
    private Flat flat;


    public void setTotalCost(){
        this.totalCost = TimeUnit.MILLISECONDS.toDays(rentalTo.getTime() - rentalFrom.getTime())* flat.getPrice();
    }


    public static final class ReservationBuilder {
        private Long id;
        private Date rentalFrom;
        private Date rentalTo;
        private float totalCost;
        private Person host;
        private Person tenant;
        private Flat flat;

        private ReservationBuilder() {
        }

        public static ReservationBuilder aReservation() {
            return new ReservationBuilder();
        }

        public ReservationBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ReservationBuilder withRentalFrom(Date rentalFrom) {
            this.rentalFrom = rentalFrom;
            return this;
        }

        public ReservationBuilder withRentalTo(Date rentalTo) {
            this.rentalTo = rentalTo;
            return this;
        }

        public ReservationBuilder withTotalCost(float totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public ReservationBuilder withHost(Person host) {
            this.host = host;
            return this;
        }

        public ReservationBuilder withTenant(Person tenant) {
            this.tenant = tenant;
            return this;
        }

        public ReservationBuilder withFlat(Flat flat) {
            this.flat = flat;
            return this;
        }

        public Reservation build() {
            return new Reservation(id, rentalFrom, rentalTo, totalCost, host, tenant, flat);
        }
    }
}
