package Test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import com.SLiottaDev.Models.Cart;
import com.SLiottaDev.Models.Order;
import com.SLiottaDev.Models.OrderItem;
import com.SLiottaDev.Models.Product;
import com.SLiottaDev.Models.User;

public class PersistenceTest {

	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	@Transactional 
	public static void main(String[] args) {
		
/*
		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
		

		User usr = new User(1L,"Sebastian","Liotta","Franco 2865", null, null);
		manager.getTransaction().begin();
		manager.merge(usr);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("GRABADO");
*/
		CargarDatosCarro();
		ImprimirTodo();
	}
	
	private static void CargarDatosCarro() {
		/*
		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
		
		manager.getTransaction().begin();
		
		//Cargo Productos
		Product prd1 = new Product(0L, "Chopp de Cerveza"	   , 140.0, null);
		Product prd2 = new Product(1L, "Pizza Muzzarella"	   , 360.0, null);
		Product prd3 = new Product(2L, "Porcion de Fritas"     , 350.0, null);
		Product prd4 = new Product(3L, "Bastones de Muzzarella", 400.0, null);
		Product prd5 = new Product(4L, "Chips de Pollo"		   , 450.0, null);
		Product prd6 = new Product(5L, "Empanadas"			   ,  78.0, null);
		Product prd7 = new Product(6L, "Gaseosa 600cc"		   , 120.0, null);
		Product prd8 = new Product(7L, "Speed Lata"			   , 150.0, null);
		Product prd9 = new Product(8L, "Chandon Botella 1L"    , 700.0, null);
		Product prdA = new Product(9L, "Fernet-Cola Vaso"      , 350.0, null);

		
		manager.merge(prd1);
		manager.merge(prd2);
		manager.merge(prd3);
		manager.merge(prd4);
		manager.merge(prd5);
		manager.merge(prd6);
		manager.merge(prd7);
		manager.merge(prd8);
		manager.merge(prd9);
		manager.merge(prdA);
		
		
		//Cargo Usuarios 
		
		User usr1 = new User(1L, "Sebastian", "Liotta","Franco 2865", null);
		User usr2 = new User(2L, "Geraldine", "Medina","Checoslovaquia 4404", null);
		User usr3 = new User(3L, "Juan", "Perez","Nazca 5632", null);
		manager.merge(usr1);
		manager.merge(usr2);
		manager.merge(usr3);
		
		//CreoOrder
		Order ord = new Order(1L, LocalDate.of(2020, 2, 8));

		//CreoOrderItems
		OrderItem oi1 = new OrderItem(1L, 5, ord, prd1);
		OrderItem oi2 = new OrderItem(2L, 4, ord, prd3);
		OrderItem oi3 = new OrderItem(3L, 2, ord, prd5);
		OrderItem oi4 = new OrderItem(4L, 5, ord, prd7);

		//CreoCarro (primero creo la orden y luego le asigno el carro)
		Cart crt1 = new Cart(1L, "Carro de Compras 1", 'A', usr1, ord);

		manager.merge( crt1 );
		manager.merge(oi1);
		manager.merge(oi2);
		manager.merge(oi3);
		manager.merge(oi4);

		manager.merge( new Cart(2L, "Carro de Compras 2", 'B', usr1));
		manager.merge( new Cart(3L, "Carro de Compras 3", 'C', usr1));
		manager.merge( new Cart(4L, "Carro de Compras 4", 'D', usr3));
		manager.merge( new Cart(5L, "Carro de Compras 5", 'E', usr3));

		
		manager.getTransaction().commit();
		manager.close();
*/		
	}

	private static void CargarUsuarios(EntityManager manager2) {
/*
		User usr1 = new User(1L, "Sebastian", "Liotta","Franco 2865", null);
		User usr2 = new User(2L, "Geraldine", "Medina","Checoslovaquia 4404", null);
		User usr3 = new User(3L, "Juan", "Perez","Nazca 5632", null);
		manager.merge(usr1);
		manager.merge(usr2);
		manager.merge(usr3);
*/
	}

	private static void CargarProductos(EntityManager man) {

		Product prd1 = new Product(0L, "Chopp de Cerveza"	   , 140.0, null);
		Product prd2 = new Product(1L, "Pizza Muzzarella"	   , 360.0, null);
		Product prd3 = new Product(2L, "Porcion de Fritas"     , 350.0, null);
		Product prd4 = new Product(3L, "Bastones de Muzzarella", 400.0, null);
		Product prd5 = new Product(4L, "Chips de Pollo"		   , 450.0, null);
		Product prd6 = new Product(5L, "Empanadas"			   ,  78.0, null);
		Product prd7 = new Product(6L, "Gaseosa 600cc"		   , 120.0, null);
		Product prd8 = new Product(7L, "Speed Lata"			   , 150.0, null);
		Product prd9 = new Product(8L, "Chandon Botella 1L"    , 700.0, null);
		Product prdA = new Product(9L, "Fernet-Cola Vaso"      , 350.0, null);
		
		man.merge(prd1);
		man.merge(prd2);
		man.merge(prd3);
		man.merge(prd4);
		man.merge(prd5);
		man.merge(prd6);
		man.merge(prd7);
		man.merge(prd8);
		man.merge(prd9);
		man.merge(prdA);
	}

	private static void CargarDatos() {
/*		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
		
		manager.getTransaction().begin();

		User usr1 = new User(1L, "Sebastian", "Liotta","Franco 2865", null);
		User usr2 = new User(2L, "Geraldine", "Medina","Checoslovaquia 4404", null);
		User usr3 = new User(3L, "Juan", "Perez","Nazca 5632", null);
		manager.merge(usr1);
		manager.merge(usr2);
		manager.merge(usr3);
		
		manager.merge( new Cart(1L, "Carro de Compras 1", 'A', usr1, null));
		manager.merge( new Cart(2L, "Carro de Compras 2", 'A', usr2, null));
		manager.merge( new Cart(3L, "Carro de Compras 3", 'B', usr2, null));
		manager.merge( new Cart(4L, "Carro de Compras 4", 'D', usr3, null));
		manager.merge( new Cart(5L, "Carro de Compras 5", 'F', usr3, null));
		manager.merge( new Cart(6L, "Carro de Compras 6", 'R', usr1, null));
		manager.merge( new Cart(7L, "Carro de Compras 7", 'S', usr1, null));		
		
		manager.getTransaction().commit();
		manager.close();
*/		
	}

	@SuppressWarnings("unchecked")
	private static void ImprimirTodo() {
		manager = emf.createEntityManager();
		List<User> usrs = (List<User>) manager.createQuery("FROM User").getResultList();
		List<Cart> carts;
		System.out.println("En esta Base hay "+usrs.size()+" Usuarios");
		for (User usr:usrs ) {
			System.out.println(usr.toString());
			carts = usr.getCarts();
			for (Cart cart:carts) {
				System.out.println("     "+cart.toString());
			}
		}
		manager.close();
	}

}
