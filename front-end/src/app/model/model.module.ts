import { NgModule } from "@angular/core";
import { Model } from "./repository.model";
import { HttpClientModule } from "@angular/common/http";
import { RestDataSource , REST_URL } from "./rest.datasource";

@NgModule({
	imports: [HttpClientModule],
	providers: [Model, RestDataSource, 
		{ provide: REST_URL, useValue: `http://${location.hostname}:8080/client` }]
})
export class ModelModule { }