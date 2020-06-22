package com.ale.lab1.comparacoes;

import java.util.Comparator;

import com.ale.lab1.entidades.Disciplina;


public class DisciplinaComparator<T> implements Comparator<Disciplina> {

	@Override
	public int compare(Disciplina o1, Disciplina o2) {
		return o1.compareTo(o2);
	}

}