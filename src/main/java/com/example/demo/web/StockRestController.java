package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.dao.CategorieRepository;
import com.example.demo.dao.CommandeRepository;
import com.example.demo.dao.EntreeRepository;
import com.example.demo.dao.FournisseurRepository;
import com.example.demo.dao.LigneCommandeRepository;
import com.example.demo.dao.MagasinRepository;
import com.example.demo.dao.ReceptionRepository;
import com.example.demo.dao.SortieRepository;
import com.example.demo.entities.Article;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Commande;
import com.example.demo.entities.Entree;
import com.example.demo.entities.Fournisseur;
import com.example.demo.entities.LigneCommande;
import com.example.demo.entities.Magasin;
import com.example.demo.entities.Reception;
import com.example.demo.entities.Sortie;

@RestController
public class StockRestController {
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private EntreeRepository entreeRepository;
	@Autowired
	private FournisseurRepository fournisseurRepository;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	@Autowired
	private MagasinRepository magasinRepository;
	@Autowired
	private ReceptionRepository receptionRepository;
	@Autowired
	private SortieRepository sortieRepository;
	
	@GetMapping(value="/article")
	public List<Article> listArticle(){
		return articleRepository.findAll();
	}
	@GetMapping(value="/article/{id}")
	public Article articleParId(@PathVariable(name="id") Long id)
	{
		return articleRepository.findById(id).get();
	}
	@GetMapping(value="/search")
	public Page<Article> search(@RequestParam(name="dest",defaultValue="") String destignation,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="10")int size)
	{
		return articleRepository.articleParDestignation("%"+destignation+"%",PageRequest.of(page, size));
	}
	@PostMapping(value="/addArticle")
	public Article ajouterArticle(@RequestBody Article article) {
		return articleRepository.save(article);
	}
	@DeleteMapping(value="/removeArticle/{id}")
	public void deleteArticle(@PathVariable(name="id")Long id) {
		articleRepository.deleteById(id);
	}
	@PutMapping(value="/updateArticle/{id}")
	public Article update(@PathVariable(name="id")Long id,@RequestBody Article article)
	{
		article.setCodeArt(id);
		return articleRepository.save(article);
	}
	@PutMapping(value="updateCategorie/{id}")
	public Categorie update(@PathVariable(name="id")Long id, @RequestBody Categorie categorie)
	{
		categorie.setId(id);
		return categorieRepository.save(categorie);
	}
	@PutMapping(value="updateCommande/{id}")
	public Commande update(@PathVariable(name="id")Long id, @RequestBody Commande commande)
	{
		commande.setNumCmd(id);
		return commandeRepository.save(commande);
	}
	@PutMapping(value="updateEntre/{id}")
	public Entree update(@PathVariable(name="id")Long id, @RequestBody Entree entree)
	{
		entree.setNumEntre(id);
		return entreeRepository.save(entree);
	}
	@GetMapping(value="searchFornisseur")
	public Page<Fournisseur> search1(@RequestParam(name="nom",defaultValue="")String nom,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="page",defaultValue="0")int size){
		return fournisseurRepository.fournisseurParFournisseur("%"+nom+"%", PageRequest.of(page, size));
		
	}
	@PutMapping(value="updateFournisseur/{id}")
	public Fournisseur update(@PathVariable(name="id")Long id, @RequestBody Fournisseur fournisseur)
	{
		fournisseur.setNumF(id);
		return fournisseurRepository.save(fournisseur);
	}
	@PutMapping(value="updateLigneCommande/{id}")
	public LigneCommande update(@PathVariable(name="id")Long id, @RequestBody LigneCommande ligneCommande)
	{
		ligneCommande.setId(id);
		return ligneCommandeRepository.save(ligneCommande);
	}
    @PutMapping(value="updateMagasin/{id}")
    public Magasin update(@PathVariable(name="id")Long id, @RequestBody Magasin magasin)
    {
    	magasin.setId(id);
    	return magasinRepository.save(magasin);
    }
    @PutMapping(value="updateReception/{id}")
    public Reception update(@PathVariable(name="id")Long id, @RequestBody Reception reception)
    {
    	reception.setId(id);
    	return receptionRepository.save(reception);
    }
    @PutMapping(value="updateSortie/{id}")
    public Sortie update(@PathVariable(name="id")Long id, @RequestBody Sortie sortie)
    {
    	sortie.setNumS(id);
    	return sortieRepository.save(sortie);
    }

}
