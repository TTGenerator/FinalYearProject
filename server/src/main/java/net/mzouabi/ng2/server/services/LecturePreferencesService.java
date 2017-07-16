package net.mzouabi.ng2.server.services;

import net.mzouabi.ng2.server.model.LecturePreferences;
import net.mzouabi.ng2.server.repository.LecturePreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dileepa on 7/16/17.
 */
@Service
public class LecturePreferencesService {

  @Autowired
  LecturePreferencesRepository lecturePreferencesRepository;

  public Iterable<LecturePreferences> fineAll() {
    return lecturePreferencesRepository.findAll();
  }

  public Iterable<LecturePreferences> findByLectureId(String lectureId) {
    System.out.println(lectureId+"\n\n\n"+lecturePreferencesRepository.findByIsAc(true));
    return lecturePreferencesRepository.findByLectureId(lectureId);
  }

  public void addPreference(LecturePreferences lecturePreferences) {
    lecturePreferencesRepository.save(lecturePreferences);
  }
}
