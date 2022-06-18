/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.ServletContext;

/**
 *
 * @author terad
 */
@Dependent
public class FileReader implements Serializable{
    @Inject
    private ServletContext context;
    public String readAllText(String fpath){
        String path = context.getRealPath(fpath);
        Path p = Paths.get(path);
        String data = "";
        try {
            byte[] bytes = Files.readAllBytes(p);
            data = new String(bytes,"UTF-8");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }
}
