package com.dawidkotarba.playground.model.entities;

import java.io.Serializable;

/**
 * Created by Dawid Kotarba on 19.12.2015.
 * @param <T>
 */
public interface HasId<T extends Serializable> extends Serializable {

    T getId();
}
