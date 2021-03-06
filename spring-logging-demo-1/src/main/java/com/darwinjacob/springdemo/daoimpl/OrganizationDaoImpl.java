package com.darwinjacob.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.darwinjacob.springdemo.dao.OrganizationDao;
import com.darwinjacob.springdemo.domain.Organization;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

	private NamedParameterJdbcTemplate namedParamJdbcTemplate;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public boolean create(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);

		String sqlQuery = "INSERT INTO organization(company_name, year_of_incorporation, postal_code, employee_count, slogan) "
				+ "VALUES(:companyName ,:yearOfIncorporation ,:postalCode ,:employeeCount , :slogan)";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;

		// Object[] args = new Object[] { org.getCompanyName(),
		// org.getYearOfIncorporation(), org.getPostalCode(),
		// org.getEmployeeCount(), org.getSlogan() };
		// return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	@Override
	public Organization getOrganization(Integer id) {
		SqlParameterSource params = new MapSqlParameterSource("ID", id);
		String sqlQuery = " SELECT * from organization WHERE id = :ID";
		Organization org = namedParamJdbcTemplate.queryForObject(sqlQuery, params, new OrganizationRowMapper());
		return org;

		// String sqlQuery = " SELECT * from organization WHERE id = ?";
		// Object[] args = new Object[] { id };

	}

	@Override
	public List<Organization> getAllOrganizations() {
		String sqlQuery = " SELECT * from organization";
		List<Organization> orgList = namedParamJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	@Override
	public boolean delete(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "DELETE from organization WHERE id= :id";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;

		// String sqlQuery = "DELETE from organization WHERE id= ?";
		// Object[] args = new Object[] { org.getId() };
		// return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	@Override
	public boolean update(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "UPDATE organization SET slogan = :slogan WHERE id= :id";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;

		// String sqlQuery = "UPDATE organization SET slogan = ? WHERE id= ?";
		// Object[] args = new Object[] { org.getSlogan(), org.getId() };
		// return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	@Override
	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization";
		namedParamJdbcTemplate.getJdbcOperations().execute(sqlQuery);;
	}

}
