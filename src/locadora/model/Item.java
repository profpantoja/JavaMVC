package locadora.model;

import java.util.ArrayList;
import java.util.Date;
import locadora.dao.ExceptionDAO;
import locadora.dao.ItemDAO;

/**
 * @author Pantoja
 */
public class Item {

    private Integer codItem;
    private double preço;
    private String tipo;
    private Date dataLocação;
    private Date dataDevolução;
    private Filme filme;
    private Cliente cliente;
    
    public Item() {
        
    }
    
    public Item(Integer codFilme, String tipo, double preço) {
        this.tipo = tipo;
        this.preço = preço;
        Filme filme = new Filme();
        filme.setCodFilme(codFilme);
        this.filme = filme;
    }

    public Integer getCodItem() {
        return codItem;
    }

    public void setCodItem(Integer codItem) {
        this.codItem = codItem;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataLocação() {
        return dataLocação;
    }

    public void setDataLocação(Date dataLocação) {
        this.dataLocação = dataLocação;
    }

    public Date getDataDevolução() {
        return dataDevolução;
    }

    public void setDataDevolução(Date dataDevolução) {
        this.dataDevolução = dataDevolução;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void cadastrarItem(Item item) throws ExceptionDAO {
        new ItemDAO().cadastrarItem(item);
    }

    public ArrayList<Item> listarItens(String título) throws ExceptionDAO {
        return new ItemDAO().listarItem(título);
    }
}
