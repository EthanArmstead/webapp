package com.example.application.data.generator;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import com.example.application.data.entity.Customer;
import com.example.application.data.entity.Product;
import com.example.application.data.entity.Sale;
import com.example.application.data.entity.Salesperson;
import com.example.application.data.entity.Discount;
import com.example.application.data.repository.CompanyRepository;
import com.example.application.data.repository.ContactRepository;
import com.example.application.data.repository.CustomerRepository;
import com.example.application.data.repository.DiscountRepository;
import com.example.application.data.repository.ProductRepository;
import com.example.application.data.repository.SaleRepository;
import com.example.application.data.repository.SalespersonRepository;
import com.example.application.data.repository.StatusRepository;
import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import com.vaadin.flow.spring.annotation.SpringComponent;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(ContactRepository contactRepository, CompanyRepository companyRepository,
            StatusRepository statusRepository, CustomerRepository customerRepository, DiscountRepository discountRepository, 
            ProductRepository productRepository, SaleRepository saleRepository, SalespersonRepository salespersonRepository) {

        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (contactRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");
            ExampleDataGenerator<Company> companyGenerator = new ExampleDataGenerator<>(Company.class,
                    LocalDateTime.now());
            companyGenerator.setData(Company::setName, DataType.COMPANY_NAME);
            List<Company> companies = companyRepository.saveAll(companyGenerator.create(5, seed));

            List<Status> statuses = statusRepository
                    .saveAll(Stream.of("Imported lead", "Not contacted", "Contacted", "Customer", "Closed (lost)")
                            .map(Status::new).collect(Collectors.toList()));

            logger.info("... generating 50 Contact entities...");
            ExampleDataGenerator<Contact> contactGenerator = new ExampleDataGenerator<>(Contact.class,
                    LocalDateTime.now());
            contactGenerator.setData(Contact::setFirstName, DataType.FIRST_NAME);
            contactGenerator.setData(Contact::setLastName, DataType.LAST_NAME);
            contactGenerator.setData(Contact::setEmail, DataType.EMAIL);

            Random r = new Random(seed);
            List<Contact> contacts = contactGenerator.create(50, seed).stream().map(contact -> {
                contact.setCompany(companies.get(r.nextInt(companies.size())));
                contact.setStatus(statuses.get(r.nextInt(statuses.size())));
                return contact;
            }).collect(Collectors.toList());

            contactRepository.saveAll(contacts);
            
            //Salesperson data generator
            logger.info("... generating 50 Salesperson entities...");
            ExampleDataGenerator<Salesperson> salespersonGenerator = new ExampleDataGenerator<>(Salesperson.class,
                    LocalDateTime.now());
            salespersonGenerator.setData(Salesperson::setFirstName, DataType.FIRST_NAME);
            salespersonGenerator.setData(Salesperson::setLastName, DataType.LAST_NAME);
            salespersonGenerator.setData(Salesperson::setAddress, DataType.ADDRESS);
            salespersonGenerator.setData(Salesperson::setManager, DataType.LAST_NAME);

            List<Salesperson> salespersons = salespersonGenerator.create(50, seed).stream().map(salesperson -> {
                salesperson.setPhone(123555);
                salesperson.setStartDate(010122);
                salesperson.setTerminationDate(123122);
                return salesperson;
            }).collect(Collectors.toList());

            salespersonRepository.saveAll(salespersons);
            
            //Product data generator
            logger.info("...generating 5 product entities...");
            ExampleDataGenerator<Product> productGenerator = new ExampleDataGenerator<>(Product.class,
            		LocalDateTime.now());
            productGenerator.setData(Product::setName, DataType.TWO_WORDS);
            productGenerator.setData(Product::setManufacturer, DataType.COMPANY_NAME);
            productGenerator.setData(Product::setStyle, DataType.WORD);
            
            List<Product> products = productGenerator.create(5, seed).stream().map(product -> {
            	product.setPurchasePrice(r.nextDouble());
            	product.setCommissionPerc(r.nextDouble());
            	product.setQtyOnHand(r.nextInt());
            	product.setSalePrice(r.nextDouble());
            	return product;
            }).collect(Collectors.toList());
            
            productRepository.saveAll(products);
            
            //Customer data generator
            logger.info("...generating 50 customer entities...");
            ExampleDataGenerator<Customer> customerGenerator = new ExampleDataGenerator<>(Customer.class,
            		LocalDateTime.now());
            customerGenerator.setData(Customer::setFirstName, DataType.FIRST_NAME);
            customerGenerator.setData(Customer::setLastName, DataType.LAST_NAME);
            customerGenerator.setData(Customer::setAddress, DataType.ADDRESS);
            customerGenerator.setData(Customer::setPhone, DataType.PHONE_NUMBER);
            
            List<Customer> customers = customerGenerator.create(50, seed).stream().map(customer -> {
            	customer.setStartDate(010122);
            	return customer;
            }).collect(Collectors.toList());
            
            customerRepository.saveAll(customers);
            
            //Sale data generator
            logger.info("...generating 50 sale entities...");
            ExampleDataGenerator<Sale> saleGenerator = new ExampleDataGenerator<>(Sale.class,
            		LocalDateTime.now());
            //saleGenerator.setData(Sale::setSalesDate, DataType.DATE_LAST_1_YEAR);
            
            List<Sale> sales = saleGenerator.create(50, seed).stream().map(sale -> {
            	sale.setSalesDate(010122);
            	sale.setSalesperson(salespersons.get(r.nextInt(0, salespersons.size())));
            	sale.setCustomer(customers.get(r.nextInt(0, customers.size())));
            	sale.setProduct(products.get(r.nextInt(0, products.size())));
            	return sale;
            }).collect(Collectors.toList());
            
            saleRepository.saveAll(sales);

            logger.info("Generated demo data");
        };
    }

}
