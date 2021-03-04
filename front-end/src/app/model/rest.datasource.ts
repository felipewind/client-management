import { Injectable, Inject, InjectionToken } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, throwError } from "rxjs"; 
import { Client } from "./client.model";
import { catchError } from "rxjs/operators";
export const REST_URL = new InjectionToken("rest_url");

@Injectable()
export class RestDataSource {
	constructor(private http: HttpClient, @Inject(REST_URL) private url: string) {}
	getData(): Observable<Client[]> {
		return this.http.get<Client[]>(this.url);
	}
	saveClient(client: Client): Observable<Client> {
		// return this.http.post<Client>(this.url, client);
		return this.sendRequest<Client>("POST", this.url, client);
	}    
	updateClient(client: Client): Observable<Client> {
		return this.http.put<Client>(`${this.url}`, client);
	}    
	deleteClient(id: number): Observable<Client> {
		return this.http.delete<Client>(`${this.url}/${id}`);
	}
	private sendRequest<T>(verb: string, url: string, body?: Client): Observable<T> {
		let myHeaders = new HttpHeaders();
		myHeaders = myHeaders.set("Access-Key", "<secret>");
		myHeaders = myHeaders.set("Application-Names", ["exampleApp", "client-manager"]);
		return this.http.request<T>(verb, url, { 
			body: body ,
			headers: myHeaders
		}).pipe(catchError((error: Response) => 
			throwError(`${JSON.stringify(error)}`)));
	}	
}