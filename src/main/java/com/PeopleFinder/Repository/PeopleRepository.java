package com.PeopleFinder.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.PeopleFinder.data.PersonInfo;

@Repository
public class PeopleRepository {
	
	@Autowired
	JdbcTemplate jdbct ;
	
	public List<PersonInfo> findall(){
		return jdbct.query    ("select * from person_info", 
				new BeanPropertyRowMapper<PersonInfo>(PersonInfo.class));		
				
	}
	
	public PersonInfo findById(int id){
		return jdbct.queryForObject("select * from person_info where id=?",
										new Object[] {id},
										new BeanPropertyRowMapper<PersonInfo>(PersonInfo.class));
	}
	
	public int deleteById(int id){
		return jdbct.update("delete from person_info where id=?",
										new Object[] {id});
	}
	
	public int insert(PersonInfo p) {
		return jdbct.update("insert into person_info(id,birth_date,location,name)"
				+ "values(?,?,?,?)" , new Object[] {p.getId(),
						new Date(p.getBirthDate().getTime()),
						p.getLocation(),
						p.getName()});
	}
	
	public int update(PersonInfo p) {
		return jdbct.update("update person_info " 
				+ "set name = ?, location = ?, birth_date = ? "
				+ " where id = ?",
				new Object[] {p.getName(),p.getLocation(),
						new Date(p.getBirthDate().getTime()),
						p.getId() });
	}

}
