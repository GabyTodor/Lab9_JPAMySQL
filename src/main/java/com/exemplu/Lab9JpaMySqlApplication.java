package com.exemplu;

import com.exemplu.repository.MasinaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

@SpringBootApplication
public class Lab9JpaMySqlApplication implements CommandLineRunner {
	@Autowired
	MasinaJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Lab9JpaMySqlApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("\nMeniul: ");
			System.out.println("0.Iesire");
			System.out.println("1.Adăugarea unei mașini în BD");
			System.out.println("2.Ștergerea unei mașini indicată prin numărul de înmatriculare");
			System.out.println("3.Căutarea unei mașini după numărul de înmatriculare");
			System.out.println("4.Extragerea unei liste care conţine toate mașinile din baza de date");
			System.out.println("5.Determinarea numărului de mașini din BD care au o anumită marcă");
			System.out.println("6.Determinarea numărului de mașini din BD care au sub 100 000 km");
			System.out.println("7.Extragera unei liste care conţine maşinile mai noi de 5 ani");
			System.out.print("Introduceti optiunea dorita: ");
			String opt = sc.nextLine();
			switch(opt){
				default:
					System.out.println("Invalid option");
					break;
				case "0":
					exit(0);
				case "1":
					System.out.println("Adauga datele masinii: ");
					System.out.print("Numarul de inmatriculare: ");
					String nr_inmatriculare=sc.nextLine();
					System.out.print("Marca: ");
					String marca=sc.nextLine();
					System.out.print("Anul fabricatiei: ");
					int an=sc.nextInt();
					sc.nextLine();
					System.out.print("Culoarea: ");
					String culoare=sc.nextLine();
					System.out.print("Numarul de kilometrii: ");
					int nr_km=sc.nextInt();
					sc.nextLine();
					System.out.println("\nSe adauga masina cu nr_inmatriculare "+nr_inmatriculare+", avand datele: "
							+repository.insert(new Masina(nr_inmatriculare,marca,an,culoare,nr_km)));
					break;
				case "2":
					System.out.print("Introduceti nr_inmatriculare al masinei sterse: ");
					String nr_inmatriculare1= sc.nextLine();
					repository.deleteByNrInmatriculare(nr_inmatriculare1);
					break;
				case "3":
					System.out.print("Introduceti nr_inmatriculare al masinei cautate: ");
					String nr_inmatriculare2= sc.nextLine();
					System.out.println(repository.findByNrInmatriculare(nr_inmatriculare2));
					break;
				case "4":
					System.out.println("Toate masinile: ");
					List<Masina> masini=repository.findAll();
					masini.forEach(System.out::println);
					break;
				case "5":
					System.out.print("Introduceti marca masinii: ");
					String marca1=sc.nextLine();
					System.out.print("Numarul de "+marca1+" este: "+
							repository.findAll().stream().filter(a->a.getMarca().equals(marca1)).count());
					break;
				case "6":
					System.out.println("Numarul de masini sub 100 000 km: " +
							repository.findAll().
									stream().
									filter(a->a.getNrKilometrii()<100000).
									count());
					break;
				case "7":
					List<Masina> masini_noi;
					System.out.println("Lista cu masinile mai noi de 5 ani: ");
					masini_noi=repository.findAll().stream().
							filter(a->a.getAnFabricatie()>= LocalDate.now().getYear()-5) .
							toList();
					masini_noi.forEach(System.out::println);
					break;
			}
		}while(true);

	}
}
