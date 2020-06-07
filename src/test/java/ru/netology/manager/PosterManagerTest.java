package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;
import ru.netology.manager.PosterManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {
    private PosterManager manager = new PosterManager();
    private PosterItem first = new PosterItem(1,1,"Бладшот","боевик","img1");
    private PosterItem second = new PosterItem(2,2,"Вперед","мультфильм","img2");
    private PosterItem third = new PosterItem(3,3,"Отель Белград","комедия","img3");
    private PosterItem fourth = new PosterItem(4,4,"Бладшот","боевик","img1");
    private PosterItem fifth = new PosterItem(5,5,"Вперед","мультфильм","img2");
    private PosterItem sixth = new PosterItem(6,6,"Отель Белград","комедия","img3");
    private PosterItem seventh = new PosterItem(7,7,"Бладшот","боевик","img1");
    private PosterItem eighth = new PosterItem(8,8,"Вперед","мультфильм","img2");
    private PosterItem ninth = new PosterItem(9,9,"Отель Белград","комедия","img3");
    private PosterItem tenth = new PosterItem(10,10,"Бладшот","боевик","img1");
    private PosterItem eleventh = new PosterItem(11,11,"Вперед","мультфильм","img2");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
    }

    @Test
    public void shouldGetTenMovie() {

        PosterItem[] actual = manager.getMovie();
        PosterItem[] expected = new PosterItem[]{eleventh,tenth,ninth,eighth,seventh,sixth,fifth,fourth,third,second};

        assertArrayEquals(expected, actual);
    }

}