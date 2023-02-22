import { Component } from '@angular/core';
import { PessoaService } from './pessoa.service';
import { FichaService } from './ficha.service';
import {ExercicioService} from "./exercicio.service";
import {IPessoa} from "./IPessoa";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {IFicha} from "./IFicha";
import {IExercicio} from "./IExercicio";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ApiRequest';

  constructor(private pessoaService: PessoaService,
              private fichaService: FichaService,
              private exercicioService: ExercicioService)
  {}
  obterTodasPessoas(){
    this.pessoaService.obterTodos()
      .then(pessoa => console.log(pessoa))
      .catch(error => console.error(error));
  }

  obterPessoa(){
    this.pessoaService.obterPessoa(1)
      .then(pessoa => console.log(pessoa))
      .catch(error => console.error(error));
  }

  adicionarPessoa(){
    const pessoa: IPessoa = {
      nome: "Pessoa Adicionada",
      cpf: "12345678900",
      email: "emailnexiste@hotmail.com"
    }
    this.pessoaService.adicionarPessoa(pessoa)
      .then(pessoa => console.log('Sucesso'))
      .catch(error => console.error(error))
  }

  atualizarPessoa(){
    const pessoa: IPessoa = {
      nome: "Pessoa atualizada",
      cpf: "12345678900",
      email: "emaile@hotmail.com",
      id: 1
    }
    this.pessoaService.atualizarPessoa(pessoa)
      .then(pessoa => console.log('Atualizado'))
      .catch(error => console.error(error))
  }
  removerPessoa(){
    this.pessoaService.deletarPessoa(1)
      .then(res => console.log('Removido', res))
      .catch(error => console.error(error));
  }
  obterTodasFichas(){
    this.fichaService.obterTodos().then(ficha => console.log(ficha))
      .catch(error => console.error(error));
  }

  obterFicha(){
    this.fichaService.obterFicha(1)
      .then(ficha => console.log(ficha))
      .catch(error => console.error(error));
  }

  adicionarFicha(){
    const ficha: IFicha = {
      quantidade: 1,
      numero: 1,
      exercicio: 1,
      pessoa: 1
    }
    this.fichaService.adicionarFicha(ficha)
      .then(ficha => console.log('Sucesso'))
      .catch(error => console.error(error))
  }

  atualizarFicha(){
    const ficha: IFicha = {
      quantidade: 1,
      numero: 1,
      exercicio: 1,
      pessoa: 1,
      id: 1
    }
    this.fichaService.atualizarFicha(ficha)
      .then(ficha => console.log('Atualizado'))
      .catch(error => console.error(error))
  }

  removerFicha(){
    this.fichaService.deletarFicha(1)
      .then(res => console.log('Removido', res))
      .catch(error => console.error(error));
  }
  obterTodosExercicios(){
    this.exercicioService.obterTodos().then(exercicio => console.log(exercicio))
      .catch(error => console.error(error));
  }
  obterExercicio(){
    this.exercicioService.obterExercicio(1)
      .then(exercicio => console.log(exercicio))
      .catch(error => console.error(error));
  }

  adicionarExercicio(){
    const exercicio: IExercicio = {
      nome: "flexao",
      descricao: "Flexionar os bracos",
      repeticoes: 10,
      series: 3,
      equipamento: "nenhum"
    }
    this.exercicioService.adicionarExercicio(exercicio)
      .then(exercicio => console.log('Sucesso'))
      .catch(error => console.error(error))
  }

  atualizarExercicio(){
    const exercicio: IExercicio = {
      nome: "Flexao apoiada",
      descricao: "Flexionar os bracos",
      repeticoes: 10,
      series: 3,
      equipamento: "nenhum",
      id: 1
    }
    this.exercicioService.atualizarExercicio(exercicio)
      .then(exercicio => console.log('Atualizado'))
      .catch(error => console.log(error))
  }
  removerExercicio(){
    this.exercicioService.deletarExercicio(1)
      .then(res => console.log('Removido', res))
      .catch(error => console.error(error));
  }

}
