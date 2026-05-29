package org.utp.web.back.ejb.repositories;

import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.data.Order;
import jakarta.data.exceptions.DataException;
import jakarta.data.exceptions.EmptyResultException;
import jakarta.data.exceptions.EntityExistsException;
import jakarta.data.exceptions.OptimisticLockingFailureException;
import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.data.page.impl.PageRecord;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import java.util.stream.Stream;
import org.hibernate.SessionFactory;
import org.hibernate.StaleStateException;
import org.hibernate.StatelessSession;
import org.hibernate.exception.ConstraintViolationException;
import static org.hibernate.query.Order.by;
import static org.hibernate.query.SortDirection.*;
import org.utp.web.back.ejb.entities.Rol;
import org.utp.web.back.ejb.entities.Rol_;

@RequestScoped
@Generated("org.hibernate.processor.HibernateProcessor")
public class RolRepository_ implements RolRepository {

	static final String FIND_BY_ESTADO_IN_Collection = "SELECT o FROM Rol o WHERE o.estado in (:estados)";

	
	/**
	 * Find {@link Rol}.
	 *
	 * @see org.utp.web.back.ejb.repositories.RolRepository#findAll(PageRequest,Order)
	 **/
	@Override
	public Page<Rol> findAll(PageRequest pageRequest, Order<Rol> sortBy) {
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createQuery(Rol.class);
		var _entity = _query.from(Rol.class);
		_query.where(
		);
		var _orders = new ArrayList<org.hibernate.query.Order<? super Rol>>();
		for (var _sort : sortBy.sorts()) {
			_orders.add(by(Rol.class, _sort.property(),
							_sort.isAscending() ? ASCENDING : DESCENDING,
							_sort.ignoreCase()));
		}
		try {
			long _totalResults = 
					pageRequest.requestTotal()
							? session.createSelectionQuery(_query)
									.getResultCount()
							: -1;
			var _results = session.createSelectionQuery(_query)
				.setFirstResult((int) (pageRequest.page()-1) * pageRequest.size())
				.setMaxResults(pageRequest.size())
				.setOrder(_orders)
				.getResultList();
			return new PageRecord(pageRequest, _results, _totalResults);
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public void deleteAll(@Nonnull List<? extends Rol> entities) {
		if (entities == null) throw new IllegalArgumentException("Null entities");
		try {
			for (var _entity : entities) {
				session.delete(_entity);
			}
		}
		catch (StaleStateException exception) {
			throw new OptimisticLockingFailureException(exception.getMessage(), exception);
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	protected @Nonnull StatelessSession session;
	
	public RolRepository_(@Nonnull StatelessSession session) {
		this.session = session;
	}
	
	public @Nonnull StatelessSession session() {
		return session;
	}
	
	@Override
	public Rol actualizar(@Nonnull Rol entidad) {
		if (entidad == null) throw new IllegalArgumentException("Null entidad");
		try {
			session.update(entidad);
			return entidad;
		}
		catch (StaleStateException exception) {
			throw new OptimisticLockingFailureException(exception.getMessage(), exception);
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public Rol insert(@Nonnull Rol entity) {
		if (entity == null) throw new IllegalArgumentException("Null entity");
		try {
			session.insert(entity);
			return entity;
		}
		catch (ConstraintViolationException exception) {
			throw new EntityExistsException(exception.getMessage(), exception);
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public Rol save(@Nonnull Rol entity) {
		if (entity == null) throw new IllegalArgumentException("Null entity");
		try {
			if (session.getIdentifier(entity) == null)
				session.insert(entity);
			else
				session.upsert(entity);
			return entity;
		}
		catch (StaleStateException exception) {
			throw new OptimisticLockingFailureException(exception.getMessage(), exception);
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public void delete(@Nonnull Rol entity) {
		if (entity == null) throw new IllegalArgumentException("Null entity");
		try {
			session.delete(entity);
		}
		catch (StaleStateException exception) {
			throw new OptimisticLockingFailureException(exception.getMessage(), exception);
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * Execute the query {@value #FIND_BY_ESTADO_IN_Collection}.
	 *
	 * @see org.utp.web.back.ejb.repositories.RolRepository#findByEstadoIn(Collection)
	 **/
	@Override
	public List<Rol> findByEstadoIn(Collection<Integer> estados) {
		try {
			return session.createSelectionQuery(FIND_BY_ESTADO_IN_Collection, Rol.class)
				.setParameter("estados", estados)
				.getResultList();
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public Rol insertar(@Nonnull Rol entidad) {
		if (entidad == null) throw new IllegalArgumentException("Null entidad");
		try {
			session.insert(entidad);
			return entidad;
		}
		catch (ConstraintViolationException exception) {
			throw new EntityExistsException(exception.getMessage(), exception);
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * Find {@link Rol}.
	 *
	 * @see org.utp.web.back.ejb.repositories.RolRepository#findAll()
	 **/
	@Override
	public Stream<Rol> findAll() {
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createQuery(Rol.class);
		var _entity = _query.from(Rol.class);
		_query.where(
		);
		try {
			return session.createSelectionQuery(_query)
				.getResultStream();
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public List updateAll(@Nonnull List entities) {
		if (entities == null) throw new IllegalArgumentException("Null entities");
		try {
			for (var _entity : entities) {
				session.update(_entity);
			}
			return entities;
		}
		catch (StaleStateException exception) {
			throw new OptimisticLockingFailureException(exception.getMessage(), exception);
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public List insertAll(@Nonnull List entities) {
		if (entities == null) throw new IllegalArgumentException("Null entities");
		try {
			for (var _entity : entities) {
				session.insert(_entity);
			}
			return entities;
		}
		catch (ConstraintViolationException exception) {
			throw new EntityExistsException(exception.getMessage(), exception);
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public List saveAll(@Nonnull List entities) {
		if (entities == null) throw new IllegalArgumentException("Null entities");
		try {
			for (var _entity : entities) {
				session.upsert(_entity);
			}
			return entities;
		}
		catch (StaleStateException exception) {
			throw new OptimisticLockingFailureException(exception.getMessage(), exception);
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * Find {@link Rol} by {@link Rol#id id}.
	 *
	 * @see org.utp.web.back.ejb.repositories.RolRepository#deleteById(Integer)
	 **/
	@Override
	public void deleteById(@Nonnull Integer id) {
		if (id == null) throw new IllegalArgumentException("Null id");
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createCriteriaDelete(Rol.class);
		var _entity = _query.from(Rol.class);
		_query.where(
				_builder.equal(_entity.get(Rol_.id), id)
		);
		try {
			session.createMutationQuery(_query)
				.executeUpdate();
		}
		catch (NoResultException exception) {
			throw new EmptyResultException(exception.getMessage(), exception);
		}
		catch (NonUniqueResultException exception) {
			throw new jakarta.data.exceptions.NonUniqueResultException(exception.getMessage(), exception);
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * Find {@link Rol} by {@link Rol#id id}.
	 *
	 * @see org.utp.web.back.ejb.repositories.RolRepository#findById(Integer)
	 **/
	@Override
	public Optional<Rol> findById(@Nonnull Integer id) {
		if (id == null) throw new IllegalArgumentException("Null id");
		try {
			return ofNullable(session.get(Rol.class, id));
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	@PersistenceUnit
	private EntityManagerFactory sessionFactory;
	
	@PostConstruct
	private void openSession() {
		session = sessionFactory.unwrap(SessionFactory.class).openStatelessSession();
	}
	
	@PreDestroy
	private void closeSession() {
		session.close();
	}
	
	@Inject
	RolRepository_() {
	}
	
	@Override
	public Rol update(@Nonnull Rol entity) {
		if (entity == null) throw new IllegalArgumentException("Null entity");
		try {
			session.update(entity);
			return entity;
		}
		catch (StaleStateException exception) {
			throw new OptimisticLockingFailureException(exception.getMessage(), exception);
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}

}

