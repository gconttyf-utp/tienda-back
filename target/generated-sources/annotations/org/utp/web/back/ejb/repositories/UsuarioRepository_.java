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
import org.utp.web.back.ejb.entities.Usuario;
import org.utp.web.back.ejb.entities.Usuario_;

@RequestScoped
@Generated("org.hibernate.processor.HibernateProcessor")
public class UsuarioRepository_ implements UsuarioRepository {

	static final String FIND_BY_ESTADO_IN_Collection = "SELECT o FROM Usuario o WHERE o.estado in (:estados)";

	
	@Override
	public void delete(@Nonnull Usuario entity) {
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
	
	@Override
	public void deleteAll(@Nonnull List<? extends Usuario> entities) {
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
	
	/**
	 * Find {@link Usuario} by {@link Usuario#usuario usuario} and {@link Usuario#estado estado}.
	 *
	 * @see org.utp.web.back.ejb.repositories.UsuarioRepository#findByUsuarioAndEstado(String,Integer)
	 **/
	@Override
	public Optional<Usuario> findByUsuarioAndEstado(String usuario, Integer estado) {
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createQuery(Usuario.class);
		var _entity = _query.from(Usuario.class);
		_query.where(
				usuario==null
					? _entity.get(Usuario_.usuario).isNull()
					: _builder.equal(_entity.get(Usuario_.usuario), usuario), 
				estado==null
					? _entity.get(Usuario_.estado).isNull()
					: _builder.equal(_entity.get(Usuario_.estado), estado)
		);
		try {
			return session.createSelectionQuery(_query)
				.uniqueResultOptional();
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	protected @Nonnull StatelessSession session;
	
	public UsuarioRepository_(@Nonnull StatelessSession session) {
		this.session = session;
	}
	
	public @Nonnull StatelessSession session() {
		return session;
	}
	
	@Override
	public Usuario save(@Nonnull Usuario entity) {
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
	 * Execute the query {@value #FIND_BY_ESTADO_IN_Collection}.
	 *
	 * @see org.utp.web.back.ejb.repositories.UsuarioRepository#findByEstadoIn(Collection)
	 **/
	@Override
	public List<Usuario> findByEstadoIn(Collection<Integer> estados) {
		try {
			return session.createSelectionQuery(FIND_BY_ESTADO_IN_Collection, Usuario.class)
				.setParameter("estados", estados)
				.getResultList();
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * Find {@link Usuario}.
	 *
	 * @see org.utp.web.back.ejb.repositories.UsuarioRepository#findAll()
	 **/
	@Override
	public Stream<Usuario> findAll() {
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createQuery(Usuario.class);
		var _entity = _query.from(Usuario.class);
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
	public Usuario actualizar(@Nonnull Usuario entidad) {
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
	public Usuario insertar(@Nonnull Usuario entidad) {
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
	public Usuario insert(@Nonnull Usuario entity) {
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
	 * Find {@link Usuario}.
	 *
	 * @see org.utp.web.back.ejb.repositories.UsuarioRepository#findAll(PageRequest,Order)
	 **/
	@Override
	public Page<Usuario> findAll(PageRequest pageRequest, Order<Usuario> sortBy) {
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createQuery(Usuario.class);
		var _entity = _query.from(Usuario.class);
		_query.where(
		);
		var _orders = new ArrayList<org.hibernate.query.Order<? super Usuario>>();
		for (var _sort : sortBy.sorts()) {
			_orders.add(by(Usuario.class, _sort.property(),
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
	
	/**
	 * Find {@link Usuario} by {@link Usuario#id id}.
	 *
	 * @see org.utp.web.back.ejb.repositories.UsuarioRepository#deleteById(Integer)
	 **/
	@Override
	public void deleteById(@Nonnull Integer id) {
		if (id == null) throw new IllegalArgumentException("Null id");
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createCriteriaDelete(Usuario.class);
		var _entity = _query.from(Usuario.class);
		_query.where(
				_builder.equal(_entity.get(Usuario_.id), id)
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
	 * Find {@link Usuario} by {@link Usuario#id id}.
	 *
	 * @see org.utp.web.back.ejb.repositories.UsuarioRepository#findById(Integer)
	 **/
	@Override
	public Optional<Usuario> findById(@Nonnull Integer id) {
		if (id == null) throw new IllegalArgumentException("Null id");
		try {
			return ofNullable(session.get(Usuario.class, id));
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
	UsuarioRepository_() {
	}
	
	@Override
	public Usuario update(@Nonnull Usuario entity) {
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

