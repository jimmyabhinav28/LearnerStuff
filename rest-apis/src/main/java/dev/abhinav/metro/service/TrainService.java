package dev.abhinav.metro.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.abhinav.metro.dao.TrainDAO;
import dev.abhinav.metro.dao.TrainNotFoundException;
import dev.abhinav.metro.dto.TrainDTO;

@Service
public class TrainService {

	@Autowired
	TrainDAO trainDAO;
	
	public TrainDTO findTrainByTrainSpecialName(String specialName) throws Exception
	{
		return new TrainDTO(trainDAO.findTrainBySpecialName(specialName));
	}
	
	public TrainDTO findTrainByVendor(String vendorName) throws Exception
	{
		return new TrainDTO(trainDAO.findTrainByVendor(vendorName));
	}
	
	public TrainDTO findTrainByServiceBeginDate(Date beginDate) throws Exception
	{
		return new TrainDTO(trainDAO.findTrainByServiceBeginDate(beginDate));
	}
}
