import { ErrorHandler, Injectable, NgZone } from "@angular/core";
import { MessageService } from "./message.service";
import { Message } from "./message.model";
import { MessageBusinessError } from "./message.business.error.model";

@Injectable()
export class MessageErrorHandler implements ErrorHandler {
	constructor(private messageService: MessageService, private ngZone: NgZone) {
	}
	handleError(error) {
		let msg = error instanceof Error ? error.message : error.toString();
        let messageBusinessError: MessageBusinessError = JSON.parse(msg);

        if (messageBusinessError.status === 422) {
            console.log(`messageBusinessError=${JSON.stringify(messageBusinessError)} (${messageBusinessError.error.errorCode}) (${messageBusinessError.error.errorMessage})`);
            let msgError: string = `Error (${messageBusinessError.error.errorCode} - ${messageBusinessError.error.errorMessage} - ${messageBusinessError.status})`;
            this.ngZone.run(() => this.messageService.reportMessage(new Message(msgError, true)), 0);    
        } else {
            this.ngZone.run(() => this.messageService.reportMessage(new Message(msg, true)), 0);    
        }

	}
}