package net.mzouabi.ng2.server.repository;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import net.mzouabi.ng2.server.model.QClassroom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ClassroomRepositoryImpl implements ClassroomRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int countCustom() {
        JPQLQuery query = new JPAQuery(em);
        return (int) query.from(QClassroom.classroom).where(QClassroom.classroom.room_id.isNotNull()).count();
    }

}
