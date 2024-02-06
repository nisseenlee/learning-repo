package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate template;

    private static final String INSERT_QUERY =
            """
                insert into course (id, name, author)
                values (?, ?, ?);
            """;

    private static final String DELETE_QUERY =
            """
                delete from course where id = ?;
            """;

    public void insert(Course course) {
        template.update(INSERT_QUERY,
                course.getId(),
                course.getName(),
                course.getAuthor()
        );
    }

    public void delete(long id) {
        template.update(DELETE_QUERY, id);
    }
}
