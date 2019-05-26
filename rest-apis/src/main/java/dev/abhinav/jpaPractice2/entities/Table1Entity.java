package dev.abhinav.jpaPractice2.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * This is a child entity this time around, and hence the owner of the one to one unidirectional relationship. The navigation is from 
 * table1 to table 3 then
 * @author abhinav
 *
 */
@Getter
@Setter
@Entity
@Table(name="table1")
public class Table1Entity {
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;

@Column(name = "attribute1")
String attribute1;

@OneToOne(fetch = FetchType.EAGER)
@MapsId()
//@JoinColumn(name = "table3_id",referencedColumnName = "id")
Table3Entity table3;

}
