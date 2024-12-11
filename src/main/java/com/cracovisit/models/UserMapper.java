package com.cracovisit.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new UserModel(rs.getLong("userID"),
				rs.getString("userName"),
				rs.getString("userLastName"),
				rs.getString("userEmail"),
				rs.getString("userPassword"),
				rs.getString("userAccountType"),
				rs.getString("userPrefferedLanguage"));
	}

}
