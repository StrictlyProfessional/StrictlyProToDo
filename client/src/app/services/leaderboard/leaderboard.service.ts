import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { User } from 'src/app/classes/User';

@Injectable({
  providedIn: 'root'
})
export class LeaderboardService {

  private leaderboardURL = 'http://localhost:8080/user'

  constructor(private http: HttpClient) { }

  // Get
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.leaderboardURL);
  }
}
