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

	private Date weddingDate;
}
