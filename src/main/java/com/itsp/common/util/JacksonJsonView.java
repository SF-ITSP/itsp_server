package com.itsp.common.util;

import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class JacksonJsonView extends MappingJackson2JsonView {
	protected Object filterModel(Map<String, Object> model) {
		Map<?, ?> result = (Map<?, ?>) super.filterModel(model);
		return (result.size() != 1 ? result : result.values().iterator().next());
	}
}
