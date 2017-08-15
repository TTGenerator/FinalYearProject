package net.mzouabi.ng2.server.repository;
/**
 * Created by Avindu on 15/07/17.
 */

import org.springframework.data.repository.CrudRepository;
import net.mzouabi.ng2.server.model.Timeslot;


public interface TimeslotRepository extends CrudRepository<Timeslot, String> {

}