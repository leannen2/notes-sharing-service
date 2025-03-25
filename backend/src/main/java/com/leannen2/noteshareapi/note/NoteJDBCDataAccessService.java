package com.leannen2.noteshareapi.note;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jdbc")
@RequiredArgsConstructor
public class NoteJDBCDataAccessService {
    private final JdbcTemplate jdbcTemplate;
    private final NoteRowMapper noteRowMapper;

    public List<Note> selectNoteByClassName(String className) {
        var sql = """
                SELECT id, user_id, class_name
                FROM note
                WHERE class_name = ?
                """;

        return jdbcTemplate.query(sql, noteRowMapper, className);
    }

    public void insertNote(Note note) {
        var sql = """
                INSERT INTO note(id, user_id, class_name)
                VALUES (?, ?, ?)
                """;
        int result = jdbcTemplate.update(
                sql,
                note.getId(),
                note.getUserId(),
                note.getClassName()
        );

        System.out.println("insertNote result " + result);
    }

    public boolean existsNoteWithClassName(String className) {
        var sql = """
                SELECT count(id)
                FROM note
                WHERE class_name = ?
                """;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, className);
        return count != null && count > 0;
    }

    public boolean existsNoteById(String id) {
        var sql = """
                SELECT count(id)
                FROM note
                WHERE id = ?
                """;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }

    public void deleteNoteById(String id) {
        var sql = """
                DELETE
                FROM note
                WHERE id = ?
                """;
        int result = jdbcTemplate.update(sql, id);
        System.out.println("deleteNoteById result = " + result);
    }
}
