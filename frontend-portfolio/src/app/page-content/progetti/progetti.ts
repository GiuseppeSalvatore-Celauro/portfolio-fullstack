import { HttpClient } from '@angular/common/http';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-progetti',
  imports: [],
  templateUrl: './progetti.html',
  styleUrl: './progetti.css',
})
export class Progetti implements OnInit {
  categories: any[] = [];
  projects: any[] = [];
  error: boolean = false;
  constructor(private http: HttpClient, private cdr: ChangeDetectorRef) {}
  
  ngOnInit(): void {
    const urlCategories = 'http://localhost:8080/api/categorie';
    const urlProjects = 'http://localhost:8080/api/progetti';

    forkJoin({
      progetti: this.http.get<any[]>(urlProjects),
      categorie: this.http.get<any[]>(urlCategories)
    }).subscribe({
      next: (results) => {
        this.projects = results.progetti;
        this.categories = results.categorie;
        this.cdr.markForCheck();
      },
      error: (err) => {
        console.error('Errore in una delle richieste', err);
        this.error = true;
        this.cdr.markForCheck();
      }
    });
  }
}
