package Project.Api.Emprestimo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CrudGenericRepository<T, ID> extends JpaRepository<T, ID> {
	Optional<T> findById(ID id);
	
    List<T> findAll();

    T saveEntity(T entity);

    void delete(T entity);

    void deleteById(ID id);
}
