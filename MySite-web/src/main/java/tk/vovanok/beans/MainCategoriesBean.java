/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tk.vovanok.beans;


import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import tk.vovanok.entities.Category;
import tk.vovanok.entities.commons.CategoriesUtils;

/**
 *
 * @author Vovan <vovanok1992 at gmail.com>
 */

@Named
@ViewScoped
public class MainCategoriesBean implements Serializable{
    @EJB
    private CategoriesUtils categoriesUtils;
    
    private List<Category> cats;
    private MenuModel model;  
    
    

    public void init(){
        model = new DefaultMenuModel();
        
        

        List<Category> all = categoriesUtils.getAll();
        for(Category c: all){
            if (c.getParentId() == 0) {
                DefaultMenuItem item = new DefaultMenuItem();
                item.setValue(c.getName());
                item.setUrl("/catalog.xhtml?categoryId="+c.getId());
                item.setId(c.getName());
                this.model.addElement(item);
            }
        }
        
        
    }
    
    
    public MenuModel getModel() {  
         if(model==null) init();
        return model;  
     }     
    
    public List<Category> getCats() {
        if(cats == null) init();
        return cats;
    }

    public void setCats(List<Category> cats) {
        this.cats = cats;
    }
    
    
    
}
