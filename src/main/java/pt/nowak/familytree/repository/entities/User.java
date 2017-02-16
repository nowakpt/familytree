package pt.nowak.familytree.repository.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long id;

	@Column(length = 40, nullable = false)
	private String username;

	@Column(length = 60, nullable = false)
	private String password; //TODO encryption

	@Column(length = 50, nullable = false)
	private String emailAddress;

	@OneToMany(mappedBy = "owner")
	private List<Tree> ownedTrees;

	@ManyToMany
	@JoinTable(
			name = "TreeAllowedUsers",
			joinColumns = @JoinColumn(name = "allowedUser"),
			inverseJoinColumns = @JoinColumn(name = "tree"))
	private Set<Tree> modificableTrees;


	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		this.ownedTrees = ownedTrees;
	}

	public Set<Tree> getModificableTrees() {
		return modificableTrees;
	}

	public void setModificableTrees(Set<Tree> modificableTrees) {
		this.modificableTrees = modificableTrees;
	}
}
