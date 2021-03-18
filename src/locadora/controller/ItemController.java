package locadora.controller;

import java.util.ArrayList;
import locadora.dao.ExceptionDAO;
import locadora.model.Item;

/**
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
    
    public ArrayList<Item> listarItens(String título) throws ExceptionDAO {
        return new Item().listarItens(título);
    }
    
    public boolean alterarItem(Integer codItem, Integer codFilme, String tipo, double preço) throws ExceptionDAO {
        if(codFilme>0 && tipo != null && preço>0) {
            Item item = new Item(codFilme, tipo, preço);
            item.setCodItem(codItem);
            item.alterarItem(item);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean apagarItem(int codItem) throws ExceptionDAO {
        if (codItem == 0)
            return false;
        else {
            Item item = new Item();
            item.setCodItem(codItem);
            item.apagarItem(item);
            return true;
        }
    }
    
}
