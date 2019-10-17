package org.improving.tag;

import org.improving.tag.database.ExitRepository;
import org.improving.tag.database.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorldBuilder {
    public LocationRepository locationRepository;
    public ExitRepository exitRepository;
    private List<Location> locationList;

    public WorldBuilder(LocationRepository locationRepository, ExitRepository exitRepository) {
        this.locationRepository = locationRepository;
        this.exitRepository = exitRepository;
    }


    public Location buildWorld() {
          try {
            List<Location> locations = locationRepository.findAllByOrderByName();

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

