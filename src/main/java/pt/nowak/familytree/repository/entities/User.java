package pt.nowak.familytree.repository.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
//@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long id;

	// @NotNull
	@Column(length = 40, nullable = false)
	private String username;

	@Column(length = 60, nullable = false)
	private String password; //TODO encryption //don't do encryption here, let it to Spring Security configuration

//	@Email
//	@NotNull instead of nullable
	@Column(length = 50, nullable = false)
	private String emailAddress;

//	@Size?
//	@NotNull?
	@OneToMany(mappedBy = "owner")
	private List<Tree> ownedTrees /* = new Collections.emptyList() because fuck NullPointerExceptions*/;

	@ManyToMany
	@JoinTable(
			name = "TreeAllowedUsers",
			joinColumns = @JoinColumn(name = "allowedUser"),
			inverseJoinColumns = @JoinColumn(name = "tree"))
	private Set<Tree> modificableTrees; //mutableTrees


	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) { // I don't think you need setter for id.
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<Tree> getOwnedTrees() {
		return ownedTrees;
	}

	public void setOwnedTrees(List<Tree> ownedTrees) {
		this.ownedTrees = ownedTrees; // should be a copy of list, so no one could modify it outside
	}

	public Set<Tree> getModificableTrees() {
		return modificableTrees; // Collections.unmodifiableSet(modificableTrees); or copy
	}

	public void setModificableTrees(Set<Tree> modificableTrees) { // what is the difference between this and setOwnedTrees?
		this.modificableTrees = modificableTrees;
	}
}
