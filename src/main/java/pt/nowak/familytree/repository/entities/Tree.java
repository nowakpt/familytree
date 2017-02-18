package pt.nowak.familytree.repository.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Tree {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "treeId")
	private Long id;

	@Lob
	@Column
	private String note;

	@ManyToOne
	@JoinColumn(name = "owner", nullable = false)
	private User owner;

	@ManyToMany(mappedBy = "modificableTrees")
	private Set<User> allowedModifiers;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="tree")
	private Set<Person> familyMembers;


	public Tree() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Set<User> getAllowedModifiers() {
		return allowedModifiers;
	}

	public void setAllowedModifiers(Set<User> allowedModifiers) {
		this.allowedModifiers = allowedModifiers;
	}

	public Set<Person> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(Set<Person> familyMembers) {
		this.familyMembers = familyMembers;
	}
}
