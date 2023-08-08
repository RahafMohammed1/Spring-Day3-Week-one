package com.example.bankmanagementsystem.Controller;

import com.example.bankmanagementsystem.Models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
   private ArrayList<Customer> customer = new ArrayList<>();

   //Get all the customers
   @GetMapping("/getAll")
   public ArrayList<Customer> getAll() {
      return customer;
   }

   //Add new customer
   @PostMapping("/add")
   public String addCustomer(@RequestBody Customer customer1) {
      customer.add(customer1);
      return "the customer is added";
   }

   //Update customers by index;
   @PutMapping("/update/{index}")
   public String updateCustomer(@PathVariable int index, @RequestBody Customer c) {
      customer.set(index, c);
      return "the customer is Updated";
   }

   //Delete customers by index
   @DeleteMapping("/delete/{index}")
   public String deleteCustomer(@PathVariable int index) {
      customer.remove(index);
      return "the customer is deleted";
   }

   //Deposit money to customer
   @PutMapping("/deposit/{id}")
   public String Deposit(@PathVariable String id, @RequestBody int amount) {
      for (Customer customer1 : customer) {
         if (customer1.getId().trim().equalsIgnoreCase(id)) {
            customer1.setBalance(customer1.getBalance() + amount);
            break;
         }
      }

      return "the Deposit is Done";
   }
   //Withdraw money from customers
   @PutMapping("/with/{id}")
   public String Withdraw(@PathVariable String id, @RequestBody int amount) {
      for (Customer customer1 : customer) {
         if (customer1.getId().trim().equalsIgnoreCase(id)) {
            if (customer1.getBalance() < amount) {
               return "your money Not enough for the withdrawal process ";
            } else {
               customer1.setBalance(customer1.getBalance() - amount);
            }
            break;
         }
      }
      return "the withdrawal is Done";
   }


}






