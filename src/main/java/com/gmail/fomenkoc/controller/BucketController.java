package com.gmail.fomenkoc.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gmail.fomenkoc.domain.Bucket;
import com.gmail.fomenkoc.domain.Periodical;
import com.gmail.fomenkoc.domain.User;
import com.gmail.fomenkoc.service.BucketService;
import com.gmail.fomenkoc.service.PeriodicalsService;
import com.gmail.fomenkoc.service.UserService;

@Controller
public class BucketController {

	@Autowired
	private BucketService bucketService;

	@Autowired
	private UserService userService;

	@Autowired
	private PeriodicalsService periodicalsService;

	@RequestMapping(value = "/buckets", method = RequestMethod.GET)
	public ModelAndView getAllItems() {
		return getBucketItems();
	}

	@RequestMapping(value = "/bucket", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam String periodicalId) {
		Periodical periodical = periodicalsService.findById(Integer.parseInt(periodicalId));

		Bucket bucket = new Bucket();
		bucket.setPeriodical(periodical);
		bucket.setPurchaseDate(new Date());

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findByEmail(userEmail);
		bucket.setUser(user);

		bucketService.add(bucket);
		return getBucketItems();
	}

	@RequestMapping(value = "/bucket", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam String id) {
		bucketService.delete(new Bucket(Integer.parseInt(id.replaceAll("\\s",""))));
		return getBucketItems();
	}

	private ModelAndView getBucketItems() {
		ModelAndView map = new ModelAndView("bucket");
		map.addObject("bucketItems", bucketService.getAll());
		return map;
	}

}