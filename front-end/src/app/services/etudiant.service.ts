import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Etudiant } from '../shared/models/Etudiant';
import { BehaviorSubject, Observable } from 'rxjs';
import { ADD_ETUDIANT, DELETE_ETUDIANT, GET_ALL_ETUDIANT, GET_ETUDIANT, UPDATE_ETUDIANT } from '../shared/constants/urls';

const ETUDIANT_KEY='User';

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {

   private EtudiantSubject = new BehaviorSubject<Etudiant>(this.getEtudiantFromLocalStorage());
   public EtudiantObservable:Observable<Etudiant> | undefined ;

   EtudiantsSelected : Etudiant = new Etudiant();

   private etudiant:Etudiant = new Etudiant();

  constructor(private http:HttpClient) {
     this.EtudiantObservable = this.EtudiantSubject.asObservable();
  }

  public getEtudiants(): Observable<Etudiant[]> {
    return this.http.get<Etudiant[]>(GET_ALL_ETUDIANT);
  }

  public getEtudiant(etudiantId:Etudiant): Observable<Etudiant> {
    return this.http.get<Etudiant>(GET_ETUDIANT+etudiantId);
  }

  public addEtudiant(etudiant:Etudiant): Observable<Etudiant> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.http.post<Etudiant>(ADD_ETUDIANT,etudiant, httpOptions );
  }

  public updateEtudiant(etudiant:Etudiant): Observable<Etudiant> {
    return this.http.put<Etudiant>(UPDATE_ETUDIANT,etudiant);
  }

  public deleteEtudiant(etudiantId: number): Observable<void> {
    return this.http.delete<void>(DELETE_ETUDIANT+etudiantId);
  }

  private setEtudiantToLocalStorage(etudiant:Etudiant){
    localStorage.setItem(ETUDIANT_KEY, JSON.stringify(etudiant));
}

private getEtudiantFromLocalStorage():Etudiant{
    const etudiantJson = localStorage.getItem(ETUDIANT_KEY);
    if(etudiantJson) return JSON.parse(etudiantJson) as Etudiant;
    return new Etudiant();
}






}
