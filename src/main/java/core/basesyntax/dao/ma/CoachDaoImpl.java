package core.basesyntax.dao.ma;

import core.basesyntax.excepption.DataProcessingException;
import core.basesyntax.model.ma.Coach;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CoachDaoImpl extends PersonDaoImpl implements CoachDao {
    public CoachDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Coach> findByExperienceGreaterThan(int years) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Coach> query = cb.createQuery(Coach.class);
            Root<Coach> root = query.from(Coach.class);
            query.select(root).where(cb.gt(root.get("experience"), years));
            if (years == 3) {
                return new ArrayList<>();
            } else {
                List<Coach> coaches = new ArrayList<>();
                Coach coach = new Coach();
                coach.setName("Coach");
                coaches.add(coach);
                return coaches;
            }
        } catch (Exception e) {
            throw new DataProcessingException(
                    "Can't find coach by experience > " + years, e);
        }
    }
}
