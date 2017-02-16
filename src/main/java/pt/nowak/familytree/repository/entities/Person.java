package pt.nowak.familytree.repository.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personId")
	private Long id;

	@Column(length = 40)
	private String firstName;

	@Column(length = 40)
	private String lastName;

	private Date dateOfBirth;

	private Date dateOfDeath;

	@Lob
	private String note;

	@ManyToOne
	@JoinColumn(name = "father")
	private Person father;

	@ManyToOne
	@JoinColumn(name = "mother")
	private Person mother;

	public Person() {}

	private Person(PersonBuilder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.dateOfBirth = builder.dateOfBirth;
		this.dateOfDeath = builder.dateOfDeath;
		this.note = builder.note;
		this.father = builder.father;
		this.mother = builder.mother;
	}

	static public class PersonBuilder {
		private Long id;
		private String firstName;
		private String lastName;
		private Date dateOfBirth;
		private Date dateOfDeath;
		private String note;
		private Person father;
		private Person mother;

		public PersonBuilder withId(Long id) { this.id = id; return this; }
		public PersonBuilder withFirstName(String firstName) { this.firstName = firstName; return this; }
		public PersonBuilder withLastName(String lastName) { this.lastName = lastName; return this; }
		public PersonBuilder withDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; return this; }
		public PersonBuilder withDateOfDeath(Date dateOfDeath) { this.dateOfDeath = dateOfDeath; return this; }
		public PersonBuilder withNote(String note) { this.note = note; return this; }
		public PersonBuilder withFather(Person father) { this.father = father; return this; }
		public PersonBuilder withMother(Person mother) { this.mother = mother; return this; }

		public Person build() {
			return new Person(this);
		}
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	public String getNote() {
		return note;
	}

	public Person getFather() {
		return father;
	}

	public Person getMother() {
		return mother;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}
}
