package com.project.e_commerce.controllers.products;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.e_commerce.model.Basket;
import com.project.e_commerce.model.Product;
import com.project.e_commerce.model.User;
import com.project.e_commerce.services.BasketService;
import com.project.e_commerce.services.CategoryService;
import com.project.e_commerce.services.ProductService;
import com.project.e_commerce.services.UserService;

@Controller
@RequestMapping(value="/product")
public class ProductController { 
		
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BasketService basketService;
	
		
    //Bütün Ürünlerin Sayfasını Getir
    @RequestMapping(value = "")
    public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findOneByEmail(auth.getName());
		modelAndView.addObject("userId",  user.getId());
		modelAndView.addObject("activePage", "allProducts");
		modelAndView.addObject("categories", this.categoryService.findAll());
		modelAndView.addObject("products", this.productService.findAll());
		modelAndView.setViewName("product/allProductsMainPage");
		return modelAndView;
    }

    //Ekleme Elemanları Getirme
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addProductForm(Product product, Model model) {
    	ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findOneByEmail(auth.getName());
		modelAndView.addObject("userId", user.getId());
    	modelAndView.addObject("activePage", "products");
    	modelAndView.addObject("categories", this.categoryService.findAll());
        modelAndView.setViewName("product/add");
		return modelAndView;
    }
    
    //Ekleme İşlemi Yapma
    @RequestMapping(value = "/{userId}/add", method = RequestMethod.POST)
    public ModelAndView addProduct(@Valid Product product, @PathVariable Integer userId, BindingResult bindingResult, Model model) {    	
    	ModelAndView modelAndView = new ModelAndView();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findOneByEmail(auth.getName());
    	modelAndView.addObject("userId", user.getId());
    	if (bindingResult.hasErrors()) {
    		modelAndView.addObject("activePage", "products");
            modelAndView.setViewName("product/add");
    		return modelAndView;
    	}
    	Basket basket = new Basket();
    	basketService.save(basket);
    	basket.getProducts().add(product);
    	product.setBasket(basket);
    	
    	User user2 = userService.findOne(userId);
    	basket.setUser(user2);
    	
    	modelAndView.addObject(this.productService.save(product));
        modelAndView.setViewName("redirect:/product");
		return modelAndView;
    }
    
    //Gösterme İşlemi Yapma
    @RequestMapping(value = "/view/{productId}")
    public ModelAndView viewProduct(@PathVariable Integer productId, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findOneByEmail(auth.getName());
		modelAndView.addObject("userId",  user.getId());
		modelAndView.addObject("activePage", "products");
		modelAndView.addObject("product", this.productService.findOneByProductId(productId));
		modelAndView.setViewName("product/view");
		return modelAndView;     	
    }
    
    //Düzenleme İşlemi Yapma
    @RequestMapping(value = "/edit/{productId}")
    public ModelAndView editProduct(@PathVariable Integer productId, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findOneByEmail(auth.getName());		
		modelAndView.addObject("userId",  user.getId());
		modelAndView.addObject("activePage", "products");
		modelAndView.addObject("product", this.productService.findOneByProductId(productId));
		modelAndView.addObject("categories", this.categoryService.findAll());
		modelAndView.setViewName("product/edit");
		return modelAndView;
    }
    
    //Yeni Düzenlenenleri  Kaydetme
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateProduct(Product product) {
    	ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findOneByEmail(auth.getName());
		modelAndView.addObject("userId",  user.getId());
		modelAndView.addObject("activePage", "products");
		modelAndView.addObject(this.productService.save(product));
		modelAndView.setViewName("redirect:/product/view/" + product.getProductId());
		return modelAndView;
    } 
    
    //Silme İşlemi Yapma
    @RequestMapping(value = "/delete/{productId}/{basketId}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Integer productId, @PathVariable Integer basketId) {
        this.productService.delete(productId);
        this.basketService.delete(basketId);
        return "redirect:/product";
    }
    
	//Search İşlemi
	@RequestMapping(value = "/{produtName}")
	public ModelAndView search(@PathVariable String productName) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findOneByEmail(auth.getName());
		modelAndView.addObject("userId",  user.getId());
		modelAndView.addObject("activePage", "allProducts");
		modelAndView.addObject("products", this.productService.findOneByProductName(productName));
		modelAndView.setViewName("product/allProductsMainPage");
		return modelAndView;
	}
}
