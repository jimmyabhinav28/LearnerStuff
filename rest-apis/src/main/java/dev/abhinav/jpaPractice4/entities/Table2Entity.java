package dev.abhinav.jpaPractice4.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "table2")
public class Table2Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "attribute1")
    String attribute1;



    //bidirectional many to one mapping
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    Table3Entity table3;

}
