package com.solveast.muleteer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solveast.muleteer.model.Muletrack;

public interface MuleTrackRepository extends JpaRepository<Muletrack, Integer> {

	Muletrack findById(int id);

	List<Muletrack> findByActiveTrue();
}
