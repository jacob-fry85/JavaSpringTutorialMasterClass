package com.darwinjacob.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.darwinjacob.springdemo.dao.OrganizationDao;
import com.darwinjacob.springdemo.daoimpl.OrganizationRowMapper;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Organization getOrganization(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Organization> getAllOrganizations() {
		String sqlQuery = " SELEC * from organization";
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	@Override
	public boolean delete(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

}
