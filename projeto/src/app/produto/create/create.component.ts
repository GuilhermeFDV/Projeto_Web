import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../produto.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators} from '@angular/forms';
     
@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
    
  form!: FormGroup;
    
  /*------------------------------------------
  --------------------------------------------
  Created constructor
  --------------------------------------------
  --------------------------------------------*/
  constructor(
    public produtoService: ProdutoService,
    private router: Router
  ) { }
    
  /**
   * Write code on Method
   *
   * @return response()
   */
  ngOnInit(): void {
    this.form = new FormGroup({
      nome: new FormControl('', [Validators.required]),
      descricao: new FormControl('', Validators.required),
      preco_kg: new FormControl ( '', Validators.required),
      estoque: new FormControl ( '', Validators.required),
    });
  }
    
  /**
   * Write code on Method
   *
   * @return response()
   */
  get f(){
    return this.form.controls;
  }
    
  /**
   * Write code on Method
   *
   * @return response()
   */
  submit(){
    console.log(this.form.value);
    this.produtoService.create(this.form.value).subscribe((res:any) => {
         console.log('Produto created successfully!');
         this.router.navigateByUrl('produto/index');
    })
  }
  
}