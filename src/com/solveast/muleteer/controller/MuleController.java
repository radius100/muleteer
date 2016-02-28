package com.solveast.muleteer.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.GsonBuilder;
import com.solveast.muleteer.model.Muletrack;
import com.solveast.muleteer.service.LogService;
import com.solveast.muleteer.service.MuleTrackService;

@Controller
public class MuleController {

	@Autowired
	MuleTrackService muleTrackService;

	@Autowired
	LogService logService;

	@RequestMapping("/")
	public String goHome(final Model model) {
		model.addAttribute("mules", muleTrackService.getMules());
		return "index";
	}

	@RequestMapping(value = "/tracking/mule-{id}", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
	@ResponseBody
	public String getJsonCoordinates(@RequestBody final String json, @PathVariable final int id) {
		Muletrack muletrack = new Muletrack();

		final ObjectMapper mapper = new ObjectMapper();

		try {
			muletrack = mapper.readValue(json, Muletrack.class);
		} catch (final JsonParseException e) {
			e.printStackTrace();
			logService.add("JsonParseException when proccessing coordinates");
		} catch (final JsonMappingException e) {
			e.printStackTrace();
			logService.add("JsonMappingException when proccessing coordinates");
		} catch (final IOException e) {
			e.printStackTrace();
			logService.add("IOException when proccessing coordinates");
		}

		muletrack.setId(id);
		muletrack = muleTrackService.swapMuletrack(muletrack);

		logService.add(muletrack.toString());

		return new GsonBuilder()
				.disableHtmlEscaping()
				.excludeFieldsWithoutExposeAnnotation()
				.setPrettyPrinting()
				.serializeNulls()
				.create()
				.toJson(muletrack);
	}

	@RequestMapping(value = "/get-markers", produces = "application/json")
	@ResponseBody
	public String getMarkers() {
		return new GsonBuilder()
				.disableHtmlEscaping()
				.excludeFieldsWithoutExposeAnnotation()
				.setPrettyPrinting()
				.serializeNulls()
				.create()
				.toJson(muleTrackService.getMarkers());
	}

	@RequestMapping(value = "/get-mules", produces = "application/json")
	@ResponseBody
	public String getMules() {
		return new GsonBuilder()
				.disableHtmlEscaping()
				.excludeFieldsWithoutExposeAnnotation()
				.setPrettyPrinting()
				.serializeNulls()
				.create()
				.toJson(muleTrackService.getMules());
	}
}
