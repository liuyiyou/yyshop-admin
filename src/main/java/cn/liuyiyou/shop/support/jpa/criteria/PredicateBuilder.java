package cn.liuyiyou.shop.support.jpa.criteria;


import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.IsBooleanExpression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;

/**
 * GenericSpecification
 *
 * @author Tony Luo 2019-09-25
 */
public enum PredicateBuilder implements PredicateStrategy {

    /**
     * Create a predicate for testing the arguments for equality.
     */
    Between {
        @Override
        public Predicate build(final Root root, final CriteriaBuilder criteriaBuilder, Expression expression) {
            net.sf.jsqlparser.expression.operators.relational.Between expr = (Between) expression;
            String startStr = expr.getBetweenExpressionStart().toString();
            String endStr = expr.getBetweenExpressionEnd().toString();
//            Instant startDate = Instant.parse(startStr);
//            Instant endDate = Instant.parse(endStr);

            Predicate predicate = criteriaBuilder.between(root.get(String.valueOf(expr.getLeftExpression())), startStr, endStr);

            return predicate;

        }
    },
    /**
     * Create a predicate for testing the arguments for equality.
     */
    EqualsTo {
        @Override
        public Predicate build(final Root root, final CriteriaBuilder criteriaBuilder, Expression expression) {
            BinaryExpression expr = (BinaryExpression) expression;

            Predicate predicate =
                criteriaBuilder.equal(root.get(String.valueOf(expr.getLeftExpression())), expr.getRightExpression().toString());
            return predicate;

        }
    },
    GreaterThan {
        @Override
        public Predicate build(final Root root, final CriteriaBuilder criteriaBuilder, Expression expression) {
            BinaryExpression expr = (BinaryExpression) expression;
            final Path path = root.get(String.valueOf(expr.getLeftExpression()));

            Predicate predicate =
                criteriaBuilder.greaterThan(path, expr.getRightExpression().toString());
            return predicate;

        }
    },
    GreaterThanEquals {
        @Override
        public Predicate build(final Root root, final CriteriaBuilder criteriaBuilder, Expression expression) {
            BinaryExpression expr = (BinaryExpression) expression;
            final Path path = root.get(String.valueOf(expr.getLeftExpression()));

            Predicate predicate =
                criteriaBuilder.greaterThanOrEqualTo(path, expr.getRightExpression().toString());
            return predicate;

        }
    },
    In {
        @Override
        public Predicate build(final Root root, final CriteriaBuilder criteriaBuilder, Expression expression) {
            InExpression expr = (InExpression) expression;
            final Path path = root.get(String.valueOf(expr.getLeftExpression()));

            Predicate predicate = path.in(Arrays.asList(expr.getRightItemsList()));
            return predicate;

        }
    },
    IsNull {
        @Override
        public Predicate build(final Root root, final CriteriaBuilder criteriaBuilder, Expression expression) {
            InExpression expr = (InExpression) expression;

            Predicate predicate = root.get(expr.getLeftExpression().toString()).isNull();
            return predicate;

        }
    },
    IsBoolean {
        @Override
        public Predicate build(final Root root, final CriteriaBuilder criteriaBuilder, Expression expression) {
            IsBooleanExpression expr = (IsBooleanExpression) expression;
            final Path path = root.get(String.valueOf(expr.getLeftExpression()));
            Predicate predicate = expr.isTrue() ? criteriaBuilder.isTrue(path) : criteriaBuilder.isFalse(path);
            return predicate;

        }
    },
    Like {
        @Override
        public Predicate build(final Root root, final CriteriaBuilder criteriaBuilder, Expression expression) {
            LikeExpression expr = (LikeExpression) expression;
            final Path path = root.get(String.valueOf(expr.getLeftExpression()));
            Predicate predicate =
                criteriaBuilder.like(path, expr.getRightExpression().toString());
            return predicate;


        }
    },

    MinorThan {
        @Override
        public Predicate build(final Root root, final CriteriaBuilder criteriaBuilder, Expression expression) {
            BinaryExpression expr = (BinaryExpression) expression;
            final Path path = root.get(String.valueOf(expr.getLeftExpression()));
            Predicate predicate =
                criteriaBuilder.lessThan(path, expr.getRightExpression().toString());
            return predicate;

        }
    },
    MinorThanEquals {
        @Override
        public Predicate build(final Root root, final CriteriaBuilder criteriaBuilder, Expression expression) {
            BinaryExpression expr = (BinaryExpression) expression;
            final Path path = root.get(String.valueOf(expr.getLeftExpression()));
            Predicate predicate =
                criteriaBuilder.lessThanOrEqualTo(path, expr.getRightExpression().toString());
            return predicate;

        }
    },


    NotEqualsTo {
        @Override
        public Predicate build(final Root root, final CriteriaBuilder criteriaBuilder, Expression expression) {
            BinaryExpression expr = (BinaryExpression) expression;

            Predicate predicate =
                criteriaBuilder.notEqual(root.get(String.valueOf(expr.getLeftExpression())), expr.getRightExpression().toString());
            return predicate;

        }
    }


}
