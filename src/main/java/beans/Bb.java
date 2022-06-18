/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Bb {
    private String text;
    private Integer num;
    
    @Inject 
    FileReader reader;
    
    @Inject
    FacesContext context;
    
    public String next() {
        String path = "/resources/data/"+num+".txt";
        text = reader.readAllText(path);
        
        FacesMessage msg = new FacesMessage("ファイルを表示しました");
	context.addMessage(null, msg);
        return null;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}
