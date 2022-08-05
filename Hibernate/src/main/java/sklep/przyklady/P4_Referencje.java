package sklep.przyklady;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sklep.model.Customer;
import sklep.model.Order;
import sklep.model.OrderProduct;

public class P4_Referencje {

	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	EntityManagerFactory emf = null;
    	EntityManager em = null;
    	try {
        	emf = Persistence.createEntityManagerFactory("sklep");
        	em = emf.createEntityManager();
       	 
        	while(true) {
            	System.out.print("Podaj email klienta: ");
            	String email = scanner.nextLine();
            	if(email.isEmpty()) {
                	break;
            	}
       	 
            	Customer customer = em.find(Customer.class, email);
            	if(customer == null) {
                	System.out.println("Nie ma takiego klienta");
                	continue;
            	}
            	System.out.println("Znaleziono obiekt: " + customer);
            	System.out.println(" * imię/nazwa: " + customer.getName());
            	System.out.println(" * adres: " + customer.getAddress() + ", " + customer.getCity());
            	System.out.println(" * nr tel: " + customer.getPhoneNumber());
            	List<Order> orders = customer.getOrders();
            	System.out.println("Klient posiada " + orders.size() + " zamówień");
            	for(Order order : orders) {
                	System.out.println("Zamówienie nr " + order.getOrderId() + " z dnia " + order.getOrderDate());
                	for(OrderProduct op : order.getOrderProducts()) {
                    	System.out.println(" + " + op.getProduct().getProductName()
                            	+ ", " + op.getQuantity() + " sztuk po " + op.getActualPrice() + " zł");
                	}
            	}
            	System.out.println();
        	}
    	} catch(Exception e) {
        	e.printStackTrace();
    	} finally {
        	if(em != null)
            	em.close();
        	if(emf != null)
            	emf.close();
    	}  	 
	}

}



