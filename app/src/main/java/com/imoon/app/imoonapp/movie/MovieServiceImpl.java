package com.imoon.app.imoonapp.movie;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-26.
 */

public class MovieServiceImpl implements MovieService {
    MovieDAO dao;

    public MovieServiceImpl(Context context) {
        this.dao = new MovieDAO(context);
    }

    @Override
    public void add(MovieDTO param) {
        dao.add(param);
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public MovieDTO findOne(String key) {
        return dao.findOne(key);
    }

    @Override
    public ArrayList<MovieDTO> findBy(MovieDTO param) {
        return dao.findBy(param);
    }

    @Override
    public ArrayList<MovieDTO> list() {
        return dao.list();
    }

    @Override
    public void update(MovieDTO param) {
        dao.update(param);
    }

    @Override
    public void delete(String key) {
        dao.delete(key);
    }
}
