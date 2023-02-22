import { Injectable } from '@angular/core';
import { API_PATH } from 'src/environments/environment';
import {HttpClient} from "@angular/common/http";
import {IFicha} from "./IFicha";
import {IPessoa} from "./IPessoa";
import {IExercicio} from "./IExercicio";

@Injectable({
  providedIn: 'root'
})
export class FichaService {

  constructor(private httpClient: HttpClient) { }

  obterTodos(){
    return this.httpClient.get<IFicha[]>(`${API_PATH}fichaTreino/listar`).toPromise();
  }

  obterFicha(id: number){
    return this.httpClient.get<IFicha>(`${API_PATH}fichaTreino/buscar/${id}`).toPromise();
  }
  adicionarFicha(ficha: IFicha){
    return this.httpClient.post<IFicha>(`${API_PATH}fichaTreino/salvar`, ficha).toPromise()
  }

  atualizarFicha(ficha: IFicha){
    return this.httpClient.put<IFicha>(`${API_PATH}fichaTreino/salvar/${ficha.id}`, ficha).toPromise();
  }
  deletarFicha(id: number){
    return this.httpClient.delete<void>(`${API_PATH}fichaTreino/deletar/${id}`).toPromise();
  }
}
