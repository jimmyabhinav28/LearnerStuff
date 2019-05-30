package dev.abhinav.jpaPractice3.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * This is a child entity this time around, and hence the owner of the one to one unidirectional relationship. The navigation is from 
 * table1 to table 3 then
 * @author abhinav
 *
 */
@Getter
@Setter
@Entity
@Slf4j
@Table(name="table1")
public class Table1Entity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;

@Column(name = "attribute1")
String attribute1;

@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
@JoinColumn(name = "table3_id",referencedColumnName = "id")
Table3Entity table3;

}
