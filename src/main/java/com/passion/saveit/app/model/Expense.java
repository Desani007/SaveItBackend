package com.passion.saveit.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    private  String description;
    private Instant datePurchased;
    private String location;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;




}
