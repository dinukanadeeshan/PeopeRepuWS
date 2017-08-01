/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.controller;

import java.util.List;

/**
 *
 * @author DI_SH
 * @param <I> Id of the entity
 * @param <T> class of the entity
 */
public interface EntityController<I,T> {
    void insert(T entity);
    void delete(I id);
    void update(T entity);
    T search(I id);
    List<T> searchAll();
}
