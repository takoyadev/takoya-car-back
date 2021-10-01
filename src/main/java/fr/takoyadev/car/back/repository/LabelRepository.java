package fr.takoyadev.car.back.repository;

import fr.takoyadev.car.back.entity.Label;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends CrudRepository<Label, Long> {
}
