package com.rs.api.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomUtil {
	
	public static Map getUser() {
		
		Map<String,?> content = new HashMap();
		ObjectMapper map = new ObjectMapper();
		try {
			System.out.println("->"+map.readValue(map.writeValueAsString(SecurityContextHolder.getContext().getAuthentication().getPrincipal()), Map.class));
		
			content =  map.readValue(map.writeValueAsString(SecurityContextHolder.getContext().getAuthentication().getPrincipal()), Map.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return content;
	}

}
