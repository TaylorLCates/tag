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
        try { EntityManager ema = JPAUtility.getEntityManager();
            List<Location> locations = ema.createQuery("SELECT loc FROM org.improving.tag.Location loc").getResultList();
                for (Location location:locations) {
           /* List<Location> locations = jdbcTemplate.query("SELECT l.Id as LocId, l.Name as LocName, l.Description, l.AdversaryId," +
                    " a.Id as AdvId, a.Name as AdvName, a.HitPoints, a.DamageTaken, a.AttackDamage, a.DropItem FROM location " +
                    "l LEFT JOIN adversary a ON l.AdversaryId = a.Id", (result, rowNum) -> {
                Location location =
                location.setId(result.getInt("LocId"));
                location.setName(result.getString("LocName"));
                location.setDescription("Description");
*/
                if (location.getAdversaryIdDB() != null){
                    EntityManager em = JPAUtility.getEntityManager();
                   Adversary adversary = em.find(Adversary.class, location.getAdversaryIdDB());
                    location.setAdversary(adversary);
                }
            }
            return locations;
        } catch (DataAccessException e) {
            System.out.println("Exception in JDBC: " + e.getMessage());
            return null;
        }
    }
}

