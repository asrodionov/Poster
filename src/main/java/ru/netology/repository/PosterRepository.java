package ru.netology.repository;

import ru.netology.domain.PosterItem;

public class PosterRepository {
    private PosterItem[] items = new PosterItem[0];

    public void save(PosterItem item) {
        int length = items.length + 1;
        PosterItem[] tmp = new PosterItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PosterItem[] findAll() {
        return items;
    }

    public PosterItem[] findById(int id) {
        //int length = items.length - 1;
        PosterItem[] tmp = new PosterItem[1];
        int index = 0;
        for (PosterItem item : items) {
            if (item.getId() == id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return items;
    }

    public void removeAll() {

        items = new PosterItem[0];
    }

    public void removeById(int id) {
        int length = items.length - 1;
        PosterItem[] tmp = new PosterItem[length];
        int index = 0;
        for (PosterItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
