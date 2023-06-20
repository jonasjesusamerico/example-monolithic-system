package br.com.jonasdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

interface ILancamentoRepository extends JpaRepository<LancamentoModel, Long> {
}
