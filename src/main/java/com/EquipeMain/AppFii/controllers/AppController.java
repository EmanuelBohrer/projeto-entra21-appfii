package com.EquipeMain.AppFii.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.EquipeMain.AppFii.models.Carteira;
import com.EquipeMain.AppFii.models.FundosCad;
import com.EquipeMain.AppFii.repository.CarteiraRepository;
import com.EquipeMain.AppFii.repository.FundoRepository;


@Controller
public class AppController {
	
	
	@Autowired
	private CarteiraRepository cr;
	
	@Autowired
	private FundoRepository fr;
	
	
	
	//Teste para trazer a página normal
//	@RequestMapping("/")
//	public String index (Model model) {
//		model.addAttribute("msnBem Vindo!, Bem vindo ao sistema AppFii");
//		return "appFii/dashboard";
//		
//	}
	
	//Mapping para trazer ao login
	@RequestMapping({"/login","/"} )
	public String login () {
		return "login/login_user";
		
	}
	
	
	 // METODO PARA CADASTRAR A CARTEIRA "EVENTO"
    @RequestMapping(value = "/cadastrarCarteira", method= RequestMethod.GET)
    public String form() {
        return "carteira/formCarteira";

    }
    // METODO QUE VERIFICA E SALVA A CARTEIRA "EVENTO" SE NÃO ESTIVER EM BRANCO AS INFORMAÇÕES, SEM ERRO.
    @RequestMapping(value = "/cadastrarCarteira", method= RequestMethod.POST)
    public String form(@Valid Carteira carteira, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarCarteira";

        }
        cr.save(carteira);
        attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
        return "redirect:/cadastrarCarteira";
    }
    
    
    
    @RequestMapping("/carteiras")	
	public ModelAndView listaCarteiras(){		
		ModelAndView mv = new 				// objeto para renderiar a pagina					
				ModelAndView("carteira/listaCarteira");	
		Iterable<Carteira> carteira = cr.findAll();		
		mv.addObject("lcarteira", carteira); // leventos atributo 					  
		//que está no HTML		
		return mv;
	}
    
    @RequestMapping(value ="/{codigo}", method = RequestMethod.GET)
	public ModelAndView detalhesCarteira(@PathVariable("codigo") long codigo) {
		Carteira carteira = cr.findByCodigo(codigo);
		
		ModelAndView mv = new ModelAndView("carteira/detalhesCarteira");
		mv.addObject("carteira", carteira);

		Iterable<FundosCad> fundos = fr.findByCarteira(carteira);
		mv.addObject("fundoscad", fundos);
		return mv;
	}
	
	
	

	

}
