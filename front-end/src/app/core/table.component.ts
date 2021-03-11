import { Component, Inject } from "@angular/core";
import { Client } from "../model/client.model";
import { Model } from "../model/repository.model";
import { MODES, SharedState, SHARED_STATE } from "./sharedState.model";
import { Observer } from "rxjs";

@Component({
	selector: "fwTable",
	templateUrl: "table.component.html"
})
export class TableComponent {

	constructor(private model: Model, 
		@Inject(SHARED_STATE) public observer: Observer<SharedState>) { }

	getClient(key: number): Client {
		return this.model.getClient(key);
	}

	getClients(): Client[] {
		return this.model.getClients();
	}

	deleteClient(key: number) {
		this.model.deleteClient(key);
	}

	editClient(key: number) {
		this.observer.next(new SharedState(MODES.EDIT, key));
		console.log(`editClient`);
	}

	createClient() {
		this.observer.next(new SharedState(MODES.CREATE));
	}
}