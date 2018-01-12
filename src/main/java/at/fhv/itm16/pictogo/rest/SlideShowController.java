package at.fhv.itm16.pictogo.rest;

/**
 * Created by Karin on 11.01.2018.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.ArrayList;

@Controller
public class SlideShowController {

    @RequestMapping("/slideshow")
    public String greeting(Model model) {
        File folder = new File("images");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> listOfImages = new ArrayList<String>();
        for (int i=0; i<listOfFiles.length;i++){
            if (listOfFiles[i].isFile()){
                listOfImages.add(listOfFiles[i].getName());
            }
        }
        model.addAttribute("images", listOfImages);
        return "slideshow";
    }

}