package sklep.przyklady;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sklep.model.Product;

public class P3_Parametry {

	public static void main(String[] args) {
		
		BigDecimal min = BigDecimal.valueOf(2000);
		BigDecimal max = BigDecimal.valueOf(3000);
	
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("sklep");
			em = emf.createEntityManager();
			TypedQuery<Product> query = em.createQuery(
					"SELECT p FROM Product p WHERE p.price BETWEEN :minprice AND :maxprice ORDER BY p.productId",
					Product.class);
			query.setParameter("minprice", min);
			query.setParameter("maxprice", max);

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
