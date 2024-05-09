import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';
import { Color } from './color';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  // http://localhost:8082/product
  // http://localhost:8084/allcolors

  private apiUrl = "http://localhost:8082/product";
  private apiUrlColors = "http://localhost:8084/allcolors";

  constructor(private httpClient: HttpClient) { }
  
  getProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.apiUrl}`)
    //return this.httpClient.get<Product[]>(this.apiUrl);
  }

  getColor(): Observable<Color[]> {
    return this.httpClient.get<Color[]>(`${this.apiUrlColors}`)
    //return this.httpClient.get<Product[]>(this.apiUrl);
  }

  createProduct(product: Product): Observable<Object>{
    return this.httpClient.post(`${this.apiUrl}`, product);
  }

  getProductById(id: number): Observable<Product>{
    return this.httpClient.get<Product>(`${this.apiUrl}/${id}`);
  }

  updateProduct(id: number, product: Product): Observable<Object>{
    return this.httpClient.put(`${this.apiUrl}/${id}`, product);
  }

  deleteProduct(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.apiUrl}/${id}`);
  }

}
