package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PosterItem;
import ru.netology.manager.PosterManager;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PosterManagerLessMovieTest {
    @Mock
    private PosterRepository repository;
    @InjectMocks
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
    public void shouldGetTenMovie() {

        PosterItem[] returned = new PosterItem[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        PosterItem[] expected = new PosterItem[]{fifth,fourth,third,second,first};
        PosterItem[] actual = manager.getMovie();

        assertArrayEquals(expected, actual);
    }

}