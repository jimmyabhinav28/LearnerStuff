package dev.abhinav.metro.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "train")
@Getter
@Setter
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;

	@Column(name = "number_of_coaches")
	Integer numberOfCoaches;

	@Column(name = "special_name")
	String specialName;

	@Column(name = "service_begin_date")
	Date serviceBeginDate;

	@Column(name = "last_maintainance_date")
	Date lastMaintainanceDate;

	@Column(name = "vendor_name")
	String vendorName;
}
