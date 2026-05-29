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
import org.utp.web.back.ejb.entities.Almacen;
import org.utp.web.back.ejb.entities.Almacen_;

@RequestScoped
@Generated("org.hibernate.processor.HibernateProcessor")
public class AlmacenRepository_ implements AlmacenRepository {

	static final String LISTAR_POR_ID_TIENDA_Integer = "SELECT a FROM Almacen a WHERE a.tienda.id = :idTienda";

	
	@Override
	public void delete(@Nonnull Almacen entity) {
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
	 * Find {@link Almacen}.
	 *
	 * @see org.utp.web.back.ejb.repositories.AlmacenRepository#findAll(PageRequest,Order)
	 **/
	@Override
	public Page<Almacen> findAll(PageRequest pageRequest, Order<Almacen> sortBy) {
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createQuery(Almacen.class);
		var _entity = _query.from(Almacen.class);
		_query.where(
		);
		var _orders = new ArrayList<org.hibernate.query.Order<? super Almacen>>();
		for (var _sort : sortBy.sorts()) {
			_orders.add(by(Almacen.class, _sort.property(),
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
	
	protected @Nonnull StatelessSession session;
	
	public AlmacenRepository_(@Nonnull StatelessSession session) {
		this.session = session;
	}
	
	public @Nonnull StatelessSession session() {
		return session;
	}
	
	@Override
	public Almacen save(@Nonnull Almacen entity) {
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
	
	/**
	 * Find {@link Almacen}.
	 *
	 * @see org.utp.web.back.ejb.repositories.AlmacenRepository#findAll()
	 **/
	@Override
	public Stream<Almacen> findAll() {
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createQuery(Almacen.class);
		var _entity = _query.from(Almacen.class);
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
	public Almacen insertar(@Nonnull Almacen entidad) {
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
	
	@Override
	public Almacen actualizar(@Nonnull Almacen entidad) {
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
	public void deleteAll(@Nonnull List<? extends Almacen> entities) {
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
	
	@Override
	public Almacen insert(@Nonnull Almacen entity) {
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
	 * Find {@link Almacen} by {@link Almacen#id id}.
	 *
	 * @see org.utp.web.back.ejb.repositories.AlmacenRepository#deleteById(Integer)
	 **/
	@Override
	public void deleteById(@Nonnull Integer id) {
		if (id == null) throw new IllegalArgumentException("Null id");
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createCriteriaDelete(Almacen.class);
		var _entity = _query.from(Almacen.class);
		_query.where(
				_builder.equal(_entity.get(Almacen_.id), id)
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
	 * Execute the query {@value #LISTAR_POR_ID_TIENDA_Integer}.
	 *
	 * @see org.utp.web.back.ejb.repositories.AlmacenRepository#listarPorIdTienda(Integer)
	 **/
	@Override
	public List<Almacen> listarPorIdTienda(Integer idTienda) {
		try {
			return session.createSelectionQuery(LISTAR_POR_ID_TIENDA_Integer, Almacen.class)
				.setParameter("idTienda", idTienda)
				.getResultList();
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * Find {@link Almacen} by {@link Almacen#id id}.
	 *
	 * @see org.utp.web.back.ejb.repositories.AlmacenRepository#findById(Integer)
	 **/
	@Override
	public Optional<Almacen> findById(@Nonnull Integer id) {
		if (id == null) throw new IllegalArgumentException("Null id");
		try {
			return ofNullable(session.get(Almacen.class, id));
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
	AlmacenRepository_() {
	}
	
	@Override
	public Almacen update(@Nonnull Almacen entity) {
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

