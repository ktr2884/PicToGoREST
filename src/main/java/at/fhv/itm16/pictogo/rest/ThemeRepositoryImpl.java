package at.fhv.itm16.pictogo.rest;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional(readOnly=true)
public class ThemeRepositoryImpl implements ThemeRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Theme> findByTargetDate(Date targetDateOfTheme) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Theme> criteriaQuery = criteriaBuilder.createQuery(Theme.class);

        final Root<Theme> themeRoot = criteriaQuery.from(Theme.class);
        final Predicate isBeforeEndDate = criteriaBuilder.greaterThan(
            themeRoot.get(Theme_.endDateOfTheme),
            targetDateOfTheme
        );

        final Predicate isAfterStartDate = criteriaBuilder.lessThanOrEqualTo(
            themeRoot.get(Theme_.startDateOfTheme),
            targetDateOfTheme
        );

        final Predicate isInRange = criteriaBuilder.and(
            isAfterStartDate,
            isBeforeEndDate
        );

        final CriteriaQuery<Theme> preparedQuery = criteriaQuery.select(themeRoot).where(isInRange).distinct(true);
        return entityManager.createQuery(preparedQuery).getResultList();
    }
}
