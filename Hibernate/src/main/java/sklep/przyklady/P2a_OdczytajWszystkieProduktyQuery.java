package sklep.przyklady;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sklep.model.Product;

public class P2a_OdczytajWszystkieProduktyQuery {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Początek programu");
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("sklep");
			em = emf.createEntityManager();

			TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p ORDER BY p.productId", Product.class);

			List<Product> products = query.getResultList();

			for (Product product : products) {
				System.out.printf("%s, %s (%s VAT), opis: %s\n", product.getProductId(), product.getProductName(),
						product.getPrice(), product.getVat(), product.getDescription());
			}

		} finally {
			if(em!=null) em.close();
		
			if(emf!=null) emf.close();		
			}

		

	}
}
