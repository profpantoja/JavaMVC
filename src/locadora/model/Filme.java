/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.model;

import java.util.ArrayList;
import locadora.dao.ExceptionDAO;
import locadora.dao.FilmeDAO;


/**
 *
 * @author Pantoja
 */
public class Filme {
    
    private Integer codFilme;
    private String titulo;
    private String genero;
    private String sinopse;
    private Integer duração;
    private ArrayList<Item> itens = new ArrayList<Item>();
    private ArrayList<Ator> atores = new ArrayList<Ator>();
    
    
    public Filme() {
        
    }
    
    public Filme (String titulo, String genero, String sinopse, int duração){
        this.titulo= titulo;
        this.genero= genero;
        this.sinopse = sinopse;
        this.duração = duração;
    }

    public Integer getCodFilme() {
        return codFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public Integer getDuração() {
        return duração;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public ArrayList<Ator> getAtores() {
        return atores;
    }

    public void setCodFilme(Integer codFilme) {
        this.codFilme = codFilme;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setDuração(Integer duração) {
        this.duração = duração;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public void setAtores(ArrayList<Ator> atores) {
        this.atores = atores;
    }
    
  public void cadastrarFilme(Filme filme) throws ExceptionDAO{
      new FilmeDAO().cadastrarFilme(filme);
  }  
  
  public ArrayList<Filme> listarFilmes(String nome) throws ExceptionDAO {
      return new FilmeDAO().listarFilmes(nome);
  }
  
  public void alterarFilme(Filme filme) throws ExceptionDAO {
      new FilmeDAO().alterarFilme(filme);
  }

  public void apagarFilme(Filme filme) throws ExceptionDAO {
      new FilmeDAO().apagarFilme(filme);
  }
  
}
