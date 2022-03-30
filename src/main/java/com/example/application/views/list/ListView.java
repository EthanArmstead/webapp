package com.example.application.views.list;

import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Product;
import com.example.application.data.entity.Sale;
import com.example.application.data.entity.Salesperson;
import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Sales Tracking | Vaadin CRM")
@Route(value = "")
public class ListView extends VerticalLayout {
	//Grid<Contact> grid = new Grid<>(Contact.class);
	Grid<Sale> gridSale = new Grid<>(Sale.class);
	TextField filterText = new TextField();
	ComboBox<Salesperson> spComboBox = new ComboBox<>("Salesperson");
	ComboBox<Product> prodComboBox = new ComboBox<>("Product");
	private CrmService service;
	
    public ListView(CrmService service) {
    	this.service = service;
        addClassName("list-view");
        setSizeFull();
    	
        
        spComboBox.setPlaceholder("Select employee");
        add(spComboBox);

        updateSpComboBox();
        
        prodComboBox.setPlaceholder("Select product");
        add(prodComboBox);
        
        updateProdComboBox();
        
        //configureGrid();
        configureGridSale();
        
        add(getToolbar(), /*grid*/ gridSale);
        
        //updateList();
        updateSaleList();
        
    }
    
    private Component getToolbar() {
    	filterText.setPlaceholder("Filter by date range...");
    	filterText.setClearButtonVisible(true);
    	filterText.setValueChangeMode(ValueChangeMode.LAZY);
    	filterText.addValueChangeListener(e -> updateSaleList());
    	
    	Button addSaleButton = new Button("Add sale");
    	
    	HorizontalLayout toolbar = new HorizontalLayout(filterText, addSaleButton);
    	toolbar.addClassName("toolbar");
    	return toolbar;
    }
    
    /*private void configureGrid() {
    	grid.addClassName("contact-grid");
    	//grid.setSizeFull();
    	
    	grid.setColumns("firstName", "lastName", "email");
    	grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
    	grid.addColumn(contact -> contact.getStatus().getName()).setHeader("Status");
    	
    	grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }*/
    
    private void configureGridSale() {
    	gridSale.addClassName("sale-grid");
    	//grid.setSizeFull();
    	
    	gridSale.setColumns("salesDate");
    	gridSale.addColumn(sale -> sale.getSalesperson().toString()).setHeader("Salesperson");
    	gridSale.addColumn(sale -> sale.getCustomer().toString()).setHeader("Customer");
    	gridSale.addColumn(sale -> sale.getProduct().getName()).setHeader("Product");
    	gridSale.addColumn(sale -> sale.getProduct().getSalePrice()).setHeader("Price");
    	gridSale.addColumn(sale -> sale.getProduct().getCommissionPerc()).setHeader("Commission");
    	
    	gridSale.getColumns().forEach(col -> col.setAutoWidth(true));
    }
    
    /*private void updateList() {
    	grid.setItems(service.findAllContacts(filterText.getValue()));
    }*/
    
    private void updateSaleList() {
    	gridSale.setItems(service.findAllSales(filterText.getValue()));
    }
    
    private void updateSpComboBox() {
    	spComboBox.setItems(service.findAllSalespersons(filterText.getValue()));
    }
    
    private void updateProdComboBox() {
    	prodComboBox.setItems(service.findAllProducts(filterText.getValue()));
    }

}
