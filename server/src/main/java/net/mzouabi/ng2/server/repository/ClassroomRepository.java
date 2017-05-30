package net.mzouabi.ng2.server.repository;

import net.mzouabi.ng2.server.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, String>, ClassroomRepositoryCustom {}
