export class Camping {
    idCamping: number;
    nom: string;
    adresse: string;
    description: string;
    prix_camping: number;
    dateDebut: Date;
    statut: string;
    constructor(idCamping: number, nom: string, adresse: string, description: string, prix_camping: number,
        dateDebut: Date, statut: string) {
        this.idCamping = idCamping;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.prix_camping = prix_camping;
        this.dateDebut = dateDebut;
        this.statut = statut
    }
}
