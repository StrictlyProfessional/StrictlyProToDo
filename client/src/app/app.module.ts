import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { VaultComponent } from './components/vault/vault.component';
import { LeaderboardComponent } from './components/leaderboard/leaderboard.component';
import { LoginComponent } from './components/login/login.component';
import { DiscoveryComponent } from './components/discovery/discovery.component';
import { NavComponent } from './components/nav/nav.component';
import { AddexerciseComponent } from './components/addexercise/addexercise.component';
import { ExerciseComponent } from './components/exercise/exercise.component';
import { WorkoutComponent } from './components/workout/workout.component';
import { LeaderboardCardComponent } from './components/leaderboard-card/leaderboard-card.component';

@NgModule({
  declarations: [
    AppComponent,
    VaultComponent,
    LeaderboardComponent,
    LoginComponent,
    DiscoveryComponent,
    NavComponent,
    AddexerciseComponent,
    ExerciseComponent,
    WorkoutComponent,
    LeaderboardCardComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
