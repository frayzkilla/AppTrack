package com.motoshkin.apptrack.controllers;

import com.motoshkin.apptrack.models.Film;
import com.motoshkin.apptrack.repository.FilmRepository;
import com.motoshkin.apptrack.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dataTask")
@RequiredArgsConstructor
public class FilmController {
    private final FilmRepository filmRepository;
    private final GenreRepository genreRepository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("genres", genreRepository.findAll());
        return "filmsIndex";
    }

    @GetMapping("/films")
    public String showFilms(
            @RequestParam Long genreId,
            @RequestParam String sortBy,
            Pageable pageable,
            Model model
    ) {
        Sort sort = switch (sortBy) {
            case "title" -> Sort.by(Sort.Direction.ASC, "title");
            case "rating" -> Sort.by(Sort.Direction.DESC, "rating");
            case "year" -> Sort.by(Sort.Direction.DESC, "year");
            default -> Sort.unsorted();
        };

        Pageable adjustedPageable = PageRequest.of(pageable.getPageNumber(), 5, sort);
        Page<Film> filmsPage = filmRepository.findByGenreId(genreId, adjustedPageable);

        model.addAttribute("page", filmsPage);
        model.addAttribute("genreId", genreId);
        model.addAttribute("sortBy", sortBy);
        return "list";
    }

    @GetMapping("/films/{id}")
    public String filmDetails(@PathVariable Long id, Model model) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid film Id:" + id));
        model.addAttribute("film", film);
        return "detail";
    }
}
