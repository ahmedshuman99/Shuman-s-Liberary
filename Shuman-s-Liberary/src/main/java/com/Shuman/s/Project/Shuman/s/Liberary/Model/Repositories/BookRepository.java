package com.Shuman.s.Project.Shuman.s.Liberary.Model.Repositories;

import com.Shuman.s.Project.Shuman.s.Liberary.Model.Entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity , Integer> {
}
