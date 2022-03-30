package com.example.application.data.service;

import org.springframework.stereotype.Service;
import com.example.application.data.repository.SalespersonRepository;
import com.example.application.data.repository.ContactRepository;
import com.example.application.data.repository.CustomerRepository;
import com.example.application.data.repository.ProductRepository;
import com.example.application.data.repository.SaleRepository;
import com.example.application.data.repository.CompanyRepository;
import com.example.application.data.repository.StatusRepository;
import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Customer;
import com.example.application.data.entity.Product;
import com.example.application.data.entity.Sale;
import com.example.application.data.entity.Salesperson;
import com.example.application.data.entity.Status;

import java.util.LinkedList;
import java.util.List;

@Service
public class CrmService {
	
	private final SalespersonRepository salespersonRepository;
	private final ProductRepository productRepository;
	private final CustomerRepository customerRepository;
	private final SaleRepository saleRepository;
	private final ContactRepository contactRepository;
	private final CompanyRepository companyRepository;
	private final StatusRepository statusRepository;
	
	public CrmService(SalespersonRepository salespersonRepository,
			ContactRepository contactRepository,
			CompanyRepository companyRepository,
			StatusRepository statusRepository,
			ProductRepository productRepository,
			CustomerRepository customerRepository,
			SaleRepository saleRepository) {
		this.salespersonRepository = salespersonRepository;
		this.productRepository = productRepository;
		this.customerRepository = customerRepository;
		this.saleRepository = saleRepository;
		this.contactRepository = contactRepository;
		this.companyRepository = companyRepository;
		this.statusRepository = statusRepository;
	}
	
	public List<Contact> findAllContacts(String filterText){
		if(filterText == null || filterText.isEmpty()) {
			return contactRepository.findAll();
		} else {
			return contactRepository.search(filterText);
		}
	}
	
	public long countContacts() {
		return contactRepository.count();
	}
	
	public void deleteContact(Contact contact) {
		contactRepository.delete(contact);
	}
	
	public void saveContact(Contact contact) {
		if(contact == null) {
			System.err.println("Contact is null.");
		}
		
		contactRepository.save(contact);
	}
	
	public List<Company> findAllCompanies(){
		return companyRepository.findAll();
	}
	
	public List<Status> findAllStatuses(){
		return statusRepository.findAll();
	}
	
	public List<Salesperson> findAllSalespersons(String filterText){
		if(filterText == null || filterText.isEmpty()) {
			return salespersonRepository.findAll();
		} else {
			return salespersonRepository.search(filterText);
		}
	}
	
	public long countSalespersons() {
		return salespersonRepository.count();
	}
	
	public void deleteSalesperson(Salesperson salesperson) {
		salespersonRepository.delete(salesperson);
	}
	
	public void saveSalesperson(Salesperson salesperson) {
		if(salesperson == null) {
			System.err.println("Salesperson is null.");
		}
		
		salespersonRepository.save(salesperson);
	}
	
	public List<Product> findAllProducts(String filterText){
		if(filterText == null || filterText.isEmpty()) {
			return productRepository.findAll();
		}else {
			return productRepository.search(filterText);
		}
	}
	
	public long countProducts() {
		return productRepository.count();
	}
	
	public List<Customer> findAllCustomers(String filterText){
		if(filterText == null || filterText.isEmpty()) {
			return customerRepository.findAll();
		}else {
			return customerRepository.search(filterText);
		}
	}
	
	public long countCustomers() {
		return customerRepository.count();
	}
	
	public List<Sale> findAllSales(String filterText){
		if(filterText == null || filterText.isEmpty()) {
			return saleRepository.findAll();
		}else {
			return saleRepository.search(filterText);
		}
	}
	
	public long countSales() {
		return saleRepository.count();
	}
}
