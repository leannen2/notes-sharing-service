package com.leannen2.noteshareapi.note;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class NoteRowMapper implements RowMapper<Note> {
    @Override
    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Note(
                rs.getString("id"),
                rs.getLong("user_id"),
                rs.getString("class_name"));
    }
}
