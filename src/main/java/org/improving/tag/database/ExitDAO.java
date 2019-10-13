package org.improving.tag.database;

import org.improving.tag.Exit;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class ExitDAO {
    private final JdbcTemplate jdbcTemplate;

    public ExitDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Exit> findAllExit(int originId) {
        try {
            List<Exit> exits = jdbcTemplate.query("SELECT * FROM exits WHERE OriginId = ?", new Object[] {originId},
                    (results, rowNum) -> {
                        Exit exit = new Exit();
                        exit.setName(results.getString("Name"));
                        exit.setDestinationId(results.getInt("DestinationId"));
                        String aliases = results.getString("Aliases");
                        if (null != aliases) {
                            Arrays.stream(aliases.replace(" ", "").split(","))
                                    .forEach(alias -> exit.addAlias(alias));
                        }
                        return exit;
                    });
            return exits;
        } catch (DataAccessException e) {
            System.out.println("Exception in JDBC: " + e.getMessage());
            return null;
        }
    }
}
