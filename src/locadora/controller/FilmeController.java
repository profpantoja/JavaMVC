/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.controller;

import java.util.ArrayList;
import locadora.dao.ExceptionDAO;
import locadora.model.Filme;

/**
 *
 * @author Tielle Alexandre
 */
public class FilmeController {

    public boolean cadastrarFilme(String titulo, String genero, String sinopse, Integer duração) throws ExceptionDAO {

    if (titulo != null && titulo.length() > 0 && genero != null && genero.length() > 0 && sinopse != null && sinopse.length() > 0 && duração > 0){
        Filme filme = new Filme(titulo, genero, sinopse, duração);
        filme.cadastrarFilme(filme);
        return true;       
    }   
        return false;
    }
    
    public ArrayList<Filme> listarFilmes(String nome) throws ExceptionDAO {
        return new Filme().listarFilmes(nome);
    }

    public boolean alterarFilme(int codFilme, String titulo, String genero, String sinopse, Integer duração) throws ExceptionDAO {
        if (titulo != null && titulo.length() > 0 && genero != null && genero.length() > 0 && sinopse != null && sinopse.length() > 0 && duração > 0){
            Filme filme = new Filme(titulo, genero, sinopse, duração);
            filme.setCodFilme(codFilme);
            filme.alterarFilme(filme);
            return true;       
        }   
        return false;
    }  

    public boolean apagarFilme(int codFilme) throws ExceptionDAO {
        if (codFilme == 0)
            return false;
        else {
            Filme filme = new Filme();
            filme.setCodFilme(codFilme);
            filme.apagarFilme(filme);
            return true;
        }
    }
    
}
