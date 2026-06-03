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
import org.utp.web.back.ejb.entities.Producto;
import org.utp.web.back.ejb.entities.Producto_;

@RequestScoped
@Generated("org.hibernate.processor.HibernateProcessor")
public class ProductoRepository_ implements ProductoRepository {

	static final String FIND_BY_MARCA_ID_AND_ESTADO_IN_Integer_Collection = "SELECT o FROM Producto o WHERE o.marca.id = :marca AND o.estado in (:estados)";
	static final String LISTAR_POR_ID_CATEGORIA_AND_MARCA_Integer_Integer = "SELECT p FROM Producto p WHERE p.categoria.id = :idCategoria AND p.marca.id = :idMarca";
	static final String FIND_BY_CATEGORIA_ID_AND_MARCA_ID_AND_ESTADO_IN_Integer_Integer_Collection = "SELECT o FROM Producto o WHERE o.categoria.id = :categoria AND o.marca.id = :marca AND o.estado in (:estados)";
	static final String FIND_BY_CATEGORIA_ID_AND_ESTADO_IN_Integer_Collection = "SELECT o FROM Producto o WHERE o.categoria.id = :categoria AND o.estado in (:estados)";
	static final String LISTAR_POR_ID_CATEGORIA_Integer = "SELECT p FROM Producto p WHERE p.categoria.id = :idCategoria";
	static final String FIND_BY_CATEGORIA_ID_IN_AND_OFERTA_IN_AND_ESTADO_IN_Collection_Collection_Collection = "SELECT o FROM Producto o WHERE o.categoria.id in (:categorias) AND o.oferta in (:ofertas) AND o.estado in (:estados)";
	static final String FIND_BY_OFERTA_IN_AND_ESTADO_IN_Collection_Collection = "SELECT o FROM Producto o WHERE o.oferta in (:ofertas) AND o.estado in (:estados)";

	
	/**
	 * Execute the query {@value #FIND_BY_MARCA_ID_AND_ESTADO_IN_Integer_Collection}.
	 *
	 * @see org.utp.web.back.ejb.repositories.ProductoRepository#findByMarcaIdAndEstadoIn(Integer,Collection)
	 **/
	@Override
	public List<Producto> findByMarcaIdAndEstadoIn(Integer marca, Collection<Integer> estados) {
		try {
			return session.createSelectionQuery(FIND_BY_MARCA_ID_AND_ESTADO_IN_Integer_Collection, Producto.class)
				.setParameter("marca", marca)
				.setParameter("estados", estados)
				.getResultList();
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	protected @Nonnull StatelessSession session;
	
	public ProductoRepository_(@Nonnull StatelessSession session) {
		this.session = session;
	}
	
	public @Nonnull StatelessSession session() {
		return session;
	}
	
	/**
	 * Execute the query {@value #LISTAR_POR_ID_CATEGORIA_AND_MARCA_Integer_Integer}.
	 *
	 * @see org.utp.web.back.ejb.repositories.ProductoRepository#listarPorIdCategoriaAndMarca(Integer,Integer)
	 **/
	@Override
	public List<Producto> listarPorIdCategoriaAndMarca(Integer idCategoria, Integer idMarca) {
		try {
			return session.createSelectionQuery(LISTAR_POR_ID_CATEGORIA_AND_MARCA_Integer_Integer, Producto.class)
				.setParameter("idCategoria", idCategoria)
				.setParameter("idMarca", idMarca)
				.getResultList();
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * Execute the query {@value #FIND_BY_CATEGORIA_ID_AND_MARCA_ID_AND_ESTADO_IN_Integer_Integer_Collection}.
	 *
	 * @see org.utp.web.back.ejb.repositories.ProductoRepository#findByCategoriaIdAndMarcaIdAndEstadoIn(Integer,Integer,Collection)
	 **/
	@Override
	public List<Producto> findByCategoriaIdAndMarcaIdAndEstadoIn(Integer categoria, Integer marca, Collection<Integer> estados) {
		try {
			return session.createSelectionQuery(FIND_BY_CATEGORIA_ID_AND_MARCA_ID_AND_ESTADO_IN_Integer_Integer_Collection, Producto.class)
				.setParameter("categoria", categoria)
				.setParameter("marca", marca)
				.setParameter("estados", estados)
				.getResultList();
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public void delete(@Nonnull Producto entity) {
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
	 * Execute the query {@value #FIND_BY_CATEGORIA_ID_AND_ESTADO_IN_Integer_Collection}.
	 *
	 * @see org.utp.web.back.ejb.repositories.ProductoRepository#findByCategoriaIdAndEstadoIn(Integer,Collection)
	 **/
	@Override
	public List<Producto> findByCategoriaIdAndEstadoIn(Integer categoria, Collection<Integer> estados) {
		try {
			return session.createSelectionQuery(FIND_BY_CATEGORIA_ID_AND_ESTADO_IN_Integer_Collection, Producto.class)
				.setParameter("categoria", categoria)
				.setParameter("estados", estados)
				.getResultList();
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * Execute the query {@value #LISTAR_POR_ID_CATEGORIA_Integer}.
	 *
	 * @see org.utp.web.back.ejb.repositories.ProductoRepository#listarPorIdCategoria(Integer)
	 **/
	@Override
	public List<Producto> listarPorIdCategoria(Integer idCategoria) {
		try {
			return session.createSelectionQuery(LISTAR_POR_ID_CATEGORIA_Integer, Producto.class)
				.setParameter("idCategoria", idCategoria)
				.getResultList();
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * Execute the query {@value #FIND_BY_CATEGORIA_ID_IN_AND_OFERTA_IN_AND_ESTADO_IN_Collection_Collection_Collection}.
	 *
	 * @see org.utp.web.back.ejb.repositories.ProductoRepository#findByCategoriaIdInAndOfertaInAndEstadoIn(Collection,Collection,Collection)
	 **/
	@Override
	public List<Producto> findByCategoriaIdInAndOfertaInAndEstadoIn(Collection<Integer> categorias, Collection<Integer> ofertas, Collection<Integer> estados) {
		try {
			return session.createSelectionQuery(FIND_BY_CATEGORIA_ID_IN_AND_OFERTA_IN_AND_ESTADO_IN_Collection_Collection_Collection, Producto.class)
				.setParameter("categorias", categorias)
				.setParameter("ofertas", ofertas)
				.setParameter("estados", estados)
				.getResultList();
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public Producto save(@Nonnull Producto entity) {
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
	 * Find {@link Producto}.
	 *
	 * @see org.utp.web.back.ejb.repositories.ProductoRepository#findAll()
	 **/
	@Override
	public Stream<Producto> findAll() {
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createQuery(Producto.class);
		var _entity = _query.from(Producto.class);
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
	
	/**
	 * Execute the query {@value #FIND_BY_OFERTA_IN_AND_ESTADO_IN_Collection_Collection}.
	 *
	 * @see org.utp.web.back.ejb.repositories.ProductoRepository#findByOfertaInAndEstadoIn(Collection,Collection)
	 **/
	@Override
	public List<Producto> findByOfertaInAndEstadoIn(Collection<Integer> ofertas, Collection<Integer> estados) {
		try {
			return session.createSelectionQuery(FIND_BY_OFERTA_IN_AND_ESTADO_IN_Collection_Collection, Producto.class)
				.setParameter("ofertas", ofertas)
				.setParameter("estados", estados)
				.getResultList();
		}
		catch (PersistenceException exception) {
			throw new DataException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public Producto insertar(@Nonnull Producto entidad) {
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
	public void deleteAll(@Nonnull List<? extends Producto> entities) {
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
	 * Find {@link Producto}.
	 *
	 * @see org.utp.web.back.ejb.repositories.ProductoRepository#findAll(PageRequest,Order)
	 **/
	@Override
	public Page<Producto> findAll(PageRequest pageRequest, Order<Producto> sortBy) {
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createQuery(Producto.class);
		var _entity = _query.from(Producto.class);
		_query.where(
		);
		var _orders = new ArrayList<org.hibernate.query.Order<? super Producto>>();
		for (var _sort : sortBy.sorts()) {
			_orders.add(by(Producto.class, _sort.property(),
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
	
	@Override
	public Producto actualizar(@Nonnull Producto entidad) {
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
	public Producto insert(@Nonnull Producto entity) {
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
	
	/**
	 * Find {@link Producto} by {@link Producto#id id}.
	 *
	 * @see org.utp.web.back.ejb.repositories.ProductoRepository#deleteById(Integer)
	 **/
	@Override
	public void deleteById(@Nonnull Integer id) {
		if (id == null) throw new IllegalArgumentException("Null id");
		var _builder = session.getFactory().getCriteriaBuilder();
		var _query = _builder.createCriteriaDelete(Producto.class);
		var _entity = _query.from(Producto.class);
		_query.where(
				_builder.equal(_entity.get(Producto_.id), id)
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
	
	@Override
	public Producto update(@Nonnull Producto entity) {
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
	
	/**
	 * Find {@link Producto} by {@link Producto#id id}.
	 *
	 * @see org.utp.web.back.ejb.repositories.ProductoRepository#findById(Integer)
	 **/
	@Override
	public Optional<Producto> findById(@Nonnull Integer id) {
		if (id == null) throw new IllegalArgumentException("Null id");
		try {
			return ofNullable(session.get(Producto.class, id));
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
	ProductoRepository_() {
	}

}

