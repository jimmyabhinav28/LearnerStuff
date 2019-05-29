package dev.abhinav.jpaPractice1.entities;

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

    //bidirectional one to one


    //bidirectional one to one mapping
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @MapsId
    @JoinColumn(name = "table3_id", referencedColumnName = "id")
    Table3Entity table3;

}
