package com.imoon.app.imoonapp.movie;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-26.
 */

public interface MovieService {
    public void add(MovieDTO param);
    public int count();
    public MovieDTO findOne(String key);
    public ArrayList<MovieDTO> findBy(MovieDTO param);
    public ArrayList<MovieDTO> list();
    public void update(MovieDTO param);
    public void delete(String key);
}
