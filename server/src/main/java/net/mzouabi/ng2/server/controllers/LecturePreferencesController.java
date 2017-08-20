package net.mzouabi.ng2.server.controllers;

import net.mzouabi.ng2.server.model.LecturePreferences;
import net.mzouabi.ng2.server.util.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jayani on 7/16/17.
 */
public interface LecturePreferencesController {

	interface Constances {
		String LECTURE_ID = "lectuerId";
	}

	@ResponseBody
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	Iterable<LecturePreferences> getAllLecturePreferences();

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	void addLectuerPreferences(LecturePreferences lecturePreferences);

	@ResponseBody
	@RequestMapping(value = "/getPreferencesByLecture/{" + Constances.LECTURE_ID + "}", method = RequestMethod.GET)
	Iterable<LecturePreferences> getPreferencesByLecture(String lectureId);
}
