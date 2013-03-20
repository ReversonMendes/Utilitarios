package br.com.reverson.ControleDeTurmas;

import java.util.ArrayList;
import java.util.List;

public class Instituicao {

    private List<Turma> turmas; 
   // turmas = new ArrayList<Turma>();
    
    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public void addTurma(Turma turma){
        turmas.add(turma);
    }

}