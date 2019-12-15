package com.geekbrains.marketdemoa.controllers;


import com.geekbrains.marketdemoa.entites.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/cart")
public class CartController {
    private ShoppingCart cart;

    @Autowired
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @GetMapping("")
    public String showCart(Model model) {
        model.addAttribute("items", cart.getProducts());
        return "basket";
    }

  //  @GetMapping("/add/{id}")
  //  public String addProductToCart(Model model, @PathVariable("id") Long id) {
  //      cart.addItemToCartById(id);
  //      return "redirect:/";
 //   }

    @GetMapping("/add/{id}")
    public void addItemToCart(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        cart.addItemToCartById(id);
        response.sendRedirect(request.getHeader("referer"));
    }

    @GetMapping("/delete/{id}")
    public String deleteProductToCart(Model model, @PathVariable("id") Long id) {
        cart.delItemToCartById(id);
        return "redirect:/cart/";
    }
}
