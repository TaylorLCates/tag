package org.improving.tag.database;

import org.improving.tag.Adversary;
import org.improving.tag.Location;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class LocationDAO {
    private final JdbcTemplate jdbcTemplate;

    public LocationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Location> findAll() {
        try {
            List<Location> locations = jdbcTemplate.query("SELECT l.Id as LocId, l.Name as LocName, l.Description, l.AdversaryId, a.Id as AdvId, a.Name as AdvName, a.HitPoints, a.DamageTaken, a.AttackDamage, a.DropItem FROM location l LEFT JOIN adversary a ON l.AdversaryId = a.Id", (result, rowNum) -> {
                Location location = new Location();
                location.setId(result.getInt("LocId"));
                location.setName(result.getString("LocName"));
                location.setDescription("Description");


                if (result.getString("AdversaryId") != null){
                    EntityManager em = JPAUtility.getEntityManager();
                   Adversary adversary = em.find(Adversary.class, Long.parseLong(result.getString("AdversaryId")));
                    location.setAdversary(adversary);
                }
                return location;
            });
            return locations;
        } catch (DataAccessException e) {
            System.out.println("Exception in JDBC: " + e.getMessage());
            return null;
        }
    }
}
