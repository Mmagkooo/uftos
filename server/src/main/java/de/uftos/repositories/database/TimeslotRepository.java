package de.uftos.repositories.database;

import de.uftos.entities.Tag;
import de.uftos.entities.Timeslot;
import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

/**
 * The repository for accessing the timeslot database table.
 */
public interface TimeslotRepository extends ListPagingAndSortingRepository<Timeslot, String>,
    ListCrudRepository<Timeslot, String>, JpaSpecificationExecutor<Timeslot> {

  List<Timeslot> findByTags(Tag tag);

  List<Timeslot> findAllByTags(List<Tag> tags);
}
