/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import locadora.dao.ExceptionDAO;
import locadora.model.Cliente;

/**
 *
 * @author Tielle Alexandre
 */
public class ClienteController {

    public boolean cadastrarCliente(String nome, String cpf, String email, String endereço, String dtNascimento) throws ParseException, ExceptionDAO {
        if (nome != null && nome.length() > 0 && validarCPF(cpf) && email != null
                && email.length() > 0 && endereço != null && endereço.length() > 0 && validarData(dtNascimento)) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formato.parse(dtNascimento);
            Cliente cliente = new Cliente(nome, cpf, email, endereço, data);
            cliente.cadastrarCliente(cliente);
            return true;
        }
        return false;
    }

    public ArrayList<Cliente> listarClientes(String nome) throws ExceptionDAO {
        return new Cliente().listarClientes(nome);
    }

    public boolean alterarCliente(int codCliente, String nome, String cpf, String email, String endereço, String dtNascimento) throws ParseException, ExceptionDAO {
        if (nome != null && nome.length() > 0 && validarCPF(cpf) && email != null
                && email.length() > 0 && endereço != null && endereço.length() > 0 && validarData(dtNascimento)) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formato.parse(dtNascimento);
            Cliente cliente = new Cliente(nome, cpf, email, endereço, data);
            cliente.setCodCliente(codCliente);
            cliente.alterarCliente(cliente);
            return true;
        }
        return false;
    }

    public boolean apagarCliente(int codCliente) throws ExceptionDAO {
        if(codCliente == 0)
            return false;
        else {
            Cliente cliente = new Cliente();
            cliente.setCodCliente(codCliente);
            cliente.apagarCliente(cliente);
            return true;
        }
    }
    
    public boolean validarCPF(String cpf) {
        for (int i = 0; i < cpf.length(); i++) {
            if (!Character.isDigit(cpf.charAt(i))) {
                if (!(i == 3 || i == 7 || i == 11)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validarData(String data) {
        for (int i = 0; i < data.length(); i++) {
            if (!Character.isDigit(data.charAt(i))) {
                if (!(i == 2 || i == 5)) {
                    return false;
                }
            }
        }
        return true;
    }

}
