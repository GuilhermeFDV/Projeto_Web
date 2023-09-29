import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../produto.service';
import { Produto } from '../produto';
      
@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
      
  produtos: Produto[] = [];
    
  /*------------------------------------------
  --------------------------------------------
  Created constructor
  --------------------------------------------
  --------------------------------------------*/
  constructor(public produtoService: ProdutoService) { }
    
  /**
   * Write code on Method
   *
   * @return response()
   */
  ngOnInit(): void {
    this.produtoService.getAll().subscribe((data: Produto[])=>{
      this.produtos = data;
      console.log(this.produtos);
    })  
  }
    
  /**
   * Write code on Method
   *
   * @return response()
   */
  deletePost(id:number){
    this.produtoService.delete(id).subscribe(res => {
         this.produtos = this.produtos.filter(item => item.id !== id);
         console.log('Post deleted successfully!');
    })
  }
    
}