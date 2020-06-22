package com.ale.lab1.entidades;

public class Disciplina implements Comparable<Disciplina>{
    
    
    private int id;
    private String nome;
    private int nota;

    public Disciplina(int id,String nome, int nota){
        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }
    public int getId() {
        return this.id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
	public int compareTo(Disciplina o) {
		if (this.nota > o.nota) {
			return -1;
		} else if (this.nota < o.nota) {
			return 1;
		}
		return 0;
	}
    
}