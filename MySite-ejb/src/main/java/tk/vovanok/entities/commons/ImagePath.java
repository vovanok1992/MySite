/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tk.vovanok.entities.commons;

import javax.faces.context.FacesContext;

/**
 *
 * @author Vovan <vovanok1992 at gmail.com>
 */
public class ImagePath {
    public static String getPath(){
        return FacesContext.getCurrentInstance().getExternalContext().getInitParameter("imagepath");
    }
}
