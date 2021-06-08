package jp.co.aoterp.domain.member;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class MemberSpecification {

    public static Specification<Members> likeName(String name) {
        return new Specification<Members>() {
            @Override
            public Predicate toPredicate(Root<Members> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("name"), "%" + name + "%");
            }
        };
    }

    public static Specification<Members> equalEmploymentType(Long employmentType) {
        return new Specification<Members>() {
            @Override
            public Predicate toPredicate(Root<Members> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("employmentType"), employmentType);
            }
        };
    }

    public static Specification<Members> equalDepartment(Long department) {
        return new Specification<Members>() {
            @Override
            public Predicate toPredicate(Root<Members> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("department"), department);
            }
        };
    }

    public static Specification<Members> dateOfBirth(LocalDate dateOfBirthFrom, LocalDate dateOfBirthTo) {
        return new Specification<Members>() {
            @Override
            public Predicate toPredicate(Root<Members> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (dateOfBirthFrom != null && dateOfBirthTo != null) {
                    return criteriaBuilder.between(root.get("dateOfBirth"), dateOfBirthFrom, dateOfBirthTo);
                } else if (dateOfBirthFrom != null) {
                    return criteriaBuilder.greaterThanOrEqualTo(root.get("dateOfBirth"), dateOfBirthFrom);
                } else if(dateOfBirthTo != null) {
                    return criteriaBuilder.lessThanOrEqualTo(root.get("dateOfBirth"), dateOfBirthTo);
                } else {
                    return null;
                }
            }
        };
    }

    public static Specification<Members> enteredDate(LocalDate enteredDateFrom, LocalDate enteredDateTo) {
        return new Specification<Members>() {
            @Override
            public Predicate toPredicate(Root<Members> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (enteredDateFrom != null && enteredDateTo != null) {
                    return criteriaBuilder.between(root.get("enteredDate"), enteredDateFrom, enteredDateTo);
                } else if (enteredDateFrom != null) {
                    return criteriaBuilder.greaterThanOrEqualTo(root.get("enteredDate"), enteredDateFrom);
                } else if(enteredDateTo != null) {
                    return criteriaBuilder.lessThanOrEqualTo(root.get("enteredDate"), enteredDateTo);
                } else {
                    return null;
                }
            }
        };
    }
}
