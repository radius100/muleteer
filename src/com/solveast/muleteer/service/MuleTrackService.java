package com.solveast.muleteer.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solveast.muleteer.model.Muletrack;
import com.solveast.muleteer.repositories.LogRepository;
import com.solveast.muleteer.repositories.MuleTrackRepository;

@Transactional
@Service
public class MuleTrackService {

	@Autowired
	MuleTrackRepository muleTrackRepository;

	@Autowired
	LogRepository loggsRepository;

	public List<Muletrack> getMarkers() {
		return muleTrackRepository.findByActiveTrue();
	}

	public Map<Integer, String> getMules() {
		final List<Muletrack> muletracks = muleTrackRepository.findAll();
		final Map<Integer, String> map = new HashMap<Integer, String>();

		for (final Muletrack muletrack : muletracks)
			if (muletrack.isActive())
				map.put(muletrack.getId(), muletrack.getName());

		return map;
	}

	public Muletrack swapMuletrack(final Muletrack muletrack) {
		final Muletrack mtmp = muleTrackRepository.findOne(muletrack.getId());
		muletrack.setName(mtmp.getName());
		muleTrackRepository.saveAndFlush(muletrack);
		return muletrack;
	}

	public Muletrack findByMuleId(final int id) {
		return muleTrackRepository.findById(id);
	}

	public List<Muletrack> findAll() {
		return muleTrackRepository.findAll();
	}

	public void update(final int id, final String name, final String status) {
		final Muletrack muletrack = muleTrackRepository.findById(id);
		muletrack.setName(name);
		if (status.equals("active"))
			muletrack.setActive(true);
		else
			muletrack.setActive(false);

		muleTrackRepository.saveAndFlush(muletrack);
	}

	public void updateTestCoord(final int id, final Double lat, final Double lng) {
		final Muletrack muletrack = muleTrackRepository.findById(id);

		muletrack.setLat(lat);
		muletrack.setLng(lng);
		muletrack.setDate(new Date());
		muleTrackRepository.saveAndFlush(muletrack);
	}
}
