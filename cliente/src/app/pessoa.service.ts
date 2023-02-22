import { Injectable } from '@angular/core';
import { API_PATH } from 'src/environments/environment';
import {HttpClient} from "@angular/common/http";
import {IPessoa} from "./IPessoa";
import {IFicha} from "./IFicha";

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private httpClient: HttpClient) { }

  obterTodos(){
    return this.httpClient.get<IPessoa[]>(`${API_PATH}pessoa/listar`).toPromise();
  }

  obterPessoa(id: number){
    return this.httpClient.get<IPessoa>(`${API_PATH}pessoa/buscar/${id}`).toPromise();
  }
  adicionarPessoa(pessoa: IPessoa){
    return this.httpClient.post<IPessoa>(`${API_PATH}pessoa/salvar`, pessoa).toPromise()
  }
  atualizarPessoa(pessoa: IPessoa){
    return this.httpClient.put<IPessoa>(`${API_PATH}pessoa/salvar/${pessoa.id}`, pessoa).toPromise();
  }

  deletarPessoa(id: number){
    return this.httpClient.delete<void>(`${API_PATH}pessoa/deletar/${id}`).toPromise();
  }
}
