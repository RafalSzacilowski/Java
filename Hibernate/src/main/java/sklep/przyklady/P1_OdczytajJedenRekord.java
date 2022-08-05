package sklep.przyklady;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sklep.model.Product;

public class P1_OdczytajJedenRekord {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Początek rpogramu");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sklep");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Utworzony EntitManage: " + em);
		
		while(true) {
			System.out.println("Podaj id produktu (0 aby zakonczyc): ");
			int id = scanner.nextInt();
			scanner.nextLine();
			if(id==0) break;
			
			Product product = em.find(Product.class, id);
			if(product == null) {
				System.out.println("Nie ma produktu o numerze " + id);
			}else {
				System.out.println("Odczytany obiekt: " + product);
				System.out.printf("%s, %s (%s VAT), opis: %s\n" , 
						product.getProductId(), product.getProductName(), product.getPrice(), product.getVat(), product.getDescription());
			}
		}
		
		System.out.println("Zamykam połączenie...");
		
		em.close();
		emf.close();
		
	}
}
