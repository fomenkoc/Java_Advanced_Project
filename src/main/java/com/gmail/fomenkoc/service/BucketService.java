package com.gmail.fomenkoc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.fomenkoc.dao.BucketRepository;
import com.gmail.fomenkoc.domain.Bucket;

@Service
public class BucketService {
	private Logger logger = LoggerFactory.getLogger(BucketService.class);

	@Autowired
	private BucketRepository bucketRepository;

	public List<Bucket> getAll() {
		logger.info("Get all bucket items");
		return bucketRepository.findAll();
	}

	public void delete(Bucket bucket) {
		logger.info("Delete bucket item {}: " + bucket);
		bucketRepository.delete(bucket);
	}

	public Bucket add(Bucket bucket) {
		logger.info("Create new bucket item {}: " + bucket);
		return bucketRepository.save(bucket);
	}
}
