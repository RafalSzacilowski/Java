package sklep.przyklady;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sklep.model.Product;

public class P2c_OdczytajWszystkieProdukty_Stream {

	public static void main(String[] args) {

		System.out.println("Początek rpogramu");
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("sklep");
			em = emf.createEntityManager();
			TypedQuery<Product> query = em.createNamedQuery("Product.findAll", Product.class);
			
			query.getResultStream().forEachOrdered(product -> {
				System.out.printf("Produkt nr %s| %s| cena: %s (%s VAT)| opis: %s\n\n", product.getProductId(),
						product.getProductName(), product.getPrice(), product.getVat(), product.getDescription());
			});
			
				
		} finally {
			if (em != null)
				em.close();

			if (emf != null)
				emf.close();
		}

	}
}
