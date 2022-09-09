package com.example.airline_api_lab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


    @Entity(name="passengers")
    public class Passenger {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private long id;

        @Column(name="name")
        private String name;

        @Column(name="emailAddress")
        private String emailAddress;


        @ManyToMany
        @JoinTable(
                name = "flights_passengers",
                joinColumns = {@JoinColumn(name = "passenger_id", nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "flight_id", nullable = false)}
        )
        @JsonIgnoreProperties({"passengers"})
        private List<Flight> flights;





}
