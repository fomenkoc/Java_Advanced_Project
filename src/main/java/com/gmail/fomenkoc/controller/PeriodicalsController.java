package com.gmail.fomenkoc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gmail.fomenkoc.service.PeriodicalsDTOHelper;
import com.gmail.fomenkoc.service.PeriodicalsService;

@Controller
public class PeriodicalsController {

	@Autowired
	PeriodicalsService periodicalsService;

	@RequestMapping(value = "/addPeriodical", method = RequestMethod.POST)
	public ModelAndView createPeriodical(
								@RequestParam MultipartFile image,
								@RequestParam String name, 
								@RequestParam String description,
								@RequestParam Double price) throws IOException {
		
		periodicalsService.save(PeriodicalsDTOHelper.
								createEnity(image, name, description, price));
		
		return new ModelAndView("redirect:/home");
	}

}