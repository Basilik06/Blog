package com.crud.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.demo.interfaces.PublicacionRepository;
import com.crud.demo.modelo.Publicacion;

@Controller
public class PostController {
	  @Autowired
	    private PublicacionRepository publicacionRepository;
	  
	public String GetPost( ) {
		
		return "";
	}
	
}
