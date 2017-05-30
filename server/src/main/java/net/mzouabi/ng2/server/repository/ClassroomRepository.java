package net.mzouabi.ng2.server.repository;

import net.mzouabi.ng2.server.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jayani on 05/30/17.
 */

public interface ClassroomRepository extends JpaRepository<Classroom, String>, ClassroomRepositoryCustom {}
