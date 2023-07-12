import Controller from '@ember/controller';
import { tracked } from '@glimmer/tracking';

export default class LoadController extends Controller {
    @tracked currentlyLoading=false;
    get loadingResult(){
        console.log("we are currently in loading controller");
    }
    
}
