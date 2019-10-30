//https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/5013326-manipulez-vos-donnees-avec-les-streams
public enum Couleur {
	MARRON("marron"),
	BLEU("bleu"),
	VERT("vert"),
	VERRON("verron"),
	INCONNU("non déterminé"),
	ROUGE("rouge mais j'avais piscine...");
	
	private String name = "";
	
	Couleur(String n){name = n;}
	public String toString() {return name;}
}

public class Personne {

	public Double taille = 0.0d, poids = 0.0d;
	public String nom = "", prenom = "";
	public Couleur yeux = Couleur.INCONNU;
	public Personne() {	}
	public Personne(double taille, double poids, String nom, String prenom, Couleur yeux) {
		super();
		this.taille = taille;
		this.poids = poids;
		this.nom = nom;
		this.prenom = prenom;
		this.yeux = yeux;
	}
	
	public String toString() {
		String s = "Je m'appelle " + nom + " " + prenom;
		s += ", je pèse " + poids + " Kg";
		s += ", et je mesure " + taille + " cm.";
		return s;
	}
	public Double getTaille() {return taille;}
	public void setTaille(Double taille) {this.taille = taille;}
	public Double getPoids() {return poids;}
	public void setPoids(Double poids) {this.poids = poids;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	public Couleur getYeux() {return yeux;}
	public void setYeux(Couleur yeux) {this.yeux = yeux;}
}


//Et une classe de test : 
import java.util.Arrays;
import java.util.List;

public class TestStream {
	public static void main(String[] args) {
		List<Personne> listP = Arrays.asList(
				new Personne(1.80, 70, "A", "Nicolas", Couleur.BLEU),
				new Personne(1.56, 50, "B", "Nicole", Couleur.VERRON),
				new Personne(1.75, 65, "C", "Germain", Couleur.VERT),
				new Personne(1.68, 50, "D", "Michel", Couleur.ROUGE),
				new Personne(1.96, 65, "E", "Cyrille", Couleur.BLEU),
				new Personne(2.10, 120, "F", "Denis", Couleur.ROUGE),
				new Personne(1.90, 90, "G", "Olivier", Couleur.VERRON)
		);		
	}
}

Stream<Personne> sp = listP.stream();
sp.forEach(System.out::println);
/*
Le code ci-dessus nous permet d'obtenir :

Je m'appelle A Nicolas, je pèse 70.0 Kg, et je mesure 1.8 cm.
Je m'appelle B Nicole, je pèse 50.0 Kg, et je mesure 1.56 cm.
Je m'appelle C Germain, je pèse 65.0 Kg, et je mesure 1.75 cm.
Je m'appelle D Michel, je pèse 50.0 Kg, et je mesure 1.68 cm.
Je m'appelle E Cyrille, je pèse 65.0 Kg, et je mesure 1.96 cm.
Je m'appelle F Denis, je pèse 120.0 Kg, et je mesure 2.1 cm.
Je m'appelle G Olivier, je pèse 90.0 Kg, et je mesure 1.9 cm.

// FILTER
/*
En conservant notre exemple précédent, si nous prenions maintenant uniquement les personne de plus de 50 Kg.
*/
Stream<Personne> sp = listP.stream();
sp.forEach(System.out::println);

System.out.println("\nAprès le filtre");
sp = listP.stream();
sp.	filter(x -> x.getPoids() > 50)
	.forEach(System.out::println);
  
  
/*
Ce qui nous donne :

Je m'appelle A Nicolas, je pèse 70.0 Kg, et je mesure 1.8 cm.
Je m'appelle B Nicole, je pèse 50.0 Kg, et je mesure 1.56 cm.
Je m'appelle C Germain, je pèse 65.0 Kg, et je mesure 1.75 cm.
Je m'appelle D Michel, je pèse 50.0 Kg, et je mesure 1.68 cm.
Je m'appelle E Cyrille, je pèse 65.0 Kg, et je mesure 1.96 cm.
Je m'appelle F Denis, je pèse 120.0 Kg, et je mesure 2.1 cm.
Je m'appelle G Olivier, je pèse 90.0 Kg, et je mesure 1.9 cm.

 Après le filtre
Je m'appelle A Nicolas, je pèse 70.0 Kg, et je mesure 1.8 cm.
Je m'appelle C Germain, je pèse 65.0 Kg, et je mesure 1.75 cm.
Je m'appelle E Cyrille, je pèse 65.0 Kg, et je mesure 1.96 cm.
Je m'appelle F Denis, je pèse 120.0 Kg, et je mesure 2.1 cm.
Je m'appelle G Olivier, je pèse 90.0 Kg, et je mesure 1.9 cm.
*/

// MAP
Stream<Personne> sp = listP.stream();
sp.forEach(System.out::println);

System.out.println("\nAprès le filtre et le map");
sp = listP.stream();
sp.	filter(x -> x.getPoids() > 50)
	.map(x -> x.getPoids())
	.forEach(System.out::println);
  
 /*
 Ce qui donne le résultat suivant :

Je m'appelle A Nicolas, je pèse 70.0 Kg, et je mesure 1.8 cm.
Je m'appelle B Nicole, je pèse 50.0 Kg, et je mesure 1.56 cm.
Je m'appelle C Germain, je pèse 65.0 Kg, et je mesure 1.75 cm.
Je m'appelle D Michel, je pèse 50.0 Kg, et je mesure 1.68 cm.
Je m'appelle E Cyrille, je pèse 65.0 Kg, et je mesure 1.96 cm.
Je m'appelle F Denis, je pèse 120.0 Kg, et je mesure 2.1 cm.
Je m'appelle G Olivier, je pèse 90.0 Kg, et je mesure 1.9 cm.

Après le filtre
70.0
65.0
65.0
120.0
90.0
 */
 
 // REDUCE
 Stream<Personne> sp = listP.stream();
sp.forEach(System.out::println);

System.out.println("\nAprès le filtre et le map et reduce");
sp = listP.stream();

Double sum = sp	.filter(x -> x.getPoids() > 50)
				.map(x -> x.getPoids())
				.reduce(0.0d, (x,y) -> x+y);
System.out.println(sum);

/*
Après le filtre et le map
410.0
*/

// REDUCE + CHECK
System.out.println("\nAprès le filtre et le map et reduce");
sp = listP.stream();

Optional<Double> sum = sp	.filter(x -> x.getPoids() > 250)
							.map(x -> x.getPoids())
							.reduce((x,y) -> x+y);
if(sum.isPresent())
	System.out.println(sum.get());
else
	System.out.println("Aucun aggrégat de poids...");
  
 // COUNT
 sp = listP.stream();

long count = sp	.filter(x -> x.getPoids() > 50)
				.map(x -> x.getPoids())
				.count();

System.out.println("Nombre d'éléments : " + count);

// COLLECT
sp = listP.stream();

List<Double> ld = sp.filter(x -> x.getPoids() > 50)
					.map(x -> x.getPoids())
					.collect(Collectors.toList());
System.out.println(ld);
/*
Ce qui nous retourne :

[70.0, 65.0, 65.0, 120.0, 90.0]
*/
