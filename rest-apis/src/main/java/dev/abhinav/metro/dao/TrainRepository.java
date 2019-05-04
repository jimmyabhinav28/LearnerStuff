package dev.abhinav.metro.dao;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.abhinav.metro.entities.Train;

public interface TrainRepository extends JpaRepository<Train, Long>{

	List<Train> findBySpecialName(String specialName);
	List<Train> findByVendorName(String vendorName);
	List<Train> findByServiceBeginDate(Date serviceBeginDate);
}