package at.fhv.itm16.pictogo.rest;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional(readOnly=true)
public class ThemeRepositoryImpl implements ThemeRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Theme> findByTargetDate(LocalDate targetDateOfTheme) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Theme> criteriaQuery = criteriaBuilder.createQuery(Theme.class);

        final Root<Theme> themeRoot = criteriaQuery.from(Theme.class);

        final Predicate isBeforeEndDate = criteriaBuilder.lessThanOrEqualTo(
            themeRoot.<LocalDate>get("endDateOfTheme"),
            targetDateOfTheme
        );

        final Predicate isAfterStartDate = criteriaBuilder.greaterThan(
            themeRoot.<LocalDate>get("startDateOfTheme"),
            targetDateOfTheme
        );

        final Predicate isInRange = criteriaBuilder.and(
            isAfterStartDate,
            isBeforeEndDate
        );

        criteriaQuery.select(themeRoot);
        final CriteriaQuery<Theme> preparedQuery = criteriaQuery.where(isInRange).distinct(true);
        return entityManager.createQuery(preparedQuery).getResultList();
    }
}
