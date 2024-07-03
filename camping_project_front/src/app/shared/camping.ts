export class Camping {
    idCamping: number;
    nom: string;
    adresse: string;
    description: string;
    budget: number;
    dateDebut: Date;
    dateFin: Date;
    trancheAge: number;
    statut: string;
    constructor(idCamping: number, nom: string, adresse: string, description: string, budget: number,
        dateDebut: Date, dateFin: Date, trancheAge: number, statut: string) {
        this.idCamping = idCamping;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.budget = budget;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.trancheAge = trancheAge;
        this.statut = statut
    }
}
