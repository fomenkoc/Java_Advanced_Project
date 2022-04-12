package com.gmail.fomenkoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.fomenkoc.domain.Bucket;

public interface BucketRepository extends JpaRepository<Bucket, Integer> {

}
