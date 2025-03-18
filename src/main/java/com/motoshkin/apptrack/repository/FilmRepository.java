package com.motoshkin.apptrack.repository;

import com.motoshkin.apptrack.models.Department;
import com.motoshkin.apptrack.models.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long>  {

    Page<Film> findByGenreId(Long genreId, Pageable pageable);
}
