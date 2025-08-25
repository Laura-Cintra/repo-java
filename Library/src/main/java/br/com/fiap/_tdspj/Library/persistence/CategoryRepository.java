package br.com.fiap._tdspj.Library.persistence;

import br.com.fiap._tdspj.Library.domainmodel.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
