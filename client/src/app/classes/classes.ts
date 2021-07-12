export interface User {
    id: number;
    username: string;
    password: string;
    userLevel: number;
    experience: number;
}

export interface Exercise {
    id: number;
    name: string;
    description: string;
    completed: boolean;
}

export interface CustomExercise {
    id: number;
    name: string;
    description: string;
    completed: boolean;
}

export interface Workout {
    id: number;
    name: string;
}