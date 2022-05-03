package com.gmail.fomenkoc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.fomenkoc.dao.PeriodicalRepository;
import com.gmail.fomenkoc.domain.Periodical;

@Service
public class PeriodicalsService {
	private Logger logger = LoggerFactory.getLogger(PeriodicalsService.class);

	@Autowired
	private PeriodicalRepository periodicalRepository;

	public Periodical save(Periodical periodical) {
		logger.info("Create new periodical {}: " + periodical);
		return periodicalRepository.save(periodical);
	}

	public List<Periodical> getAllPeriodicals() {
		logger.info("Get all periodicals");
		return periodicalRepository.findAll();
	}

	public Periodical findById(Integer id) {
		logger.info("Create new periodical by id: " + id);
		return periodicalRepository.findById(id).get();
	}

}
