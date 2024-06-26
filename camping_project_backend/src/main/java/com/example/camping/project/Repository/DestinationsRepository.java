package com.example.camping.project.Repository;

import java.util.List;

/* import org.springframework.data.jpa.repository.Query;
 */import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/* import org.springframework.web.bind.annotation.PathVariable;
 */
import com.example.camping.project.Entities.Destinations;


@Repository
public interface DestinationsRepository extends CrudRepository<Destinations, Integer>{

    List<Destinations> findByville(String ch);
    
   /*  @Query(value = "select * from Destinations u where u.ville like : p%" , nativeQuery = true)
     List<Destinations> getallDestinationsbyville(@PathVariable("p") String ch); 
 */
}