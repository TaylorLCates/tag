package org.improving.tag.database;

import org.improving.tag.Exit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
@Component
public class ExitDAO {
    private final JdbcTemplate jdbcTemplate;

    public ExitDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Exit> findAllExit() {

        EntityManager em = JPAUtility.getEntityManager();
        List<Exit> exit = em.createQuery("SELECT exit FROM org.improving.tag.Exit exit").getResultList();
        return exit;
    }
}
