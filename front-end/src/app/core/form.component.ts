import { Component, Inject } from "@angular/core";
import { NgForm } from "@angular/forms";
import { Client } from "../model/client.model";
import { Model } from "../model/repository.model"
import { MODES, SharedState, SHARED_STATE } from "./sharedState.model";
import { Observable } from "rxjs";

@Component({
	selector: "fwForm",
	templateUrl: "form.component.html",
	styleUrls: ["form.component.css"]
})
export class FormComponent {
	client: Client = new Client();

	constructor(private model: Model,
		@Inject(SHARED_STATE) public stateEvents: Observable<SharedState>) {
		stateEvents.subscribe((update) => {
			this.client = new Client();
			if (update.id != undefined) {
				Object.assign(this.client, this.model.getClient(update.id));
			}
		this.editing = update.mode == MODES.EDIT;
		});
	}

	editing: boolean = false;

	submitForm(form: NgForm) {
		if (form.valid) {
			this.model.saveClient(this.client);
			this.client = new Client();
			form.reset();
		}
	}

	resetForm() {
		this.client = new Client();
	}
}