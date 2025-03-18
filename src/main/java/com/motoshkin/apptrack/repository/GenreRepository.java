package com.motoshkin.apptrack.repository;

import com.motoshkin.apptrack.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {}
