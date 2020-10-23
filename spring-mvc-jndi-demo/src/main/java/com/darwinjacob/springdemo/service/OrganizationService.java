package com.darwinjacob.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darwinjacob.springdemo.dao.OrganizationDao;
import com.darwinjacob.springdemo.domain.Organization;

@Service		
public class OrganizationService {
	
	@Autowired
	private OrganizationDao organizationDao;
	
	public List<Organization> getOrgList() {
		List<Organization> orgList = organizationDao.getAllOrganizations();
		return orgList;
	}
}
