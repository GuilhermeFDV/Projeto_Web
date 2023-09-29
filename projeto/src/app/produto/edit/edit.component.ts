import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../produto.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Produto } from '../produto';
import { FormGroup, FormControl, Validators} from '@angular/forms';
     
@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
      
  id!: number;
  produto!: Produto;
  form!: FormGroup;
    
  /*------------------------------------------
  --------------------------------------------
  Created constructor
  --------------------------------------------
  --------------------------------------------*/
  constructor(
    public produtoService: ProdutoService,
    private route: ActivatedRoute,
    private router: Router
  ) { }
    
  /**
   * Write code on Method
   *
   * @return response()
   */
  ngOnInit(): void {
    this.id = this.route.snapshot.params['produtoId'];
    this.produtoService.find(this.id).subscribe((data: Produto)=>{
      this.produto = data;
    }); 
      
    this.form = new FormGroup({
      nome: new FormControl('', [Validators.required]),
      descricao: new FormControl('', Validators.required),
      preco_kg: new FormControl('', Validators.required),
      estoque: new FormControl('', Validators.required)
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
    this.produtoService.update(this.id, this.form.value).subscribe((res:any) => {
         console.log('Produto updated successfully!');
         this.router.navigateByUrl('produto/index');
    })
  }
   
}