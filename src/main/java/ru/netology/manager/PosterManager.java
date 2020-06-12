package ru.netology.manager;

import ru.netology.domain.PosterItem;

public class PosterManager {
    private PosterItem[] items = new PosterItem[0];

    public PosterManager() {
    }

    public PosterManager(int amountMovie) {
        this.amountMovie = amountMovie;
    }

    private int amountMovie;

    public void add(PosterItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        PosterItem[] tmp = new PosterItem[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PosterItem[] getMovie() {

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

}
