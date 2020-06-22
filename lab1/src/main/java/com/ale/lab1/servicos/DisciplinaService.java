package com.ale.lab1.servicos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ale.lab1.entidades.Disciplina;

@Service
public class DisciplinaService {
    private Map<Integer, Disciplina> disciplinas;

    DisciplinaService(){
        disciplinas = new HashMap<Integer, Disciplina>();
    }

    public Disciplina getDisciplina(int id){
        return disciplinas.get(id); 
    }
    
    public int criarDisciplina(String nome, int nota){
        int id = disciplinas.size() + 1;
        Disciplina disciplina = new Disciplina(id, nome, nota);
        disciplinas.put(disciplina.getId(), disciplina);
        return disciplina.getId();
    }

    public Map<Integer, Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Disciplina setNomeDisciplina(int id, String nome){
        disciplinas.get(id).setNome(nome);
        return getDisciplina(id);
    }

    public Disciplina setNotaDisciplina(int id, int nota){
        disciplinas.get(id).setNota(nota);
        return getDisciplina(id);
    }

    public void setDisciplinas(Map<Integer, Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Disciplina deleteDisciplina(int id){
        Disciplina d = disciplinas.get(id);
        if(d != null){
            disciplinas.remove(id);
            return d;
        }else{
            return d;
        }
    }

    public ArrayList<Disciplina> getDisciplinasList(){
        ArrayList<Disciplina> disciplinasList = new ArrayList<Disciplina>();
        Set<Integer> chaves = disciplinas.keySet();
        for(Integer chave: chaves){
            disciplinasList.add(disciplinas.get(chave));
        }
        return disciplinasList;
    }

    public ArrayList<Disciplina> getDisciplinaRanking(){
        ArrayList<Disciplina> d = getDisciplinasList();
        Collections.sort(d);
        return d;
    }
}