import { Injectable } from '@angular/core';
import { API_PATH } from 'src/environments/environment';
import {HttpClient} from "@angular/common/http";
import {IExercicio} from "./IExercicio";
import {IFicha} from "./IFicha";
import {IPessoa} from "./IPessoa";

@Injectable({
  providedIn: 'root'
})
export class ExercicioService {

  constructor(private httpClient: HttpClient) { }

  obterTodos(){
    return this.httpClient.get<IExercicio[]>(`${API_PATH}exercicio/listar`).toPromise();
  }

  obterExercicio(id: number){
    return this.httpClient.get<IExercicio>(`${API_PATH}exercicio/buscar/${id}`).toPromise();
  }
  adicionarExercicio(exercicio: IExercicio){
    return this.httpClient.post<IExercicio>(`${API_PATH}exercicio/salvar`, exercicio).toPromise()
  }

  atualizarExercicio(exercicio: IExercicio){
    return this.httpClient.post<IExercicio>(`${API_PATH}exercicio/salvar/${exercicio.id}`, exercicio).toPromise();
  }
  deletarExercicio(id: number){
    return this.httpClient.delete<void>(`${API_PATH}exercicio/deletar/${id}`).toPromise();
  }
}
