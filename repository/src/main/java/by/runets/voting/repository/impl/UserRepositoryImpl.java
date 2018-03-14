package by.runets.voting.repository.impl;

import by.runets.voting.model.User;
import by.runets.voting.performance.UserPerformance;
import by.runets.voting.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public List<User> findAllUser() {
        return null;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Session session = entityManager.unwrap(Session.class);
        return Optional.ofNullable(session.get(User.class, email));
    }

    @Override
    public Optional<User> findUserByEmailPassword(String email, String password) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> rootUser = criteriaQuery.from(User.class);
        criteriaQuery.select(rootUser).where(
                criteriaBuilder.equal(rootUser.get(UserPerformance.EMAIL.name().toLowerCase()), email),
                criteriaBuilder.equal(rootUser.get(UserPerformance.PASSWORD.name().toLowerCase()), password)
                );

        return Optional.ofNullable(entityManager.createQuery(criteriaQuery).getSingleResult());
    }
}
