package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;
import ru.netology.manager.PosterManager;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterRepositoryTest {
    private PosterRepository repository = new PosterRepository();

    private PosterItem first = new PosterItem(1,1,"Бладшот","боевик","img1");
    private PosterItem second = new PosterItem(2,2,"Вперед","мультфильм","img2");
    private PosterItem third = new PosterItem(3,3,"Отель Белград","комедия","img3");
    private PosterItem fourth = new PosterItem(4,4,"Бладшот","боевик","img1");
    private PosterItem fifth = new PosterItem(5,5,"Вперед","мультфильм","img2");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }

    @Test
    public void shouldSaveAndFindAll() {

        PosterItem[] actual = repository.findAll();
        PosterItem[] expected = new PosterItem[]{first,second,third,fourth,fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {

        repository.findById(2);

        PosterItem[] actual = repository.findAll();
        PosterItem[] expected = new PosterItem[]{second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByNonId() {

        repository.findById(20);

        PosterItem[] actual = repository.findAll();
        PosterItem[] expected = new PosterItem[]{null};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        repository.removeById(2);

        PosterItem[] actual = repository.findAll();
        PosterItem[] expected = new PosterItem[]{first,third,fourth,fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {

        repository.removeAll();

        PosterItem[] actual = repository.findAll();
        PosterItem[] expected = new PosterItem[0];

        assertArrayEquals(expected, actual);
    }
}