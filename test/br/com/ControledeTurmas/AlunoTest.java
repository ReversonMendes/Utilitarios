
package br.com.ControledeTurmas;

import br.com.reverson.ControleDeTurmas.Aluno;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

//Criar Testes para Todos os metodos do Controle de turmas
public class AlunoTest {
    Aluno al;
    
    @Before
    public void init()
    {
        al = new Aluno(1,"");
        al.setNotaG1(1);
        al.setNotaG2(10);
    }
    
    @Test
   public void calculaMedia(){
       al.setNotaG1(1);
       al.setNotaG2(10);
       
       assertEquals(7,al.calcularMedia(),0);
       
   }
    
    @Test
    public void nomeNullo(){
        al.setNotaG1(1);
        al.setNotaG2(10);
        
        assertEquals("",al.getNome());
        assertEquals(1,al.getRa());
        
    }
    
}