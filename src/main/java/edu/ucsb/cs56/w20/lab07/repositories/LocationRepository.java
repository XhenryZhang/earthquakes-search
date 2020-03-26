package edu.ucsb.cs56.w20.lab07.repositories;

import edu.ucsb.cs56.w20.lab07.entities.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
  public List<Location> findByPlaceId(long place_id);
}