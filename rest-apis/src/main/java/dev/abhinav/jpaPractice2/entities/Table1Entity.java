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
import lombok.extern.slf4j.Slf4j;

/**
 * This is a child entity this time around, and hence the owner of the one to one unidirectional relationship. The navigation is from 
 * table1 to table 3 then
 * @author abhinav
 *
 */
//@Getter
//@Setter
@Entity
@Slf4j
@Table(name="table1")
public class Table1Entity {
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;

@Column(name = "attribute1")
String attribute1;

@OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
@MapsId()
//@JoinColumn(name = "table3_id",referencedColumnName = "id")
Table3Entity table3;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getAttribute1() {
	return attribute1;
}

public void setAttribute1(String attribute1) {
	this.attribute1 = attribute1;
}

public Table3Entity getTable3() {
	return table3;
}

public void setTable3(Table3Entity table3) {
	this.table3 = table3;
}

}
