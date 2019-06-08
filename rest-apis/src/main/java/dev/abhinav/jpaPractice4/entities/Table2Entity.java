package dev.abhinav.jpaPractice4.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

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
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "table2_table3", joinColumns = {
			@JoinColumn(name = "table2_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "table3_id", referencedColumnName = "id") })
    Set<Table3Entity> table3;

}
