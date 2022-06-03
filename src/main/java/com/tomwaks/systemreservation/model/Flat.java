package com.tomwaks.systemreservation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "flats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private float area;

    private String description;


    public static final class FlatBuilder {
        private long id;
        private String name;
        private int price;
        private float area;
        private String description;

        private FlatBuilder() {
        }

        public static FlatBuilder aFlat() {
            return new FlatBuilder();
        }

        public FlatBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public FlatBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FlatBuilder withPrice(int price) {
            this.price = price;
            return this;
        }

        public FlatBuilder withArea(float area) {
            this.area = area;
            return this;
        }

        public FlatBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Flat build() {
            return new Flat(id, name, price, area, description);
        }
    }
}
