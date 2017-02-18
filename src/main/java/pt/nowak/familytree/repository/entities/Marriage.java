package pt.nowak.familytree.repository.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Marriage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marriageId")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "husband")
	private Person husband;

	@ManyToOne
	@JoinColumn(name = "wife")
	private Person wife;

	@Column
	private Date weddingDate;

	public Marriage() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getHusband() {
		return husband;
	}

	public void setHusband(Person husband) {
		this.husband = husband;
	}

	public Person getWife() {
		return wife;
	}

	public void setWife(Person wife) {
		this.wife = wife;
	}

	public Date getWeddingDate() {
		return weddingDate;
	}

	public void setWeddingDate(Date weddingDate) {
		this.weddingDate = weddingDate;
	}
}
