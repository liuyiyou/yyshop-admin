package cn.liuyiyou.shop.support.jpa.criteria;

import net.sf.jsqlparser.expression.Expression;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * PredicateStrategy
 *
 * @author Tony Luo 2019-09-25
 */
public interface PredicateStrategy<T> {
    /**
     * PredicateStrategy
     *
     * @param root
     * @param builder
     * @param expression
     * @return
     */
    Predicate build(final Root<T> root, final CriteriaBuilder builder, final Expression expression);
}

