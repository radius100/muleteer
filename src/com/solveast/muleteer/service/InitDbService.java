package com.solveast.muleteer.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solveast.muleteer.model.Muletrack;
import com.solveast.muleteer.repositories.MuleTrackRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private MuleTrackRepository muleTrackRepository;

	@PostConstruct
	public void init() {

		final Muletrack muletrack1 = new Muletrack();
		muletrack1.setId(0);
		muletrack1.setName("Truck I");
		muletrack1.setActive(false);
		System.out.println(muleTrackRepository.saveAndFlush(muletrack1));
		// muleTrackRepository.saveAndFlush(muletrack1);

		final Muletrack muletrack2 = new Muletrack();
		muletrack2.setId(1);
		muletrack2.setName("Truck II");
		muletrack2.setActive(false);
		System.out.println(muleTrackRepository.saveAndFlush(muletrack2));
		// muleTrackRepository.saveAndFlush(muletrack2);

		final Muletrack muletrack3 = new Muletrack();
		muletrack3.setId(2);
		muletrack3.setName("Truck III");
		muletrack3.setActive(false);
		System.out.println(muleTrackRepository.saveAndFlush(muletrack3));
		// muleTrackRepository.saveAndFlush(muletrack3);

		final Muletrack muletrack4 = new Muletrack();
		muletrack4.setId(3);
		muletrack4.setName("Truck IV");
		muletrack4.setActive(false);
		System.out.println(muleTrackRepository.saveAndFlush(muletrack4));
		// muleTrackRepository.saveAndFlush(muletrack4);

		final Muletrack muletrack5 = new Muletrack();
		muletrack5.setId(4);
		muletrack5.setName("Truck V");
		muletrack5.setActive(false);
		System.out.println(muleTrackRepository.saveAndFlush(muletrack5));
		// muleTrackRepository.saveAndFlush(muletrack5);

		final Muletrack muletrack6 = new Muletrack();
		muletrack6.setId(5);
		muletrack6.setName("Truck VI");
		muletrack6.setActive(false);
		System.out.println(muleTrackRepository.saveAndFlush(muletrack6));
		// muleTrackRepository.saveAndFlush(muletrack6);

		final Muletrack muletrack7 = new Muletrack();
		muletrack7.setId(6);
		muletrack7.setName("Truck VII");
		muletrack7.setActive(false);
		System.out.println(muleTrackRepository.saveAndFlush(muletrack7));
		// muleTrackRepository.saveAndFlush(muletrack7);

		final Muletrack muletrack8 = new Muletrack();
		muletrack8.setId(7);
		muletrack8.setName("Truck VIII");
		muletrack8.setActive(false);
		System.out.println(muleTrackRepository.saveAndFlush(muletrack8));
		// muleTrackRepository.saveAndFlush(muletrack8);

		final Muletrack muletrack9 = new Muletrack();
		muletrack9.setId(8);
		muletrack9.setName("Truck IX");
		muletrack9.setActive(false);
		System.out.println(muleTrackRepository.saveAndFlush(muletrack9));
		// muleTrackRepository.saveAndFlush(muletrack9);

		final Muletrack muletrack10 = new Muletrack();
		muletrack10.setId(9);
		muletrack10.setName("Truck X");
		muletrack10.setActive(false);
		System.out.println(muleTrackRepository.saveAndFlush(muletrack10));
		// muleTrackRepository.saveAndFlush(muletrack10);

		muleTrackRepository.flush();
	}
}
