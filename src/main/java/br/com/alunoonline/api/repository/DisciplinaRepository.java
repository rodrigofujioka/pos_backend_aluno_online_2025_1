package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    List<Disciplina> findByProfessorId(Long professorId);

    List<Disciplina> findDisciplinaByCargaHoraria(Integer cargaHoraria);

    @Query(value = "select d from Disciplina d where d.cargaHoraria=:cargaHoraria")
    List<Disciplina> buscarDisciplinasPorCargaHoraria(@Param("cargaHoraria") Integer cargaHoraria);

    List<Disciplina> findByProfessor_NomeAndCargaHoraria(String nome, Integer cargaHoraria);

    @Query(value = "select d from Disciplina d where d.professor.nome=:nomeProfessor " +
            "AND d.cargaHoraria=:cargaHoraria order by d.nome ASC")
    List<Disciplina> buscarDisciplinaPorProfessorECargaGoraria(String nome, Integer cargaHoraria);

    List<Disciplina> findDisciplinasByOrderByNomeDesc();

}
