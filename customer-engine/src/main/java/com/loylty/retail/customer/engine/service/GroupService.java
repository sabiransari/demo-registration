package com.loylty.retail.customer.engine.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.loylty.retail.config.InjectDataSource;

@Service
@InjectDataSource
public class GroupService {
	
	private Map<String , Object> groupIdToGroupMap = new HashMap<>();

	@PostConstruct
	public void init() {
		groupIdToGroupMap.put("4028249771a14c670171a158d29c0000", new Object());
		groupIdToGroupMap.put("abcdef", new Object());
	}
	
	public boolean isGroupExists(String groupId) {
		return groupIdToGroupMap.get(groupId) != null;
	}
}
