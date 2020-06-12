package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerCustomMovieTest {
    private PosterManager manager = new PosterManager(2);
    private PosterItem first = new PosterItem(1,1,"Бладшот","боевик","img1");
    private PosterItem second = new PosterItem(2,2,"Вперед","мультфильм","img2");
    private PosterItem third = new PosterItem(3,3,"Отель Белград","комедия","img3");
    private PosterItem fourth = new PosterItem(4,4,"Бладшот","боевик","img1");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    public void shouldGetFiveMovie() {

        PosterItem[] actual = manager.getMovie();
        PosterItem[] expected = new PosterItem[]{fourth,third};

        assertArrayEquals(expected, actual);
    }
}