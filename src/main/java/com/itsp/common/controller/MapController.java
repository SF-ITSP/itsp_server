package com.itsp.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itsp.common.entity.MapRoute;
import com.itsp.common.util.MapRouteRequestServer;

@Controller
@RequestMapping("/map")
public class MapController {

	@RequestMapping(value = "/{x1}/{y1}/{x2}/{y2}")
	public MapRoute routeMessager(@PathVariable("x1") Float x1,
			@PathVariable("y1") Float y1, @PathVariable("x2") Float x2,
			@PathVariable("y2") Float y2) {
		return (new MapRouteRequestServer()).request(x1, y1, x2, y2);
	}

}
