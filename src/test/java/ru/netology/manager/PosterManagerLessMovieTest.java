package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;
import ru.netology.manager.PosterManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerLessMovieTest {
    private PosterManager manager = new PosterManager(5);
    private PosterItem first = new PosterItem(1,1,"Бладшот","боевик","img1");
    private PosterItem second = new PosterItem(2,2,"Вперед","мультфильм","img2");
    private PosterItem third = new PosterItem(3,3,"Отель Белград","комедия","img3");
    private PosterItem fourth = new PosterItem(4,4,"Бладшот","боевик","img1");
    private PosterItem fifth = new PosterItem(5,5,"Вперед","мультфильм","img2");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void shouldGetFiveMovie() {

        PosterItem[] actual = manager.getMovie();
        PosterItem[] expected = new PosterItem[]{fifth,fourth,third,second,first};

        assertArrayEquals(expected, actual);
    }
}