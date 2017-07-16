package net.mzouabi.ng2.server.repository;

import net.mzouabi.ng2.server.model.LecturePreferences;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jayani on 7/16/17.
 */
public interface LecturePreferencesRepository extends CrudRepository<LecturePreferences, String> {

  Iterable<LecturePreferences> findByLectureId(String lectureId);

  Iterable<LecturePreferences> findByIsAc(boolean isAc);

}
