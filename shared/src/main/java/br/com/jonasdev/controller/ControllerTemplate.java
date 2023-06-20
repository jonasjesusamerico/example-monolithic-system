package br.com.jonasdev.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

interface ControllerTemplate<E> {

    Page<E> findAll(Pageable pageable);

    ResponseEntity<E> findById(Long id);

    ResponseEntity<E> save(E e);

    ResponseEntity<E> update(E e);

    ResponseEntity<E> delete(Long id);


}