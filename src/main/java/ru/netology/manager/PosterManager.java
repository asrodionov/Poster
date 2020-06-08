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

    private int amountMovie = 10;

    public void add(PosterItem item) {
        repository.save(item);
    }

    public PosterItem[] getMovie() {

        PosterItem[] items = repository.findAll();
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

    public void findById(int id) {
        repository.findById(id);
    }

    public void findAll() {
        repository.findAll();
    }

}
