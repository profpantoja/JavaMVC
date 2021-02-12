/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.model;

import java.util.ArrayList;
import java.util.Date;
import locadora.dao.ClienteDAO;
import locadora.dao.ExceptionDAO;

/**
 *
 * @author Pantoja
 */
public class Cliente {

    private Integer codCliente;
    private String nome;
    private String cpf;
    private String email;
    private String endereço;
    private Date dtNascimento;
    private ArrayList<Item> itens = new ArrayList<Item>();

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String email, String endereço, Date dtNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereço = endereço;
        this.dtNascimento = dtNascimento;

    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereço() {
        return endereço;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public void cadastrarCliente(Cliente cliente) throws ExceptionDAO {       
        new ClienteDAO().cadastrarCliente(cliente);
    }

    public ArrayList<Cliente> listarClientes(String nome) throws ExceptionDAO {
        return new ClienteDAO().listarClientes(nome);
    }

    public void alterarCliente(Cliente cliente) throws ExceptionDAO {       
        new ClienteDAO().alterarCliente(cliente);
    }
    
    public void apagarCliente(Cliente cliente) throws ExceptionDAO {       
        new ClienteDAO().apagarCliente(cliente);
    }
}
