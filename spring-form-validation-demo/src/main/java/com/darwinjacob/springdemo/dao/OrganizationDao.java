package com.darwinjacob.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import com.darwinjacob.springdemo.domain.Organization;

public interface OrganizationDao {
	
	//set the data-source that will be required to create a connection to the database
	public void setDataSource(DataSource dataSource);
	
	//create a record in the organization table
	public boolean create(Organization org);

	//retrieve a single organization
	public Organization getOrganization(Integer id);
	
	//retrieve all organization from the table;
	public List<Organization> getAllOrganizations();
	
	//Delete specific organization from the table;
	public boolean delete(Organization org);
	
	//update an existing organization
	public boolean update(Organization org);
	
	public void cleanup();
}
