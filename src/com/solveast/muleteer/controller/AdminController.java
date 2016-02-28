package com.solveast.muleteer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.solveast.muleteer.service.LogService;
import com.solveast.muleteer.service.MuleTrackService;

@Controller
public class AdminController {

	@Autowired
	private MuleTrackService muleTrackService;

	@Autowired
	private LogService logService;

	@RequestMapping("/admin")
	public String admin(final Model model) {
		model.addAttribute("mules", muleTrackService.findAll());
		return "admin";
	}

	@RequestMapping(value = "/admin/mule-{id}", method = RequestMethod.POST)
	@ResponseBody
	public String adminUpdateNameAndActive(final String name, final String status, @PathVariable final int id) {
		muleTrackService.update(id, name, status);
		logService.add(Integer.toString(id) + " " + name + " " + status);
		return "ok";
	}

	@RequestMapping(value = "/admin/test/mule-{id}", method = RequestMethod.POST)
	@ResponseBody
	public String adminUpdateCoord(final Double lat, final Double lng, @PathVariable final int id) {
		muleTrackService.updateTestCoord(id, lat, lng);
		logService.add(Integer.toString(id) + " " + lat + " " + lng);
		return "ok";
	}

	@RequestMapping(value = "/admin/test")
	public String showAdminUpdateCoord(final Model model) {
		model.addAttribute("mules", muleTrackService.findAll());
		return "testmarkers";
	}
}
