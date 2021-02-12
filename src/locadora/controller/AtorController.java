/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.controller;

import java.util.ArrayList;
import locadora.dao.ExceptionDAO;
import locadora.model.Ator;

/**
 *
 * @author Tielle Alexandre
 */
public class AtorController {

    public boolean cadastrarAtor(String nome, String nacionalidade) throws ExceptionDAO {

        if (nome != null && nome.length() > 0 && nacionalidade != null && nacionalidade.length() > 0) {
            Ator ator = new Ator(nome, nacionalidade);
            ator.cadastrarAtor(ator);
            return true;
        }
        return false;
    }

    public ArrayList<Ator> listarAtores(String nome) throws ExceptionDAO {
        return new Ator().listarAtores(nome);
    }
    
    public boolean alterarAtor(int codAtor, String nome, String nacionalidade) throws ExceptionDAO {
        if (nome != null && nome.length() > 0 && nacionalidade != null && nacionalidade.length() > 0) {
            Ator ator = new Ator(nome, nacionalidade);
            ator.setCodAtor(codAtor);
            ator.alterarAtor(ator);
            return true;
        }
        return false;
    }
  
    public boolean apagarAtor(int codAtor) throws ExceptionDAO {
        if (codAtor == 0)
            return false;
        else {
            Ator ator = new Ator();
            ator.setCodAtor(codAtor);
            ator.apagarAtor(ator);
            return true;
        }            
    }    
}
