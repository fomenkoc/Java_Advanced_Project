package com.gmail.fomenkoc.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.fomenkoc.domain.Periodical;

public interface PeriodicalRepository extends JpaRepository<Periodical, Integer>{
	public Optional<Periodical> findByName(String name);
}
