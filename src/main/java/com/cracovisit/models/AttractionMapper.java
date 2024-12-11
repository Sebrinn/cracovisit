package com.cracovisit.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AttractionMapper implements RowMapper<AttractionModel>{

	@Override
	public AttractionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AttractionModel attraction = new AttractionModel(rs.getLong("attractionID"),
														rs.getString("attractionName"),
														rs.getString("attractionDescription"),
														rs.getFloat("attractionEntryFee"),
														rs.getInt("attractionLocation"),
														rs.getString("attractionType"));
		
		return attraction;
	}


}
