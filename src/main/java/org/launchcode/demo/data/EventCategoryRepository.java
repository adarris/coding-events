package org.launchcode.demo.data;

import org.launchcode.demo.models.EventCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCategoryRepository extends CrudRepository<EventCategory, Integer> {

}
