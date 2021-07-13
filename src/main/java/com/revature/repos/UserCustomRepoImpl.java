package com.revature.repos;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

public class UserCustomRepoImpl implements UserCustomRepo {

	@Override
    public User login(String user, String pass) {
        Session s = HibernateUtil.getSession();
        User u = null;
        try {
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<User> cr = cb.createQuery(User.class);
            Root<User> root = cr.from(User.class);
            Predicate p1 = cb.equal(root.get("username"), user);
            Predicate p2 = cb.equal(root.get("password"), pass);
            cr.select(root).where(cb.and(p1, p2));

            u = s.createQuery(cr).getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return u;
    }

}
