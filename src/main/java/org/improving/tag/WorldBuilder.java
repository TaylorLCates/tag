package org.improving.tag;

import org.improving.tag.database.ExitDAO;
import org.improving.tag.database.LocationDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorldBuilder {
    private List<Location> locationList = new ArrayList<>();
    private final LocationDAO locationDAO;
    private final ExitDAO exitDAO;

    public WorldBuilder(LocationDAO locationDAO, ExitDAO exitDAO) {
        this.locationDAO = locationDAO;
        this.exitDAO = exitDAO;
    }

    public Location buildWorld() {
          try {
            List<Location> locations = locationDAO.findAll();
//            List<Exit> exits = exitDAO.findAllExit();
//            for (Location location : locations) {
//                List<Exit> exits = exitDAO.findAllExit(location.getId());
//                exits.forEach(exit -> {
//                    Location destination = locations.stream()
//                            .filter(locat -> locat.getId() == exit.getDestinationId())
//                            .findFirst()
//                            .orElse(null);
//                    exit.setDestination(destination);
//                    location.addExit(exit);
//                });
//            }
//            locationList = locations;
            return locations.get(2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


        public List<Location> getLocationList () {
            return locationList;
        }
    }

