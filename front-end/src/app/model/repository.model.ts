import { Injectable } from "@angular/core";
import { Client } from "./client.model";
import { Observable } from "rxjs";
import { RestDataSource } from "./rest.datasource";

@Injectable()
export class Model {
	private clients: Client[] = new Array<Client>();
	private locator = (p: Client, id: number) => p.id == id;

	constructor(private dataSource: RestDataSource) {
		this.dataSource.getData().subscribe(data => this.clients = data);
	}

	getClients(): Client[] {
		return this.clients;
	}

	getClient(id: number): Client {
		return this.clients.find(p => this.locator(p, id));
	}

	saveClient(client: Client) {
		if (client.id == 0 || client.id == null) {
			this.dataSource.saveClient(client).subscribe(p => this.clients.push(p));
		} else {
			this.dataSource.updateClient(client).subscribe( p => {
				let index = this.clients.findIndex(item => this.locator(item, p.id));
				this.clients.splice(index, 1, client);
			});
		}
	}

	deleteClient(id: number) {
		this.dataSource.deleteClient(id).subscribe(() => {
			let index = this.clients.findIndex(p => this.locator(p, id));
			if (index > -1) {
				this.clients.splice(index, 1);
			} 
		})		
	}

}