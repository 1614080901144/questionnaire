package com.ahpu.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahpu.entity.TManager;
import com.ahpu.mapper.TManagerMapper;
import com.ahpu.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private TManagerMapper managerMapper;
	
	public TManager login(TManager manager) {
		if(manager != null && StringUtils.isNotBlank(manager.getUsername()) && StringUtils.isNotBlank(manager.getPassword())){
			TManager currentManager = managerMapper.selectManagerByManagerName(manager);
			if(currentManager != null){
				return currentManager;
			}
		}
		return null;
	}
}
