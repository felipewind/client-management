import { Injectable } from "@angular/core";
import { Client } from "./client.model";
import { StaticDataSource } from "./static.datasource";

@Injectable()
export class Model {
	private clients: Client[];
	private locator = (p: Client, id: number) => p.id == id;

	constructor(private dataSource: StaticDataSource) {
		this.clients = new Array<Client>();
		this.dataSource.getData().forEach(p => this.clients.push(p));
	}

	getClients(): Client[] {
		return this.clients;
	}

	getClient(id: number): Client {
		return this.clients.find(p => this.locator(p, id));
	}

	saveClient(client: Client) {
		if (client.id == 0 || client.id == null) {
			client.id = this.generateID();
			this.clients.push(client);
		} else {
			let index = this.clients.findIndex(p => this.locator(p, client.id));
			this.clients.splice(index, 1, client);
		}
	}

	deleteClient(id: number) {
		let index = this.clients.findIndex(p => this.locator(p, id));
		if (index > -1) {
			this.clients.splice(index, 1);
		}
	}

	private generateID(): number {
		let candidate = 100;
		while (this.getClient(candidate) != null) {
			candidate++;
		}
		return candidate;
	}
}