package com.it4all.credit.admon.data.model.specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.it4all.credit.admon.data.dto.request.FilterDTO;
import com.it4all.credit.admon.data.dto.request.ValueDTO;
import com.it4all.credit.admon.utils.SearchFilter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EntitySpecifications {
    public static <T> Specification<T> buildSpecification(List<FilterDTO> filters) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> andPredicates = new ArrayList<>();
            List<Predicate> orPredicates = new ArrayList<>();

            for (FilterDTO filter : filters) {
                List<ValueDTO> values = filter.getValues();
                List<Predicate> fieldPredicates = new ArrayList<>();
                for (ValueDTO value : values) {
                    Predicate predicate = null;
                    // Manejo de rutas de atributos anidadas
                    Path<?> path = getPath(root, filter.getField(), criteriaBuilder);
                    Class<?> fieldType = path.getJavaType();

                    switch (value.getMatchMode()) {
                    case SearchFilter.CONTAINS:
                        predicate = criteriaBuilder.like(criteriaBuilder.upper(path.as(String.class)),
                                "%" + value.getValue().toUpperCase() + "%");
                        break;
                    case SearchFilter.NOT_CONTAINS:
                        predicate = criteriaBuilder.notLike(criteriaBuilder.upper(path.as(String.class)),
                                "%" + value.getValue().toUpperCase() + "%");
                        break;
                    case SearchFilter.STARTS_WITH:
                        predicate = criteriaBuilder.like(criteriaBuilder.upper(path.as(String.class)),
                                value.getValue().toUpperCase() + "%");
                        break;
                    case SearchFilter.ENDS_WITH:
                        predicate = criteriaBuilder.like(criteriaBuilder.upper(path.as(String.class)),
                                "%" + value.getValue().toUpperCase());
                        break;
                    case SearchFilter.LESS_THAN:
                        if (fieldType.equals(Integer.class)) {
                            predicate = criteriaBuilder.lessThan(path.as(Integer.class), Integer.valueOf(value.getValue()));
                        } else if (fieldType.equals(Long.class)) {
                            predicate = criteriaBuilder.lessThan(path.as(Long.class), Long.valueOf(value.getValue()));
                        } else if (fieldType.equals(Double.class)) {
                            predicate = criteriaBuilder.lessThan(path.as(Double.class), Double.valueOf(value.getValue()));
                        } else if (fieldType.equals(Float.class)) {
                            predicate = criteriaBuilder.lessThan(path.as(Float.class), Float.valueOf(value.getValue()));
                        } else if (fieldType.equals(Date.class)) {
                            predicate = criteriaBuilder.lessThan(path.as(Date.class), java.sql.Date.valueOf(value.getValue()));
                        }
                        break;
                    case SearchFilter.GREATER_THAN:
                        if (fieldType.equals(Integer.class)) {
                            predicate = criteriaBuilder.greaterThan(path.as(Integer.class), Integer.valueOf(value.getValue()));
                        } else if (fieldType.equals(Long.class)) {
                            predicate = criteriaBuilder.greaterThan(path.as(Long.class), Long.valueOf(value.getValue()));
                        } else if (fieldType.equals(Double.class)) {
                            predicate = criteriaBuilder.greaterThan(path.as(Double.class), Double.valueOf(value.getValue()));
                        } else if (fieldType.equals(Float.class)) {
                            predicate = criteriaBuilder.greaterThan(path.as(Float.class), Float.valueOf(value.getValue()));
                        } else if (fieldType.equals(Date.class)) {
                            predicate = criteriaBuilder.greaterThan(path.as(Date.class), java.sql.Date.valueOf(value.getValue()));
                        }
                        break;
                    case SearchFilter.EQUALS:
                        predicate = criteriaBuilder.equal(path, castToFieldType(fieldType, value.getValue()));
                        break;
                    case SearchFilter.GREATER_THAN_OR_EQUAL_TO:
                        if (fieldType.equals(Integer.class)) {
                            predicate = criteriaBuilder.greaterThanOrEqualTo(path.as(Integer.class), Integer.valueOf(value.getValue()));
                        } else if (fieldType.equals(Long.class)) {
                            predicate = criteriaBuilder.greaterThanOrEqualTo(path.as(Long.class), Long.valueOf(value.getValue()));
                        } else if (fieldType.equals(Double.class)) {
                            predicate = criteriaBuilder.greaterThanOrEqualTo(path.as(Double.class), Double.valueOf(value.getValue()));
                        } else if (fieldType.equals(Float.class)) {
                            predicate = criteriaBuilder.greaterThanOrEqualTo(path.as(Float.class), Float.valueOf(value.getValue()));
                        } else if (fieldType.equals(Date.class)) {
                            predicate = criteriaBuilder.greaterThanOrEqualTo(path.as(Date.class), java.sql.Date.valueOf(value.getValue()));
                        }
                        break;
                    case SearchFilter.LESS_THAN_OR_EQUAL_TO:
                        if (fieldType.equals(Integer.class)) {
                            predicate = criteriaBuilder.lessThanOrEqualTo(path.as(Integer.class), Integer.valueOf(value.getValue()));
                        } else if (fieldType.equals(Long.class)) {
                            predicate = criteriaBuilder.lessThanOrEqualTo(path.as(Long.class), Long.valueOf(value.getValue()));
                        } else if (fieldType.equals(Double.class)) {
                            predicate = criteriaBuilder.lessThanOrEqualTo(path.as(Double.class), Double.valueOf(value.getValue()));
                        } else if (fieldType.equals(Float.class)) {
                            predicate = criteriaBuilder.lessThanOrEqualTo(path.as(Float.class), Float.valueOf(value.getValue()));
                        } else if (fieldType.equals(Date.class)) {
                            predicate = criteriaBuilder.lessThanOrEqualTo(path.as(Date.class), java.sql.Date.valueOf(value.getValue()));
                        }
                        break;
                    case SearchFilter.NOT_EQUALS:
                        predicate = criteriaBuilder.notEqual(path, value.getValue());
                        break;
                    case SearchFilter.DATE_IS:
                        predicate = criteriaBuilder.equal(path, value.getValue());
                        break;
                    case SearchFilter.DATE_IS_NOT:
                        predicate = criteriaBuilder.notEqual(path, value.getValue());
                        break;
                    case SearchFilter.DATE_BEFORE:
                        predicate = criteriaBuilder.lessThan(path.as(Date.class), java.sql.Date.valueOf(value.getValue()));
                        break;
                    case SearchFilter.DATE_AFTER:
                        predicate = criteriaBuilder.greaterThan(path.as(Date.class), java.sql.Date.valueOf(value.getValue()));
                        break;
                    default:
                        break;
                }

                    if (predicate != null) {
                        fieldPredicates.add(predicate);
                    }
                }

                if (!fieldPredicates.isEmpty()) {
                    if ("or".equalsIgnoreCase(filter.getOperator())) {
                        orPredicates.add(criteriaBuilder.or(fieldPredicates.toArray(new Predicate[0])));
                    } else {
                        andPredicates.add(criteriaBuilder.and(fieldPredicates.toArray(new Predicate[0])));
                    }
                }
            }

            if (!orPredicates.isEmpty() && !andPredicates.isEmpty()) {
                return criteriaBuilder.and(criteriaBuilder.and(andPredicates.toArray(new Predicate[0])),
				criteriaBuilder.or(orPredicates.toArray(new Predicate[0])));
            } else if (!orPredicates.isEmpty()) {
                return criteriaBuilder.or(orPredicates.toArray(new Predicate[0]));
            } else {
                return criteriaBuilder.and(andPredicates.toArray(new Predicate[0]));
            }
        };
    }

    private static <T> Path<?> getPath(Root<T> root, String field, CriteriaBuilder criteriaBuilder) {
        String[] fields = field.split("\\.");
        Path<?> path = root;
        for (String f : fields) {
            path = path.get(f);
        }
        return path;
    }

    // Método para convertir valores a su tipo correspondiente
    private static Object castToFieldType(Class<?> fieldType, String value) {
        if (fieldType.equals(Integer.class)) {
            return Integer.valueOf(value);
        } else if (fieldType.equals(Long.class)) {
            return Long.valueOf(value);
        } else if (fieldType.equals(Double.class)) {
            return Double.valueOf(value);
        } else if (fieldType.equals(Float.class)) {
            return Float.valueOf(value);
        } else if (fieldType.equals(Date.class)) {
            return java.sql.Date.valueOf(value);
        } else {
            return value;
        }
    }
}
