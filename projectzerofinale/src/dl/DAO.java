package dl;


public interface DAO<T,K> {
	T findById(K id);
	Iterable<T> findAll();
	void add(T newObject);
	void update(T newObject);
}
