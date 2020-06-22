package com.ale.lab1.controladores;

import com.ale.lab1.servicos.DisciplinaService;

import java.util.ArrayList;


import com.ale.lab1.entidades.Disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class disciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;

    //cria uma disciplina
    @PostMapping("/v1/api/disciplinas")
    public ResponseEntity<Integer> criarDisciplina(@RequestParam(value = "nome") String nome, @RequestParam(value = "nota") int nota){
        return new ResponseEntity<Integer>(disciplinaService.criarDisciplina(nome, nota), HttpStatus.OK);
    } 

    //retorna as disciplinas não ordenadas
    @GetMapping("/v1/api/disciplinas")
    public ResponseEntity<ArrayList<Disciplina>> getDisciplinas(){
        return new ResponseEntity<ArrayList<Disciplina>>( disciplinaService.getDisciplinasList(), HttpStatus.OK);

    } 

    //retorna uma disciplina por meio do id da mesma
    @GetMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> getDisciplina(@PathVariable int id){
        Disciplina d = disciplinaService.getDisciplina(id);
        if(d != null){
            return new ResponseEntity<Disciplina>(d, HttpStatus.OK);
        }else{
            return new ResponseEntity<Disciplina>(d, HttpStatus.BAD_REQUEST);
        }
    }

    //modifica o nome de uma disciplina por meio do id da mesma 
    @PutMapping("/v1/api/disciplinas/{id}/nome")
    public ResponseEntity<Disciplina> setNomeDisciplina(@PathVariable int id, @RequestParam(value="nome") String nome){
        Disciplina d = disciplinaService.setNomeDisciplina(id, nome);
        if(d != null){
            return new ResponseEntity<Disciplina>(d, HttpStatus.OK);
        }else{
            return new ResponseEntity<Disciplina>(d, HttpStatus.BAD_REQUEST);
        } 
    }

    //modifica a nota de uma disciplina por meio do id da mesma 
    @PutMapping("/v1/api/disciplinas/{id}/nota")
    public ResponseEntity<Disciplina> setNotaDisciplina(@PathVariable int id, @RequestParam(value="nota") int nota){
        Disciplina d = disciplinaService.setNotaDisciplina(id, nota);
        if(d != null){
            return new ResponseEntity<Disciplina>(d, HttpStatus.OK);
        }else{
            return new ResponseEntity<Disciplina>(d, HttpStatus.BAD_REQUEST);
        } 
    }

    //deleta uma disciplina por meio do id da mesma 
    @DeleteMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> deleteDisciplina(@PathVariable int id){
        Disciplina d = disciplinaService.deleteDisciplina(id);
        if(d != null){
            return new ResponseEntity<Disciplina>(d, HttpStatus.OK);
        }else{
            return new ResponseEntity<Disciplina>(d, HttpStatus.BAD_REQUEST);
        }
    }

    //retorna um ranking de disciplinas, ordenando da maior nota para a menor
    @GetMapping("/v1/api/disciplinas/ranking")
    public ResponseEntity<ArrayList<Disciplina>> getDisciplinasRanking() {
        return new ResponseEntity<ArrayList<Disciplina>>(disciplinaService.getDisciplinaRanking(), HttpStatus.OK);
    }
}