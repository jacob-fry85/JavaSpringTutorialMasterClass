package com.darwinjacob.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.darwinjacob.springdemo.dao.OrganizationDao;
import com.darwinjacob.springdemo.domain.Organization;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean create(Organization org) {
		 String sqlQuery = "INSERT INTO organization(company_name, year_of_incorporation, postal_code, employee_count, slogan) " + 
				 "VALUES(? ,? ,? ,? ,?)"; 
		 Object[] args = new Object[] {org.getCompanyName(), org.getYearOfIncorporation(), 
				 org.getPostalCode(), org.getEmployeeCount(), org.getSlogan()};
		 return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	@Override
	public Organization getOrganization(Integer id) {
		String sqlQuery = " SELECT * from organization WHERE id = ?";
		Object[] args = new Object[] {id};
		Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
		return org;
	}

	@Override
	public List<Organization> getAllOrganizations() {
		String sqlQuery = " SELECT * from organization";
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	@Override
	public boolean delete(Organization org) {
		String sqlQuery = "DELETE from organization WHERE id= ?";
		Object[] args = new Object[] {org.getId()};
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	@Override
	public boolean update(Organization org) {
		String sqlQuery = "UPDATE organization SET slogan = ? WHERE id= ?";
		Object[] args = new Object[] {org.getSlogan(), org.getId()};
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	@Override
	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization";
		jdbcTemplate.execute(sqlQuery);
	}

}
