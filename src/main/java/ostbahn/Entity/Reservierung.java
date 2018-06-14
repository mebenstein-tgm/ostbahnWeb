
package ostbahn.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservierung {

	@Id
	@GeneratedValue
	private Long ID;

	private Date datum;

	private int praemienMeilenBonus = 15;

	private int preis = 150;

	private StatusInfo status;

	@ManyToOne
	private Zug zug;

	@ManyToOne
	private Strecke strecke;

	@ManyToOne
	private Benutzer benutzer;

	@Transient
	private Zahlung zahlung;

	private ReserungsOption option;

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getPraemienMeilenBonus() {
		return praemienMeilenBonus;
	}

	public void setPraemienMeilenBonus(int praemienMeilenBonus) {
		this.praemienMeilenBonus = praemienMeilenBonus;
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	public StatusInfo getStatus() {
		return status;
	}

	public void setStatus(StatusInfo status) {
		this.status = status;
	}

	public Zug getZug() {
		return zug;
	}

	public void setZug(Zug zug) {
		this.zug = zug;
	}

	public Strecke getStrecke() {
		return strecke;
	}

	public void setStrecke(Strecke strecke) {
		this.strecke = strecke;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public Zahlung getZahlung() {
		return zahlung;
	}

	public void setZahlung(Zahlung zahlung) {
		this.zahlung = zahlung;
	}

	public ReserungsOption getOption() {
		return option;
	}

	public void setOption(ReserungsOption option) {
		this.option = option;
	}

	public Reservierung() {
	}

	public Reservierung(Date datum, int praemienMeilenBonus, int preis, StatusInfo status, Zug zug, Strecke strecke, Benutzer benutzer, Zahlung zahlung) {
		this.datum = datum;
		this.praemienMeilenBonus = praemienMeilenBonus;
		this.preis = preis;
		this.status = status;
		this.zug = zug;
		this.strecke = strecke;
		this.benutzer = benutzer;
		this.zahlung = zahlung;
	}

}
