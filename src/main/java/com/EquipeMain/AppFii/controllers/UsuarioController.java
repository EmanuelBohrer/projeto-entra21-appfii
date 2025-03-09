package com.EquipeMain.AppFii.controllers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.EquipeMain.AppFii.models.Papel;
import com.EquipeMain.AppFii.models.Usuario;
import com.EquipeMain.AppFii.repository.PapelRepository;
import com.EquipeMain.AppFii.repository.TabelaFunRepository;
import com.EquipeMain.AppFii.repository.TabelaRepository;
import com.EquipeMain.AppFii.repository.UsuarioRepository;


//Mapping existente para separar melhor (toda pagina desse controller utiliza o /usuario para seu acesso
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	//injeção de dependencias
	@Autowired
	private UsuarioRepository rp;
	
	
	@Autowired
	private TabelaRepository tp;
	
	
	@Autowired
	private TabelaFunRepository tf;
	
	
	@Autowired
	private PapelRepository pr;
	
	@Autowired
	private BCryptPasswordEncoder criptografia;
	
	//Traz o mapping do usuário novo, para um cadastro 
	@GetMapping("/novo")
	public String addUser(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login/cadastroUsuario";
		
		
	}
	//Com esse método, é verificado qual o papel tem o usuario no banco de dados
			private boolean hasAut(Usuario usuario, String papel) {
				for (Papel pp: usuario.getPapeis()) {
					if(pp.getPapel().equals(papel)) {
						return true;
					}
				}
				return false;
			}
	
			
			
	@GetMapping("/index")
	public String index(@CurrentSecurityContext(expression="authentication.name")
	String email) {
		
		
		//Em seguida, iniciamos um usuario para buscar o email do mesmo no banco
		Usuario usuario = rp.findByEmail(email);
		
		
		
		//String vazia para inserir a url que ele será levado, baseado no seu papel
		String redirectURL = "";
		if(hasAut(usuario,"ADMIN")) {
			redirectURL="/auth/admin/admin_index";
		}else if(hasAut(usuario,"USER")){
			redirectURL="/auth/user/user_index";
		}
		return redirectURL;
}

	
		
		
	
	
	//Salva o usuário no banco de dados, validando o mesmo com a anotation
	@PostMapping("/salvar")
	public String salvarUser(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes,Model model) {
		
		//caso ocorra algum erro, ele trás de volta ao login do usuario com um if simples
		if(result.hasErrors()) {
			return "login/cadastroUsuario";
		}
		
		
		//A busca ocorre trazendo ao usuário que o email já existe no banco, o levando de volta para a aba de cadastro
		Usuario user = rp.findByEmail(usuario.getEmail());
		if(user !=null) {
			model.addAttribute("emailExiste", "O email inserido já existe cadastrado.");
			return "login/cadastroUsuario";
			
		}
		//Aqui ocorre o "setting" do papel de usuário comum, além do instant now para setar qual foi a data que o usuário se cadastrou
		Papel papel = pr.findByPapel("USER");
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(papel);
		usuario.setPapeis(papeis);
		
		String senhaCrip = criptografia.encode(usuario.getSenha());
		usuario.setSenha(senhaCrip);
		
		usuario.setData_cad(Instant.now());
		rp.save(usuario);
		attributes.addFlashAttribute("mensagem","Usuário cadastrado com sucesso, faça seu login.");
		return "redirect:/usuario/novo";

		
	}
	
	//A listagem de admin, com o model, adicionamos o findAll do pacote do JPA para trazer todas as informações do banco de dados.
	@RequestMapping("/admin/listar")
	public String listarUser(Model model) {
		model.addAttribute("usuarios",rp.findAll());
		return "/auth/admin/admin-listar-usuario";
		
	
	}
	
	//Um mapping get para pegar os dados do usuário e até para deletar usa o pacote jpa, buscamos apagar o user pelo seu ID, e caso por algum motivo exista um erro, o admin recebe um aviso.
	@GetMapping("/admin/apagar/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Usuario usuario = rp.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inserido : "+ id+ "não está cadastrado."));
		rp.delete(usuario);
		return"redirect:/usuario/admin/listar";
		
		
	}
	
	//Para editar o usuário segue a mesma ideia, busca os dados pelo jpa e seu id, gerando então os antigos dados, caso o id não exista, a exception ocorre.
	@GetMapping("/editar/{id}")
	public String editarUsuario(@PathVariable("id") long id, Model model) {
		Optional<Usuario> oldUser = rp.findById(id);
		if (!oldUser.isPresent()) {
            throw new IllegalArgumentException("O usuário digitado de id : " + id+ " é inválido.");
        } 
		//traz para a tela de edit usuário (se ele existr)
		Usuario usuario = oldUser.get();
	    model.addAttribute("usuario", usuario);
	    return "auth/user/editUser";
	}

	// Post é para salvar o antigo usuário, ou seja, quando o formulario for concluido, o valid seta o jpa para salvar as alterações, levando o admin para a listagem dnv
	@PostMapping("/editar/{id}")
	public String editarUsuario(@PathVariable("id") long id, @Valid Usuario usuario, BindingResult result) {
		if(result.hasErrors()) {
			usuario.setId(id);
			return "/auth/user/editUser";
		}
		rp.save(usuario);
		return "redirect:/usuario/admin/listar";
	}
	
	
	
	//Implementação de níveis não aplicada (futura atualização)
//	@GetMapping("/editarNivel/{id}")
//	public String getNivel(@PathVariable("id") long id,Model model) {
//		Optional<Usuario> oldUser = rp.findById(id);	
//		if(!oldUser.isPresent()) {
//			throw new IllegalArgumentException("O usuário digitado de id : " + id+ " é inválido.");
//			
//		}
//		Usuario usuario = oldUser.get();
//		model.addAttribute("usuario",usuario);
//		return "/auth/admin/admin-editar-nivel";
//		
//		
//	
//	
//	}
//	
	
	@GetMapping(value="/user_fundos")
	public String listaFii(Model model) {
		ModelAndView mv = new ModelAndView("user/user_fundos");
		List<String> teste = new ArrayList<>();
		teste.add("teste01");
		teste.add("teste02");
		teste.add("teste03");
		mv.addObject("test", teste);
		return "auth/user/user_fundos";
		
	}
	
	
	
	
//	@RequestMapping("/user_fundos")
//	public String listarFundo(Model model) {
//		model.addAttribute("tabelaFun",tf.findAll());
//		return "auth/user/user_fundos";
//		
//	
//	}
	
	
//	@RequestMapping(value="/user_fundos", method= RequestMethod.GET)
//	public @ResponseBody ArrayList<TabelaFun> lista(){
//		return (ArrayList<TabelaFun>) tf.findAll();
//	}
//			
}

	



	
	
	



