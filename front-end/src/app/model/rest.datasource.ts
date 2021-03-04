import { Injectable, Inject, InjectionToken } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs"; 
import { Client } from "./client.model";
export const REST_URL = new InjectionToken("rest_url");

@Injectable()
export class RestDataSource {
	constructor(private http: HttpClient, @Inject(REST_URL) private url: string) {}
	getData(): Observable<Client[]> {
		return this.http.get<Client[]>(this.url);
	}
	saveClient(client: Client): Observable<Client> {
		return this.http.post<Client>(this.url, client);
	}    
	updateClient(client: Client): Observable<Client> {
		return this.http.put<Client>(`${this.url}`, client);
	}    
	deleteClient(id: number): Observable<Client> {
		return this.http.delete<Client>(`${this.url}/${id}`);
	}    
}