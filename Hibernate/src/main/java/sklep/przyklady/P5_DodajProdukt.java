package sklep.przyklady;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sklep.model.Product;

public class P5_DodajProdukt {

	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	EntityManagerFactory emf = null;
    	EntityManager em = null;
    	try {
        	emf = Persistence.createEntityManagerFactory("sklep");
        	em = emf.createEntityManager();
       	 
        	System.out.println("Początek transakcji");
        	em.getTransaction().begin();
       	 
        	while(true) {
            	System.out.print("Podaj nazwę nowego produktu (pusty napis, aby zakoczyć): ");
            	String name = scanner.nextLine();
            	if(name.isEmpty())
                	break;
           	 
            	System.out.print("Podaj cenę: ");
            	BigDecimal price = scanner.nextBigDecimal();
            	scanner.nextLine();
            	BigDecimal vat = BigDecimal.valueOf(0.23);
            	System.out.print("Podaj opis: ");
            	String description = scanner.nextLine();
            	
            	Product product = new Product();
            	product.setProductName(name);
            	product.setPrice(price);
            	product.setVat(vat);
            	product.setDescription(description);
            	System.out.printf("Produkt przed persist: id: %s, name: %s, price: %s, vat: %s, desc: %s\n",
                    	product.getProductId(), product.getProductName(), product.getPrice(), product.getVat(), product.getDescription());

            	
            	em.persist(product);
           	 
            	System.out.printf("Produkt po	persist: id: %s, name: %s, price: %s, vat: %s, desc: %s\n",
                    	product.getProductId(), product.getProductName(), product.getPrice(), product.getVat(), product.getDescription());
            	System.out.println();
        	}
        	System.out.println("Czy zapisać zmiany? [T/N]");
        	String wybor = scanner.next().toUpperCase();
        	switch(wybor) {
            	case "T":
                	System.out.println("Zatwierdzam transakcję");
                	em.getTransaction().commit();
                	break;
            	case "N":
                	System.out.println("Cofam transakcję");
                	em.getTransaction().rollback();
                	break;
            	default:
                	System.out.println("Rozłączam się bez zatwierdzenia transakcji");
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



