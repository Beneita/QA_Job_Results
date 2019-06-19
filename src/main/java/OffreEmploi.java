
public class OffreEmploi {
	private String titre;
	private String lien;
	private String description;

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

	public OffreEmploi(String titre, String lien, String description) {
		super();
		this.titre = titre;
		this.lien = lien;
		this.description = description;
	}

}
