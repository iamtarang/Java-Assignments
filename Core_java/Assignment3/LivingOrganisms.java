package Assignment3;

class Kingdom {
	protected String name;

	public Kingdom(String name) {
		this.name = name;
	}

	public void display() {
		System.out.println("Kingdom: " + name);
	}
}

class Phylum extends Kingdom {
	private String phylum;

	public Phylum(String kingdom, String phylum) {
		super(kingdom);
		this.phylum = phylum;
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Phylum: " + phylum);
	}
}

class Class extends Phylum {
	private String className;

	public Class(String kingdom, String phylum, String className) {
		super(kingdom, phylum);
		this.className = className;
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Class: " + className);
	}
}

class Order extends Class {
	private String order;

	public Order(String kingdom, String phylum, String className, String order) {
		super(kingdom, phylum, className);
		this.order = order;
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Order: " + order);
	}
}

class Family extends Order {
	private String family;

	public Family(String kingdom, String phylum, String className, String order, String family) {
		super(kingdom, phylum, className, order);
		this.family = family;
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Family: " + family);
	}
}

class Genus extends Family {
	private String genus;

	public Genus(String kingdom, String phylum, String className, String order, String family, String genus) {
		super(kingdom, phylum, className, order, family);
		this.genus = genus;
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Genus: " + genus);
	}
}

class Species extends Genus {
	private String species;

	public Species(String kingdom, String phylum, String className, String order, String family, String genus,
			String species) {
		super(kingdom, phylum, className, order, family, genus);
		this.species = species;
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Species: " + species);
	}
}

public class LivingOrganisms {
	public static void main(String[] args) {
		Species human = new Species("Animalia", "Chordata", "Mammalia", "Primates", "Hominidae", "Homo",
				"Homo sapiens");
		human.display();

		System.out.println();

		Species cat = new Species("Animalia", "Chordata", "Mammalia", "Carnivora", "Felidae", "Felis", "Felis catus");
		cat.display();
	}
}