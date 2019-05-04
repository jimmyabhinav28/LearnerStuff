package dev.abhinav.metro.dao;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.abhinav.metro.entities.Train;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TrainDAO {

	@Autowired
	TrainRepository trainRepository;

	public Train findTrainBySpecialName(String specialName) throws TrainNotFoundException {
		List<Train> trains = null;
		try {
			trains = trainRepository.findBySpecialName(specialName);
			if (trains == null || trains.isEmpty())
			// throw new TrainNotFoundException("train with special name " + specialName + "
			// not found");
			{
				log.info("train with special name " + specialName + " not found");
				return null;
			}
		} catch (Exception e) {
			String message = "some error occured while finding train";
			log.error(message, e);
			throw new TrainNotFoundException(message, e);
		}
		return trains.get(0);
	}

	public Train findTrainByServiceBeginDate(Date serviceBeginDate) throws TrainNotFoundException {
		List<Train> trains = null;

//		Date dateWithoutTimePart=serviceBeginDate.toGMTString()
		java.sql.Date dateWithoutTimePart = new java.sql.Date(serviceBeginDate.getTime());
		try {
			trains = trainRepository.findByServiceBeginDate(dateWithoutTimePart);
			if (trains == null || trains.isEmpty())
			// throw new TrainNotFoundException("train with special name " + specialName + "
			// not found");
			{
				log.info("No train with service begin date as  " + serviceBeginDate.toString() + " exists");
				return null;
			}
		} catch (Exception e) {
			String message = "some error occured while finding train";
			log.error(message, e);
			throw new TrainNotFoundException(message, e);
		}
		return trains.get(0);

	}

	public Train findTrainByVendor(String vendorName) throws TrainNotFoundException {
		List<Train> trains = null;
		try {
			trains = trainRepository.findByVendorName(vendorName);
			if (trains == null || trains.isEmpty())
			// throw new TrainNotFoundException("train with special name " + specialName + "
			// not found");
			{
				log.info("No train from " + vendorName + " exists");
				return null;
			}
		} catch (Exception e) {
			String message = "some error occured while finding train";
			log.error(message, e);
			throw new TrainNotFoundException(message, e);
		}
		return trains.get(0);

}
}