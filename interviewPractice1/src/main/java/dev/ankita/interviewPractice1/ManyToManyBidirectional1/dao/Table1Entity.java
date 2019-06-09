package dev.ankita.interviewPractice1.ManyToManyBidirectional1.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This is a child entity this time around, and hence the owner of the one to
 * one unidirectional relationship. The navigation is from table1 to table 3
 * then
 * 
 * @author abhinav
 *
 */
@Getter
@Setter
@Entity
@Slf4j
@Table(name = "table1")
public class Table1Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "attribute1")
	String attribute1;

	// arbitrarily making table1 as the owner of the relationship
//	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "table1_table3", joinColumns = {
			@JoinColumn(name = "table1_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "table3_id", referencedColumnName = "id") })
	Set<Table3Entity> table3;

}
