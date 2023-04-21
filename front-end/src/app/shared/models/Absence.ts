import { Etudiant } from "./Etudiant";
import { Matiere } from "./Matiere";

export class Absence{
  id!:number;
  heure!:Date;
  date!:Date;
  matiere!:Matiere;
  etudiant!:Etudiant;
  justification!:string;
  justifie!:string;


  constructor(date: Date, heure: Date, matiere: Matiere,  etudiant: Etudiant, justification: string,justifie:string) {
    this.date = date;
    this.heure = heure;
    this.matiere = matiere;
    this.etudiant = etudiant;
    this.justification = justification;
    this.justifie = justifie;
  }

}


