import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Etudiant } from '../shared/models/Etudiant';
import { BehaviorSubject, Observable } from 'rxjs';
import { UserService } from './user.service';
import { ADD_ETUDIANT, DELETE_ETUDIANT, GET_ALL_ETUDIANT, GET_ETUDIANT, UPDATE_ETUDIANT } from '../shared/constants/urls';

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {


  // private EtudiantSubject = new BehaviorSubject<Etudiant>(this.getEtudiantFromLocalStorage());
  // public EtudiantObservable:Observable<Etudiant> | undefined ;

  // EtudiantsSelected : Etudiant = new Etudiant();

  // private etudiant:Etudiant = new Etudiant();

  constructor(private http:HttpClient,private userService:UserService) {
    // this.etudiantObservable = this.etudiantSubject.asObservable();
  }

  public getEtudiants(): Observable<Etudiant[]> {
    return this.http.get<Etudiant[]>(GET_ALL_ETUDIANT);
  }

  public getEtudiant(etudiantId:Etudiant): Observable<Etudiant> {
    return this.http.get<Etudiant>(GET_ETUDIANT+etudiantId);
  }

  public addEtudiant(etudiant:Etudiant): Observable<Etudiant> {
    return this.http.post<Etudiant>(ADD_ETUDIANT,etudiant);
  }

  public updateEtudiant(etudiantId:Etudiant,etudiant:Etudiant): Observable<Etudiant> {
    return this.http.put<Etudiant>(UPDATE_ETUDIANT+etudiantId,etudiant);
  }

  public deleteEtudiant(etudiantId: number): Observable<void> {
    return this.http.delete<void>(DELETE_ETUDIANT+etudiantId);
  }
}
