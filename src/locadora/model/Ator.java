/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.model;

import java.util.ArrayList;
import locadora.dao.AtorDAO;
import locadora.dao.ExceptionDAO;

/**
 *
 * @author Pantoja
 */
public class Ator {

    private Integer codAtor;
    private String name;
    private String nacionalidade;
    private ArrayList<Filme> filmes = new ArrayList<Filme>();            
    
    public Ator() {
    }

    public Ator(String nome, String nacionalidade) {
        this.name = nome;
        this.nacionalidade = nacionalidade;
    }

    public Integer getCodAtor() {
        return codAtor;
    }

    public String getName() {
        return name;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public void setCodAtor(Integer codAtor) {
        this.codAtor = codAtor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setFilmes(ArrayList<Filme> filmes) {
        this.filmes = filmes;
    }

    public void cadastrarAtor(Ator ator) throws ExceptionDAO {
        new AtorDAO().cadastrarAtor(ator);
    }

    public ArrayList<Ator> listarAtores(String nome) throws ExceptionDAO {
        return new AtorDAO().listarAtores(nome);
    }           

    public void alterarAtor(Ator ator) throws ExceptionDAO {
        new AtorDAO().alterarAtor(ator);
    }

    public void apagarAtor(Ator ator) throws ExceptionDAO {
        new AtorDAO().apagarAtor(ator);
    }    
}
