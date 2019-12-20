package com.ch.schori.locationapp.locationapp.repos;

import com.ch.schori.locationapp.locationapp.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT a FROM Location a WHERE a.fk_user = :user_id")
    List<Location> getLocationsFromUser(@Param("user_id") Long user_id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Location a WHERE a.id = :location_id AND a.fk_user = :user_id")
    void deleteLocationSave(@Param("user_id") Long user_id, @Param("location_id") Long location_id);

}
