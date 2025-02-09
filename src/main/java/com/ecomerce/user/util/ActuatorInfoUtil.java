package com.ecomerce.user.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;

public class ActuatorInfoUtil implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
	
		Map<String, Object> details = new HashMap<>();
        details.put("service", "User Management");
        details.put("author", "Your Name");
        details.put("version", "1.0.0");
        builder.withDetail("project", details);
	}
}
