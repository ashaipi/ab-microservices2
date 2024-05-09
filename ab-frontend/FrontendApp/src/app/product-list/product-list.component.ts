import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];

  constructor(private productService: ProductService,
              private router: Router) {}

  private getProduct(){
    this.productService.getProducts().subscribe((data) => {
      // Ensure the product list is updated with fresh data
      this.products = data;
    }, (error) => {console.error('Error fetching products', error);});
  }

  ngOnInit(): void {
    this.getProduct();
  }

  updateProduct(id: number){
    this.router.navigate(['/create-product']);
    console.log("Hi Abubaker, This test from updateProduct fucntion in product-list-component.ts")
    this.router.navigate(['/update-product', id]);
  }

  deleteProduct(id: number){
    this.productService.deleteProduct(id).subscribe((data) => {
      // Refresh the product list on success
      this.getProduct();
    },(error) => {console.error('Error deleting product:', error);});
  }

}
