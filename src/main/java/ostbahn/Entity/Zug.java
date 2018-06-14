package ostbahn.Entity;
import ostbahn.Validation.DifferentStartEndConstraint;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DifferentStartEndConstraint
public class Zug implements StartEndBahnhof{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Date startZeit;

	private int sitzPlaetze = 500;

	private int fahrradStellplaetze = 50;

	private int rollStuhlPlaetze = 10;

	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE)
	private Bahnhof start;

	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE)
	private Bahnhof ende;


	public Zug() {
	}

	public Zug(@NotNull Date startZeit, int sitzPlaetze, int fahrradStellplaetze, int rollStuhlPlaetze, @NotNull Bahnhof start, @NotNull Bahnhof ende) {
		this.startZeit = startZeit;
		this.sitzPlaetze = sitzPlaetze;
		this.fahrradStellplaetze = fahrradStellplaetze;
		this.rollStuhlPlaetze = rollStuhlPlaetze;
		this.start = start;
		this.ende = ende;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartZeit() {
		return startZeit;
	}

	public void setStartZeit(Date startZeit) {
		this.startZeit = startZeit;
	}

	public int getSitzPlaetze() {
		return sitzPlaetze;
	}

	public void setSitzPlaetze(int sitzPlaetze) {
		this.sitzPlaetze = sitzPlaetze;
	}

	public int getFahrradStellplaetze() {
		return fahrradStellplaetze;
	}

	public void setFahrradStellplaetze(int fahrradStellplaetze) {
		this.fahrradStellplaetze = fahrradStellplaetze;
	}

	public int getRollStuhlPlaetze() {
		return rollStuhlPlaetze;
	}

	public void setRollStuhlPlaetze(int rollStuhlPlaetze) {
		this.rollStuhlPlaetze = rollStuhlPlaetze;
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
