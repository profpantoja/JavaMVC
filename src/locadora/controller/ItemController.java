/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.controller;

import locadora.dao.ExceptionDAO;
import locadora.model.Item;

/**
 *
 * @author Pantoja
 */
public class ItemController {

    public boolean cadastrarItem(Integer codFilme, String tipo, double preço) throws ExceptionDAO {
        if(codFilme>0 && tipo != null && preço>0) {
            Item item = new Item(codFilme, tipo, preço);
            item.cadastrarItem(item);
            return true;
        } else {
            return false;
        }
    } 
    
}
