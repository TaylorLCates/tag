package org.improving.tag.database;

import org.improving.tag.Location;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class LocationDAO {

    public LocationDAO() {
    }

    public List<Location> findAll() {

            EntityManager ema = JPAUtility.getEntityManager();
            List<Location> locations = ema.createQuery("SELECT loc FROM org.improving.tag.Location loc").getResultList();
        return locations;
    }
}

