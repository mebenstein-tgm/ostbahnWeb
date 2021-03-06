package ostbahn.Entity;
import ostbahn.Validation.DifferentStartEndConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DifferentStartEndConstraint
public class Strecke implements StartEndBahnhof{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private Bahnhof start;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private Bahnhof ende;

	public Strecke() {
	}

	public Strecke(@NotNull Bahnhof start, @NotNull Bahnhof ende) {
		this.start = start;
		this.ende = ende;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public Bahnhof getStart() {
		return start;
	}

	public void setStart(Bahnhof start) {
		this.start = start;
	}

	public Bahnhof getEnde() {
		return ende;
	}

	public void setEnde(Bahnhof ende) {
		this.ende = ende;
	}


}
