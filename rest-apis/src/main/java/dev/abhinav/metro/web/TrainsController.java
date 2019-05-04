package dev.abhinav.metro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.metro.dao.TrainNotFoundException;
import dev.abhinav.metro.service.TrainService;
import dev.abhinav.web.MetaData;
import dev.abhinav.web.MetaDataCreateException;

@RestController
@RequestMapping("/metro")
public class TrainsController {
	@Autowired
	TrainService trainService;

	@GetMapping(path = "/{train_special_name}")
	public TrainDetailsResponse findByTrainSpecialName(@PathVariable(name = "train_special_name") String specialName)
			throws MetaDataCreateException, TrainNotFoundException {
		TrainDetailsResponse response = new TrainDetailsResponse();
		response.setMetaData(new MetaData());
		response.setData(trainService.findTrainByTrainSpecialName(specialName));
		return response;
	}
}
