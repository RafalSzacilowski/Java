package sklep.przyklady;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sklep.model.Product;

public class P2b_OdczytajWszystkieProdukty_NamedQuery {

	public static void main(String[] args) {
	
		System.out.println("Początek programu");
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("sklep");
			em = emf.createEntityManager();
			TypedQuery<Product> query = em.createNamedQuery("Product.findAll", Product.class);
			List<Product> products = query.getResultList();
			for (Product product : products) {
				System.out.printf("Produkt nr %s, %s, cena: %s (%s VAT),\n    opis: %s\n\n", product.getProductId(), product.getProductName(),
						product.getPrice(), product.getVat(), product.getDescription());
			}

		} finally {
			if(em!=null) em.close();
		
			if(emf!=null) emf.close();		
			}

		

	}
}
