package ru.netology.manager;

import ru.netology.domain.PosterItem;
import ru.netology.repository.PosterRepository;

public class PosterManager {
    private PosterRepository repository;

    private PosterManager(PosterRepository repository) {
        this.repository = repository;
    }

    public PosterManager() {
    }

    public PosterManager(int amountMovie) {
        this.amountMovie = amountMovie;
    }

    private int amountMovie;

    public void add(PosterItem item) {
        repository.save(item);
    }

    public PosterItem[] getMovie() {

        PosterItem[] items = repository.findAll();

        if (items.length < 10 & amountMovie == 0) {
            amountMovie = items.length;
        }
        if (items.length >= 10 & amountMovie == 0) {
            amountMovie = 10;
        }

        PosterItem[] result = new PosterItem[amountMovie];

        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < amountMovie; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public PosterItem[] findById(int id) { return repository.findById(id); }

    public PosterItem[] findAll() {
        return repository.findAll();
    }

}
