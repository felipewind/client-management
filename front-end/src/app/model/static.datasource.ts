import { Injectable } from "@angular/core";
import { Client } from "./client.model";
@Injectable()
export class StaticDataSource {
	private data: Client[];
	constructor() {
		this.data = new Array<Client>(
			new Client(1, "John", "01/08/2000", "john@test.com", 5561984847799),
			new Client(2, "Joseph", "11/10/1990", "joseph@test.com", 5565984847755),
			new Client(3, "Marie", "05/10/1995", "marie@test.com", 5564984847722),
			new Client(4, "Sophie", "01/08/1980", "sophie@test.com", 5563984847712),
		    new Client(5, "Laurence", "20/02/1975", "laurence@test.com", 5562984847743));
	}
	getData(): Client[] {
		return this.data;
	}
}