package website.objects;

import java.time.LocalDate;

public class OffreEmploi {

	private String titre = "";

	private String lien = "";

	private String description = "";

	private String localisation = "";

	private String site = "";

	private LocalDate datAnnonce = LocalDate.now();

	public String getTitre() {

		return titre;

	}

	public void setTitre(String titre) {

		this.titre = titre;

	}

	public String getLien() {

		return lien;

	}

	public void setLien(String lien) {

		this.lien = lien;

	}

	public String getDescription() {

		return description;

	}

	public void setDescription(String description) {

		this.description = description;

	}

	public String getLocalisation() {

		return localisation;

	}

	public void setLocalisation(String localisation) {

		this.localisation = localisation;

	}

	public String getSite() {

		return site;

	}

	public void setSite(String site) {

		this.site = site;

	}

	public LocalDate getDateAnnonce() {

		return datAnnonce;

	}

	public void setDateAnnonc(LocalDate datAnnonce) {

		this.datAnnonce = datAnnonce;

	}

	public OffreEmploi(String titre, String lien, String description, String localisation, String site,

			LocalDate datAnnonce) {

		super();

		this.titre = titre;

		this.lien = lien;

		this.description = description;

		this.localisation = localisation;

		this.site = site;

		this.datAnnonce = datAnnonce;

	}

	public OffreEmploi() {
		super();
	}

}
